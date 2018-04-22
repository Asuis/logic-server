package com.real.logicserver.meeting.service.impl;

import java.util.List;

import com.real.logicserver.meeting.service.MeetingSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.real.logicserver.meeting.model.Meeting;
import com.real.logicserver.meeting.query.MeetingQuery;
import com.real.logicserver.meeting.repository.MeetingMapper;

@Service
public class MeetingSearchServiceImpl implements MeetingSearchService {

	@Autowired
	private MeetingMapper meetingMapper;

	
	@Override
	public Meeting meetingSearch(MeetingQuery meetingQuery) {
		Meeting res = null;
		try {			
			
			res = meetingMapper.selectByPrimaryKey(Integer.valueOf(meetingQuery.getQuery()));
		}
		catch(Exception e) {
			return null;
		}
		return res;
	}

}
