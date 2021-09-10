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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String email=request.getParameter("em");
		String password = request.getParameter("pw");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp?","root","4109");
			PreparedStatement pst = con.prepareStatement("select * from login where email=? and password=?");
			pst.setString(1, email);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				pw.print("Login successful Mr/Mrs"+rs.getString("firstName"));
				RequestDispatcher rd=request.getRequestDispatcher("Update.html");
	            rd.include(request, response);
			} else {
				pw.print("<p style='color:red'>Login failed please try again</p>");
				RequestDispatcher rd=request.getRequestDispatcher("login.html");
	            rd.include(request, response);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
	}

}
