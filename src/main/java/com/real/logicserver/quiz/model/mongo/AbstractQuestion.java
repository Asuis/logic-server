package com.real.logicserver.quiz.model.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author asuis
 */
public abstract class AbstractQuestion {
    protected String title;
    protected String type;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
