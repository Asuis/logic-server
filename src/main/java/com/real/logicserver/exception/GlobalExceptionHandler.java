package com.real.logicserver.exception;

import com.real.logicserver.dto.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author asuis
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    public Result castException() {
        return null;
    }
}
