package com.real.logicserver.meeting.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author asuis
 */
@Data
public class MeetingSimpleInfo {
    private Integer mid;
    private String title;
    private String desc;
    private String logo;
    private Date start;
    private Date end;
}
