package com.real.logicserver.quiz.model.mongo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author asuis
 */
public class TextQuestion extends AbstractQuestion {

    private String content;
    private Integer length;
    private List<TextQuestionAnswer> answers;
    TextQuestion(){
        this.type = QuestionType.TEXT;
        answers = new ArrayList<>();
    }
    public void addAnswer(TextQuestionAnswer answer) {
        this.answers.add(answer);
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
