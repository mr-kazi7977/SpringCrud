package com.hello.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hello.demo.exception.Resourcenotfound;
import com.hello.demo.model.Employee;
import com.hello.demo.repository.EmployeeRepo;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepo repo;
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/employees")
	public List<Employee> disp() {
		
		return repo.findAll();
	}
	

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/employees")
	public Employee createempl(@RequestBody Employee empl) {
		return repo.save(empl);
	}
		

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/employees/{id}") //read
	public ResponseEntity<Employee> getalls(@PathVariable int id) {
		Employee al=repo.findById(id).orElse(new Employee());
		return ResponseEntity.ok(al);
	}
	
	

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateem(@PathVariable int id,@RequestBody Employee empl){
		Employee al=repo.findById(id).orElse(new Employee());
		al.setFirstname(empl.getFirstname());
		al.setLastname(empl.getLastname());
		al.setEmail(empl.getEmail());
		
		Employee upd = repo.save(al);
		return ResponseEntity.ok(upd);
	}
	
	

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> delete(@PathVariable int id){
		Employee al=repo.findById(id).orElseThrow(() -> new Resourcenotfound("Employee Not exist with Id "+id));
		repo.delete(al);
		Map<String, Boolean> response= new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	

}
