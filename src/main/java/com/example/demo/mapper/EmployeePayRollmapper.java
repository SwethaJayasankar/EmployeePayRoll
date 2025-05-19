package com.example.demo.mapper;

import java.util.List;
import java.util.stream.Collectors;

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
	public List<EmployeePayrollDTO> listOfDataToDto(List<EmployeePayRollmodel > e){
		return e.stream().map(x->dataToDto(x)).collect(Collectors.toList());
	}
	public List<EmployeePayRollmodel> listOfDtoToData(List<EmployeePayrollDTO > e){
		return e.stream().map(y->DtoToData(y)).collect(Collectors.toList());
	}

}
