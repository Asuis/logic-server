package com.real.logicserver;

import com.github.pagehelper.PageInfo;
import com.real.logicserver.dto.Result;
import com.real.logicserver.meeting.dto.SimpleUserInfo;
import com.real.logicserver.meeting.service.MeetingService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MeetingServiceTests {
    @Autowired
    MeetingService meetingService;

    @Test
    public void testQuery() {
        Result<PageInfo<SimpleUserInfo>> msg = meetingService.getMembersByMeId(44,null,null);
        log.info(msg.getMsg());
    }
}
