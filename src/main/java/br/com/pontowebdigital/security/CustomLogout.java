package br.com.pontowebdigital.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

public class CustomLogout extends SimpleUrlLogoutSuccessHandler
{
	
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException
	{

		setDefaultTargetUrl("/index.jsp");

		super.onLogoutSuccess(request, response, authentication);
	}
}
