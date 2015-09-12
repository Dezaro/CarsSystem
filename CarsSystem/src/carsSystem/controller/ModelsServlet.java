package carsSystem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carsSystem.model.IConstants;
import carsSystem.model.ModelEntity;
import carsSystem.model.ModelsDAO;

@WebServlet("/ModelsServlet")
public class ModelsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int page = 1;
		int recordsPerPage = 3;
		int endLink = 5;
		int startLink = 1;
		if (request.getParameter("page") != null)
			try {
				page = Integer.parseInt(request.getParameter("page"));
			} catch (NumberFormatException e) {
				page = 1;
			}
		ModelsDAO dao = new ModelsDAO();
		List<ModelEntity> list = dao.getModels((page - 1) * recordsPerPage, recordsPerPage);
		int records = dao.getRecords();
		int pages = (int) Math.ceil(records * 1.0 / recordsPerPage);
		endLink = page + 2;
		startLink = page - 2;
		if (endLink > pages) {
			endLink = pages;
			startLink = pages - 4;
		}
		if (startLink < 1) {
			startLink = 1;
			endLink = 5;
		}
		if (endLink > pages) {
			endLink = pages;
		}

		request.setAttribute("endLink", endLink);
		request.setAttribute("startLink", startLink);
		request.setAttribute("models", list);
		request.setAttribute("pages", pages);
		request.setAttribute("currentPage", page);
		RequestDispatcher view = request.getRequestDispatcher(IConstants.MODELS);
		view.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
