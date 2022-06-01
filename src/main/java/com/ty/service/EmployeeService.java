package com.ty.service;

import java.util.List;

import com.ty.dao.EmployeeDao;
import com.ty.dto.Employee;

public class EmployeeService {
	EmployeeDao dao = new EmployeeDao();

	public Employee saveEmployee(Employee employee) {
		return dao.saveEmployee(employee);
	}
	
	public List<Employee> validateEmployee(String name, String phone){
		return dao.validateEmployee(name, phone);
	}
}
