package br.com.pontowebdigital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pontowebdigital.dao.CargoDAO;
import br.com.pontowebdigital.model.Cargo;
import br.com.pontowebdigital.service.CargoService;

@Service
@Transactional("transactionManager")
public class CargoServiceImpl implements CargoService
{
	
	@Autowired
	private CargoDAO dao;
	
	@Override
	public List<Cargo> findAll()
	{
		return dao.findAll();
	}
	
	@Override
	public Cargo save(Cargo entity)
	{
		return dao.save(entity);
	}
	
	@Override
	public Cargo saveOrUpdate(Cargo entity)
	{
		return dao.saveOrUpdate(entity);
	}
	
	@Override
	public Cargo find(Integer id)
	{
		return dao.find(id);
	}
	
	@Override
	public void remove(Cargo entity)
	{
		dao.remove(entity);
	}
	
	@Override
	public void remove(Integer id)
	{
		dao.remove(id);
	}
	
	@Override
	public Cargo update(Cargo entity)
	{
		return dao.update(entity);
	}
	
}
