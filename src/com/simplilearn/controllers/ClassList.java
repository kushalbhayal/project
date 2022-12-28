package com.simplilearn.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClassList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ClassList() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		studentDAO d = new studentDAO();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		try {
			List<techsub> t = d.techsubs(); // getstudent();
			out.println("<table border=1 width=20% height=20%>");
			out.println("<tr><th>" + "CLASS LIST" + "</th></tr>");
			for (techsub ab : t) {
				out.println("<tr><td>" + ab.getTechclass() + "</td></tr>");
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