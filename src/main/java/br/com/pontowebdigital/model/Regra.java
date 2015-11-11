package br.com.pontowebdigital.model;

import br.com.pontowebdigital.interfaces.Entidade;

public class Regra implements Entidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Tdia tipoDia;
	private double valor;
	private double procentagemHoraExtra;
	private double horasTrabalho;
	
	

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(horasTrabalho);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		temp = Double.doubleToLongBits(procentagemHoraExtra);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tipoDia == null) ? 0 : tipoDia.hashCode());
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Regra other = (Regra) obj;
		if (Double.doubleToLongBits(horasTrabalho) != Double.doubleToLongBits(other.horasTrabalho))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(procentagemHoraExtra) != Double.doubleToLongBits(other.procentagemHoraExtra))
			return false;
		if (tipoDia == null) {
			if (other.tipoDia != null)
				return false;
		} else if (!tipoDia.equals(other.tipoDia))
			return false;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Regra [id=" + id + ", tipoDia=" + tipoDia + ", valor=" + valor + ", procentagemHoraExtra="
				+ procentagemHoraExtra + ", horasTrabalho=" + horasTrabalho + "]";
	}

	
}
