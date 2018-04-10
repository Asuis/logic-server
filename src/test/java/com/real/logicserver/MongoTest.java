package com.real.logicserver;

import com.real.logicserver.quiz.model.mongo.Questions;
import com.real.logicserver.quiz.model.mongo.SingleSelectQuestion;
import com.real.logicserver.quiz.repository.mongo.QuestionsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoTest {

    @Autowired
    QuestionsRepository questionsRepository;

    @Test
    public void test() {
        Questions questions = new Questions();
        questions.setDate(new Date(System.currentTimeMillis()));
        questions.setTitle("question");
        SingleSelectQuestion singleSelectQuestion = new SingleSelectQuestion();
        singleSelectQuestion.setTitle("question");

        questionsRepository.save(questions);
        String str = questions.get_id();
        System.out.println(str);
    }
}
