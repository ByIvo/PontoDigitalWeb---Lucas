package br.com.pontowebdigital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pontowebdigital.dao.FuncionarioDAO;
import br.com.pontowebdigital.model.Funcionario;
import br.com.pontowebdigital.service.FuncionarioService;

@Service
@Transactional("transactionManager")
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioDAO dao;

	@Override
	public List<Funcionario> findAll() {
		return dao.findAll();
	}

	@Override
	public Funcionario save(Funcionario entity) {
		return dao.save(entity);
	}

	@Override
	public Funcionario saveOrUpdate(Funcionario entity) {
		return dao.saveOrUpdate(entity);
	}

	@Override
	public Funcionario find(Integer id) {
		return dao.find(id);
	}

	@Override
	public void remove(Funcionario entity) {
		dao.remove(entity);
	}

	@Override
	public void remove(Integer id) {
		dao.remove(id);
	}

	@Override
	public Funcionario update(Funcionario entity) {
		return dao.update(entity);
	}

	@Override
	public Funcionario findFuncionario(Integer id) {
		return dao.findFuncionario(id);
	}

}
