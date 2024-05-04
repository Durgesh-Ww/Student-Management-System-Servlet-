package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.controller.Controller;
import com.jsp.model.Student;
@WebServlet(value = "/student")
public class StudentLogin extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String studentName = req.getParameter("student");
		String password = req.getParameter("password");
		
		PrintWriter printWriter = resp.getWriter();
		Controller controller = new Controller();
		Student fetchStudent = controller.fetchStudent(studentName);
		if(fetchStudent!=null) {
			if(studentName.equals(fetchStudent.getName())&& password.equals(fetchStudent.getPassword()))
			{
			printWriter.print("<html><body>");
			printWriter.print("<h1>student Login Successfull</h1>");
			printWriter.print("</body></html>");
			}
			
		
		}
		else
		{
			printWriter.print("<html><body>");
			printWriter.print("<h1>Wrong credentials</h1>");
			printWriter.print("</body></html>");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("studentLogin.html");
			requestDispatcher.include(req, resp);
		
	}
	}

}
