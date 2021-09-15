package com.java.mockprojectspringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.mockprojectspringboot.entity.Category;
import com.java.mockprojectspringboot.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
	List<Question> findByCate(Category cate);
}
