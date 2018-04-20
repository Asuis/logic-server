package com.real.logicserver.meeting.form;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class MeetingUpdate {
	private Integer userId;
	private Integer meetingId;
	@JSONField(format="yyyy-MM-dd HH:mm")
	private Date startTime;
	@JSONField(format="yyyy-MM-dd HH:mm")
	private Date endTime;
	private String place;
	private String desc;
	private String title;
	private Integer typeId;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getMeetingId() {
		return meetingId;
	}
	public void setMeetingId(Integer meetingId) {
		this.meetingId = meetingId;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date starTime) {
		this.startTime = starTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
}
