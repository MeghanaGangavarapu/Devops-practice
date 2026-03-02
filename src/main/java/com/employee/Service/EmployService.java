package com.employee.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.Entity.Employee;
import com.employee.Repository.EmployRepository;

@Service
public class EmployService {
	@Autowired
	EmployRepository emprepo;
	
	public Employee createEmploy(Employee emp) {
		return emprepo.save(emp);
	}

	public Optional<Employee> getEmploy(Integer id) {
		return emprepo.findById(id);
	}
	
	public List<Employee> getEmploy() {
		return emprepo.findAll();
	}
	
	public void deleteEmploy(Integer id) {
		 emprepo.deleteById(id);
	}
	
	public void updateEmploy(Integer id, Employee emp, Employee exisEmp) {
		
		if(emp.getFirstName()!=null)
		   exisEmp.setFirstName(emp.getFirstName());
		
		if(emp.getLastName()!=null)
			   exisEmp.setLastName(emp.getLastName());
		
		emprepo.save(exisEmp);
		
		
		
	}

	public Employee save(Employee emp) {
		// TODO Auto-generated method stub
		return null;
	}

	
	}


