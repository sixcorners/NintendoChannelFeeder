package com.djr4488.wiichannelfeeder;

import org.slf4j.Logger;
import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Once all Wii channels are forwarded here look at what the Wii is asking for
 */
public class RequestLoggingFilter implements Filter {
	@Inject
	private Logger log;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		if (!httpRequest.getHeader("user-agent").equalsIgnoreCase("IntelliJ IDEA")) {
			log.debug("doFilter() - url:{}, contextPath:{}, queryString:{}", httpRequest.getRequestURL(),
					httpRequest.getContextPath(),
					httpRequest.getQueryString());
			Enumeration<String> headers = httpRequest.getHeaderNames();
			while (headers.hasMoreElements()) {
				String header = headers.nextElement();
				log.debug("doFilter() - header:{}, value:{}", header, httpRequest.getHeader(header));
			}
			Enumeration<String> attributes = httpRequest.getAttributeNames();
			while (attributes.hasMoreElements()) {
				String attribute = attributes.nextElement();
				log.debug("doFilter() - attribute:{}, value:{}", attribute, httpRequest.getAttribute(attribute));
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}
}
