package com.real.logicserver.social.friend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.real.logicserver.dto.Result;
import com.real.logicserver.social.friend.FriendResult;

@Service
public class FriendServiceImpl implements FriendService {

	@Autowired
	com.real.logicserver.social.friend.repository.UserFriendMapper userFriendMapper;
	
	
	@Override
	public Result<FriendResult> addFriend() {
		
		return null;
	}

	@Override
	public Result<FriendResult> removeFriend() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<FriendResult> updateFriend() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<FriendResult> findFriendByTips() {
		// TODO Auto-generated method stub
		return null;
	}

}
