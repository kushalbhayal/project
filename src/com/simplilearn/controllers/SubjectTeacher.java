package com.simplilearn.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.dao.DB_Connection;

public class SubjectTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SubjectTeacher() {
		super();
// TODO Auto-generated constructor stub
	}

protected void doGet(HttpServletRequest request, HttpServletResponse
response) throws ServletException, IOException {
// TODO Auto-generated method stub
response.getWriter().append("Served at: ").append(request.getContextPath());
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String techid = request.getParameter("techid");
		String ssubject = request.getParameter("ssubject");
		String assigntech = request.getParameter("assigntech");
		String techclass = request.getParameter("techclass");
//String classid = request.getParameter("classid");
		PrintWriter out = response.getWriter();
		try {
			Connection con = DB_Connection.getConn();
			String sql = "insert into sub_tech values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, techid);
			ps.setString(2, ssubject);
			ps.setString(3, assigntech);
			ps.setString(4, techclass);
//ps.setString(5, classid);
			int row = ps.executeUpdate();
			if (row > 0) {
				response.sendRedirect("studeSUCCESS.html");
			} else {
				response.sendRedirect("studFAIL.html");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			out.print("CHECK THE CONNECTION " + e);
		} catch (SQLException e) {
			response.sendRedirect("SUBtecherError.html");
			e.printStackTrace();
		}
	}
}