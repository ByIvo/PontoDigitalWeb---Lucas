package br.com.pontowebdigital.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class RegraTrabalho extends Entidade{
	
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
	@JsonIgnore
	private boolean deleted = false;
	
	public RegraTrabalho()
	{
	}
	
	public RegraTrabalho(Integer id) {
		super();
		this.id = id;
	}
	
	public RegraTrabalho(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	@Override
	public Integer getId() {
		return id;
	}
	@Override
	public void setId(Integer id) {
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

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "RegraTrabalho [id=" + id + ", nome=" + nome + "]";
	}
	
}
