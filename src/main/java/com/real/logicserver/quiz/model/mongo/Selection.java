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
