package com.java.mockprojectspringboot.service;

import java.util.List;

import com.java.mockprojectspringboot.entity.Category;
import com.java.mockprojectspringboot.entity.Question;
import com.java.mockprojectspringboot.entity.QuestionList;
import com.java.mockprojectspringboot.entity.User;


public interface QuizService {
	QuestionList getQuestions();

	Long getUserResult(QuestionList questionList);

	void saveScore(User user);

	List<User> getTopScore();

	QuestionList getQuestionByCate(Category category);

	void saveQuestion(Question question);
}
