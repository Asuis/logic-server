package com.real.logicserver.meeting.service;

import java.io.IOException;
import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.real.logicserver.meeting.form.MeetingForm;
import com.real.logicserver.meeting.model.Meeting;
import com.real.logicserver.meeting.model.MeetingType;
import com.real.logicserver.meeting.model.MeetingUser;
import com.real.logicserver.meeting.form.MeetingCreate;
import com.real.logicserver.meeting.repository.MeetingMapper;
import com.real.logicserver.meeting.repository.MeetingTypeMapper;
import com.real.logicserver.meeting.repository.MeetingUserMapper;


@Service
public class MeetingCreateServiceImpl implements MeetingCreateService  {

	@Autowired
	private MeetingUserMapper meetingUserMapper;
	
	@Autowired
	private MeetingMapper meetingMapper;
	
	@Override
	public boolean meetingCreate(MeetingCreate meetingCreate) {		
		try {
			Meeting meeting = new Meeting();
			meeting.setTypeId(meetingCreate.getType());
			meetingMapper.insertSelective(meeting);
			int meetingId = meeting.getMeId();		
			
			MeetingUser meetingUser = new MeetingUser();
			meetingUser.setCreateTime(new Date(System.currentTimeMillis()));
			meetingUser.setUserId(meetingCreate.getUserId());		
			meetingUser.setMeId(meetingId);
			meetingUserMapper.insertSelective(meetingUser);	
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}


}
