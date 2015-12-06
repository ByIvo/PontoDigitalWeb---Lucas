package br.com.pontowebdigital.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pontowebdigital.dao.PontoDAO;
import br.com.pontowebdigital.dao.impl.PontoDAOImpl;
import br.com.pontowebdigital.model.Funcionario;
import br.com.pontowebdigital.model.Ponto;
import br.com.pontowebdigital.model.Regra;
import br.com.pontowebdigital.service.PontoService;

@Service
@Transactional("transactionManager")
public class PontoServiceImpl implements PontoService
{
	
	@Autowired
	private PontoDAO dao;
	
	@Override
	public List<Ponto> findAll()
	{
		return dao.findAll();
	}
	
	@Override
	public Ponto save(Ponto entity)
	{
		return dao.save(entity);
	}
		
	@Override
	public Ponto saveOrUpdate(Ponto entity)
	{
		return dao.saveOrUpdate(entity);
	}
	
	@Override
	public Ponto find(Integer id)
	{
		return dao.find(id);
	}
	
	@Override
	public void remove(Ponto entity)
	{
		dao.remove(entity);
	}
	
	@Override
	public void remove(Integer id)
	{
		dao.remove(id);
	}
	
	@Override
	public Ponto update(Ponto entity)
	{
		return dao.update(entity);
	}
	
	public List<Ponto> findAllByFuncionarioId(Integer id){
		return dao.findAllByFuncionarioId(id);
	}

	@Override
	public List<Ponto> findBetweenDates(Integer id, Date dataI, Date dataF) {
		return dao.findBetweenDates(id, dataI, dataF);
	}

	@Override
	public Regra findRegra(Integer id, String tipo) {
		return dao.findRegra(id, tipo);
	}
	
		
}
