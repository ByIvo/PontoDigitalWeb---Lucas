package br.com.pontowebdigital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pontowebdigital.dao.TdiaDAO;
import br.com.pontowebdigital.model.Tdia;
import br.com.pontowebdigital.service.TdiaService;

@Service
@Transactional("transactionManager")
public class TdiaServiceImpl implements TdiaService
{
	
	@Autowired
	private TdiaDAO dao;
	
	@Override
	public List<Tdia> findAll()
	{
		return dao.findAll();
	}
	
	@Override
	public Tdia save(Tdia entity)
	{
		return dao.save(entity);
	}
	
	@Override
	public Tdia saveOrUpdate(Tdia entity)
	{
		return dao.saveOrUpdate(entity);
	}
	
	@Override
	public Tdia find(Integer id)
	{
		return dao.find(id);
	}
	
	@Override
	public void remove(Tdia entity)
	{
		dao.remove(entity);
	}
	
	@Override
	public void remove(Integer id)
	{
		dao.remove(id);
	}
	
	@Override
	public Tdia update(Tdia entity)
	{
		return dao.update(entity);
	}
	
}
