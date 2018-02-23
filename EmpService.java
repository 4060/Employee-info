package com.emp;
 
import java.util.List;
 
import com.emp.Emp;
 
public interface EmpService {
 
public List listAllUser();
 
 public void addUser(Emp user);
 
 public void updateUser(Emp user);
 
 public void delete(Emp user);
 
 public Emp findUserById(Emp user);
}