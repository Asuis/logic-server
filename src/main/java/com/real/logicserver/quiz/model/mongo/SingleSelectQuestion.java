package com.real.logicserver.quiz.model.mongo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author asuis
 */
public class SingleSelectQuestion extends AbstractQuestion {
    private HashMap<String,Selection> selections;
    private String trueAnswer;
    private HashMap<String,List<SingleSelectAnswer>> answers;

    public SingleSelectQuestion(){
        this.type = QuestionType.SINGLE_SELECT;
        this.answers = new HashMap<>();
    }


    public void setTrueAnswer(String trueAnswer) {
        this.trueAnswer = trueAnswer;
    }


    public HashMap<String,List<SingleSelectAnswer>> getAnswers() {
        return answers;
    }

    public String getTrueAnswer() {
        return trueAnswer;
    }

    public void addAnswer(SingleSelectAnswer answer) {
        String select = answer.getSerialNumber();
        if (selections.containsKey(select)) {
            selections.get(select).addNum(1);
            if (answers.containsKey(select)) {
                answers.get(select).add(answer);
            } else {
                List<SingleSelectAnswer> answerList = new ArrayList<>();
                answerList.add(answer);
                answers.put(select,answerList);
            }
        }
    }
    public void addSelection(Selection selection) {
        this.selections.put(selection.getSerialNumber(),selection);
    }
}