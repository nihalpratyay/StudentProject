package com.nihal.crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReadServlet")
public class ReadServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String Password=request.getParameter("pw");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp?","root","4109");
			PreparedStatement pst = con.prepareStatement("select * from login where password='"+Password+"'");
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				pw.print("Your Details are: "+rs.getLong(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5));
			} else {
				pw.print("<p style='color:red'>You have entered incorrect password</p>");
				RequestDispatcher rd=request.getRequestDispatcher("read.html");
	            rd.include(request, response);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			pw.print("You have Entered wrong credentials");
		}
		}

}
