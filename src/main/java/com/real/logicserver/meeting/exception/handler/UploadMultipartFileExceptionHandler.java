package com.real.logicserver.meeting.exception.handler;

import com.real.logicserver.dto.Result;
import com.real.logicserver.dto.ResultCode;
import com.real.logicserver.meeting.dto.UpLoadLogoResult;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
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
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Result handleBindException(BindException ex) {
        // ex.getFieldError():随机返回一个对象属性的异常信息。如果要一次性返回所有对象属性异常信息，则调用ex.getAllErrors()
        FieldError fieldError = ex.getFieldError();
        StringBuilder sb = new StringBuilder();
        sb.append(fieldError.getField()).append("=[").append(fieldError.getRejectedValue()).append("]")
                .append(fieldError.getDefaultMessage());
        // 生成返回结果
        Result errorResult = new Result();
        errorResult.setCode(ResultCode.BAD_REQUEST);
        errorResult.setMsg(sb.toString());
        return errorResult;
    }
}
