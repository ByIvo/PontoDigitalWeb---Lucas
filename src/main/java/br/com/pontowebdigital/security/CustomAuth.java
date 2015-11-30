package br.com.pontowebdigital.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import br.com.pontowebdigital.model.Funcionario;
import br.com.pontowebdigital.service.FuncionarioService;

public class CustomAuth implements AuthenticationProvider
{
	
	@Autowired
	private FuncionarioService service;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException
	{
		String email = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		
		if (email.isEmpty() || password.isEmpty())
		{
			throw new BadCredentialsException("Invalid username/password");
		}
		
		Funcionario funcionario = null;
		
		// funcionario = service.makeLogin(email, password);
		return new UsernamePasswordAuthenticationToken(funcionario, password);
	}
	
	@Override
	public boolean supports(Class<?> authentication)
	{
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
}
