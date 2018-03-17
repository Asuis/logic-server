package com.real.logicserver.meeting.model;

import java.util.Date;

public class MeetingSigned {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column meeting_signed.meeting_signed_id
     *
     * @mbg.generated
     */
    private Integer meetingSignedId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column meeting_signed.meeting_id
     *
     * @mbg.generated
     */
    private Integer meetingId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column meeting_signed.mark
     *
     * @mbg.generated
     */
    private String mark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column meeting_signed.signed_time
     *
     * @mbg.generated
     */
    private Date signedTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column meeting_signed.place
     *
     * @mbg.generated
     */
    private String place;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meeting_signed.meeting_signed_id
     *
     * @return the value of meeting_signed.meeting_signed_id
     *
     * @mbg.generated
     */
    public Integer getMeetingSignedId() {
        return meetingSignedId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meeting_signed.meeting_signed_id
     *
     * @param meetingSignedId the value for meeting_signed.meeting_signed_id
     *
     * @mbg.generated
     */
    public void setMeetingSignedId(Integer meetingSignedId) {
        this.meetingSignedId = meetingSignedId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meeting_signed.meeting_id
     *
     * @return the value of meeting_signed.meeting_id
     *
     * @mbg.generated
     */
    public Integer getMeetingId() {
        return meetingId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meeting_signed.meeting_id
     *
     * @param meetingId the value for meeting_signed.meeting_id
     *
     * @mbg.generated
     */
    public void setMeetingId(Integer meetingId) {
        this.meetingId = meetingId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meeting_signed.mark
     *
     * @return the value of meeting_signed.mark
     *
     * @mbg.generated
     */
    public String getMark() {
        return mark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meeting_signed.mark
     *
     * @param mark the value for meeting_signed.mark
     *
     * @mbg.generated
     */
    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meeting_signed.signed_time
     *
     * @return the value of meeting_signed.signed_time
     *
     * @mbg.generated
     */
    public Date getSignedTime() {
        return signedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meeting_signed.signed_time
     *
     * @param signedTime the value for meeting_signed.signed_time
     *
     * @mbg.generated
     */
    public void setSignedTime(Date signedTime) {
        this.signedTime = signedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meeting_signed.place
     *
     * @return the value of meeting_signed.place
     *
     * @mbg.generated
     */
    public String getPlace() {
        return place;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meeting_signed.place
     *
     * @param place the value for meeting_signed.place
     *
     * @mbg.generated
     */
    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }
}