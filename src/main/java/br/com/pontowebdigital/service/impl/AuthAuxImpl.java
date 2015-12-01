package br.com.pontowebdigital.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.com.pontowebdigital.service.IAuthAux;

@Component
public class AuthAuxImpl implements IAuthAux
{
	@Override
	public Authentication getAuthentication()
	{
		return SecurityContextHolder.getContext().getAuthentication();
	}
}
