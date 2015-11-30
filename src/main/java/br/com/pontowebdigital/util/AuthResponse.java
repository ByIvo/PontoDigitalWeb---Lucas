package br.com.pontowebdigital.util;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class AuthResponse implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String forwardPage;
	private HttpStatus cod;
	
	public AuthResponse()
	{
	}
	
	public AuthResponse(String forwardPage, HttpStatus cod)
	{
		super();
		this.forwardPage = forwardPage;
		this.cod = cod;
	}
	
	public HttpStatus getCod()
	{
		return cod;
	}
	
	public void setCod(HttpStatus cod)
	{
		this.cod = cod;
	}
	
	public String getForwardPage()
	{
		return forwardPage;
	}
	
	public void setForwardPage(String forwardPage)
	{
		this.forwardPage = forwardPage;
	}
	
}
