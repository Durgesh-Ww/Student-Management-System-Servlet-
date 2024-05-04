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

@WebServlet(value = "/updateStudent")
public class UpdateStudent extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String studentName = req.getParameter("studentName");
		String updateMail = req.getParameter("updateMail");
		String updateContact = req.getParameter("updateContact");
		String UpdateAddress = req.getParameter("UpdateAddress");
		String studentPassword = req.getParameter("studentPassword");
		PrintWriter printWriter = resp.getWriter();
		Controller controller = new Controller();
		
		Student student = controller.fetchStudent(studentName);
		if (student != null) {
			student.setAddress(UpdateAddress);
			student.setConact(Long.parseLong(updateContact));
			student.setMail(updateMail);
			student.setPassword(studentPassword);
			if (controller.updateStudent(student)) {
				printWriter.print("<html><body>");
				printWriter.print("<h1>Student Updated</h1>");
				printWriter.print("</body></html>");
			} 
			
		} else {
			printWriter.print("<html><body>");
			printWriter.print("<h1>Student does not Exist</h1>");
			printWriter.print("</body></html>");
		}
		
		
	}

}
