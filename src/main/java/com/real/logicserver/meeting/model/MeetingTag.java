package com.real.logicserver.meeting.model;

public class MeetingTag {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column meeting_tag.meeting_tag_id
	 * @mbg.generated
	 */
	private Integer meetingTagId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column meeting_tag.tag_id
	 * @mbg.generated
	 */
	private Integer tagId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column meeting_tag.meeting_id
	 * @mbg.generated
	 */
	private Integer meetingId;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column meeting_tag.meeting_tag_id
	 * @return  the value of meeting_tag.meeting_tag_id
	 * @mbg.generated
	 */
	public Integer getMeetingTagId() {
		return meetingTagId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column meeting_tag.meeting_tag_id
	 * @param meetingTagId  the value for meeting_tag.meeting_tag_id
	 * @mbg.generated
	 */
	public void setMeetingTagId(Integer meetingTagId) {
		this.meetingTagId = meetingTagId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column meeting_tag.tag_id
	 * @return  the value of meeting_tag.tag_id
	 * @mbg.generated
	 */
	public Integer getTagId() {
		return tagId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column meeting_tag.tag_id
	 * @param tagId  the value for meeting_tag.tag_id
	 * @mbg.generated
	 */
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column meeting_tag.meeting_id
	 * @return  the value of meeting_tag.meeting_id
	 * @mbg.generated
	 */
	public Integer getMeetingId() {
		return meetingId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column meeting_tag.meeting_id
	 * @param meetingId  the value for meeting_tag.meeting_id
	 * @mbg.generated
	 */
	public void setMeetingId(Integer meetingId) {
		this.meetingId = meetingId;
	}
}