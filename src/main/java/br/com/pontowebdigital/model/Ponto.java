package br.com.pontowebdigital.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Ponto extends Entidade
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;
	@Column
	private Date entrada;
	@Column
	private Date saida;
	@Column
	private Contrato contrato;
	@Column
	private Funcionario funcionario;
	@Column
	@JsonIgnore
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
