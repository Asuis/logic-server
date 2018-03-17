package com.real.logicserver.social.friend.service;

import com.real.logicserver.dto.Result;
import com.real.logicserver.social.friend.FriendResult;

/**
 * @author asuis
 */
public interface FriendService {
    /**
     * 添加朋友
     * */
    public Result<FriendResult> addFriend();
    /**
     * 删除朋友
     * */
    public Result<FriendResult> removeFriend();
    /**
     * 更新朋友关联信息
     * */
    public Result<FriendResult> updateFriend();
    /**
     * 根据nickname，以及其他关键自查找朋友
     * @return 执行结果
     * */
    public Result<FriendResult> findFriendByTips();
}
