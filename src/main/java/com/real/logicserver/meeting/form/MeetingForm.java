package com.real.logicserver.meeting.form;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author asuis
 */
@Getter
@Setter
public class MeetingForm {
    private String mid;
    private String title;
    private String num;
    private Date startTime;
    private Date endTime;
    private String place;
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
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
}
