package br.com.pontowebdigital.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "funcionarios")
@SQLDelete(sql = "UPDATE cargos SET deleted = 1 WHERE id = ?")
@Where(clause = "deleted <> 1")
public class Funcionario extends Entidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable=false, unique=true)
	private String cpf;
	@Column(nullable=false, unique=true)
	private String rg;
	@ManyToOne
	@JoinColumn(name = "cargo_id", referencedColumnName="id", nullable = true)
	private Cargo cargo;
	@ManyToOne
	@JoinColumn(name = "contrato_atual_id", referencedColumnName="id", nullable = true)
	private Contrato contratoAtual;
	@Column
	@OneToMany(targetEntity = Contrato.class, fetch = FetchType.EAGER)
	private List<Contrato> listaContratos;
	@Column(nullable=false, unique=true)
	private String login;
	@Column(nullable=false)
	private String senha;
	@ManyToOne
	@JoinColumn(name = "regra_trabalho_id", referencedColumnName="id", nullable = true)
	private RegraTrabalho regraTrabalho;
	@Column
	@JsonIgnore
	private boolean deleted = false;

	public Funcionario() {
	}

	public Funcionario(Integer id) {
		super();
		this.id = id;
	}

	public Funcionario(Integer id, String nome, String cpf, String rg, Cargo cargo, Contrato contratoAtual,
			List<Contrato> listaContratos, String login, String senha, RegraTrabalho regraTrabalho) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.cargo = cargo;
		this.contratoAtual = contratoAtual;
		this.listaContratos = listaContratos;
		this.login = login;
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

	@Override
	public boolean isDeleted() {
		return deleted;
	}

	@Override
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
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

	public String getlogin() {
		return login;
	}

	public void setlogin(String login) {
		this.login = login;
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
	public void setSenhaEncriptada(String plainSenha){
		
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", cargo=" + cargo
				+ ", contratoAtual=" + contratoAtual + ", listaContratos=" + listaContratos + ", login=" + login
				+ ", senha=" + senha + ", regraTrabalho=" + regraTrabalho + "]";
	}

}
