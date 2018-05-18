package com.real.logicserver.price.api;

import com.alibaba.fastjson.JSON;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayUtil;
import com.real.logicserver.aop.RedisLockable;
import com.real.logicserver.dto.Result;
import com.real.logicserver.dto.ResultCode;
import com.real.logicserver.price.config.WxPayConfig;
import com.real.logicserver.price.constants.PayType;
import com.real.logicserver.price.dto.OrderInfo;
import com.real.logicserver.price.model.Business;
import com.real.logicserver.price.repository.BusinessMapper;
import com.real.logicserver.utils.tools.IpAdrressUtil;
import com.real.logicserver.utils.tools.UUIDUtil;
import com.real.logicserver.utils.user.OurLoginService;
import com.real.logicserver.utils.user.model.OurUserInfo;
import com.real.logicserver.utils.user.model.UserInfo;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author 15988440973
 */
@Component
public class PayApi {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(PayApi.class);

    private final WxPayConfig wxPayConfig;

    private static final String SUCCESS = "SUCCESS";
    private static final String ERROR = "FAIL";

    @Autowired
    public PayApi(WxPayConfig wxPayConfig) {
        this.wxPayConfig = wxPayConfig;
    }

    /**
     * 发起统一订单
     * */
    @RedisLockable(key = "#openId",expiration = 10)
    public OrderInfo unifiedOrder(String price,String openId,String no, String ip, String type) {

        WXPay wxPay = new WXPay(wxPayConfig);


        HashMap<String,String> data = new HashMap<>();

        data.put("openid", openId);

        data.put("body","red");

        data.put("out_trade_no",no);

        data.put("fee_type","CNY");

        data.put("total_fee",price);

        data.put("spbill_create_ip",ip);

//        data.put("notify_url","https://asuis.mengxiangjing.com/logic-server/v1/pay/notice");
        data.put("notify_url","https://asuis.mynatapp.cc/v1/pay/notice/");
        data.put("trade_type","JSAPI");

        data.put("product_id", PayType.REDP);


        Map<String,String> result = null;

        try {
            result = wxPay.unifiedOrder(data);
        } catch (Exception e) {

            e.printStackTrace();
        }
        OrderInfo orderInfo = new OrderInfo();

        if (result!=null) {

            String returnCode = result.get("return_code");

            if (SUCCESS.equals(returnCode)){

                String resultCode = result.get("result_code");

                if (SUCCESS.equals(resultCode)) {
                    HashMap<String,String> map = new HashMap<>(10);
                    map.put("package","prepay_id="+result.get("prepay_id"));
                    map.put("nonceStr",WXPayUtil.generateNonceStr());
                    map.put("timeStamp",System.currentTimeMillis()+"");
                    map.put("appId",wxPayConfig.getAppID());
                    map.put("signType","MD5");
                    try {
                        map.put("paySign",WXPayUtil.generateSignature(map,wxPayConfig.getKey()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    orderInfo.setAppId(map.get("appId"));
                    orderInfo.setNonceStr(map.get("nonceStr"));
                    orderInfo.setPaySign(map.get("paySign"));
                    orderInfo.setTimeStamp(map.get("timeStamp"));
                    orderInfo.setPackage(map.get("package"));
                    orderInfo.setSignType(map.get("signType"));



                }
            }
        }
        return orderInfo;
    }

    public String paymentNotice(String str){
        Map<String,String> res = null;
        try {
            res = WXPayUtil.xmlToMap(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (res != null) {
            log.info(JSON.toJSONString(res));
            String returnCode = res.get("return_code");
            if ("SUCCESS".equalsIgnoreCase(returnCode)) {
                String appId = res.get("appid");
                String mchId = res.get("mch_id");
                String nonceStr = res.get("nonce_str");
                String sign = res.get("sign");
                String signType = res.get("signType");
                String resultCode=  res.get("result_code");
                String openId = res.get("openId");
                String totalFee = res.get("total_fee");
                String 	transactionId = res.get("transaction_id");
                String outTradeNo = res.get("out_trade_no");
                String timeEnd = res.get("time_end");
            } else {
                log.info("\t签名失败\t\n",res.get("return_msg"));
            }
        }
        HashMap<String,String> result = new HashMap<>();
        result.put("return_code","SUCCESS");
        String xml = null;
        try {
            xml = WXPayUtil.mapToXml(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xml;
    }
}