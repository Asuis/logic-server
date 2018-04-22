package com.real.logicserver.meeting.service.impl;

import java.util.Date;

import com.real.logicserver.meeting.service.MeetingUpdateService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.real.logicserver.meeting.form.MeetingUpdate;
import com.real.logicserver.meeting.model.Meeting;
import com.real.logicserver.meeting.repository.MeetingMapper;

/**
 * @author asuis
 */
@Service
public class MeetingUpdateServiceImpl implements MeetingUpdateService {

	private final MeetingMapper meetingMapper;

	@Autowired
	public MeetingUpdateServiceImpl(MeetingMapper meetingMapper) {
		this.meetingMapper = meetingMapper;
	}

	@Override
	public boolean meetingUpdate(MeetingUpdate meetingUpdate) {
		try {
			Meeting meeting = new Meeting();
			if(meetingUpdate.getMeetingId()!=null) {
				meeting.setMeId(meetingUpdate.getMeetingId());
			} else {
				return false;
			}
			if(meetingUpdate.getDesc()!=null) {
				meeting.setDesc(meetingUpdate.getDesc());
			} else {
				return false;
			}
			if(meetingUpdate.getEndTime()!=null) {
				meeting.setEndTime(meetingUpdate.getEndTime());
			} else {
				return false;
			}
			if(meetingUpdate.getStartTime()!=null) {
				meeting.setEndTime(meetingUpdate.getStartTime());
			} else {
				return false;
			}
			if(meetingUpdate.getPlace()!=null) {
				meeting.setPlace(meetingUpdate.getPlace());
			} else {
				return false;
			}
			if(meetingUpdate.getTitle()!=null) {
				meeting.setTitle(meetingUpdate.getTitle());
			} else {
				return false;
			}
			//todo 处理反馈信息
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
