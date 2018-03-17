package com.real.logicserver.meeting.dto;

import com.real.logicserver.meeting.constants.MeetingHistoryType;
import lombok.Data;

/**
 * @author asuis
 */
@Data
public class MeetingHistoryQuery {
    private String userId;
    private MeetingHistoryType type;
    private Integer page;
    private Integer pageSize;
}
