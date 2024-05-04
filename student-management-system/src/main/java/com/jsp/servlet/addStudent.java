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
@WebServlet(value = "/addStudent")
public class addStudent extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	String studentName = req.getParameter("studentName");
	String email = req.getParameter("email");
	String contact = req.getParameter("contact");
	String gender = req.getParameter("gender");
	String branch = req.getParameter("branch");
	String address = req.getParameter("address");
	String password = req.getParameter("password");
	
	Controller controller = new Controller();
	Student student = new Student();
	student.setName(studentName);
	student.setMail(email);
	student.setPassword(password);
	student.setGender(gender);
	student.setConact(Long.parseLong(contact));
	student.setBranch(branch);
	student.setAddress(address);
	
	boolean addStudent = controller.addStudent(student);
	PrintWriter printWriter = resp.getWriter();
	
	if(addStudent)
	{
		printWriter.print("<html><body>");
		printWriter.print("<h1>Student Added</h1>");
		printWriter.print("</body></html>");
	}
	else
	{
		printWriter.print("<html><body>");
		printWriter.print("<h1>Student Already Exist</h1>");
		printWriter.print("</body></html>");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
}
}
