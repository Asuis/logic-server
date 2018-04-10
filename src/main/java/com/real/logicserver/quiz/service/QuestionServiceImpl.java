package com.real.logicserver.quiz.service;

import com.real.logicserver.quiz.form.QuestionAnswerForm;
import com.real.logicserver.quiz.model.mongo.*;
import com.real.logicserver.quiz.repository.mongo.QuestionsRepository;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public boolean submitQuestionForm(QuestionAnswerForm form) {
        Optional<Questions> questions = questionsRepository.findById(form.getQuestionsId());
        if (questions.isPresent()) {
            Questions questionForm = questions.get();
            List<AbstractQuestion> questionList = questionForm.getQuestions();

            List<AbstractAnswer> answers = form.getAnswers();
            answers.forEach((abstractAnswer) -> {
                String type = abstractAnswer.getType();
                switch (type) {
                    case AnswerType.SINGLE_SELECT_ANSWER:
                        SingleSelectAnswer answer = (SingleSelectAnswer) abstractAnswer;
                        SingleSelectQuestion question = (SingleSelectQuestion) questionList.get(answer.getQid());
                        question.addAnswer(answer);
                        break;
                    case AnswerType.MUL_SELECT_ANSWER:
                        break;
                    case AnswerType.TEXT_ANSWER:
                        TextQuestionAnswer textQuestionAnswer = (TextQuestionAnswer) abstractAnswer;
                        TextQuestion textQuestion = (TextQuestion) questionList.get(textQuestionAnswer.getQid());
                        textQuestion.addAnswer(textQuestionAnswer);
                        break;
                    default:
                        break;
                }
            });
        }
        return true;
    }

    @Override
    public Questions getDetailsQuestionForm(String questionsId) throws NotFoundQuestionException {
        Optional<Questions> questions = questionsRepository.findById(questionsId);
        Questions questions1 = null;
        if (questions.isPresent()) {
            questions1 = questions.get();
        } else {
            throw new NotFoundQuestionException("question 404");
        }
        return questions1;
    }
}