package com.real.logicserver.quiz.form;

import com.real.logicserver.quiz.model.mongo.AbstractAnswer;
import com.real.logicserver.quiz.model.mongo.Questions;

import java.util.List;

/**
 * @author asuis
 */
public class QuestionAnswerForm {

    private String questionsId;

    private List<AbstractAnswer> answers;

    public String getQuestionsId() {
        return questionsId;
    }

    public void setQuestionsId(String questionsId) {
        this.questionsId = questionsId;
    }

    public List<AbstractAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AbstractAnswer> answers) {
        this.answers = answers;
    }
}
