package com.myspringbootproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myspringbootproject.domain.Blogger;

@Repository
public interface BloggerRepository extends CrudRepository<Blogger, Long> {

	public List<Blogger> findAll();
	
	public Optional<Blogger> findByName(String name);
	
}
