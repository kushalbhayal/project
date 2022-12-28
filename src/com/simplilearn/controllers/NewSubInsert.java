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

public class NewSubInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewSubInsert() {
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
		String subid = request.getParameter("subid");
		String subcode = request.getParameter("subcode");
		String subname = request.getParameter("subname");
		String classname = request.getParameter("classname");
		PrintWriter out = response.getWriter();
		try {
			Connection con = DB_Connection.getConn();
			String sql = "insert into subject values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, subid);
			ps.setString(2, subcode);
			ps.setString(3, subname);
			ps.setString(4, classname);
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
			response.sendRedirect("studFAIL.html");
			e.printStackTrace();
		}
	}
}