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

public class StudentUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentUpdate() {
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
		String studid = request.getParameter("studid");
		String studfname = request.getParameter("studfname");
		String studlname = request.getParameter("studlname");
		String studdob = request.getParameter("studdob");
		String studadd = request.getParameter("studadd");
		String studphone = request.getParameter("studphone");
		String studclass = request.getParameter("studclass");
		String stud_class = request.getParameter("stud_class");

		PrintWriter out = response.getWriter();
		try {
			Connection con = DB_Connection.getConn();
			String sql = "update s_t set studfname=?, studlname=?, studdob=?, studadd=?, studphone=?, studclass=?, stud_class=? where studid=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, studfname);
			ps.setString(2, studlname);
			ps.setString(3, studdob);
			ps.setString(4, studadd);
			ps.setString(5, studphone);
			ps.setString(6, studclass);
			ps.setString(7, stud_class);
			ps.setString(8, studid);
			int row = ps.executeUpdate();
			if (row > 0) {
//out.print("UPDATED ");
				response.sendRedirect("studeSUCCESS.html");
			} else {
//out.print("NOT UPDATED");
				response.sendRedirect("studFAIL.html");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			out.print("CHECK THE CONNECTION " + e);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}