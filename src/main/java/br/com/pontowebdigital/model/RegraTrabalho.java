package br.com.pontowebdigital.model;

public class RegraTrabalho extends Entidade{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
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
