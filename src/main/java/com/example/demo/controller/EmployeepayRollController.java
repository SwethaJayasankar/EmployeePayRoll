package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeePayrollDTO;
import com.example.demo.service.EmployeePayRollService;

@RestController
@RequestMapping("/employeepayservice")
public class EmployeepayRollController {
	
	@Autowired
	private EmployeePayRollService eps;
	
	@GetMapping("/")
	public List<EmployeePayrollDTO> getEmployeeData(){
		return eps.getEmployee();
	}
	@GetMapping("/{id}")
	public EmployeePayrollDTO getEmployeeById(@PathVariable long id) {
		return eps.getEmployeeById(id);
	}
	@PostMapping("/create")
    public String createNewEmployee(@RequestBody EmployeePayrollDTO dto) {
        return eps.createEmployee(new EmployeePayrollDTO(dto.getId(),dto.getSalary(),dto.getName()));
    }
	
	@PutMapping("/update/{id}")
	public EmployeePayrollDTO updateEmployee(@PathVariable long id,@RequestBody EmployeePayrollDTO dto) {
		return eps.updateEmployee(id,new EmployeePayrollDTO(dto.getId(),dto.getSalary(),dto.getName()));
	}
	@DeleteMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable long id) {
		eps.deleteEmployee(id);
	}

}