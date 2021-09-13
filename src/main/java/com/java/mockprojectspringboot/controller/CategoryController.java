package com.java.mockprojectspringboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.java.mockprojectspringboot.entity.Category;
import com.java.mockprojectspringboot.service.CateService;

@Controller
public class CategoryController {
	
	@Autowired
	CateService cateService;
	
	@GetMapping("/cates")
	public List<Category> findAllCate(){
		return cateService.getCate();
	}
	
	@PostMapping("/addCate")
	public Category addCate(@RequestBody Category cate) {
		return cateService.saveCate(cate);
	}
	
	@GetMapping("/cate/{id}")
	public Optional<Category> findCateById( @PathVariable int id) {
		return cateService.findById(id);
	}
	
	@GetMapping("/cate/{name}")
	public Category findCateByName(@PathVariable String name) {
		return cateService.getCateByName(name);
	}	
	
	@PostMapping("/update")
	public Category updateCate(@RequestBody Category cate) {
		return cateService.updateCate(cate);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteCate(@PathVariable int id) {
		cateService.deleteCate(id);
	}
}
