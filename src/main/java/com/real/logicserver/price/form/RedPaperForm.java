package com.real.logicserver.price.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author asuis
 */
@Data
public class RedPaperForm {
    /**
     * 红包金额
     * */
    private BigDecimal price;
    /**
     * 红包个数
     * */
    private Integer num;
    /**
     * 红包类型
     * 定向红包，还是？？？
     * */
    private String type;
    /**
     * 定向红包 则是某人id，
     * 随机红包则是 会议id
     * */
    private String toId;
}
