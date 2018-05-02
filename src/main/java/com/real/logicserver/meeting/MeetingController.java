package com.real.logicserver.meeting;

import com.github.pagehelper.PageInfo;
import com.real.logicserver.dto.Result;
import com.real.logicserver.dto.ResultCode;
import com.real.logicserver.meeting.dto.SimpleUserInfo;
import com.real.logicserver.meeting.form.MeetingSignedMembers;
import com.real.logicserver.meeting.form.MeetingUpdate;
import com.real.logicserver.meeting.form.MeetingCreate;
import com.real.logicserver.meeting.form.MeetingDelete;
import com.real.logicserver.meeting.model.Meeting;
import com.real.logicserver.meeting.model.MeetingSigned;
import com.real.logicserver.meeting.model.MeetingUser;
import com.real.logicserver.meeting.model.UploadResult;
import com.real.logicserver.meeting.query.MeetingQuery;
import com.real.logicserver.meeting.service.*;
import com.real.logicserver.meeting.valitor.LogoFileValitor;
import com.real.logicserver.utils.tools.upload.UploadUtils;
import com.real.logicserver.utils.user.OurLoginService;
import com.real.logicserver.utils.user.model.OurUserInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

/**
 * @author asuis
 */
@RestController
@Api("会议相关接口")
@RequestMapping("/v1/m")
public class MeetingController {


	private final MeetingService meetingService;

	private final static String DEFAULT_LOGO = "http://res.mengxiangjing.com/53969178_p0_master1200.jpg";

	private final com.real.logicserver.utils.user.OurLoginService ourLoginService;
	
	private final com.real.logicserver.meeting.service.MeetingCreateService meetingCreatService;
	 
	private final com.real.logicserver.meeting.service.MeetingDeleteService meetingDeleteService;
	 
	private final com.real.logicserver.meeting.service.MeetingUpdateService meetingUpdateService;
	 
	private final com.real.logicserver.meeting.service.MeetingSearchService meetingSearchService;
	 
	private final com.real.logicserver.meeting.service.MeetingMemberService meetingMemberService;
	 
	private final com.real.logicserver.meeting.service.MeetingHistoryService meetingHistoryService;
	 
	
	private static final Logger log = LoggerFactory.getLogger(MeetingController.class);
	 
	private static final String UPLOADED_FOLDER = "D://Temp/";

	@Autowired
	public MeetingController(OurLoginService ourLoginService, MeetingCreateService meetingCreatService, MeetingDeleteService meetingDeleteService, MeetingUpdateService meetingUpdateService, MeetingSearchService meetingSearchService, MeetingMemberService meetingMemberService, MeetingHistoryService meetingHistoryService, MeetingService meetingService) {
		this.ourLoginService = ourLoginService;
		this.meetingCreatService = meetingCreatService;
		this.meetingDeleteService = meetingDeleteService;
		this.meetingUpdateService = meetingUpdateService;
		this.meetingSearchService = meetingSearchService;
		this.meetingMemberService = meetingMemberService;
		this.meetingHistoryService = meetingHistoryService;
		this.meetingService = meetingService;
	}

	/**
     * 上传会议logo（图片）
     * 使用腾讯cos
     * 先缓存到本地然后使用cos sdk上传至对象存储
     * */
    
    @PostMapping(value = "/upload/logo",consumes = "multipart/*",headers = "content-type=multipart/form-data")
    @ApiOperation("创建会议时上传logo")
    public Result<UploadResult> uploadLogo(@ApiParam(value = "上传的logo文件",required = true) @RequestParam("logo") MultipartFile file){
    	//验证logo信息
    	ResultCode res = LogoFileValitor.validate(file);
    	if(res.equals(ResultCode.FAIL)) {
    		return  new Result<>(ResultCode.FAIL,null,"Please select a file to upload");
    	}
    	
    	UploadResult uploadResult = new UploadResult();
        if (file.isEmpty()) {
            return new Result<>(ResultCode.FAIL,null,"Please select a file to upload");
        }
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            //uploadResult.setMsg("You successfully uploaded '" + file.getOriginalFilename() + "'");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Result<>(ResultCode.SUCC,uploadResult,"upload successful");
    }
    /**
	 * todo 权限验证
	 * */
    @PostMapping(value = "/upload/token/logo")
	@ApiOperation("获取logo")
	public Result<HashMap<String,String>> getUploadToken(HttpServletRequest request) {
		Result<HashMap<String,String>> result = new Result<>();
		try {
			String upToken = UploadUtils.getQiniuUploadToken();
			result.setCode(ResultCode.SUCC);
			HashMap<String,String> resultMap = new HashMap<>();
			resultMap.put("up_token",upToken);
			result.setData(resultMap);
		} catch (RuntimeException e) {
			e.printStackTrace();
			result.setCode(ResultCode.FAIL);
		}
		return result;
	}
	@GetMapping(value = "/upload/token/logo/callback")
	@ApiOperation("获取logo")
	public Result<HashMap<String,String>> qiniuUploadCallback(HttpServletRequest request) {
		Result<HashMap<String,String>> result = new Result<>();
		HashMap<String,String> map = new HashMap<>();
		Enumeration<String> res = request.getAttributeNames();
		map.put("str",res.toString());
		result.setData(map);
		return result;
	}

