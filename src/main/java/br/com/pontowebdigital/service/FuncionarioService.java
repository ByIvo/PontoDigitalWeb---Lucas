package br.com.pontowebdigital.service;

import br.com.pontowebdigital.model.Funcionario;

public interface FuncionarioService extends DefaultService<Funcionario, Integer> {
	
	Funcionario findFuncionario(Integer id);
}
