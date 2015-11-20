package br.com.pontowebdigital.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Funcionario extends Entidade
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
	private String nome;
	@Column
	private String cpf;
	@Column
	private String rg;
	@Column
	private Cargo cargo;
	@Column
	private Contrato contratoAtual;
	@Column
	private List<Contrato> listaContratos;
	@Column
	private String email;
	@Column
	private String senha;
	@Column
	private RegraTrabalho regraTrabalho;
	@Column
	@JsonIgnore
	private boolean deleted = false;
	
	public Funcionario()
	{
	}
	
	public Funcionario(Integer id)
	{
		super();
		this.id = id;
	}
	
	public Funcionario(Integer id, String nome, String cpf, String rg, Cargo cargo, Contrato contratoAtual, List<Contrato> listaContratos, String email, String senha, RegraTrabalho regraTrabalho)
	{
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.cargo = cargo;
		this.contratoAtual = contratoAtual;
		this.listaContratos = listaContratos;
		this.email = email;
		this.senha = senha;
		this.regraTrabalho = regraTrabalho;
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
	
	public String getNome()
	{
		return nome;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public String getCpf()
	{
		return cpf;
	}
	
	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}
	
	public String getRg()
	{
		return rg;
	}
	
	public void setRg(String rg)
	{
		this.rg = rg;
	}
	
	public Cargo getCargo()
	{
		return cargo;
	}
	
	public void setCargo(Cargo cargo)
	{
		this.cargo = cargo;
	}
	
	public Contrato getContratoAtual()
	{
		return contratoAtual;
	}
	
	public void setContratoAtual(Contrato contratoAtual)
	{
		this.contratoAtual = contratoAtual;
	}
	
	public List<Contrato> getListaContratos()
	{
		return listaContratos;
	}
	
	public void setListaContratos(List<Contrato> listaContratos)
	{
		this.listaContratos = listaContratos;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getSenha()
	{
		return senha;
	}
	
	public void setSenha(String senha)
	{
		this.senha = senha;
	}
	
	public RegraTrabalho getRegraTrabalho()
	{
		return regraTrabalho;
	}
	
	public void setRegraTrabalho(RegraTrabalho regraTrabalho)
	{
		this.regraTrabalho = regraTrabalho;
	}
	
	@Override
	public String toString()
	{
		return "Funcionario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", cargo=" + cargo + ", contratoAtual=" + contratoAtual + ", listaContratos=" + listaContratos + ", email=" + email + ", senha=" + senha + ", regraTrabalho=" + regraTrabalho + "]";
	}
	
}
