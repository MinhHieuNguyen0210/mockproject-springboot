package com.java.mockprojectspringboot.service;

import java.util.List;
import java.util.Optional;

import com.java.mockprojectspringboot.entity.Category;

public interface CateService {
	
	List<Category> findAll();

	Optional<Category> findById(int id);
}
