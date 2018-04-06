package com.real.logicserver.quiz.form;

import java.util.List;

/**
 * @author asuis
 */
public class Question {
    private String title;
    private List<Chioce> chioces;

    public String getTitle() {
        return this.title;
    }

    public List<Chioce> getChioces() {
        return this.chioces;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setChioces(List<Chioce> chioces) {
        this.chioces = chioces;
    }
}
