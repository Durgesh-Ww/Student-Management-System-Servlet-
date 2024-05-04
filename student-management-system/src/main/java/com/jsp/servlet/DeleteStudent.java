package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.controller.Controller;
import com.jsp.model.Student;
@WebServlet(value = "/deleteStudent")
public class DeleteStudent extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String StudentName = req.getParameter("StudentName");
		PrintWriter printWriter = resp.getWriter();
		Controller controller = new Controller();
		
		if(controller.deleteStudent(StudentName))
		{
			printWriter.print("<html><body>");
			printWriter.print("<h1>Student Deleted</h1>");
			printWriter.print("</body></html>");
		}
		else
		{
			printWriter.print("<html><body>");
			printWriter.print("<h1>Student does not Exist</h1>");
			printWriter.print("</body></html>");
		}
		
		
	}

}
