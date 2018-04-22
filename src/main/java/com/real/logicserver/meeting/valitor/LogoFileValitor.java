package com.real.logicserver.meeting.valitor;

import org.springframework.web.multipart.MultipartFile;

import com.real.logicserver.dto.ResultCode;

/**
 * @author 36
 */
public class LogoFileValitor {
	
	private static final String JPG = ".jpg";
	private static final String PNG = ".png";
	
	public static ResultCode validate(MultipartFile file) {
		String fileName = file.getOriginalFilename();
		String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
		if(JPG.equals(fileSuffix) || PNG.equals(fileSuffix)) {
			return ResultCode.SUCC;
		}
		else {
			return ResultCode.FAIL;
		}
	}
}
