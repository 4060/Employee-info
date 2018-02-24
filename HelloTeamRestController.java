package com.vamshi.restfulapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vamshi.restfulapi.Emp;
import com.vamshi.restfulapi.EmpService;

@Controller
public class HelloTeamRestController {
	
	@Autowired
	  private EmpService empService;
		
		@RequestMapping(value = "/emp", method = RequestMethod.GET)		
		@ResponseBody
		public Object index(){ 
			return empService.findAll();
		}
	
	  @RequestMapping(value = "/create", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)	  
	  @ResponseBody
	   public String create(@RequestBody Emp emp) {
		  String userId = "";
	    try {	    
	      
	    	empService.save(emp);
	    
	      userId = String.valueOf(emp.getId());
	    }
	    catch (Exception ex) {
	      return "Error creating the user: " + ex.toString();
	    }
	    return "User succesfully created with id = " + userId;
	  }
	  
	 
	  @RequestMapping("/delete/{id}")
	  @ResponseBody
	  public String delete(@PathVariable int id) {
	    try {
	    	Emp emp = empService.findById(id);
	    	empService.delete(emp);
	    }
	    catch (Exception ex) {
	      return "Error deleting the user:" + ex.toString();
	    }
	    return "User succesfully deleted!";
	  }
	  
	  
	  @RequestMapping("/get-by-email")
	  @ResponseBody
	  public String getByEmail(String email) {
	    String userId = "";
	    try {
	    	Emp emp = empService.findByEmail(email);
	        userId = String.valueOf(emp.getId());
	    }
	    catch (Exception ex) {
	      return "User not found";
	    }
	    return "The user id is: " + userId;
	  }
	  
	  
	  @RequestMapping("/update/{id}")
	  @ResponseBody
	  //public String updateUser(@PathVariable("id") Long id, @PathVariable("name")String name,@PathVariable("email") String email,@PathVariable("password") String password,@PathVariable("PhoneNo") String PhoneNo) {
	  public String updateUser(@RequestBody Emp emp,@PathVariable int id) {
		try {
	    	//Person user = personService.findById(id);
	    	emp.setId(id);
	    	empService.save(emp);
	    }
	    catch (Exception ex) {
	      return "Error updating the user: " + ex.toString();
	    }
	    return "User succesfully updated!";
	  }

}