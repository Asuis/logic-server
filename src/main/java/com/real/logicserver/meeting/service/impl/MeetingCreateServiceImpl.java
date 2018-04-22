package com.real.logicserver.meeting.service.impl;

import java.util.Date;

import com.real.logicserver.meeting.service.MeetingCreateService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.real.logicserver.meeting.model.Meeting;
import com.real.logicserver.meeting.model.MeetingUser;
import com.real.logicserver.meeting.form.MeetingCreate;
import com.real.logicserver.meeting.repository.MeetingMapper;
import com.real.logicserver.meeting.repository.MeetingUserMapper;

@Service
public class MeetingCreateServiceImpl implements MeetingCreateService {

	private final MeetingUserMapper meetingUserMapper;
	
	private final MeetingMapper meetingMapper;

	@Autowired
	public MeetingCreateServiceImpl(MeetingUserMapper meetingUserMapper, MeetingMapper meetingMapper) {
		this.meetingUserMapper = meetingUserMapper;
		this.meetingMapper = meetingMapper;
	}

	@Override
	public Integer meetingCreate(MeetingCreate meetingCreate) {
		Integer meetingId = null;
		try {
			Meeting meeting = new Meeting();
			meeting.setTypeId(meetingCreate.getType());
			meetingMapper.insertSelective(meeting);
			
			meetingId = meeting.getMeId();
			
			MeetingUser meetingUser = new MeetingUser();
			meetingUser.setCreateTime(new Date(System.currentTimeMillis()));
			meetingUser.setUserId(meetingCreate.getUserId());		
			meetingUser.setMeId(meetingId);
			
			meetingUserMapper.insertSelective(meetingUser);	
		}
		catch(Exception e) {
			return null;
		}
		return meetingId;
	}


}
