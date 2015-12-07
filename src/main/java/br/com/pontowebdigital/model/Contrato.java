package br.com.pontowebdigital.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "contratos")
@SQLDelete(sql = "UPDATE cargos SET deleted = 1 WHERE id = ?")
@Where(clause = "deleted <> 1")
public class Contrato extends Entidade
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;
	@Column(nullable = false)
	private double horasMensais;
	@Column(nullable = false)
	private double salario;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-mm-yy")
	private Date dataContrato;
	@ManyToOne
	@JoinColumn(name = "funcionario_id", referencedColumnName = "id", nullable = false)
	private Funcionario funcionario;
	@Column
	@JsonIgnore
	private boolean deleted = false;
	
	public Contrato()
	{
	}
	
	public Contrato(Integer id, double horasMensais, double salario, Date dataContrato, Funcionario funcionario)
	{
		super();
		this.id = id;
		this.horasMensais = horasMensais;
		this.salario = salario;
		this.dataContrato = dataContrato;
		this.funcionario = funcionario;
	}
	
	public Contrato(Integer id)
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
	
	public double getHorasMensais()
	{
		return horasMensais;
	}
	
	public void setHorasMensais(double horasMensais)
	{
		this.horasMensais = horasMensais;
	}
	
	public double getSalario()
	{
		return salario;
	}
	
	public void setSalario(double salario)
	{
		this.salario = salario;
	}
	
	public Date getDataContrato()
	{
		return dataContrato;
	}
	
	public void setDataContrato(Date dataContrato)
	{
		this.dataContrato = dataContrato;
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
		return "Contrato [id=" + id + ", horasMensais=" + horasMensais + ", salario=" + salario + ", dataContrato=" + dataContrato + ", funcionario=" + funcionario + "]";
	}
	
}
