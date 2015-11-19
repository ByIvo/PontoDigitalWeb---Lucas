package br.com.pontowebdigital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pontowebdigital.dao.RegraDAO;
import br.com.pontowebdigital.model.Regra;
import br.com.pontowebdigital.service.RegraService;

@Service
@Transactional("transactionManager")
public class RegraServiceImpl implements RegraService
{
	
	@Autowired
	private RegraDAO dao;
	
	@Override
	public List<Regra> findAll()
	{
		return dao.findAll();
	}
	
	@Override
	public Regra save(Regra entity)
	{
		return dao.save(entity);
	}
	
	@Override
	public Regra saveOrUpdate(Regra entity)
	{
		return dao.saveOrUpdate(entity);
	}
	
	@Override
	public Regra find(Integer id)
	{
		return dao.find(id);
	}
	
	@Override
	public void remove(Regra entity)
	{
		dao.remove(entity);
	}
	
	@Override
	public void remove(Integer id)
	{
		dao.remove(id);
	}
	
	@Override
	public Regra update(Regra entity)
	{
		return dao.update(entity);
	}
	
}
