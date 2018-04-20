package com.real.logicserver.quiz.model.mongo;

/**
 * @author asuis
 */
public class Selection {

    private String serialNumber;
    private String content;
    /**
     * 选择的人数
     * */
    private Integer num;

    public Selection(String serialNumber, String content) {
        this.serialNumber = serialNumber;
        this.content = content;
        this.num = 0;
    }
    public Selection() {
        this.num = 0;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
    public void addNum(int de) {
        this.num+=de;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public String getContent() {
        return this.content;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
