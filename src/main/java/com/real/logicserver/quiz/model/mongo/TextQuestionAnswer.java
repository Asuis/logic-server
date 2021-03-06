package com.real.logicserver.quiz.model.mongo;

import com.real.logicserver.meeting.dto.SimpleUserInfo;

import java.util.Date;

/**
 * @author asuis
 */
public class TextQuestionAnswer extends AbstractAnswer {
    private String content;
    private Date time;
    private SimpleUserInfo simpleUserInfo;

    public TextQuestionAnswer(String content, SimpleUserInfo simpleUserInfo) {
        this.setType(AnswerType.TEXT_ANSWER);
        this.time = new Date(System.currentTimeMillis());
        this.content = content;
        this.simpleUserInfo = simpleUserInfo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public SimpleUserInfo getSimpleUserInfo() {
        return simpleUserInfo;
    }

    public void setSimpleUserInfo(SimpleUserInfo simpleUserInfo) {
        this.simpleUserInfo = simpleUserInfo;
    }
}