package com.emp;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.emp.Emp;
 
import com.emp.EmpService;
 
@ControllerAdvice
public class EmpController {
 
 @Autowired
 EmpService userService;
 
 @SuppressWarnings({ "unchecked" })
@RequestMapping(value="/user/", method = RequestMethod.GET, headers="Accept=application/json")
 public ResponseEntity<List<Emp>> listAllUser(){
  
 
 
  {
      try
      {
    	  
		List<Emp> list = userService.listAllUser();
          if (list == null || list.size() == 0)
          {
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
          else
          {
              return new ResponseEntity<>(list, HttpStatus.OK);
          }
      }
      catch (Exception exc)
      {
          exc.printStackTrace();
          // Don't cache the client -- it's relying on thread-local storage.
          TelemetryClient client = Utility.getTelemetryClient();
          if (client != null) client.trackException(exc);
          return new ResponseEntity<>(exc.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }

 }
 @RequestMapping(value="/add/", method = RequestMethod.POST, headers="Accept=application/json")
 public ResponseEntity<Void> add(@RequestBody Emp user){
  userService.addUser(user);
  
  HttpHeaders headers = new HttpHeaders();
  return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
 }
 
 @RequestMapping(value="/update/{id}", method = RequestMethod.PUT, headers="Accept=application/json")
 public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Emp user){
  user.setId(id);
  userService.updateUser(user);
  
  HttpHeaders headers = new HttpHeaders();
  return new ResponseEntity<Void>(headers, HttpStatus.OK);
 }
 
 @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, headers="Accept=application/json")
 public ResponseEntity<Void> delete(@PathVariable("id") int id, @RequestBody Emp user){
  user.setId(id);
  userService.delete(user);
  
  HttpHeaders headers = new HttpHeaders();
  return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
 }
}