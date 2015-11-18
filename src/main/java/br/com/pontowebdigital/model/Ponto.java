package br.com.pontowebdigital.model;

import java.util.Date;

public class Ponto extends Entidade
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date entrada;
	private Date saida;
	private Contrato contrato;
	private Funcionario funcionario;
	
	private boolean deleted = false;
	
	public Ponto()
	{
	}
	
	public Ponto(Integer id)
	{
		super();
		this.id = id;
	}
	
	public Ponto(Integer id, Date entrada, Date saida, Contrato contrato, Funcionario funcionario)
	{
		super();
		this.id = id;
		this.entrada = entrada;
		this.saida = saida;
		this.contrato = contrato;
		this.funcionario = funcionario;
	}
	
	@Override
	public Integer getId()
	{
		return id;
	}
	
	@Override
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	@Override
	public boolean isDeleted()
	{
		return deleted;
	}
	
	@Override
	public void setDeleted(boolean deleted)
	{
		this.deleted = deleted;
	}
	
	public Date getEntrada()
	{
		return entrada;
	}
	
	public void setEntrada(Date entrada)
	{
		this.entrada = entrada;
	}
	
	public Date getSaida()
	{
		return saida;
	}
	
	public void setSaida(Date saida)
	{
		this.saida = saida;
	}
	
	public Contrato getContrato()
	{
		return contrato;
	}
	
	public void setContrato(Contrato contrato)
	{
		this.contrato = contrato;
	}
	
	public Funcionario getFuncionario()
	{
		return funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario)
	{
		this.funcionario = funcionario;
	}
	
	@Override
	public String toString()
	{
		return "Ponto [id=" + id + ", entrada=" + entrada + ", saida=" + saida + ", contrato=" + contrato + ", funcionario=" + funcionario + "]";
	}
	
}
