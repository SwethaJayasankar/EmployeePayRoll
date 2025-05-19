package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.example.demo.dto.EmployeePayrollDTO;
	import com.example.demo.mapper.EmployeePayRollmapper;
	import com.example.demo.model.EmployeePayRollmodel;

	@Service
	public class EmployeePayRollService {
		@Autowired
		private EmployeePayRollmapper mapper;
		public String getEmployee() {
			EmployeePayrollDTO dtomodel = mapper.dataToDto(new EmployeePayRollmodel(1,"John",35000));
			return "Name : " +dtomodel.getName() + " Salary : "+dtomodel.getSalary();
		}
	    public EmployeePayrollDTO createEmployee(EmployeePayrollDTO dto) {
	        EmployeePayrollDTO response = mapper.dataToDto(new EmployeePayRollmodel(dto.getId(),dto.getName(),dto.getSalary()));
	        return response;
	    }


	}

