package com.employee.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
	@Table(name = "employee")
	public class Employee {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		@Column
	    @NotBlank(message = "Name is required")
		private String firstName;
		
		@Column
		@Email(message = "Email must be valid")
		private String emailAddress;
		
		@Column
		@NotBlank(message = "Name is required")
		private String lastName;
		
		@Column
		private String department;
		@Column
		private String jobTitle;
		
		@Column
	    @Positive(message = "Salary must be a positive number")
		private int salary;
		
		
		


		public  Integer getId() {
			return id;
		}



		public  void setId(Integer id) {
			this.id = id;
		}



		public  String getFirstName() {
			return firstName;
		}



		public  void setFirstName(String firstName) {
			this.firstName = firstName;
		}



		public  String getEmailAddress() {
			return emailAddress;
		}



		public  void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}



		public  String getLastName() {
			return lastName;
		}



		public  void setLastName(String lastName) {
			this.lastName = lastName;
		}



		public  String getDepartment() {
			return department;
		}



		public  void setDepartment(String department) {
			this.department = department;
		}



		public  String getJobTitle() {
			return jobTitle;
		}



		public  void setJobTitle(String jobTitle) {
			this.jobTitle = jobTitle;
		}



		public  int getSalary() {
			return salary;
		}



		public  void setSalary(int i) {
			this.salary = i;
		}



		public Employee(Integer id, String firstName, String emailAddress, String lastName, String department,
				String jobTitle, int salary) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.emailAddress = emailAddress;
			this.lastName = lastName;
			this.department = department;
			this.jobTitle = jobTitle;
			this.salary = salary;
		}



		public Employee() {
			super();
		}
	}

