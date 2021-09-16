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
	public Category saveCate(Category cate) {
		return cateRepo.save(cate);
	}

	@Override
	public List<Category> getCate() {
		return cateRepo.findAll();
	}

	@Override
	public Optional<Category> findById(int id) {
		return cateRepo.findById(id);
	}

	@Override
	public Category getCateByName(String name) {
		return cateRepo.getByName(name);
	}


	@Override
	public void addCate(Category cate) {
		cateRepo.save(cate);
	}


	@Override
	public Category updateCate(Category cate) {
		Category existCate = cateRepo.findById(cate.getId()).orElse(null);
		existCate.setName(cate.getName());
		return cateRepo.save(existCate);
	}

	@Override
	public void deleteCate(int id) {
		cateRepo.deleteById(id);
	}



	@Override
	public void createCategory(Category category) {
		cateRepo.save(category);
	}
}
