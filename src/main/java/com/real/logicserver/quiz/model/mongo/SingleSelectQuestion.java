package com.real.logicserver.quiz.model.mongo;

import java.util.List;

/**
 * @author asuis
 */
public class SingleSelectQuestion extends AbstractQuestion {
    private List<Selection> selections;
    private String trueAnswer;
    private List<SingleSelectAnswer> answers;

    public SingleSelectQuestion(){
        this.type = QuestionType.SINGLE_SELECT;
    }

    public void setSelections(List<Selection> selections) {
        this.selections = selections;
    }

    public void setTrueAnswer(String trueAnswer) {
        this.trueAnswer = trueAnswer;
    }

    public List<Selection> getSelections() {
        return selections;
    }

    public List<SingleSelectAnswer> getAnswers() {
        return answers;
    }

    public String getTrueAnswer() {
        return trueAnswer;
    }

    public void setAnswers(List<SingleSelectAnswer> answers) {
        this.answers = answers;
    }
    public void addAnswer(SingleSelectAnswer answer) {
        this.answers.add(answer);
    }
    public void addSelection(Selection selection) {
        this.selections.add(selection);
    }
}