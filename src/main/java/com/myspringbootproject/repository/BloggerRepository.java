package com.myspringbootproject.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.myspringbootproject.domain.Blogger;


public interface BloggerRepository extends CrudRepository<Blogger, Long> {

	public List<Blogger> findAll();
	
	
	
}
