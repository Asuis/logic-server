package com.real.logicserver.quiz.model.mongo;

/**
 * @author asuis
 */
public class TextQuestion extends Question {

    private String content;
    private Integer length;

    TextQuestion(){
        this.type = QuestionType.TEXT;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getLength() {
        return length;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
