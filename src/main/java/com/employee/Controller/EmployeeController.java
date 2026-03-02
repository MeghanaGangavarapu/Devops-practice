package com.employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.Entity.Employee;
import com.employee.Service.EmployService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	@Autowired
	EmployService empService;

	@PostMapping("employees")
	public ResponseEntity<Employee> create(@Valid @RequestBody Employee emp) {
		empService.createEmploy(emp);
		return new ResponseEntity<>(HttpStatus.CREATED);

	}

	@GetMapping("employees/{id}")
	public ResponseEntity<Employee> findEmploy(@PathVariable("id") Integer employId) {
		Employee emp = empService.getEmploy(employId).orElse(new Employee());
		if (emp.getId() != null) {
			return new ResponseEntity<>(emp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("employees/{id}")
	public ResponseEntity<Employee> deleteEmploy(@PathVariable("id") Integer employId) {
		Employee emp = empService.getEmploy(employId).orElse(new Employee());
		if (emp.getId() != null) {
			empService.deleteEmploy(employId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("employees")
	public ResponseEntity<List<Employee>> findEmploy() {
		List<Employee> emp = empService.getEmploy();
		if (emp.size() > 0) {
			return new ResponseEntity<>(emp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("employees/{id}")
	public ResponseEntity<Employee> update(@PathVariable("id") Integer employId, @RequestBody Employee emp) {
		Employee exitEmp = empService.getEmploy(employId).orElse(new Employee());
		if (exitEmp.getId() != null) {
			empService.updateEmploy(employId, emp, exitEmp);
			return new ResponseEntity<>(HttpStatus.OK);

		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}

}
