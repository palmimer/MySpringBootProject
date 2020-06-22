package com.myspringbootproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myspringbootproject.domain.Story;

@Repository
public interface StoryRepository extends CrudRepository<Story, Long>{
	
	//SELECT * FROM STORIES
	public List<Story> findAll();
	
	//SELECT * FROM STORIES where latest_updated IN(SELECT MAX(latest_updated) FROM STORIES) LIMIT 1 
	public Story findFirstByOrderByLatestUpdatedDesc();

//	public Story findByTitle(String title);
	
//	@Query("") JPQL nyelven végzi a lekérdezést (objektumokban dolgozik)
//	@Query(value = "select * from story where title = ?1 limit 1", nativeQuery = true) 
//	@Query(value = "select * from story where title = :title limit 1", nativeQuery = true)
	@Query(value = "select s from Story s where s.title = :title")
	public Story findByTitle(@Param("title") String title);
	
	//JPA nyelven megfogalmazott lekérdezés:
	public List<Story> findAllByBloggerNameIgnoreCaseOrderByLatestUpdatedDesc();
	
	
	
}
