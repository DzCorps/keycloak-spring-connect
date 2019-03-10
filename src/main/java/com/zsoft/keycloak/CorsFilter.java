package com.zsoft.keycloak;


import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

@Component
@Order(HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {
	
	@Override public void init(FilterConfig filterConfig) throws ServletException {
	
	}
	
	@Override public void doFilter(ServletRequest req, ServletResponse res,
								   FilterChain chain) throws IOException, ServletException
	{
		
		final HttpServletResponse response = (HttpServletResponse) res;
		final HttpServletRequest request = (HttpServletRequest) req;
		
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
		
		if (!Objects.equals(request.getMethod(), "OPTIONS")) {
			chain.doFilter(req, res);
		}
	
	}
	
	@Override public void destroy() {
	
	}
}
