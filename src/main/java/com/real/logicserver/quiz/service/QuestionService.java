package com.real.logicserver.quiz.service;

import com.real.logicserver.quiz.model.mongo.Questions;
import org.bson.BSON;

/**
 * @author asuis
 */
public interface QuestionService {
    public String createQuestionForm(Questions questions);
    public boolean deleteQuestionForm(String id);
    public boolean submitQuestionForm();
    public boolean getDetailsQuestionForm();
}
