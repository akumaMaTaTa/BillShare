/* New user registry
 * 
 * TODU: 
 * 	# Input validation (not null, unique)
 *  # Alert at failed attempts
 * */
package com.billShare.servelet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.billShare.DAO.userDAO;

/**
 * Servlet implementation class registry
 */
@WebServlet("/registry")
public class registry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registry() {
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
		userDAO d = new userDAO();
		String userName = request.getParameter("unsignup");
		String email = request.getParameter("useremailsp");
		String psw = request.getParameter("pwsignup");
		d.newUser(userName,email,psw);
		response.sendRedirect("signingup.jsp");
	}

}
