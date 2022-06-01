package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dto.User;
import com.ty.service.UserService;

public class UserController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String n1 = req.getParameter("Name");
		String n2 = req.getParameter("Email");
		String n3 = req.getParameter("Password");
		String n4 = req.getParameter("Gender");

		User user = new User();
		user.setName(n1);
		user.setEmail(n2);
		user.setPassword(n3);
		user.setGender(n4);
		
		PrintWriter printWriter = resp.getWriter();

		String htmlCode1 = "<html><body><h1>Name: " + n1 + " </h1></body></html>";
		String htmlCode2 = "<html><body><h1>Email: " + n2 + " </h1></body></html>";
		String htmlCode3 = "<html><body><h1>Password: " + n3 + " </h1></body></html>";
		String htmlCode4 = "<html><body><h1>Gender: " + n4 + " </h1></body></html>";
		

		UserService service = new UserService();
		User user2 = service.saveUser(user);
		if (user2 != null) {
			printWriter.write(htmlCode1);
			printWriter.write(htmlCode2);
			printWriter.write(htmlCode3);
			printWriter.write(htmlCode4);
			printWriter.write(n1 + " Thank You for registering, your UserId is: " + user2.getId());
		} else {
			printWriter.write("<html><body><h1> user not saved </h1></body></html>");
		}
	}

}
