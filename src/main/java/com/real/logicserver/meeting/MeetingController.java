package com.real.logicserver.meeting;

import com.github.pagehelper.PageInfo;
import com.real.logicserver.dto.Result;
import com.real.logicserver.dto.ResultCode;
import com.real.logicserver.meeting.dto.MeetingHistoryQuery;
import com.real.logicserver.meeting.dto.MeetingSimpleInfo;
import com.real.logicserver.meeting.dto.SimpleUserInfo;
import com.real.logicserver.meeting.form.MeetingForm;
import com.real.logicserver.meeting.form.MeetingUpdate;
import com.real.logicserver.meeting.form.MeetingCreate;
import com.real.logicserver.meeting.form.MeetingDelete;
import com.real.logicserver.meeting.model.UploadResult;
import com.real.logicserver.meeting.query.MeetingQuery;
import com.real.logicserver.meeting.valitor.LogoFileValitor;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author asuis
 */
@RestController
@Api("会议相关接口")
@RequestMapping("/v1/m")
@Slf4j
public class MeetingController {

	
	
	 @Autowired
	 com.real.logicserver.meeting.service.MeetingCreateService meetingCreatService;
	 
	 @Autowired
	 com.real.logicserver.meeting.service.MeetingDeleteService meetingDeleteService;
	 
	 @Autowired
	 com.real.logicserver.meeting.service.MeetingUpdateService meetingUpdateService;
	
	 private static final Logger log = LoggerFactory.getLogger(MeetingController.class);
	 
	 private static final String UPLOADED_FOLDER = "D://Temp/";
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
    	
    	//
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
    public Result<MeetingCreate> createMeeting(@RequestBody MeetingCreate meetingCreate){
    	Integer userId = 2;
    	
    	meetingCreate.setUserId(userId);
    	boolean accept = meetingCreatService.meetingCreate(meetingCreate);
    	if(accept) {
    		return new Result<>(ResultCode.SUCC,meetingCreate,"creat successful");
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
    	Integer userId = 2;
    	
    	MeetingDelete meetingDelete = new MeetingDelete();
    	meetingDelete.setMeetingId(Integer.valueOf(meetingId));
    	meetingDelete.setUserId(userId);
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
     * todo 再设计
     * */
    @PostMapping("/update")
    @ApiOperation("上传更新会议信息")
    public Result<MeetingUpdate> updateMeeting(@RequestBody MeetingUpdate meetingUpdate){
    	int userId = 2;
    	
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
    @GetMapping("/search")
    @ApiOperation("查找会议")
    public Result<String> searchMeeting(@RequestBody MeetingQuery meetingQuery){
        return null;
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
    public Result<PageInfo<MeetingSimpleInfo>> getMeetingHistory(@RequestBody MeetingHistoryQuery historyQuery, @RequestParam(value = "query",required = false) String query){
        return null;
    }
    /**
     * 获取会议成员(当前已报名的会议成员)
     * */
    @GetMapping("/member/get/{mid}")
    @ApiOperation("获取会议成员(当前已报名的会议成员)")
    public Result<PageInfo<SimpleUserInfo>> getMeetingMembers(@PathVariable("mid") Integer mid){
        return null;
    }
    /**
     * 获取会议报名表
     * */
    @GetMapping("/sign/get/{mid}")
    @ApiOperation("获取会议进行中，签到的人选")
    public Result getSignUpList(@PathVariable("mid") Integer mid){
        return null;
    }

    /**
     * 签到会议
     * 扫描二维码签到
     * */
    @PostMapping("/signup/{mid}")
    @ApiOperation("签到会议")
    public Result signUpMeeting(@PathVariable("mid")Integer mid,HttpServletRequest request,HttpServletResponse response){
        return null;
    }
    /**
     * 展示当前会议签到人员信息
     * */
    @GetMapping("/sign/list/{mid}")
    @ApiOperation("展示会议签到人员信息")
    public Result<PageInfo<SimpleUserInfo>> getSignMembersMessage(@PathVariable("mid")Integer mid) {
        return null;
    }
    /**
     * 获得会议邀请码
     * */
    @GetMapping("/invite/get/{type}")
    @ApiOperation("会议邀请码，需验证身份")
    public Result<String> getInviteCode(HttpServletRequest request,HttpServletResponse response,@PathVariable("type") String type) {
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
}