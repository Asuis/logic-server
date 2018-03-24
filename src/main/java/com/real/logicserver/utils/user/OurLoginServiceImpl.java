package com.real.logicserver.utils.user;

import com.alibaba.fastjson.JSON;
import com.real.logicserver.dto.Result;
import com.real.logicserver.utils.user.model.LoginResult;
import com.real.logicserver.utils.user.model.OurUserInfo;
import com.real.logicserver.utils.user.model.PcLoginResult;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * @author asuis
 */
@Service
public class OurLoginServiceImpl implements OurLoginService {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(OurLoginServiceImpl.class);
    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    @Override
    public String login(HttpServletRequest request) {
        String code = request.getHeader("X-WX-Code");
        String data = request.getHeader("X-WX-Encrypted-Data");
        String iv = request.getHeader("X-WX-IV");
        if (code!=null&&data!=null&&iv!=null) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("X-WX-Code",code);
            headers.add("X-WX-Encrypted-Data",data);
            headers.add("X-WX-IV",iv);

            HttpEntity<String> httpEntity = new HttpEntity<>(null, headers);

            Result<LoginResult> result = null;
            ResponseEntity<String> responseEntity = null;

            try {
                responseEntity = restTemplate.exchange("http://user-server/wx/login",HttpMethod.GET,httpEntity,String.class);
            } catch (Exception e) {
                log.warn("login service error",e.getMessage());
            }
            if (responseEntity!=null) {
                return responseEntity.getBody();
            }
            return null;
        }

        return null;
    }

    @Override
    public Result<PcLoginResult> pcLogin(HttpServletRequest request) {
        String sid = request.getParameter("sid");
        String token = request.getParameter("token");
        if (sid!=null&&token!=null) {
        }
        return null;
    }

    @Override
    public OurUserInfo pcCheck(HttpServletRequest request) {
        OurUserInfo ourUserInfo = null;
        String auth = request.getHeader("Authorization");
        if (auth!=null) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization",auth);
            Result<OurUserInfo> result = null;
            ResponseEntity<Result> resultResponseEntity = null;
            HttpEntity<String> httpEntity = new HttpEntity<>(null, headers);
            try {
                resultResponseEntity = restTemplate.exchange("http://user-server/pc/check",HttpMethod.GET,httpEntity,Result.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (resultResponseEntity!=null) {
                try {
                    ourUserInfo = (OurUserInfo) resultResponseEntity.getBody().getData();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return ourUserInfo;
    }

    @Override
    public OurUserInfo wxCheck(HttpServletRequest request) {
        OurUserInfo ourUserInfo = null;
        String id = request.getHeader("WX_HEADER_ID");
        String skey = request.getHeader("WX_HEADER_SKEY");
        if (id!=null&&skey!=null) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("WX_HEADER_ID",id);
            headers.add("WX_HEADER_SKEY",skey);
            HttpEntity<String> httpEntity = new HttpEntity<>(null, headers);
            ResponseEntity<Result> resultResponseEntity = null;
            try {
                resultResponseEntity = restTemplate.exchange("http://user-server/wx/check",HttpMethod.GET,httpEntity,Result.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (resultResponseEntity!=null) {
                try {
                    ourUserInfo = (OurUserInfo) resultResponseEntity.getBody().getData();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return ourUserInfo;
    }
}
