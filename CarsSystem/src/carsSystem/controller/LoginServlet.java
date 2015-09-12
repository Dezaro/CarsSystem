package carsSystem.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import carsSystem.model.DateBaseManager;
import carsSystem.model.IConstants;
import carsSystem.model.UserEntity;
import carsSystem.model.UserUtils;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserEntity user;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("cp1251");
		String userName = request.getParameter(IConstants.USER_PARAM);
		String password = request.getParameter(IConstants.PASSWORD_PARAM);
		HttpSession session = request.getSession();

		if (isUserValid(userName, password)) {
			UserUtils.setCurrentUser(session, user.getFirstName() + " " + user.getLastName(), user.getRole());
			String targetURL = (String) session.getAttribute(IConstants.ORIGINAL_URL);
			session.removeAttribute(IConstants.ORIGINAL_URL);
			if (targetURL == null) {
				targetURL = IConstants.MAIN_FORM;
			}
			response.sendRedirect(targetURL);
		} else if (userName != null) {
			session.setAttribute(IConstants.LAST_ERROR, "Невалиден потребител или парола!");
			response.sendRedirect(IConstants.LOGIN_FORM);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public static boolean isUserValid(String aUserName, String aPassword) {
		DateBaseManager date = new DateBaseManager();
		ResultSet result;
		try {
			result = date.Select("select * from users where user_name = '" + aUserName + "' and user_password = '"
					+ aPassword + "'");
			user = new UserEntity();
			while (result.next()) {
				user.setId(result.getInt("user_id"));
				user.setUserName(result.getString("user_name"));
				user.setFirstName(result.getString("user_fname"));
				user.setLastName(result.getString("user_lname"));
				user.setEmail(result.getString("user_email"));
				user.setPassword(result.getString("user_password"));
				user.setRole(result.getString("user_role"));
			}
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		boolean valid = (user.getUserName() != null && user.getPassword() != null
				&& user.getPassword().equals(aPassword));
		return valid;
	}
}
