package com.java.mockprojectspringboot.service;

import java.util.List;
import java.util.Optional;

import com.java.mockprojectspringboot.entity.Category;

public interface CateService {
	
	List<Category> getCate();

	Optional<Category> findById(int id);
	
	Category getCateByName(String name);
	
	Category saveCate(Category cate);
	
	void addCate(Category cate);
	
	Category updateCate(Category cate);
	
	void deleteCate(int id);
	
}
