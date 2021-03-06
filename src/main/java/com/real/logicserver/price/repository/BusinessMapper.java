package com.real.logicserver.price.repository;

import com.real.logicserver.price.model.Business;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BusinessMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table business
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer businessId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table business
     *
     * @mbg.generated
     */
    int insert(Business record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table business
     *
     * @mbg.generated
     */
    int insertSelective(Business record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table business
     *
     * @mbg.generated
     */
    Business selectByPrimaryKey(Integer businessId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table business
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Business record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table business
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Business record);
}