package com.real.logicserver.price.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author asuis
 */
@Setter
@Getter
public class OrderInfo {
    private String nonceStr;
    private String timeStamp;
    private String appId;
    private String Package;
    private String signType;
    private String paySign;
}
