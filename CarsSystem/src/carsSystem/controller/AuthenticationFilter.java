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

import carsSystem.model.BrandsDAO;
import carsSystem.model.IConstants;
import carsSystem.model.UserUtils;

@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {

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
		BrandsDAO dao = new BrandsDAO();
		session.setAttribute("brands", dao.getBrands());

		if (requestedPage.equals(IConstants.EMPTY_URL)) {
			session.removeAttribute(IConstants.LAST_ERROR);
			httpResponse.sendRedirect(IConstants.MAIN_FORM);
			return;
		}

		if (IConstants.LOGIN_FORM.equals(requestedPage) || IConstants.LOGIN_URL.equals(requestedPage)
				|| IConstants.LOGOUT_URL.equals(requestedPage) || IConstants.MAIN_FORM.equals(requestedPage)
				|| IConstants.INFO_URL.equals(requestedPage) || IConstants.BRAND_MODELS.equals(requestedPage)) {
			chain.doFilter(request, response);
			return;
		}

		boolean authenticated = (UserUtils.getCurrentUser(session) != null);
		if (authenticated) {
			chain.doFilter(request, response);
		} else {

			session.setAttribute(IConstants.LAST_ERROR,
					"Поисканата страница изисква автентикация. Моля първо влезте в системата!");
			session.setAttribute(IConstants.ORIGINAL_URL, requestedPage);
			httpResponse.sendRedirect(IConstants.LOGIN_FORM);

		}

	}

	protected String getRequestedPage(HttpServletRequest aHttpRequest) {
		String url = aHttpRequest.getRequestURI();
		int firstSlash = url.indexOf("/", 1);
		String requestedPage = null;
		if (firstSlash != -1)
			requestedPage = url.substring(firstSlash + 1, url.length());
		return requestedPage;
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
