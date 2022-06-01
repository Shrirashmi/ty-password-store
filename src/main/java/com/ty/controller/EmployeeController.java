package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dto.Employee;
import com.ty.dto.User;
import com.ty.service.EmployeeService;

public class EmployeeController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("Name");
		String phone = req.getParameter("Phone");
		String address = req.getParameter("Address");
		String gender = req.getParameter("Gender");
		String role = req.getParameter("Role");
		
		Employee employee = new Employee();
		employee.setName(name);
		employee.setPhone(phone);
		employee.setAddress(address);
		employee.setGender(gender);
		employee.setRole(role);
		
		
		PrintWriter printWriter = resp.getWriter();
		EmployeeService service = new EmployeeService();
		Employee employee2 = service.saveEmployee(employee);
		if (employee2 != null) {
		printWriter.write("<html><body>");
		printWriter.write("<h1>Name: " + name + " </h1>");
		printWriter.write("<h2>Phone: " + phone + " </h2>");
		printWriter.write("<h3>Address: " + address + " </h3>");
		printWriter.write("<h4>Gender: " + gender + " </h4>");
		printWriter.write("<h5>Role: " + role + " </h5>");
		printWriter.write(name + " Your Employee Id is: " + employee2.getId());
		} else {
			printWriter.write("<html><body><h1> Employee not saved </h1></body></html>");
		}
	}
}
