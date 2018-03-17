package com.real.logicserver.quiz.form;

import lombok.Data;

import java.util.List;

/**
 * @author asuis
 */
@Data
public class QuizAnswer {
    private String quizId;
    private List<QuizItemAnswer> answers;
}