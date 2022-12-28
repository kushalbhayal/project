package com.simplilearn.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.dao.DB_Connection;

public class RetriveReport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RetriveReport() {
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
		String classname = request.getParameter("classname");
// studentDAO dao = new studentDAO();
		PrintWriter out = response.getWriter();
		try {
			Connection con = DB_Connection.getConn();
			PreparedStatement ps = con.prepareStatement(
					"select studid, studfname, studlname, studdob, studadd,studphone, stud_class, techid, assigntech, ssubject from s_t,sub_tech where studclass= '"
							+ classname + "'");
// + "inner join sub_tech stt"
// + "on a.studclass = stt.techclass"
// + "where a.studclass='"+classname+"'");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				response.setContentType("text/html");
				out.println("<html><body>");
				out.println("<table border=2 width=50% height=50%>");
				out.println(
// "<tr><th>Student ID</th></th>"+
						"<tr><td>" + rs.getString(1) + "</td><td>"
// "<tr><th> First Name</th><th>" 
								+ "</td><td>" + rs.getString(2) + "</td><td>"
// "<tr><th>Last Name</th><th>"
								+ "</td><td>" + rs.getString(3) + "</td><td>" + "</td><td>" + rs.getString(4)
								+ "</td><td>" + "</td><td>" + rs.getString(5) + "</td><td>" + "</td><td>"
								+ rs.getString(6) + "</td><td>" + "</td><td>" + rs.getString(7) + "</td><td>"
								+ "</td><td>" + rs.getString(8) + "</td><td>" + "</td><td>" + rs.getString(9)
								+ "</td><td>" + "</td><td>" + rs.getString(10) + "</tr></td>");
				/*
				 * "<tr><th>Student ID</th><th>" + "First Name</th><th>" + "Last Name</th><th>"
				 * + "DOB</th><th>" + "Address</th><th>" + "Phone No</th><th>" +
				 * "Assigned Class </th><th>" + "Teacher ID</th><th>" +
				 * "Assigned Teacher</th><th>" + "Subject</th></tr>");
				 */
				out.println("</table>");
				out.println("</html></body>");
			}
		} catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			out.print(e);
			out.print("CHECK RETRIVE PAGE");
		}
	}
}/*
	 * // for(techsub tt : ts) // for(clas css : cs) for(REPORT rr:r) {
	 * out.println("<tr><td>"+rr.getStudid()+ "</td><td>"+rr.getStudfname()+
	 * "</td><td>"+rr.getStudlname()+ "</td><td>"+ rr.getStuddob()+ "</td><td>"+
	 * rr.getStudadd()+ "</td><td>"+ rr.getStudphone()+ "</td><td>"+
	 * rr.getStud_class()+ "</td><td>"+rr.getTechid()+
	 * "</td><td>"+rr.getAssigntech() + "</td><td>"+rr.getSsubject() +"</td></tr>");
	 * }
	 */
