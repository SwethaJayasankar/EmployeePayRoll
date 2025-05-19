
	package com.example.demo.dto;

	public class EmployeePayrollDTO {
		private long id;
		private String name;
		private double salary;
	    public EmployeePayrollDTO() {}
		public EmployeePayrollDTO(long id, double salary, String name) {
			this.id = id;
			this.salary = salary;
			this.name = name;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public double getSalary() {
			return salary;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "EmployeePayrollDTO{" +
					"id=" + id +
					", name='" + name + '\'' +
					", salary=" + salary +
					'}';
		}
	}

