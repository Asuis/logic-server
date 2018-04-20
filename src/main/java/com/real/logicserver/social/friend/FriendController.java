package com.real.logicserver.social.friend;

import com.real.logicserver.dto.Result;
import com.real.logicserver.dto.ResultCode;
import com.real.logicserver.social.friend.form.InviteFriendForm;
import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author asuis
 */
@RestController
@Api("好友添加相关Api")
@RequestMapping("/v1/fri")
public class FriendController {
	
	@Autowired
	com.real.logicserver.social.friend.service.FriendService friendService;
	
	@Autowired
	com.real.logicserver.social.service.SocialService socialService;
	
    /**
     * 添加好友
     * */
    @PostMapping("/add/{uid}/{fid}")
    public Result<Boolean> addFriend(@PathVariable("uid") String uid,@PathVariable("fid") String fid) {
    	boolean ac = socialService.addFriend(Integer.valueOf(uid), Integer.valueOf(fid));
    	if(ac) {
    		return  new Result<>(ResultCode.SUCC,null,"add success");
    	}
    	else {
    		return  new Result<>(ResultCode.SUCC,null,"add fail");
    	}
    }
    
    /**
     * 同意/拒绝添加好友
     * */
    @PostMapping("/review/{type}/{mid}/{uid}/{fid}")
    public Result<Boolean> reviewFriend(@PathVariable("type") String type,@PathVariable("mid") String mid,@PathVariable("uid") String uid,@PathVariable("fid") String fid) {
    	boolean ac = socialService.reviewFriend(Integer.valueOf(mid), type, uid, fid);
    	if(ac) {
    		return  new Result<>(ResultCode.SUCC,null,"review success");
    	}
    	else {
    		return  new Result<>(ResultCode.SUCC,null,"review fail");
    	}
    }
    
    /**
     * 删除好友
     * */
    @DeleteMapping("/del/{uid}/{fid}")
    public Result removerFriend(@PathVariable("uid") String uid,@PathVariable("fid") String fid) {
    	boolean ac = socialService.removeFriend(uid, fid);
    	if(ac) {
    		return  new Result<>(ResultCode.SUCC,null,"remove success");
    	}
    	else {
    		return  new Result<>(ResultCode.SUCC,null,"remove fail");
    	}
    }
    /**
     * 添加好友备注
     * */
    @PutMapping("/tag/add/{type}/{uid}")
    public Result addFriendTag(@PathVariable("type") String type,@PathVariable("uid") String uid) {
        return null;
    }
    /**
     * 邀请参加会议
     * */
    @PostMapping("/invite")
    public Result inviteToMeeting(@RequestBody InviteFriendForm inviteFriendForm){
        return null;
    }
    /**
     * 获取朋友列表
     * */
    @GetMapping("/list")
    public Result getFriendList(){
        return null;
    }
    /**
     * 查询朋友
     * */
    @GetMapping("/search/{query}")
    public Result searchFriend(@PathVariable String query){
        return null;
    }
}