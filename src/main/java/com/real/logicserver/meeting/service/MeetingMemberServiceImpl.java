package com.real.logicserver.meeting.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.real.logicserver.meeting.form.MeetingSignedMembers;
import com.real.logicserver.meeting.model.MeetingSigned;
import com.real.logicserver.meeting.model.MeetingUser;
import com.real.logicserver.meeting.repository.MeetingSignedMapper;
import com.real.logicserver.meeting.repository.MeetingUserMapper;

@Service
public class MeetingMemberServiceImpl implements MeetingMemberService {
	
	@Autowired
	private MeetingUserMapper meetingUserMapper;
	
	@Autowired
	private MeetingSignedMapper meetingSignedMapper;
	
	
	@Override
	public List<MeetingUser> getMeetingMembers(Integer meetingId){
		
		List<MeetingUser> list = meetingUserMapper.getMeetingMembers(meetingId);
		for(int n = 0;n < list.size(); n++) {
			if(list.get(n).getStatus()==0) {
				list.remove(n);
			}
		}
		
		return list;
	}

	@Override
	public List<MeetingSignedMembers> getMeetingSignMembers(Integer meetingId) {
		
		List<MeetingSigned> list1 = meetingSignedMapper.getMeetingSignedMembers(meetingId);
		HashMap<Integer,MeetingSigned> map = new HashMap<Integer,MeetingSigned>();
		List<MeetingUser> list2 = meetingUserMapper.getMeetingMembers(meetingId);
		List<MeetingSignedMembers> list = new ArrayList<MeetingSignedMembers>();
		for(int n=0;n<list1.size();n++) {
			map.put(list1.get(n).getUserId(), list1.get(n));
		}
		
		for(int n=0;n<list2.size();n++) {
			MeetingSignedMembers meetingSignedMembers = new MeetingSignedMembers();
			meetingSignedMembers.setUserId(list2.get(n).getUserId());
			if(map.containsKey(list2.get(n).getUserId())) {
				meetingSignedMembers.setSigned(true);
				meetingSignedMembers.setSignedPlace(map.get(list2.get(n).getUserId()).getPlace());
				meetingSignedMembers.setSignedTime(map.get(list2.get(n).getUserId()).getSignedTime());
			}
			else meetingSignedMembers.setSigned(false);	
			
			if(list2.get(n).getStatus()==0)continue;
			
			list.add(meetingSignedMembers);
		}		
		
		return list;
	}

	@Override
	public MeetingSigned meetingSigned(Integer meetingId, Integer userId) {
		
		//未加入会议
		List<MeetingUser> list = meetingUserMapper.getMeetingMembers(meetingId);
		boolean userYes = false;
		for(int n=0;n<list.size();n++) {
			if(list.get(n).getUserId()==userId) {
				userYes = true;
				break;
			}
		}
		//已签到
		List<MeetingSigned> list2 = meetingSignedMapper.getMeetingSignedMembers(meetingId);
		for(int n=0;n<list2.size();n++) {
			if(list.get(n).getUserId()==userId) {
				userYes = false;
				break;
			}
		}
		if(userYes) {
			MeetingSigned meetingSigned = new MeetingSigned();
			meetingSigned.setMeetingId(meetingId);
			meetingSigned.setPlace("地点");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	        String strTime = String.valueOf(new Date().getTime());
	        Date date = null;
			try {
				date = format.parse(strTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    	        
			meetingSigned.setSignedTime(date);
			meetingSigned.setUserId(userId);
			meetingSignedMapper.insert(meetingSigned);
			return meetingSigned;
		}
		else {
			return null;
		}
		
		
	}
}
