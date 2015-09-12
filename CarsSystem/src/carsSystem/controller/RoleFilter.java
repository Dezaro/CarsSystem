package carsSystem.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import carsSystem.model.IConstants;
import carsSystem.model.UserUtils;

@WebFilter("/RoleFilter")
public class RoleFilter extends AuthenticationFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String requestedPage = getRequestedPage(httpRequest);
		HttpSession session = httpRequest.getSession();
		String role = (String) session.getAttribute(IConstants.USER_ROLE);
		boolean authenticated = (UserUtils.getCurrentUser(session) != null);

		if (authenticated) {
			if (role.equals("admin")) {
				chain.doFilter(request, response);
			} else if (IConstants.USERS_URL.equals(requestedPage) || IConstants.USERS_DELETE.equals(requestedPage)
					|| IConstants.USERS_INSERT.equals(requestedPage) || IConstants.USERS_UPDATE.equals(requestedPage)
					|| IConstants.EDIT_USER.equals(requestedPage) || IConstants.INSERT_USER.equals(requestedPage)
					|| IConstants.ADMIN_PANEL.equals(requestedPage)) {
				session.setAttribute(IConstants.LAST_ERROR,
						"Поисканата страница изисква автентикация като админостратор!");
				httpResponse.sendRedirect(IConstants.MAIN_FORM);
			} else {
				chain.doFilter(request, response);
			}
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
