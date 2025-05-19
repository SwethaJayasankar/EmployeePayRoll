package com.example.demo.mapper;
import org.springframework.stereotype.Component;
import com.example.demo.dto.EmployeePayrollDTO;
import com.example.demo.model.EmployeePayRollmodel;

	@Component
	public class EmployeePayRollmapper {
		
		public EmployeePayrollDTO dataToDto(EmployeePayRollmodel e) {
			EmployeePayrollDTO emp = new EmployeePayrollDTO(e.getId(),e.getSalary(),e.getName());
			return emp;
		}
		public EmployeePayRollmodel DtoToData(EmployeePayrollDTO e) {
			EmployeePayRollmodel emp = new EmployeePayRollmodel();
			emp.setId(e.getId());
			emp.setName(e.getName());
			emp.setSalary(e.getSalary());
			return emp;
		}

	}

	
