package com.newt.mytraining.controller;

import java.io.IOException;
import java.util.List;


import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.newt.mytraining.entity.Admin;
import com.newt.mytraining.entity.Employee;
import com.newt.mytraining.service.EmployeeService;
//import com.newt.mytraining.model.Employee;

import com.newt.mytraining.entity.Student;




@CrossOrigin(origins = "http://localhost:4200")
@RestController// controller+ response
public class EmployeeController {

private static final Logger logger = Logger
.getLogger(EmployeeController.class);

public EmployeeController(){}
@Autowired
private EmployeeService employeeService;

@GetMapping("/{id}")
public ResponseEntity<Employee> getEmployee(@PathVariable int id) throws IOException {
Employee employee=employeeService.getEmployee(id);
return ResponseEntity.ok(employee);
}
@PostMapping(value="/login")
	public boolean	loginValidate(@RequestBody Admin admin) {
	List<Employee> listHR1 = employeeService.getAllEmployees();
	for(Employee hr1:listHR1) {
	if(hr1.getEmail().equals(admin.getEmail()) && hr1.getPassword().equals(admin.getPassword())) {
	return true;
	}
	}
	return false;
	
	
}

@GetMapping("/")
public ResponseEntity<List<Employee>> listEmployee() throws IOException {
List<Employee> listEmployee = employeeService.getAllEmployees();
return ResponseEntity.ok(listEmployee);
}


@PostMapping(value = "/")
public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {

employeeService.addEmployee(employee);

return ResponseEntity.ok().body("New employee is added");
}

@DeleteMapping("/{id}")
public ResponseEntity<?> deleteEmployee(@PathVariable int id) {

employeeService.deleteEmployee(id);
return ResponseEntity.ok().body("Employeen with id:"+id+"deleted sucessfully");
}

@PutMapping("/")
public ResponseEntity<?> editContact(@RequestBody Employee employee) {
employeeService.updateEmployee(employee);

return ResponseEntity.ok().body("Employee is update sucessfully") ;
}
@GetMapping("/selectedstudent")
public ResponseEntity<Student[]> getStudent() throws IOException
{
final String baseURL = "http://localhost:8001/marks/90"
		+ ""
		+ "";
RestTemplate restTemplate = new RestTemplate();

Student[] e = restTemplate.getForObject(baseURL, Student[].class);

return ResponseEntity.ok().body(e);

}




}
