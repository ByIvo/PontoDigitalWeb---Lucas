package br.com.pontowebdigital.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import br.com.pontowebdigital.util.AuthResponse;
import br.com.pontowebdigital.util.JSONUtils;

public class AjaxAuthSucessHandler implements AuthenticationSuccessHandler
{
	
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException, ServletException
	{
		
		AuthResponse ajaxResponse = new AuthResponse("admin/index.jsp", HttpStatus.OK);
		
		response.setContentType("application/json");
		
		response.getWriter().print(JSONUtils.buildJsonFromObject(ajaxResponse));
		response.getWriter().flush();
	}
}
