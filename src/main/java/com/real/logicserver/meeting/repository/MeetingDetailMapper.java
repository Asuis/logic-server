package com.real.logicserver.meeting.repository;

import com.real.logicserver.meeting.model.MeetingDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MeetingDetailMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table meeting_detail
	 * @mbg.generated
	 */
	int deleteByPrimaryKey(Integer meetingDetailId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table meeting_detail
	 * @mbg.generated
	 */
	int insert(MeetingDetail record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table meeting_detail
	 * @mbg.generated
	 */
	int insertSelective(MeetingDetail record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table meeting_detail
	 * @mbg.generated
	 */
	MeetingDetail selectByPrimaryKey(Integer meetingDetailId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table meeting_detail
	 * @mbg.generated
	 */
	int updateByPrimaryKeySelective(MeetingDetail record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table meeting_detail
	 * @mbg.generated
	 */
	int updateByPrimaryKey(MeetingDetail record);
}