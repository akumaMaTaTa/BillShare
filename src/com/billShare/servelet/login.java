/* Authenticate user's identity at login , granted session if success 
 
 TODU:
 	# Session management
 	# Alert at failed attempts
 */

package com.billShare.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.billShare.DAO.userDAO;
import com.billShare.entity.User;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		userDAO d = new userDAO();
		String userName = request.getParameter("uName");
		String psw = request.getParameter("psw");
		User user = d.authenticate(userName,psw);
		if(user==null)
		{
			
			// response.sendRedirect("index.html");
		}
		else{
			response.sendRedirect("personalpage.jsp?id="+user.getUserId());
		}
	}

}
