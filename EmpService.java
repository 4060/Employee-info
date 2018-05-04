package com.vamshi.restfulapi;

import org.springframework.stereotype.Service;

import com.vamshi.restfulapi.Emp;
import com.vamshi.restfulapi.EmpRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class EmpService {

    @Autowired
    private EmpRepository empRepository;

    public Object findAll(){
        return empRepository.findAll();
    }

    public Emp findById(Integer id){
        return empRepository.findOne(id);
    }

    public Emp save(Emp emp){
        return empRepository.save(emp);
    }

    public void delete(Emp emp){
    	empRepository.delete(emp);
    	return;
    }

	public Emp findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
    
}