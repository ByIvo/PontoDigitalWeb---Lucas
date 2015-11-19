package br.com.pontowebdigital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pontowebdigital.dao.RegraTrabalhoDAO;
import br.com.pontowebdigital.model.RegraTrabalho;
import br.com.pontowebdigital.service.RegraTrabalhoService;

@Service
@Transactional("transactionManager")
public class RegraTrabalhoServiceImpl implements RegraTrabalhoService
{
	
	@Autowired
	private RegraTrabalhoDAO dao;
	
	@Override
	public List<RegraTrabalho> findAll()
	{
		return dao.findAll();
	}
	
	@Override
	public RegraTrabalho save(RegraTrabalho entity)
	{
		return dao.save(entity);
	}
	
	@Override
	public RegraTrabalho saveOrUpdate(RegraTrabalho entity)
	{
		return dao.saveOrUpdate(entity);
	}
	
	@Override
	public RegraTrabalho find(Integer id)
	{
		return dao.find(id);
	}
	
	@Override
	public void remove(RegraTrabalho entity)
	{
		dao.remove(entity);
	}
	
	@Override
	public void remove(Integer id)
	{
		dao.remove(id);
	}
	
	@Override
	public RegraTrabalho update(RegraTrabalho entity)
	{
		return dao.update(entity);
	}
	
}
