package br.com.pontowebdigital.dao;

import java.util.List;

import br.com.pontowebdigital.model.Regra;

public interface RegraDAO
{
	List<Regra> findAll();
	
	Regra save(Regra entity);
	
	Regra saveOrUpdate(Regra entity);
	
	Regra find(Integer id);
	
	void remove(Regra entity);
	
	void remove(Integer id);
	
	Regra update(Regra entity);
}
