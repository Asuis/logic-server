package com.real.logicserver.price.service;

import com.real.logicserver.dto.Result;
import com.real.logicserver.dto.ResultCode;
import com.real.logicserver.price.api.PayApi;
import com.real.logicserver.price.constants.PayType;
import com.real.logicserver.price.dto.OrderInfo;
import com.real.logicserver.price.model.Business;
import com.real.logicserver.price.repository.BusinessMapper;
import com.real.logicserver.utils.tools.IpAdrressUtil;
import com.real.logicserver.utils.tools.UUIDUtil;
import com.real.logicserver.utils.user.OurLoginService;
import com.real.logicserver.utils.user.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * @author 15988440973
 */
@Service
public class PayServiceImpl implements PayService {

    private final PayApi payApi;

    private final BusinessMapper businessMapper;

    private final OurLoginService ourLoginService;

    @Autowired
    public PayServiceImpl(PayApi payApi, OurLoginService ourLoginService, BusinessMapper businessMapper) {
        this.payApi = payApi;
        this.ourLoginService = ourLoginService;
        this.businessMapper = businessMapper;
    }
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Result<OrderInfo> payRedPaper(HttpServletRequest request) {

        Result<OrderInfo> orderResult = new Result<>();

        UserInfo userInfo = ourLoginService.checkWx(request);

        String ip = IpAdrressUtil.getIpAdrress(request);

        String no  = UUIDUtil.get24UUID();

        Integer price = (Integer) request.getAttribute("total_fee");
        if (price==null) {
            price=1;
        }
        OrderInfo orderInfo = payApi.unifiedOrder("1",userInfo.getOpenId(),no,ip,PayType.REDP);

        if (orderInfo!=null) {
            try {
                Business business = new Business();
                business.setProductId(no);
                business.setOpenId(userInfo.getOpenId());
                business.setTotalFee(price);
                business.setTradeType(PayType.REDP);
                business.setSpbillCreateIp(ip);
                business.setUpdateTime(new Date(System.currentTimeMillis()));
                business.setState("none");
                businessMapper.insert(business);
            } catch (RuntimeException e) {
                e.printStackTrace();
                throw e;
            }
            orderResult.setCode(ResultCode.SUCC);
            orderResult.setData(orderInfo);
        }

        return orderResult;
    }

    @Override
    public String noticePay(String str) {
        return payApi.paymentNotice(str);
    }
}
