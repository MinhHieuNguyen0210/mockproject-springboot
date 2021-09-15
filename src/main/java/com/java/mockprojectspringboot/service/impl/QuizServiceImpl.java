package com.java.mockprojectspringboot.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.java.mockprojectspringboot.entity.Category;
import com.java.mockprojectspringboot.entity.Question;
import com.java.mockprojectspringboot.entity.QuestionList;
import com.java.mockprojectspringboot.entity.User;
import com.java.mockprojectspringboot.repository.CategoryRepository;
import com.java.mockprojectspringboot.repository.QuestionRepository;
import com.java.mockprojectspringboot.repository.UserRepository;
import com.java.mockprojectspringboot.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    Question question;
    @Autowired
    QuestionList questionList;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    User user;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CategoryRepository cateRepo;

    @Override
    public QuestionList getQuestions() {
        List<Question> allQuestion = questionRepository.findAll();
        List<Question> qList = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int rand = random.nextInt(allQuestion.size());
            qList.add(allQuestion.get(rand));
            allQuestion.remove(rand);
        }
        questionList.setQuestions(qList);
        return questionList;
    }

    @Override
    public void saveQuestion(Question question) {
        questionRepository.save(question);
    }

    @Override
    public Long getUserResult(QuestionList questionList) {
        long numberOfCorrect = questionList.getQuestions()
                .stream()
                .filter(item -> item.getChose() == item.getAns())
                .count();
        return numberOfCorrect;
    }

    @Override
    public void saveScore(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getTopScore() {
        List<User> listTopScore = userRepository.findAll(Sort.by(Sort.Direction.DESC, "totalCorrect"));
        return listTopScore;
    }

	@Override
	public QuestionList getQuestionByCate(Category cate) {
//		 List<Question> listQuesByCate = questionRepository.findByCate(cate);
		questionList.setQuestions(questionRepository.findByCate(cate));
//		 questionList.setQuestions(listQuesByCate);
		return questionList;
	}
	//cho nay phai ko e dr a 

	
}
