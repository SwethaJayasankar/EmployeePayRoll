package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeePayrollDTO;
import com.example.demo.mapper.EmployeePayRollmapper;
import com.example.demo.model.EmployeePayRollmodel;

@Service
public class EmployeePayRollService {
	@Autowired
	private EmployeePayRollmapper mapper;
	
	List<EmployeePayRollmodel> employeelist = new ArrayList<>(); 
	
	public List<EmployeePayrollDTO> getEmployee(){
		return employeelist.stream().map(x->mapper.dataToDto(x)).collect(Collectors.toList());
	}
	public EmployeePayrollDTO getEmployeeById(long id) {
		try {
			for(int i=0;i<employeelist.size();i++) {
				if(employeelist.get(i).getId()==id) {
					return mapper.dataToDto(employeelist.get(i));
				}
			}
		}
		catch(Exception e) {
			System.out.println("EMPLOYEE NOT FOUND");
		}
		return null;
	}
	
	public String createEmployee(EmployeePayrollDTO d) {
		employeelist.add(mapper.DtoToData(d));
		return "Successfully added " + d.getName() + "to the list";
	}
	public EmployeePayrollDTO updateEmployee(long id,EmployeePayrollDTO emp) {
		for (EmployeePayRollmodel e : employeelist) {
	        if (e.getId() == id) {
	            e.setName(emp.getName());
	            e.setSalary(emp.getSalary());
	            return mapper.dataToDto(e); 
	        }
	    }
	    return null; 
	}
    public void deleteEmployee(long id) {
    	try {
    		for (EmployeePayRollmodel e : employeelist) {
    	        if (e.getId() == id) {
    	            employeelist.remove(e);
    	            return ;
    	        }
    	    }
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    }

}