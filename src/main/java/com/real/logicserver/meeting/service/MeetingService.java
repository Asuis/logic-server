package com.real.logicserver.meeting.service;

import com.github.pagehelper.PageInfo;
import com.real.logicserver.dto.Result;
import com.real.logicserver.meeting.dto.MeetingSimpleInfo;
import com.real.logicserver.meeting.dto.SimpleUserInfo;
import com.real.logicserver.utils.user.model.OurUserInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * @author asuis
 */
public interface MeetingService {
    Result joinMeeting(OurUserInfo ourUserInfo, Integer mid);

    Result<PageInfo<SimpleUserInfo>> getMembersByMeId(Integer meId,Integer pageNum,Integer pageSize);

    Result<PageInfo<MeetingSimpleInfo>> getMeetingSimple(Integer pageNum, Integer pageSize);

    Result<PageInfo<MeetingSimpleInfo>> getMyMeetingSimpleInfo(Integer pageNum, Integer pageSize, OurUserInfo ourUserInfo);

    Result<PageInfo<MeetingSimpleInfo>> getFriendMeetingSimpleInfo(Integer pageNum, Integer pageSize, OurUserInfo ourUserInfo);

    void updateLogo(Integer mid,String str);
}
