package com.real.logicserver.quiz.repository;

import com.real.logicserver.quiz.model.TextAnswers;

public interface TextAnswersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table text_answers
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer textAnswersId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table text_answers
     *
     * @mbg.generated
     */
    int insert(TextAnswers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table text_answers
     *
     * @mbg.generated
     */
    int insertSelective(TextAnswers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table text_answers
     *
     * @mbg.generated
     */
    TextAnswers selectByPrimaryKey(Integer textAnswersId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table text_answers
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TextAnswers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table text_answers
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TextAnswers record);
}