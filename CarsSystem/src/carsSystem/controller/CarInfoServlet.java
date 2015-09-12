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

@WebServlet("/CarInfoServlet")
public class CarInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("car_id"));
		ModelsDAO dao = new ModelsDAO();
		ModelEntity model = dao.getModelInfo(id);

		request.setAttribute("carInfo", model);
		RequestDispatcher view = request.getRequestDispatcher(IConstants.CAR_INFO);
		view.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
