package carsSystem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import carsSystem.model.BrandsDAO;

@WebFilter("/BrandFilter")
public class BrandFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		boolean isReal = true;
		BrandsDAO dao = new BrandsDAO();
		String brand = request.getParameter("brand");
		List<String> brands = dao.getBrands();
		for (String test : brands) {
			if (brand != null && brand.equals(test)) {
				isReal = true;
				break;
			} else
				isReal = false;
		}
		if (isReal == false) {
			brand = "Audi";
		}

		request.setAttribute("brand", brand);
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
