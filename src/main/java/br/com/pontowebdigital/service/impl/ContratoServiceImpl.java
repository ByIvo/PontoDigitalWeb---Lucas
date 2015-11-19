package br.com.pontowebdigital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pontowebdigital.dao.ContratoDAO;
import br.com.pontowebdigital.model.Contrato;
import br.com.pontowebdigital.service.ContratoService;

@Service
@Transactional("transactionManager")
public class ContratoServiceImpl implements ContratoService
{
	
	@Autowired
	private ContratoDAO dao;
	
	@Override
	public List<Contrato> findAll()
	{
		return dao.findAll();
	}
	
	@Override
	public Contrato save(Contrato entity)
	{
		return dao.save(entity);
	}
	
	@Override
	public Contrato saveOrUpdate(Contrato entity)
	{
		return dao.saveOrUpdate(entity);
	}
	
	@Override
	public Contrato find(Integer id)
	{
		return dao.find(id);
	}
	
	@Override
	public void remove(Contrato entity)
	{
		dao.remove(entity);
	}
	
	@Override
	public void remove(Integer id)
	{
		dao.remove(id);
	}
	
	@Override
	public Contrato update(Contrato entity)
	{
		return dao.update(entity);
	}
	
}
