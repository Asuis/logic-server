package com.real.logicserver.meeting.form;

import java.util.Date;

public class MeetingSignedMembers {
	private Integer userId;
	private Date signedTime;
	private String signedPlace;
	private Integer userRole;
	private boolean signed;
	public boolean isSigned() {
		return signed;
	}
	public void setSigned(boolean signed) {
		this.signed = signed;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Date getSignedTime() {
		return signedTime;
	}
	public void setSignedTime(Date signedTime) {
		this.signedTime = signedTime;
	}
	public String getSignedPlace() {
		return signedPlace;
	}
	public void setSignedPlace(String signedPlace) {
		this.signedPlace = signedPlace;
	}
	public Integer getUserRole() {
		return userRole;
	}
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
	
}
