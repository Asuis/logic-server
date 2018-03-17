package com.real.logicserver.quiz.form;

import lombok.Data;

/**
 * @author asuis
 */
@Data
public class QuizItemAnswer<T> {
    private String quizItemId;
    private T ans;
}
