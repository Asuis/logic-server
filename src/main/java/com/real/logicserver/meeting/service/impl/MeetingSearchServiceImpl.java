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

	private final MeetingMapper meetingMapper;

	@Autowired
	public MeetingSearchServiceImpl(MeetingMapper meetingMapper) {
		this.meetingMapper = meetingMapper;
	}


	@Override
	public Meeting meetingSearch(MeetingQuery meetingQuery) {
		Meeting res = null;
		try {			
			Integer mid = Integer.valueOf(meetingQuery.getQuery());
			res = meetingMapper.selectByPrimaryKey(mid);

		}
		catch(Exception e) {
			return null;
		}
		return res;
	}

}
