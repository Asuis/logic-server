package com.real.logicserver.meeting.service;

import java.util.List;

import com.real.logicserver.meeting.form.MeetingSignedMembers;
import com.real.logicserver.meeting.model.MeetingSigned;
import com.real.logicserver.meeting.model.MeetingUser;

public interface MeetingMemberService {
	
	public List<MeetingUser> getMeetingMembers(Integer meetingId);
	
	public List<MeetingSignedMembers> getMeetingSignMembers(Integer meetingId);
	
	public MeetingSigned meetingSigned(Integer meetingId,Integer userId);
	
}
