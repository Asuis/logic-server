package com.real.logicserver.social.friend.repository;

import com.github.pagehelper.PageInfo;
import com.real.logicserver.dto.Result;
import com.real.logicserver.social.friend.dto.FriendSimpleInfo;
import com.real.logicserver.social.friend.model.UserFriend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author asuis
 */
@Mapper
public interface FriendDao {
    List<FriendSimpleInfo> getMyFriends(@Param("uid") Integer uid);
    UserFriend isHaveFriend(@Param("fid") Integer fid,@Param("uid") Integer uid);
}
