package com.real.logicserver.meeting.constants;

/**
 * @author asuis
 */
public enum MeetingHistoryType {
    JOINED("joined"),
    VIEWED("viewed"),
    CREATED("created"),
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
