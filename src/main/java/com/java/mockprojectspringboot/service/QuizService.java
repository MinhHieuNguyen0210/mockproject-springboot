package com.java.mockprojectspringboot.service;

import com.java.mockprojectspringboot.entity.QuestionList;
import com.java.mockprojectspringboot.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface QuizService {
    QuestionList getQuestions();
    Long getUserResult (QuestionList questionList);
    void saveScore(User user);
    List<User> getTopScore();
}
