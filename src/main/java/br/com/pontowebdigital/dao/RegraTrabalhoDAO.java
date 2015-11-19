package br.com.pontowebdigital.dao;

import java.util.List;

import br.com.pontowebdigital.model.RegraTrabalho;

public interface RegraTrabalhoDAO
{
	List<RegraTrabalho> findAll();
	
	RegraTrabalho save(RegraTrabalho entity);
	
	RegraTrabalho saveOrUpdate(RegraTrabalho entity);
	
	RegraTrabalho find(Integer id);
	
	void remove(RegraTrabalho entity);
	
	void remove(Integer id);
	
	RegraTrabalho update(RegraTrabalho entity);
}
