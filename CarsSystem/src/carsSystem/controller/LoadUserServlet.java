package carsSystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carsSystem.model.IConstants;
import carsSystem.model.UserEntity;
import carsSystem.model.UsersDAO;

@WebServlet("/LoadUserServlet")
public class LoadUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("user_id"));
		UsersDAO dao = new UsersDAO();
		UserEntity user = dao.loadUser(id);
		String targetURL = request.getHeader("Referer");

		request.setAttribute("user", user);
		request.setAttribute("url", targetURL);
		RequestDispatcher view = request.getRequestDispatcher(IConstants.EDIT_USER);
		view.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
