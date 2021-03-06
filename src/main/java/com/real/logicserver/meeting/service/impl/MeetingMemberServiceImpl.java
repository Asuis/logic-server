package com.real.logicserver.meeting.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.real.logicserver.meeting.service.MeetingMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.real.logicserver.meeting.form.MeetingSignedMembers;
import com.real.logicserver.meeting.model.MeetingSigned;
import com.real.logicserver.meeting.model.MeetingUser;
import com.real.logicserver.meeting.repository.MeetingSignedMapper;
import com.real.logicserver.meeting.repository.MeetingUserMapper;

/**
 * @author 36
 */
@Service
public class MeetingMemberServiceImpl implements MeetingMemberService {
	
	private final MeetingUserMapper meetingUserMapper;
	
	private final MeetingSignedMapper meetingSignedMapper;

	@Autowired
	public MeetingMemberServiceImpl(MeetingUserMapper meetingUserMapper, MeetingSignedMapper meetingSignedMapper) {
		this.meetingUserMapper = meetingUserMapper;
		this.meetingSignedMapper = meetingSignedMapper;
	}


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
		for (MeetingSigned aList1 : list1) {
			map.put(aList1.getUserId(), aList1);
		}

		for (MeetingUser aList2 : list2) {
			MeetingSignedMembers meetingSignedMembers = new MeetingSignedMembers();
			meetingSignedMembers.setUserId(aList2.getUserId());
			if (map.containsKey(aList2.getUserId())) {
				meetingSignedMembers.setSigned(true);
				meetingSignedMembers.setSignedPlace(map.get(aList2.getUserId()).getPlace());
				meetingSignedMembers.setSignedTime(map.get(aList2.getUserId()).getSignedTime());
			} else {
				meetingSignedMembers.setSigned(false);
			}

			if (aList2.getStatus() == 0) {
				continue;
			}

			list.add(meetingSignedMembers);
		}		
		
		return list;
	}

	@Override
	public MeetingSigned meetingSigned(Integer meetingId, Integer userId) {

		//未加入会议
		List<MeetingUser> list = meetingUserMapper.getMeetingMembers(meetingId);
		boolean userYes = false;
		for (MeetingUser aList : list) {
			if (aList.getUserId().equals(userId)) {
				userYes = true;
				break;
			}
		}
		//已签到
		List<MeetingSigned> list2 = meetingSignedMapper.getMeetingSignedMembers(meetingId);
		for(int n=0;n<list2.size();n++) {
			if(list.get(n).getUserId().equals(userId)) {
				userYes = false;
				break;
			}
		}
		if(userYes) {
			MeetingSigned meetingSigned = new MeetingSigned();
			meetingSigned.setMeetingId(meetingId);
			meetingSigned.setPlace("地点");

			meetingSigned.setSignedTime(new Date(System.currentTimeMillis()));
			meetingSigned.setUserId(userId);
			meetingSignedMapper.insert(meetingSigned);
			return meetingSigned;
		}
		else {
			return null;
		}
	}
}
