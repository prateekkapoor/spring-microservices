package com.demo.microservices.netflixzuulapigatewayserver.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class ZuulLoggingFilter extends ZuulFilter {
	private Logger logger = LoggerFactory.getILoggerFactory().getLogger(this.getClass().getSimpleName());

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("request-> {}, request-uri-> ", request, request.getRequestURI());
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}
}
