package com.vamshi.restfulapi;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vamshi.restfulapi.Emp;

@Repository
public interface EmpRepository extends CrudRepository<Emp,Integer> {
	public Emp findByEmail(String email);
	/***public Person findUsingEmail(String email);******/
	
}