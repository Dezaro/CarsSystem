package carsSystem.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carsSystem.model.UserEntity;
import carsSystem.model.UsersDAO;

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		UserEntity user = new UserEntity();
		user.setId(Integer.parseInt(request.getParameter("Id")));
		user.setUserName(request.getParameter("Uname"));
		user.setFirstName(request.getParameter("Fname"));
		user.setLastName(request.getParameter("Lname"));
		user.setEmail(request.getParameter("Email"));
		user.setPassword(request.getParameter("Pass"));
		user.setRole(request.getParameter("Role"));

		UsersDAO dao = new UsersDAO();
		dao.updateUser(user);
		String targetURL = request.getParameter("url");
		response.sendRedirect(targetURL);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
