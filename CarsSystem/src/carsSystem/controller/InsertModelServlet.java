package carsSystem.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import carsSystem.model.IConstants;
import carsSystem.model.ModelEntity;
import carsSystem.model.ModelsDAO;

@WebServlet("/InsertModelServlet")
public class InsertModelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		final String SAVE_DIR = request.getServletContext().getRealPath("\\images");

		ModelEntity model = new ModelEntity();
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<?> items = null;

		try {
			items = upload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		Iterator<?> itr = items.iterator();
		while (itr.hasNext()) {
			FileItem item = (FileItem) itr.next();
			if (item.isFormField()) {
				String name = item.getFieldName();
				String value = item.getString();
				switch (name) {
				case "Brand":
					model.setBrand(value);
					break;
				case "Model":
					model.setModel(value);
					break;
				case "Seria":
					model.setSeria(value);
					break;
				case "Price":
					model.setPrice(Double.parseDouble(value));
					break;
				case "Data":
					model.setData(value);
					break;
				case "Info":
					model.setInfo(value);
					break;
				default:
					break;
				}
			} else {
				String fileName = item.getName();
				model.setPicture(fileName);
				File fi = new File(SAVE_DIR + "\\" + fileName);
				try {
					item.write(fi);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		ModelsDAO dao = new ModelsDAO();
		dao.insertModel(model);
		HttpSession session = request.getSession();
		session.setAttribute("message", "Модела е добавен успешно");
		response.sendRedirect(IConstants.INSERT_MODEL);

	}

}
