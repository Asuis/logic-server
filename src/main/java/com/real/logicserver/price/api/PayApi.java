package com.real.logicserver.price.api;

import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayUtil;
import com.real.logicserver.dto.Result;
import com.real.logicserver.price.config.WxPayConfig;
import com.real.logicserver.utils.user.OurLoginService;
import com.real.logicserver.utils.user.model.OurUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 15988440973
 */
@Component
public class PayApi {

    @Autowired
    OurLoginService ourLoginService;

    @Autowired
    WxPayConfig wxPayConfig;

    private static final String SUCCESS = "SUCCESS";
    private static final String ERROR = "FAIL";

    /**
     * 发起统一订单
     * */
    public HashMap<String, String> unifiedOrder(HttpServletRequest request) {

        OurUserInfo userInfo = ourLoginService.wxCheck(request);
        String openId = "";

        WXPay wxPay = new WXPay(wxPayConfig);

        HashMap<String,String> data = new HashMap<>();

        data.put("openid",openId);
        data.put("body","");
        data.put("out_trade_no","2015");
        data.put("fee_type","CNY");
        data.put("total_fee","1");
        data.put("spbill_create_ip","123.123.123.123");
        data.put("notify_url","");
        data.put("trade_type","JSAPI");

        Map<String,String> result = null;
        try {
            result = wxPay.unifiedOrder(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result!=null) {
            String returnCode = result.get("return_code");
            if ("SUCCESS".equals(returnCode)){
                String resultCode = result.get("result_code");
                if ("SUCCESS".equals(resultCode)) {
                    String prepayId = result.get("prepay_id");
                }
            }
        }
        return null;
    }

    public Result paymentNotice(String str){
        Map<String,String> res = null;
        try {
            res = WXPayUtil.xmlToMap(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (res != null) {
            String returnCode = res.get("return_code");

        }
        return null;
    }
}
