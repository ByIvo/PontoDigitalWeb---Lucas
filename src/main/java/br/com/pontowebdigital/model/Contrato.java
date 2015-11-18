package br.com.pontowebdigital.model;

import java.util.Date;

public class Contrato extends Entidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private double horasMensais;
	private double salario;
	private Date dataContrato;
	private Funcionario funcionario;
	
	private boolean deleted = false;
	
	
	public Contrato()
	{
	}

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

	@Override
	public String toString() {
		return "Contrato [id=" + id + ", horasMensais=" + horasMensais + ", salario=" + salario + ", dataContrato="
				+ dataContrato + ", funcionario=" + funcionario + "]";
	}

}
