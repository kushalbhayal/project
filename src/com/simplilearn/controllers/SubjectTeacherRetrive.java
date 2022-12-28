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

public class SubjectTeacherRetrive extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SubjectTeacherRetrive() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentDao a = new StudentDao();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		try {
			List<SUBTECHRS> s = a.subtechrs();
			out.println("<table border=1 width=50% height=50%>");
			out.println("<tr><th>SUBJECT ID</th><th>" + "SUBJECT CODE</th><th>" + "SUBJECT NAME </th><th>"
					+ "ASSIGNED CLASS </tr></th>");
			for (SUBTECHRS ss : s) {
				out.println("<tr><td>" + ss.getSubid() + "</td><td>" + ss.getSubcode() + "</td><td>" + ss.getSubname()
						+ "</td><td>" + ss.getClassname() + "</td></tr>");
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