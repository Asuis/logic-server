package com.real.logicserver.meeting.service.impl;

import java.util.List;

import com.real.logicserver.meeting.service.MeetingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.real.logicserver.meeting.model.MeetingUser;
import com.real.logicserver.meeting.repository.MeetingUserMapper;

@Service
public class MeetingHistoryServiceImpl implements MeetingHistoryService {

	@Autowired
	private MeetingUserMapper meetingUserMapper;
	
	@Override
	public List<MeetingUser> getMeetingHistory(Integer userId) {
		List<MeetingUser> list = meetingUserMapper.getMeetingHistory(userId);
		return list;
	}

}
