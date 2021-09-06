package com.java.mockprojectspringboot.entity;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionList {

    public QuestionList(List<Question> questions) {
        this.questions = questions;
    }

    private List<Question> questions;

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
