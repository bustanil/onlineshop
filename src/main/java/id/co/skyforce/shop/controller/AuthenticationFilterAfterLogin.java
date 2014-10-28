package id.co.skyforce.shop.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationFilterAfterLogin implements Filter {
	private FilterConfig config;

	public void doFilter(ServletRequest req, ServletResponse resp,FilterChain chain) 
			throws IOException, ServletException {
		if (((HttpServletRequest) req).getSession().getAttribute(
				LoginController.AUTH_KEY) != null) {
			HttpServletRequest re = (HttpServletRequest) req;
			HttpServletResponse res = (HttpServletResponse) resp;
			res.sendRedirect(re.getContextPath() +"/index.xhtml");
		} else {
			chain.doFilter(req, resp);
		}
	}

	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	public void destroy() {
		config = null;
	}
}