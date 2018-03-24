package com.real.logicserver.meeting.valitor;

import org.springframework.web.multipart.MultipartFile;

import com.real.logicserver.dto.ResultCode;

public class LogoFileValitor {
	
	
	
	public static ResultCode validate(MultipartFile file) {
		String fileName = file.getOriginalFilename();
		String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
		if(fileSuffix.equals(".jpg")||fileSuffix.equals(".png")) {
			return ResultCode.SUCC;
		}
		else {
			return ResultCode.FAIL;
		}
	}
}
