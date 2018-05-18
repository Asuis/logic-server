package com.real.logicserver.meeting.repository;

import com.real.logicserver.meeting.dto.MeetingSimpleInfo;
import com.real.logicserver.meeting.dto.SimpleUserInfo;
import com.real.logicserver.meeting.query.MeetingQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author asuis
 */
@Mapper
public interface MeetingDao {
    /**
     * 判断是否存在会议
     * @param meId 会议Id
     * @return 是否存在会议
     * */
    Integer isExist(@Param("mid") Integer meId);

    List<SimpleUserInfo> getMembersByMeId(@Param("mid") Integer meId);

    List<MeetingSimpleInfo> getMeetingsByQuery();

    List<MeetingSimpleInfo> getMyMeeting(@Param("uid") Integer userId);

    List<MeetingSimpleInfo> getFriendMeeting(@Param("uid") Integer userId);
}
