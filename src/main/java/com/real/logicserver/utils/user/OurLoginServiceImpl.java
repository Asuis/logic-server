package com.real.logicserver.utils.user;

import com.alibaba.fastjson.JSON;
import com.real.logicserver.dto.Result;
import com.real.logicserver.utils.user.model.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author asuis
 */
@Service
public class OurLoginServiceImpl implements OurLoginService {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(OurLoginServiceImpl.class);

    private final RestTemplate restTemplate;

    @Autowired
    public OurLoginServiceImpl(@LoadBalanced RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

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

            HttpEntity<String> httpEntity = new HttpEntity<>("", headers);

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
            HttpEntity<String> httpEntity = new HttpEntity<>("", headers);
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
        String id = request.getHeader("x-wx-id");
        String skey = request.getHeader("x-wx-skey");
        if (id!=null&&skey!=null) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("x-wx-id",id);
            headers.add("x-wx-skey",skey);
            HttpEntity<String> httpEntity = new HttpEntity<>("", headers);
            ResponseEntity<String> resultResponseEntity = null;
            Res res = null;
            try {
                resultResponseEntity = restTemplate.exchange("http://user-server/wx/check",HttpMethod.GET,httpEntity,String.class);
                res = JSON.parseObject(resultResponseEntity.getBody(),Res.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (resultResponseEntity!=null) {
                try {
                    ourUserInfo = res.getData();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return ourUserInfo;
    }

    @Override
    public UserInfo checkWx(HttpServletRequest request) {
        UserInfo userInfo = null;
        String id = request.getHeader("x-wx-id");
        String skey = request.getHeader("x-wx-skey");
        if (id!=null&&skey!=null) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("x-wx-id",id);
            headers.add("x-wx-skey",skey);
            HttpEntity<String> httpEntity = new HttpEntity<>("", headers);
            ResponseEntity<String> resultResponseEntity = null;
            UserInfoRes res = null;
            try {
                resultResponseEntity = restTemplate.exchange("http://user-server/wx/user",HttpMethod.GET,httpEntity,String.class);
                res = JSON.parseObject(resultResponseEntity.getBody(),UserInfoRes.class);
                userInfo = res.getData();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return userInfo;
    }
}
