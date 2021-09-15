package com.java.mockprojectspringboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.mockprojectspringboot.entity.Category;
import com.java.mockprojectspringboot.repository.CategoryRepository;
import com.java.mockprojectspringboot.service.CateService;

@Service
public class CateServiceImpl implements CateService{

	@Autowired
	CategoryRepository cateRepo;
	
	
	@Override
	public List<Category> findAll() {
		return cateRepo.findAll();
	}


	@Override
	public Optional<Category> findById(int id) {
		return cateRepo.findById(id);
	}

	@Override
	public void createCategory(Category category) {
		cateRepo.save(category);
	}
}
