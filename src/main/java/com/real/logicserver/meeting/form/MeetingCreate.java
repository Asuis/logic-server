package com.real.logicserver.meeting.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MeetingCreate {
	private Integer type;
	private Integer userId;
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
