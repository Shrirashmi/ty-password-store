package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dto.Employee;
import com.ty.service.EmployeeService;

public class ValidateEmployeeController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("Name");
		String phone = req.getParameter("Phone");

		Employee employee = new Employee();
		employee.setName(name);
		employee.setPhone(phone);

		EmployeeService employeeService = new EmployeeService();
		List<Employee> employees = employeeService.validateEmployee(name, phone);

		PrintWriter printWriter = resp.getWriter();
		if (employees.size() > 0) {
			for (Employee employee2 : employees) {
				printWriter.write("<html><body>");
				printWriter.write("<h1>Name: " + name + " </h1>");
				printWriter.write("<h2>Phone: " + phone + " </h2>");
				printWriter.write(name + " You have logged in successfully and your Id is: " + employee2.getId());
			}
		} else {
			printWriter.write("<html><body><h1> Login failed!! </h1></body></html>");
		}
	}
}
