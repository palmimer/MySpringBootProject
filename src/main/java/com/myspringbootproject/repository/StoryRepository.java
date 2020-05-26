package com.myspringbootproject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.myspringbootproject.domain.Story;

public interface StoryRepository extends CrudRepository<Story, Long>{
	
	
	public List<Story> findAll();
	
}
