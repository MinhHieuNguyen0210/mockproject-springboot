package com.java.mockprojectspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.mockprojectspringboot.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	Category getByName(String name);

}
