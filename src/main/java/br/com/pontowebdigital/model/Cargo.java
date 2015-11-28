package br.com.pontowebdigital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cargos")
@SQLDelete(sql = "UPDATE cargos SET deleted = 1 WHERE id = ?")
@Where(clause = "deleted <> 1")
public class Cargo extends Entidade
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;
	
	@Column(length=80, nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private Double horasMensais;
	
	//saber quantas horas ele trabalha por dia normal; qualquer coisa fora disso deve ser incluido na regra de trabalho
	@Column(nullable=true)
	private Double padraoHorasDiaTrabalho;
	
	@Column()
	@JsonIgnore
	private boolean deleted = false;
	
	
	public Cargo()
	{
	}
	
	public Cargo(Integer id, String nome, double horasMensais)
	{
		super();
		this.id = id;
		this.nome = nome;
		this.horasMensais = horasMensais;
	}
	
	public Cargo(Integer id)
	{
		super();
		this.id = id;
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
	
	
	public Double getHorasMensais() {
		return horasMensais;
	}

	public void setHorasMensais(Double horasMensais) {
		this.horasMensais = horasMensais;
	}

	public Double getPadraoHorasDiaTrabalho() {
		return padraoHorasDiaTrabalho;
	}

	public void setPadraoHorasDiaTrabalho(Double padraoHorasDiaTrabalho) {
		this.padraoHorasDiaTrabalho = padraoHorasDiaTrabalho;
	}

	@Override
	public String toString()
	{
		return "Cargo [id=" + id + ", nome=" + nome + ", horasMensais=" + horasMensais + ", deleted=" + deleted + "]";
	}
	
}
