package com.real.logicserver.meeting.constants;

/**
 * @author asuis
 */
public enum MeetingHistoryType {
    /**
     * JOINED 加入的会议
     */
    JOINED("joined"),
    /**
     * 查看过的会议 加入的会议
     */
    VIEWED("viewed"),
    /**
     * 创建过的会议
     * */
    CREATED("created"),
    /**
     * 进行中的会议
     * */
    GOING("going");
    private String name;

    MeetingHistoryType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}