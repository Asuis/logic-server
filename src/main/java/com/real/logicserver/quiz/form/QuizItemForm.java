package com.real.logicserver.quiz.form;

import lombok.Data;

import java.util.List;

/**
 * @author asuis
 * 单个quiz对象
 */
@Data
public class QuizItemForm {
    private String title;
    private List<SelectItem> list;
    /**
    * 多选 单选
    * **/
    private String type;
    private List<Integer> answer;
}
