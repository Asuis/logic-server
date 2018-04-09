package com.real.logicserver.social.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.real.logicserver.social.friend.model.UserFriend;
import com.real.logicserver.social.friend.repository.UserFriendMapper;
import com.real.logicserver.social.model.Message;
import com.real.logicserver.social.model.UserDetail;
import com.real.logicserver.social.repository.MessageMapper;
import com.real.logicserver.social.repository.UserDetailMapper;

@Service
public class SocialServiceImpl implements SocialService{

	@Autowired
	private UserDetailMapper userDetailMapper;
	
	@Autowired
	private MessageMapper messageMapper;
	
	@Autowired
	private UserFriendMapper userFriendMapper;
	
	@Override
	public UserDetail searchUser(Integer userId) {
		UserDetail userDetail = userDetailMapper.selectByPrimaryKey(userId);
		return userDetail;
	}

	@Override
	public List<Message> getMessage(Integer userId) {
		List<Message> list = messageMapper.selectByUserId(userId);
		return list;
	}

	@Override
	public boolean addFriend(Integer userId, Integer friendId) {
		Message message = new Message();
		message.setSenderId(String.valueOf(userId));
		message.setReceiverId(String.valueOf(friendId));
		message.setContent("添加好友");
		message.setMsgTime(new Date(System.currentTimeMillis()));
		message.setMsgType(3);
		message.setStatus("0");
		message.setIsRoom(false);
		messageMapper.insertSelective(message);
		return true;
	}

	@Override
	public boolean reviewFriend(Integer messageId, String type, String userId, String friendId) {
		Message message1 = new Message();
		message1.setMsgId(messageId);
		message1.setStatus("1");			
		messageMapper.updateByPrimaryKeySelective(message1);
		if(type.equals("0")) {
			Message message = new Message();
			message.setSenderId(String.valueOf(userId));
			message.setReceiverId(String.valueOf(friendId));
			message.setContent("拒绝添加好友");
			message.setMsgTime(new Date(System.currentTimeMillis()));
			message.setMsgType(4);
			message.setStatus("0");
			message.setIsRoom(false);
			messageMapper.insertSelective(message);
			
			return true;
		}
		else if(type.equals("1")) {
			Message message = new Message();
			message.setSenderId(String.valueOf(userId));
			message.setReceiverId(String.valueOf(friendId));
			message.setContent("同意添加好友");
			message.setMsgTime(new Date(System.currentTimeMillis()));
			message.setMsgType(4);
			message.setStatus("0");
			message.setIsRoom(false);
			messageMapper.insertSelective(message);
			
			UserFriend userFriend = new UserFriend();
			userFriend.setUserId(Integer.valueOf(userId));
			userFriend.setFrUserId(Integer.valueOf(friendId));
			userFriendMapper.insertSelective(userFriend);
			userFriend.setFrUserId(Integer.valueOf(userId));
			userFriend.setUserId(Integer.valueOf(friendId));
			userFriendMapper.insertSelective(userFriend);
			
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public boolean removeFriend(String userId, String friendId) {
		userFriendMapper.deleteByUserId(Integer.valueOf(userId), Integer.valueOf(friendId));
		userFriendMapper.deleteByUserId(Integer.valueOf(friendId), Integer.valueOf(userId));
		return true;
	}

	
	
}
