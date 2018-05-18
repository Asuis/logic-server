package com.real.logicserver.price.service;

import com.real.logicserver.dto.Result;
import com.real.logicserver.price.dto.OrderInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author 15988440973
 */
public interface PayService {
    Result<OrderInfo> payRedPaper(HttpServletRequest request);
    String noticePay(String str);
}
