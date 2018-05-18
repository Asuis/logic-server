package com.real.logicserver.utils.user;

import com.real.logicserver.dto.Result;
import com.real.logicserver.utils.user.model.OurUserInfo;
import com.real.logicserver.utils.user.model.PcLoginResult;
import com.real.logicserver.utils.user.model.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author asuis
 */
public interface OurLoginService {
    /**
     * 登录方法
     * @param request 带有会话的请求
     * @return OurUserInfo 用户信息
     */
    public String login(HttpServletRequest request);

    /**
     * pc端登录
     * @param request pc端发送的request
     * @return OurUserInfo 用户信息
     */
    public Result<PcLoginResult> pcLogin(HttpServletRequest request);
    /**
     * pc端检查用户身份
     * @param request 检查会话
     * @return 返回用户信息
     */
    public OurUserInfo pcCheck(HttpServletRequest request);

    /**
     * 小程序检查用户身份
     * @param request 检查会话 
     * @return 返回用户信息
     */
    public OurUserInfo wxCheck(HttpServletRequest request);

    public UserInfo checkWx(HttpServletRequest request);
}
