package carsSystem.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carsSystem.model.IConstants;
import carsSystem.model.ModelsDAO;

@WebServlet("/DeleteModelServlet")
public class DeleteModelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("car_id"));
		ModelsDAO dao = new ModelsDAO();
		dao.deleteModel(id);
		String targetURL = request.getHeader("Referer");
		if (targetURL == null) {
			targetURL = IConstants.MAIN_FORM;
		}
		response.sendRedirect(targetURL);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
