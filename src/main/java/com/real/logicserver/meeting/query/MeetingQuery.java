package com.real.logicserver.meeting.query;

import lombok.Data;

/**
 * @author asuis
 * 关键字查询会议
 */

public class MeetingQuery {

    private String query;
    private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
    
}
