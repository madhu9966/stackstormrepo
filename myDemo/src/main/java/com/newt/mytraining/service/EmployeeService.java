package com.newt.mytraining.service;

import java.util.List;

import com.newt.mytraining.entity.Employee;
 
public interface EmployeeService {
     
    public void addEmployee(Employee employee);
 
   // public List<Employee> getAllEmployees();
 
    public void deleteEmployee(Integer employeeId);
 
    public Employee getEmployee(int id);
 
    public Employee updateEmployee(Employee employee);

	public List<Employee> getAllEmployees();
}
