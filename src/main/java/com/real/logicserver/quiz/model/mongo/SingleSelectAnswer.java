package com.real.logicserver.quiz.model.mongo;

import com.real.logicserver.meeting.dto.SimpleUserInfo;

import java.util.Date;


/**
 * @author asuis
 */
public class SingleSelectAnswer extends AbstractAnswer {
    private String serialNumber;
    private Date time;
    private SimpleUserInfo simpleUserInfo;

    public SingleSelectAnswer(String serialNumber, SimpleUserInfo simpleUserInfo) {
        setType(AnswerType.SINGLE_SELECT_ANSWER);
        this.serialNumber = serialNumber;
        this.time = new Date(System.currentTimeMillis());
        this.simpleUserInfo = simpleUserInfo;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
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
