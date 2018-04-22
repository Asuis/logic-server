package com.real.logicserver.meeting.service;

import com.github.pagehelper.PageInfo;
import com.real.logicserver.dto.Result;
import com.real.logicserver.meeting.dto.SimpleUserInfo;
import com.real.logicserver.utils.user.model.OurUserInfo;

/**
 * @author asuis
 */
public interface MeetingService {
    Result joinMeeting(OurUserInfo ourUserInfo, Integer mid);

    Result<PageInfo<SimpleUserInfo>> getMembersByMeId(Integer meId,Integer pageNum,Integer pageSize);
}
