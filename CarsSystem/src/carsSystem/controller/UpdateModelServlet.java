package carsSystem.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carsSystem.model.ModelEntity;
import carsSystem.model.ModelsDAO;

@WebServlet("/UpdateModelServlet")
public class UpdateModelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		ModelEntity model = new ModelEntity();
		model.setId(Integer.parseInt(request.getParameter("car_id")));
		model.setBrand_id(Integer.parseInt(request.getParameter("brand_id")));
		model.setModel(request.getParameter("model"));
		model.setSeria(request.getParameter("seria"));
		model.setPrice(Double.parseDouble(request.getParameter("price")));
		model.setInfo(request.getParameter("info"));
		model.setData(request.getParameter("date"));

		ModelsDAO dao = new ModelsDAO();
		dao.updateModel(model);
		String targetURL = request.getParameter("url");
		response.sendRedirect(targetURL);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
