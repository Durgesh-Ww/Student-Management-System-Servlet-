package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value = "/validation")
public class Admin extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String adminName = req.getParameter("Admin");
		String password = req.getParameter("password");
		
		PrintWriter printWriter = resp.getWriter();
		if(adminName.equals("admin")&& password.equals("123"))
		{
	RequestDispatcher requestDispatcher = req.getRequestDispatcher("AdminAccesse.html");
	requestDispatcher.include(req, resp);
		}
		else
		{
			printWriter.print("<html><body>");
			printWriter.print("<h1>Wrong credentials</h1>");
			printWriter.print("</body></html>");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("adminLogin.html");
			requestDispatcher.include(req, resp);
		}
		
	}

}
