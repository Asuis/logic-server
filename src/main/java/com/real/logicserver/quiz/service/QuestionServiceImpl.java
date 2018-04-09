package com.real.logicserver.quiz.service;

import com.real.logicserver.quiz.model.mongo.Questions;
import com.real.logicserver.quiz.repository.mongo.QuestionsRepository;
import org.bson.BSON;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author asuis
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(QuestionServiceImpl.class);
    @Autowired
    private QuestionsRepository questionsRepository;

    @Override
    public String createQuestionForm(Questions questions) {
        try {
            questionsRepository.save(questions);
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return questions.get_id();
    }

    @Override
    public boolean deleteQuestionForm(String id) {
        try {
            questionsRepository.deleteById(id);
        } catch (Exception e) {
            log.warn(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean submitQuestionForm() {
        return false;
    }

    @Override
    public boolean getDetailsQuestionForm() {
        return false;
    }
}
