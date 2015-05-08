package com.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.minidev.json.JSONObject;

import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

public class TestInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object obj, Exception exp)	throws Exception {
		System.out.println("afterCompletion");
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object obj, ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle");
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		System.out.println("preHandle");
		System.out.println("preHandle, context Path : "+req.getContextPath());
		System.out.println("preHandle, QueryString : "+req.getQueryString());
		System.out.println("preHandle, getRequestURL : "+req.getRequestURL());
		System.out.println("preHandle, PathInfo : "+req.getPathInfo());


		Map pathVariable = (Map)req.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		System.out.println("preHandle, pathVariable : "+pathVariable);
		Map typeLevelMapping = (Map)req.getAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING);
		System.out.println("preHandle, typeLevelMapping : "+typeLevelMapping);
		String bestMatchingPatternAttribute = (String)req.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
		System.out.println("preHandle, bestMatchingPatternAttribute : "+bestMatchingPatternAttribute);
		String pathHandlerMappingAttribute = (String)req.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		System.out.println("preHandle, pathHandlerMappingAttribute : "+pathHandlerMappingAttribute);
		String producibleMediaTypeAttr = (String)req.getAttribute(HandlerMapping.PRODUCIBLE_MEDIA_TYPES_ATTRIBUTE);
		System.out.println("preHandle, producibleMediaTypeAttr : "+producibleMediaTypeAttr);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=utf-8");

		JSONObject json = new JSONObject();
		json.put("message", "An application error has occurred");
		json.put("status", "500");

		
		res.getWriter().print(json.toString());
		res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

		/*res.setHeader("WWW-Authenticate","Basic realm=\"" + "test" + "\"");
		res.sendError(HttpServletResponse.SC_UNAUTHORIZED);*/
		return true;
	}

}

