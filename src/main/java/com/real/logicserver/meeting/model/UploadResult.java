package com.real.logicserver.meeting.model;

import lombok.Data;

/**
 * @author asuis
 */
@Data
public class UploadResult {
    private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
    
}
