package com.real.logicserver.meeting.dto;

import lombok.Data;

/**
 * @author asuis
 */
@Data
public class UpLoadLogoResult {
    private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
    
}
