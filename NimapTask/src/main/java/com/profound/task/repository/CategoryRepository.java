package com.profound.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.profound.task.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
