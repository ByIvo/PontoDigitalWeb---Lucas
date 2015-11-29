package br.com.pontowebdigital.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.com.pontowebdigital.dao.FuncionarioDAO;
import br.com.pontowebdigital.dao.GenericDAO;
import br.com.pontowebdigital.model.Funcionario;

@Repository
@Transactional
public class FuncionarioDAOImpl extends GenericDAO<Funcionario, Integer> implements FuncionarioDAO {

	public FuncionarioDAOImpl() {
		super(Funcionario.class);
	}

}
