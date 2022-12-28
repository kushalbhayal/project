package com.simplilearn.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.dao.StudentDao;

public class SubjectList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SubjectList() {
		super();
// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentDao d = new StudentDao();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		try {
			List<techsub> t = d.techsubs(); // getstudent();
			out.println("<table border=1 width=50% height=50%>");
			out.println("<tr><th>" + "SUBJECT</th><th>" + "ASSIGNED TEACHER</tr></th>");
			for (techsub ab : t) {
				out.println("<tr><td>" + ab.getSsubject() + "</td><td>" + ab.getAssigntech() + "</td></tr>");
			}
			out.println("</table>");
			out.println("</html></body>");
		} catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}