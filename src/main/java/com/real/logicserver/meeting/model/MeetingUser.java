package com.real.logicserver.meeting.model;

import java.util.Date;

public class MeetingUser {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column meeting_user.meeting_user_id
	 * @mbg.generated
	 */
	private Integer meetingUserId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column meeting_user.me_id
	 * @mbg.generated
	 */
	private Integer meId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column meeting_user.user_id
	 * @mbg.generated
	 */
	private Integer userId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column meeting_user.create_time
	 * @mbg.generated
	 */
	private Date createTime;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column meeting_user.meeting_user_id
	 * @return  the value of meeting_user.meeting_user_id
	 * @mbg.generated
	 */
	public Integer getMeetingUserId() {
		return meetingUserId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column meeting_user.meeting_user_id
	 * @param meetingUserId  the value for meeting_user.meeting_user_id
	 * @mbg.generated
	 */
	public void setMeetingUserId(Integer meetingUserId) {
		this.meetingUserId = meetingUserId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column meeting_user.me_id
	 * @return  the value of meeting_user.me_id
	 * @mbg.generated
	 */
	public Integer getMeId() {
		return meId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column meeting_user.me_id
	 * @param meId  the value for meeting_user.me_id
	 * @mbg.generated
	 */
	public void setMeId(Integer meId) {
		this.meId = meId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column meeting_user.user_id
	 * @return  the value of meeting_user.user_id
	 * @mbg.generated
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column meeting_user.user_id
	 * @param userId  the value for meeting_user.user_id
	 * @mbg.generated
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column meeting_user.create_time
	 * @return  the value of meeting_user.create_time
	 * @mbg.generated
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column meeting_user.create_time
	 * @param createTime  the value for meeting_user.create_time
	 * @mbg.generated
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}