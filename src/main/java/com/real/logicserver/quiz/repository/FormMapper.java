package com.real.logicserver.quiz.repository;

import com.real.logicserver.quiz.model.Form;

public interface FormMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table form
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer formId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table form
     *
     * @mbg.generated
     */
    int insert(Form record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table form
     *
     * @mbg.generated
     */
    int insertSelective(Form record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table form
     *
     * @mbg.generated
     */
    Form selectByPrimaryKey(Integer formId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table form
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Form record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table form
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Form record);
}