    /**
     * 创建会议
     * 场景 app点击创建会议 从数据库 添加默认会议（按模板填写）
     * 判断是否有未填写完成的会议，若有则返回提示，是否继续编辑，还是重新创建新的会议
     * 创建会议步骤
     * 1. 填写会议基本资料
     * 2. 添加会议互动类型
     * 3. 添加会议参加类型（邀请码，指定成员，报名，公开）
     * 4. 若选择报名，则可选择编辑报名表
     * */
    
    /**
     * 创建会议id与类型
     */   
    @PostMapping("/create")
    @ApiOperation("创建会议")
    public Result<Meeting> createMeeting(@RequestBody MeetingCreate meetingCreate,HttpServletRequest request){
    	
    	Integer userId = ourLoginService.wxCheck(request).getUserId();
    	
    	meetingCreate.setUserId(userId);
    	Integer mid = meetingCreatService.meetingCreate(meetingCreate);
    	Meeting meeting = new Meeting();
		meeting.setLogo(DEFAULT_LOGO);
    	meeting.setMeId(mid);
    	if(mid!=null) {
    		return new Result<>(ResultCode.SUCC,meeting,"creat successful");
    	}
    	else {
    		return new Result<>(ResultCode.FAIL,null,"creat fail");
    	}
		
    }
    /**
     * 删除会议
     * 使用时校验权限
     * 应该用处不大
     * */
    @PostMapping("/del/{id}")
    @ApiOperation("删除会议，应该用处不大")
    public Result<MeetingDelete> deleteMeeting(@PathVariable("id")String meetingId, HttpServletRequest request, HttpServletResponse response){
    	log.info("delete meetingId "+meetingId);
    	OurUserInfo ourUserInfo = ourLoginService.wxCheck(request);
    	MeetingDelete meetingDelete = new MeetingDelete();
    	meetingDelete.setMeetingId(Integer.valueOf(meetingId));
    	meetingDelete.setUserId(ourUserInfo.getUserId());
    	boolean accept = meetingDeleteService.meetingDelete(meetingDelete);
    	if(accept) {
    		return new Result<>(ResultCode.SUCC,meetingDelete,"creat successful");
    	}
    	else {
    		return new Result<>(ResultCode.FAIL,null,"creat fail");
    	}
        
    }
    /**
     * 更新会议信息
     * 场景app上传更新信息
     * */
    @PostMapping("/update")
    @ApiOperation("上传更新会议信息")
    public Result<MeetingUpdate> updateMeeting(HttpServletRequest request, @RequestBody MeetingUpdate meetingUpdate){
		Integer userId = ourLoginService.wxCheck(request).getUserId();

    	meetingUpdate.setUserId(userId);
    	boolean accept = meetingUpdateService.meetingUpdate(meetingUpdate);
    	if(accept) {
    		return new Result<>(ResultCode.SUCC,meetingUpdate,"update successful");
    	}
    	else {
    		return new Result<>(ResultCode.FAIL,null,"update fail");
    	}
        
    }
    /**
     * 查询公开会议
     * 提供邀请码搜索
     * */
    @PostMapping("/search")
    @ApiOperation("查找会议")
    public Result<Meeting> searchMeeting(@RequestBody MeetingQuery meetingQuery){
    	Meeting meeting = meetingSearchService.meetingSearch(meetingQuery);
    	if(meeting!=null) {
    		 return new Result<>(ResultCode.SUCC,meeting,"search successful");  	
    	}	
    	else {
			return new Result<>(ResultCode.FAIL,null,"search fail");
		}
    	
    }
    
