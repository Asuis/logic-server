package com.real.logicserver.social.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.real.logicserver.social.model.UserDetail;

@Repository
@Mapper
public interface UserDetailMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_detail
	 * @mbg.generated
	 */
	int deleteByPrimaryKey(Integer userId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_detail
	 * @mbg.generated
	 */
	int insert(UserDetail record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_detail
	 * @mbg.generated
	 */
	int insertSelective(UserDetail record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_detail
	 * @mbg.generated
	 */
	UserDetail selectByPrimaryKey(Integer userId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_detail
	 * @mbg.generated
	 */
	int updateByPrimaryKeySelective(UserDetail record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_detail
	 * @mbg.generated
	 */
	int updateByPrimaryKey(UserDetail record);
}