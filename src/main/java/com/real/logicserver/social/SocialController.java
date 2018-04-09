package com.real.logicserver.social;

import io.swagger.annotations.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.real.logicserver.dto.Result;
import com.real.logicserver.dto.ResultCode;
import com.real.logicserver.social.model.Message;
import com.real.logicserver.social.model.UserDetail;

/**
 * @author asuis
 */
@RestController
@Api("社交，好友相关Api")
@RequestMapping("/v1/social")
public class SocialController {
	
	@Autowired
	com.real.logicserver.social.service.SocialService socialService;
	
	/**
	 * 查找用户
	 */
	@PostMapping("/search/{uid}")
    public Result<UserDetail> searchUser(@PathVariable("uid") String uid) {
		UserDetail userDetail = socialService.searchUser(Integer.valueOf(uid));
		if(userDetail == null) {
			return  new Result<>(ResultCode.FAIL,null,"search fail");
		}
		else {
			return  new Result<>(ResultCode.SUCC,userDetail,"search success");
		}
        
    }
	
	/**
	 * 获取好友增删消息
	 */
	@PostMapping("/message/{uid}")
    public Result<List<Message>> getMessage(@PathVariable("uid") String uid) {
		List<Message> list = socialService.getMessage(Integer.valueOf(uid));
        if(list==null) {
        	return  new Result<>(ResultCode.FAIL,null,"no message");
        }
        else {
        	return  new Result<>(ResultCode.SUCC,list,"had message");
        }
    }

}
