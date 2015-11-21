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
@Table(name = "regras")
@SQLDelete(sql = "UPDATE cargos SET deleted = 1 WHERE id = ?")
@Where(clause = "deleted <> 1")
public class Regra extends Entidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;
	@Column
	private Tdia tipoDia;
	@Column
	private double valor;
	@Column
	private double procentagemHoraExtra;
	@Column
	private double horasTrabalho;
	@Column
	@JsonIgnore
	private boolean deleted = false;

	
	public Regra()
	{
	}
	
	public Regra(Integer id) {
		super();
		this.id = id;
	}

	public Regra(Integer id, Tdia tipoDia, double valor, double procentagemHoraExtra, double horasTrabalho) {
		super();
		this.id = id;
		this.tipoDia = tipoDia;
		this.valor = valor;
		this.procentagemHoraExtra = procentagemHoraExtra;
		this.horasTrabalho = horasTrabalho;
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

	public Tdia getTipoDia() {
		return tipoDia;
	}

	public void setTipoDia(Tdia tipoDia) {
		this.tipoDia = tipoDia;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getProcentagemHoraExtra() {
		return procentagemHoraExtra;
	}

	public void setProcentagemHoraExtra(double procentagemHoraExtra) {
		this.procentagemHoraExtra = procentagemHoraExtra;
	}

	public double getHorasTrabalho() {
		return horasTrabalho;
	}

	public void setHorasTrabalho(double horasTrabalho) {
		this.horasTrabalho = horasTrabalho;
	}

	@Override
	public String toString() {
		return "Regra [id=" + id + ", tipoDia=" + tipoDia + ", valor=" + valor + ", procentagemHoraExtra="
				+ procentagemHoraExtra + ", horasTrabalho=" + horasTrabalho + "]";
	}

	
}
