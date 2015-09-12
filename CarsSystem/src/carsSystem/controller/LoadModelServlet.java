package carsSystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carsSystem.model.IConstants;
import carsSystem.model.ModelEntity;
import carsSystem.model.ModelsDAO;

@WebServlet("/LoadModelServlet")
public class LoadModelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int car_id = Integer.parseInt(request.getParameter("car_id"));
		int brand_id = Integer.parseInt(request.getParameter("brand_id"));
		ModelsDAO dao = new ModelsDAO();
		ModelEntity model = dao.loadModel(car_id);

		String targetURL = request.getHeader("Referer");
		request.setAttribute("brand_id", brand_id);
		request.setAttribute("model", model);
		request.setAttribute("url", targetURL);
		RequestDispatcher view = request.getRequestDispatcher(IConstants.EDIT_MODEL);
		view.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
