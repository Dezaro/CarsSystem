package carsSystem.model;

import javax.servlet.http.HttpSession;

public class UserUtils {

	public static String getCurrentUser(HttpSession aSession) {
		String currentUser = (String) aSession.getAttribute(IConstants.CURRENT_USER);
		return currentUser;
	}

	public static void setCurrentUser(HttpSession aSession, String aUserName, String aUserRole) {
		aSession.setAttribute(IConstants.CURRENT_USER, aUserName);
		aSession.setAttribute(IConstants.USER_ROLE, aUserRole);
	}
}
