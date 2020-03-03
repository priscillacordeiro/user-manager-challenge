package io.github.priscillacordeiro.usermanagerchallenge.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("*")
public class LoginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String servletPath = httpServletRequest.getServletPath();

		if (httpServletRequest.getSession().getAttribute("name") != null 
				|| servletPath.startsWith("/css/")
				|| servletPath.startsWith("/img/")) {
			chain.doFilter(request, response);
		} else {
			request.getRequestDispatcher("/login").forward(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

}