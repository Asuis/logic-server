package com.real.logicserver.meeting.form;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author asuis
 */
@Getter
@Setter
public class MeetingForm {
    private String mid;
    private String title;
    private String num;
    private Date startTime;
    private Date endTime;
    private String place;
}
