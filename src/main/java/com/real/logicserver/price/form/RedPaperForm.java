package com.real.logicserver.price.form;

import java.math.BigDecimal;

/**
 * @author asuis
 */
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

    public RedPaperForm() {
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public Integer getNum() {
        return this.num;
    }

    public String getType() {
        return this.type;
    }

    public String getToId() {
        return this.toId;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof RedPaperForm)) return false;
        final RedPaperForm other = (RedPaperForm) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$price = this.getPrice();
        final Object other$price = other.getPrice();
        if (this$price == null ? other$price != null : !this$price.equals(other$price)) return false;
        final Object this$num = this.getNum();
        final Object other$num = other.getNum();
        if (this$num == null ? other$num != null : !this$num.equals(other$num)) return false;
        final Object this$type = this.getType();
        final Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
        final Object this$toId = this.getToId();
        final Object other$toId = other.getToId();
        if (this$toId == null ? other$toId != null : !this$toId.equals(other$toId)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $price = this.getPrice();
        result = result * PRIME + ($price == null ? 43 : $price.hashCode());
        final Object $num = this.getNum();
        result = result * PRIME + ($num == null ? 43 : $num.hashCode());
        final Object $type = this.getType();
        result = result * PRIME + ($type == null ? 43 : $type.hashCode());
        final Object $toId = this.getToId();
        result = result * PRIME + ($toId == null ? 43 : $toId.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof RedPaperForm;
    }

    public String toString() {
        return "RedPaperForm(price=" + this.getPrice() + ", num=" + this.getNum() + ", type=" + this.getType() + ", toId=" + this.getToId() + ")";
    }
}
