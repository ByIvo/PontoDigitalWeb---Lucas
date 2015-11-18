package br.com.pontowebdigital.model;

public class Regra extends Entidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Tdia tipoDia;
	private double valor;
	private double procentagemHoraExtra;
	private double horasTrabalho;
	
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
