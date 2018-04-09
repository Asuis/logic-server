package com.real.logicserver.meeting.service;

import java.util.List;

import com.real.logicserver.meeting.model.MeetingUser;

public interface MeetingHistoryService {
	public List<MeetingUser> getMeetingHistory(Integer userId);
}
