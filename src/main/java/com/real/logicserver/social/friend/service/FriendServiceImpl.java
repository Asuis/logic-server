package com.real.logicserver.social.friend.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.real.logicserver.aop.RedisLockable;
import com.real.logicserver.dto.Result;
import com.real.logicserver.dto.ResultCode;
import com.real.logicserver.social.friend.FriendResult;
import com.real.logicserver.social.friend.constants.FriendType;
import com.real.logicserver.social.friend.dto.FriendSimpleInfo;
import com.real.logicserver.social.friend.model.UserFriend;
import com.real.logicserver.social.friend.repository.FriendDao;
import com.real.logicserver.social.friend.repository.UserFriendMapper;
import com.real.logicserver.utils.user.model.OurUserInfo;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author asuis
 */
@Service
public class FriendServiceImpl implements FriendService {

	private static final Logger log = org.slf4j.LoggerFactory.getLogger(FriendServiceImpl.class);
	private final com.real.logicserver.social.friend.repository.UserFriendMapper userFriendMapper;
	private final FriendDao friendDao;
	@Autowired
	public FriendServiceImpl(UserFriendMapper userFriendMapper, FriendDao friendDao) {
		this.userFriendMapper = userFriendMapper;
		this.friendDao = friendDao;
	}
	@RedisLockable(key = "#ourUserInfo.getUserId()+'_'+#fid")
	@Override
	public Result<FriendResult> addFriend(OurUserInfo ourUserInfo, Integer fid) {

		Result<FriendResult> result = new Result<>();

		UserFriend userFriend = new UserFriend();
		userFriend.setFrUserType(FriendType.NORMAL);
		userFriend.setFrUserId(ourUserInfo.getUserId());
		userFriend.setFrUserId(fid);

		try {
			if (friendDao.isHaveFriend(fid,ourUserInfo.getUserId())==null) {
				userFriendMapper.insert(userFriend);
				result.setCode(ResultCode.SUCC);
			} else {
				result.setCode(ResultCode.FAIL);
				result.setMsg("already");
				log.warn("已经添加朋友:",fid);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(ResultCode.FAIL);
			log.error("添加朋友失败");
		}
		return result;
	}

	@Override
	public Result<FriendResult> removeFriend(OurUserInfo ourUserInfo, Integer fid) {
		return null;
	}

	@Override
	public Result<FriendResult> updateFriend() {
		return null;
	}

	@Override
	public Result<FriendResult> findFriendByTips() {
		return null;
	}

	@Override
	public Result<PageInfo<FriendSimpleInfo>> getMyFriends(Integer pageNum, Integer pageSize,Integer uid) {
		Result<PageInfo<FriendSimpleInfo>> pageInfoResult = new Result<>();
		if (pageNum==null) {
			pageNum = 0;
		} else if (pageNum<0) {
			pageNum = 0;
		}
		if (pageSize==null) {
			pageSize = 3;
		} else if (pageSize<1) {
			pageSize = 3;
		}
		try {
			PageHelper.startPage(pageSize,pageNum);
			List<FriendSimpleInfo> friendInfos = friendDao.getMyFriends(uid);
			PageInfo<FriendSimpleInfo> friendInfoPageInfo = new PageInfo<>(friendInfos);
			pageInfoResult.setCode(ResultCode.SUCC);
			pageInfoResult.setMsg("query members successful");
			pageInfoResult.setData(friendInfoPageInfo);
		} catch (Exception e) {
			e.printStackTrace();
			pageInfoResult.setCode(ResultCode.FAIL);
			pageInfoResult.setMsg("query error");
		}
		return pageInfoResult;
	}
}
