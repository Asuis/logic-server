package com.real.logicserver.social.service;

import java.util.List;

import com.real.logicserver.social.model.Message;
import com.real.logicserver.social.model.UserDetail;

public interface SocialService {
	
	
	public UserDetail searchUser(Integer userId);

	public List<Message> getMessage(Integer userId);
	
	public boolean addFriend(Integer userId,Integer friendId);
	
	public boolean reviewFriend(Integer messageId,String type, String userId, String friendId);
	
	public boolean removeFriend(String userId,String friendId);
}
