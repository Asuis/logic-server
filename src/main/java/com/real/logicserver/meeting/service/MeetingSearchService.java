package com.real.logicserver.meeting.service;

import java.util.List;
import com.real.logicserver.meeting.model.Meeting;
import com.real.logicserver.meeting.query.MeetingQuery;

public interface MeetingSearchService {

	public Meeting meetingSearch(MeetingQuery meetingQuery);
	
}
