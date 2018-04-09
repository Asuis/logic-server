package com.real.logicserver.quiz.form;

import com.real.logicserver.quiz.model.mongo.Questions;

/**
 * @author asuis
 */
public class QuestionForm {
    private String meetingId;
    private Questions questions;

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }
}
