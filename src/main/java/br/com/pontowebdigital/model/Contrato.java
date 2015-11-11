package br.com.pontowebdigital.model;

import java.util.Date;

import br.com.pontowebdigital.interfaces.Entidade;

public class Contrato implements Entidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private double horasMensais;
	private double salario;
	private Date dataContrato;
	private Funcionario funcionario;

	public Contrato(Integer id, double horasMensais, double salario, Date dataContrato, Funcionario funcionario) {
		super();
		this.id = id;
		this.horasMensais = horasMensais;
		this.salario = salario;
		this.dataContrato = dataContrato;
		this.funcionario = funcionario;
	}

	public Contrato(Integer id) {
		super();
		this.id = id;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;

	}

	public double getHorasMensais() {
		return horasMensais;
	}

	public void setHorasMensais(double horasMensais) {
		this.horasMensais = horasMensais;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Date getDataContrato() {
		return dataContrato;
	}

	public void setDataContrato(Date dataContrato) {
		this.dataContrato = dataContrato;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataContrato == null) ? 0 : dataContrato.hashCode());
		result = prime * result + ((funcionario == null) ? 0 : funcionario.hashCode());
		long temp;
		temp = Double.doubleToLongBits(horasMensais);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		temp = Double.doubleToLongBits(salario);
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
		Contrato other = (Contrato) obj;
		if (dataContrato == null) {
			if (other.dataContrato != null)
				return false;
		} else if (!dataContrato.equals(other.dataContrato))
			return false;
		if (funcionario == null) {
			if (other.funcionario != null)
				return false;
		} else if (!funcionario.equals(other.funcionario))
			return false;
		if (Double.doubleToLongBits(horasMensais) != Double.doubleToLongBits(other.horasMensais))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(salario) != Double.doubleToLongBits(other.salario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contrato [id=" + id + ", horasMensais=" + horasMensais + ", salario=" + salario + ", dataContrato="
				+ dataContrato + ", funcionario=" + funcionario + "]";
	}

}
