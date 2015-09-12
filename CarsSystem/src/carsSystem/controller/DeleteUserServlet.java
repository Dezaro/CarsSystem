package carsSystem.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carsSystem.model.IConstants;
import carsSystem.model.UsersDAO;

@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("user_id"));
		UsersDAO dao = new UsersDAO();
		dao.deleteUser(id);

		String targetURL = request.getHeader("Referer");
		if (targetURL == null) {
			targetURL = IConstants.MAIN_FORM;
		}
		response.sendRedirect(targetURL);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	// private int getRequestedPage(String url) {
	// int page = 0, firstSlash = url.indexOf("=", 1);
	// if (firstSlash != -1)
	// page = Integer.parseInt(url.substring(firstSlash + 1, url.length()));
	// System.out.println(page);
	// return page;
	// }

}
