package com.myspringbootproject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myspringbootproject.domain.Story;

@Repository
public interface StoryRepository extends CrudRepository<Story, Long>{
	
	//SELECT * FROM STORIES
	public List<Story> findAll();
	
	//SELECT * FROM STORIES where latest_updated IN(SELECT MAX(latest_updated) FROM STORIES) LIMIT 1 
	public Story findFirstByOrderByLatestUpdatedDesc();

	public Story findByTitle(String title);
	
}
