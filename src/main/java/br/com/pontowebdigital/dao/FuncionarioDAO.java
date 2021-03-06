package br.com.pontowebdigital.dao;

import java.util.List;

import br.com.pontowebdigital.model.Funcionario;

public interface FuncionarioDAO
{
	List<Funcionario> findAll();
	
	Funcionario save(Funcionario entity);
	
	Funcionario saveOrUpdate(Funcionario entity);
	
	Funcionario find(Integer id);
	
	Funcionario findFuncionario(Integer id);
	
	void remove(Funcionario entity);
	
	void remove(Integer id);
	
	Funcionario update(Funcionario entity);
	
	Funcionario makeLogin(String login, String senha);
}
