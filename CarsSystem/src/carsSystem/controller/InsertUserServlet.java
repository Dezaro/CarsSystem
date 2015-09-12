package carsSystem.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import carsSystem.model.IConstants;
import carsSystem.model.UserEntity;
import carsSystem.model.UsersDAO;

@WebServlet("/InsertUserServlet")
public class InsertUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		UserEntity user = new UserEntity();
		user.setUserName(request.getParameter("Uname"));
		user.setFirstName(request.getParameter("Fname"));
		user.setLastName(request.getParameter("Lname"));
		user.setEmail(request.getParameter("Email"));
		user.setPassword(request.getParameter("Pass"));
		user.setRole(request.getParameter("Role"));

		UsersDAO dao = new UsersDAO();
		dao.insertUser(user);
		HttpSession session = request.getSession();
		session.setAttribute("message", "Потребителят е добавен успешно");
		response.sendRedirect(IConstants.INSERT_USER);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
