package com.real.logicserver.meeting.service;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.real.logicserver.meeting.form.MeetingUpdate;
import com.real.logicserver.meeting.model.Meeting;
import com.real.logicserver.meeting.repository.MeetingMapper;

@Service
public class MeetingUpdateServiceImpl implements MeetingUpdateService {

	@Autowired
	private MeetingMapper meetingMapper;
	
	@Override
	public boolean meetingUpdate(MeetingUpdate meetingUpdate) {
		try {
			Meeting meeting = new Meeting();
			if(meetingUpdate.getMeetingId()!=null)meeting.setMeId(meetingUpdate.getMeetingId());
			else return false;
			if(meetingUpdate.getDesc()!=null)meeting.setDesc(meetingUpdate.getDesc());
			else return false;
			if(meetingUpdate.getEndTime()!=null)meeting.setEndTime(meetingUpdate.getEndTime());
			else return false;
			if(meetingUpdate.getStarTime()!=null)meeting.setEndTime(meetingUpdate.getStarTime());
			else return false;
			if(meetingUpdate.getPlace()!=null)meeting.setPlace(meetingUpdate.getPlace());
			else return false;
			if(meetingUpdate.getTitle()!=null)meeting.setTitle(meetingUpdate.getTitle());
			else return false;
			System.out.println(meeting.getMeId()+"!"+meeting.getDesc());
			meetingMapper.updateByPrimaryKeySelective(meeting);		
			System.out.println(meeting.getMeId()+"!"+meeting.getDesc());
		}
		//update meeting  SET place = '1',desc = '1',title = '1' where me_id = 1
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