    /**
     * 获取当前用户会议历史
     * 已参加的会议
     * 已报名的会议
     * 编辑的会议
     * 创建的会议
     * */
    @GetMapping("/his")
    @ApiOperation("查询个人会议历史")
    public Result<List<MeetingUser>> getMeetingHistory(HttpServletRequest request){
        
    	OurUserInfo userInfo = ourLoginService.wxCheck(request);
    	Integer userId = null;
    	if(userInfo==null) {
    		return new Result<>(ResultCode.FAIL,null,"search fail");  	
    	}
    	else {
    		userId = userInfo.getUserId();
    		List<MeetingUser> list = meetingHistoryService.getMeetingHistory(userId);
    		if(list == null) {
    			return new Result<>(ResultCode.FAIL,null,"no meetings"); 
    		}
    		else {
    			 return new Result<>(ResultCode.SUCC,list,"search successful");
    		}
    	}

    }
    
    /**
     * 获取会议成员(当前已报名的会议成员)
     * */
    @GetMapping("/member/get/{mid}")
    @ApiOperation("获取会议成员(当前已报名的会议成员)")
    public Result<List<MeetingUser>> getMeetingMembers(@PathVariable("mid") Integer mid){
    	
    	List<MeetingUser> memberList = meetingMemberService.getMeetingMembers(mid);
    	if(memberList==null) {
    		return new Result<>(ResultCode.FAIL,null,"search fail");  	
    	}
    	else {
    		return new Result<>(ResultCode.SUCC,memberList,"search successful");  	
    	}
       
    }
    
    /**
     * 获取会议报名表
     * */
    @GetMapping("/sign/get/{mid}")
    @ApiOperation("获取会议进行中，签到的人选")
    public Result<List<MeetingSignedMembers>> getSignUpList(@PathVariable("mid") Integer mid){
    	
    	List<MeetingSignedMembers> signedList = meetingMemberService.getMeetingSignMembers(mid);
    	if(signedList==null) {
    		return new Result<>(ResultCode.FAIL,null,"search fail");  	
    	}
    	else {
    		return new Result<>(ResultCode.SUCC,signedList,"search successful");
    	}
    }

    /**
     * 签到会议
     * 扫描二维码签到
     * */
    
    @PostMapping("/signup/{mid}")
    @ApiOperation("签到会议")
    public Result<MeetingSigned> signUpMeeting(@PathVariable("mid")Integer mid,HttpServletRequest request,HttpServletResponse response){
    	
        OurUserInfo ourUserInfo = ourLoginService.wxCheck(request);
        if (ourUserInfo!=null) {
			MeetingSigned meetingSigned = meetingMemberService.meetingSigned(mid, ourUserInfo.getUserId());
			if(meetingSigned==null) {
				return new Result<>(ResultCode.FAIL,null,"signed fail");
			}
			else {
				return new Result<>(ResultCode.SUCC, meetingSigned, "signed successful");
			}
		}
		return null;
    }

    /**
     * 获取文件列表
     * */
    @GetMapping("/file/list/{mid}")
    @ApiOperation("获取会议分享文件")
    public Result getFileList() {
        return null;
    }

    @PostMapping("/join/{mid}")
	@ApiOperation("加入会议")
	public Result joinMeeting(HttpServletRequest request, @PathVariable Integer mid) {
    	Result result = null;
    	OurUserInfo ourUserInfo = ourLoginService.wxCheck(request);
    	if (ourUserInfo!=null) {
			result = meetingService.joinMeeting(ourUserInfo,mid);
		} else {
    		result = new Result();
    		result.setCode(ResultCode.FAIL);
    		result.setMsg("please use weixin app login");
		}
    	return result;
	}

	/**
	 * 获取会议成员(当前已报名的会议成员)
	 * */
	@GetMapping("/member/get2/{mid}/{pageNum}/{pageSize}")
	@ApiOperation("获取会议成员(当前已报名的会议成员)")
	public Result<PageInfo<SimpleUserInfo>> getMeetingMembers2(@PathVariable("mid") Integer mid,
															   @PathVariable("pageNum")Integer pageNum,
															   @PathVariable("pageSize") Integer pageSize){
		return meetingService.getMembersByMeId(mid,pageNum,pageSize);
	}

}