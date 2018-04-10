package com.real.logicserver;

import com.real.logicserver.quiz.model.mongo.Questions;
import com.real.logicserver.quiz.model.mongo.Selection;
import com.real.logicserver.quiz.model.mongo.SingleSelectQuestion;
import com.real.logicserver.quiz.repository.mongo.QuestionsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        singleSelectQuestion.setTitle("这道题的答案是?");

        Selection selection = new Selection("A","你好");
        Selection selection1 = new Selection("B","再见");
        singleSelectQuestion.addSelection(selection);
        singleSelectQuestion.addSelection(selection1);

        questionsRepository.save(questions);
        String str = questions.get_id();
        System.out.println(str);
    }
}
