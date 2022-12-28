package com.simplilearn.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.entities.NewClass;

public class NewAddClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewAddClass() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		studentDAO b = new studentDAO();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		try {
			List<NewClass> s = b.newclasses();
			out.println("<table border=1 width=50% height=50%>");
			out.println("<tr><th>CLASS ID</th><th>" + "CLASS LIST</th></tr>");
			for (NewClass ss : s) {
				out.println("<tr><td>" + ss.getClassid() + "</td><td>" + ss.getClassname() + "</td></tr>");
			}
			out.println("</table>");
			out.println("</html></body>");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}