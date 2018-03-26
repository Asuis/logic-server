package com.real.logicserver.quiz.form;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

/**
 * @author asuis
 */
public class TextQuestion {
    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
