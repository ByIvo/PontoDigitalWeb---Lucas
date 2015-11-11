package br.com.pontowebdigital.model;

import java.util.List;

import br.com.pontowebdigital.interfaces.Entidade;

public class Funcionario implements Entidade{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	private String cpf;
	private String rg;
	private Cargo cargo;
	private Contrato contratoAtual;
	private List<Contrato> listaContratos;
	private String email;
	private String senha;
	private RegraTrabalho regraTrabalho;
	
	
	
	public Funcionario(Integer id) {
		super();
		this.id = id;
	}
	public Funcionario(Integer id, String nome, String cpf, String rg, Cargo cargo, Contrato contratoAtual,
			List<Contrato> listaContratos, String email, String senha, RegraTrabalho regraTrabalho) {
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
	public Integer getId() {
		return id;
	}
	@Override
	public void setId(Integer id) {
		this.id = id;
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public Contrato getContratoAtual() {
		return contratoAtual;
	}
	public void setContratoAtual(Contrato contratoAtual) {
		this.contratoAtual = contratoAtual;
	}
	public List<Contrato> getListaContratos() {
		return listaContratos;
	}
	public void setListaContratos(List<Contrato> listaContratos) {
		this.listaContratos = listaContratos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public RegraTrabalho getRegraTrabalho() {
		return regraTrabalho;
	}
	public void setRegraTrabalho(RegraTrabalho regraTrabalho) {
		this.regraTrabalho = regraTrabalho;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		result = prime * result + ((contratoAtual == null) ? 0 : contratoAtual.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((listaContratos == null) ? 0 : listaContratos.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((regraTrabalho == null) ? 0 : regraTrabalho.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (cargo == null) {
			if (other.cargo != null)
				return false;
		} else if (!cargo.equals(other.cargo))
			return false;
		if (contratoAtual == null) {
			if (other.contratoAtual != null)
				return false;
		} else if (!contratoAtual.equals(other.contratoAtual))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (listaContratos == null) {
			if (other.listaContratos != null)
				return false;
		} else if (!listaContratos.equals(other.listaContratos))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (regraTrabalho == null) {
			if (other.regraTrabalho != null)
				return false;
		} else if (!regraTrabalho.equals(other.regraTrabalho))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", cargo=" + cargo
				+ ", contratoAtual=" + contratoAtual + ", listaContratos=" + listaContratos + ", email=" + email
				+ ", senha=" + senha + ", regraTrabalho=" + regraTrabalho + "]";
	}
	
	
}
