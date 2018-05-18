package com.real.logicserver.meeting.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.real.logicserver.dto.Result;
import com.real.logicserver.dto.ResultCode;
import com.real.logicserver.meeting.constants.MeetingStatus;
import com.real.logicserver.meeting.dto.MeetingSimpleInfo;
import com.real.logicserver.meeting.dto.SimpleUserInfo;
import com.real.logicserver.meeting.model.Meeting;
import com.real.logicserver.meeting.model.MeetingUser;
import com.real.logicserver.meeting.repository.MeetingDao;
import com.real.logicserver.meeting.repository.MeetingMapper;
import com.real.logicserver.meeting.repository.MeetingUserMapper;
import com.real.logicserver.meeting.service.MeetingService;
import com.real.logicserver.utils.tools.TimeUtils;
import com.real.logicserver.utils.user.model.OurUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author asuis
 */
@Service
public class MeetingServiceImpl implements MeetingService {

    private final MeetingDao meetingDao;

    private final MeetingUserMapper meetingUserMapper;
    private final MeetingMapper meetingMapper;

    @Autowired
    public MeetingServiceImpl(MeetingUserMapper meetingUserMapper, MeetingMapper meetingMapper, MeetingDao meetingDao) {
        this.meetingUserMapper = meetingUserMapper;
        this.meetingMapper = meetingMapper;
        this.meetingDao = meetingDao;
    }

    @Override
    public Result joinMeeting(OurUserInfo ourUserInfo, Integer mid) {
        Result result = new Result();
        if (isHaveMeeting(mid)) {
            //checkUserAuth(ourUserInfo,mid);
            MeetingUser meetingUser = new MeetingUser();
            meetingUser.setCreateTime(TimeUtils.getCurrentTIme());
            meetingUser.setMeId(mid);
            meetingUser.setUserId(ourUserInfo.getUserId());
            meetingUser.setStatus(MeetingStatus.USER_PASS);
            try {
                meetingUserMapper.insertSelective(meetingUser);
                result.setCode(ResultCode.SUCC);
                result.setMsg("join successful");
            } catch (Exception e) {
                e.printStackTrace();
                result.setCode(ResultCode.FAIL);
                result.setMsg("error");
            }
        } else {
            result.setCode(ResultCode.FAIL);
            result.setMsg("无加入权限");
        }
        return result;
    }

    @Override
    public Result<PageInfo<SimpleUserInfo>> getMembersByMeId(Integer meId, Integer pageSize, Integer pageNum) {
        Result<PageInfo<SimpleUserInfo>> pageInfoResult = new Result<>();
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
            List<SimpleUserInfo> userInfos = meetingDao.getMembersByMeId(meId);
            PageInfo<SimpleUserInfo> userInfoPageInfo = new PageInfo<>(userInfos);
            pageInfoResult.setCode(ResultCode.SUCC);
            pageInfoResult.setMsg("query members successful");
            pageInfoResult.setData(userInfoPageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            pageInfoResult.setCode(ResultCode.FAIL);
            pageInfoResult.setMsg("query error");
        }
        return pageInfoResult;
    }

    @Override
    public Result<PageInfo<MeetingSimpleInfo>> getMeetingSimple(Integer pageNum, Integer pageSize) {
        Result<PageInfo<MeetingSimpleInfo>> pageInfoResult = new Result<>();
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
            List<MeetingSimpleInfo> meetingSimpleInfo = meetingDao.getMeetingsByQuery();
            PageInfo<MeetingSimpleInfo> meetingSimpleInfos = new PageInfo<>(meetingSimpleInfo);
            pageInfoResult.setCode(ResultCode.SUCC);
            pageInfoResult.setMsg("query members successful");
            pageInfoResult.setData(meetingSimpleInfos);
        } catch (Exception e) {
            e.printStackTrace();
            pageInfoResult.setCode(ResultCode.FAIL);
            pageInfoResult.setMsg("query error");
        }
        return pageInfoResult;
    }

    @Override
    public Result<PageInfo<MeetingSimpleInfo>> getMyMeetingSimpleInfo(Integer pageNum, Integer pageSize, OurUserInfo ourUserInfo) {

        Result<PageInfo<MeetingSimpleInfo>> pageInfoResult = new Result<>();
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
            List<MeetingSimpleInfo> meetingSimpleInfo = meetingDao.getMyMeeting(ourUserInfo.getUserId());
            PageInfo<MeetingSimpleInfo> meetingSimpleInfos = new PageInfo<>(meetingSimpleInfo);
            pageInfoResult.setCode(ResultCode.SUCC);
            pageInfoResult.setMsg("query members successful");
            pageInfoResult.setData(meetingSimpleInfos);
        } catch (Exception e) {
            e.printStackTrace();
            pageInfoResult.setCode(ResultCode.FAIL);
            pageInfoResult.setMsg("query error");
        }

        return pageInfoResult;
    }

    @Override
    public Result<PageInfo<MeetingSimpleInfo>> getFriendMeetingSimpleInfo(Integer pageNum, Integer pageSize, OurUserInfo ourUserInfo) {

        Result<PageInfo<MeetingSimpleInfo>> pageInfoResult = new Result<>();
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
            List<MeetingSimpleInfo> meetingSimpleInfo = meetingDao.getFriendMeeting(ourUserInfo.getUserId());
            PageInfo<MeetingSimpleInfo> meetingSimpleInfos = new PageInfo<>(meetingSimpleInfo);
            pageInfoResult.setCode(ResultCode.SUCC);
            pageInfoResult.setMsg("query members successful");
            pageInfoResult.setData(meetingSimpleInfos);
        } catch (Exception e) {
            e.printStackTrace();
            pageInfoResult.setCode(ResultCode.FAIL);
            pageInfoResult.setMsg("query error");
        }

        return pageInfoResult;
    }

    @Override
    public void updateLogo(Integer mid,String str) {
        Meeting meeting = new Meeting();
        meeting.setLogo("http://res.mengxiangjing.com/"+str);
        meeting.setMeId(mid);
        meetingMapper.updateByPrimaryKeySelective(meeting);
    }

    private boolean isHaveMeeting(Integer mid) {
        return meetingDao.isExist(mid) == 1;
    }
    /**
     * 检查用户是否拥有加入会议的权限
     * */
    private Result checkUserAuth(OurUserInfo ourUserInfo,Integer mid) {
        Result result = new Result();
        result.setCode(ResultCode.SUCC);
        return result;
    }
}
