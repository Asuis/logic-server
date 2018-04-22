package com.real.logicserver.meeting.service.impl;

import com.real.logicserver.meeting.service.MeetingDeleteService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.real.logicserver.meeting.form.MeetingDelete;
import com.real.logicserver.meeting.model.Meeting;
import com.real.logicserver.meeting.repository.MeetingMapper;

@Service
public class MeetingDeleteServiceImpl implements MeetingDeleteService {

	@Autowired
	private MeetingMapper meetingMapper;
	
	@Override
	public boolean meetingDelete(MeetingDelete meetingDelete) {
		try {
			Meeting meeting = new Meeting();
			meeting.setMeId(meetingDelete.getMeetingId());
			
			meetingMapper.updateByPrimaryKeySelective(meeting);
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}

}
