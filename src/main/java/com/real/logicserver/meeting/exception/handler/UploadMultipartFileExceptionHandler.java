package com.real.logicserver.meeting.exception.handler;

import com.real.logicserver.dto.Result;
import com.real.logicserver.dto.ResultCode;
import com.real.logicserver.meeting.dto.UpLoadLogoResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;

/**
 * @author asuis
 */
@ControllerAdvice
public class UploadMultipartFileExceptionHandler {
    @ExceptionHandler(MultipartException.class)
    @ResponseBody
    public Result<UpLoadLogoResult> handleError1(MultipartException e) {
        UpLoadLogoResult result = new UpLoadLogoResult();
        result.setMsg("file size too large");
        return new Result<>(ResultCode.FAIL,result,"file size too large");
    }
}
