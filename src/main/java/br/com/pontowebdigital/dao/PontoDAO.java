package br.com.pontowebdigital.dao;

import java.util.List;

import br.com.pontowebdigital.model.Ponto;

public interface PontoDAO
{
	List<Ponto> findAll();
	
	Ponto save(Ponto entity);
	
	Ponto saveOrUpdate(Ponto entity);
	
	Ponto find(Integer id);
	
	Ponto findF(Integer id);
	
	void remove(Ponto entity);
	
	void remove(Integer id);
	
	Ponto update(Ponto entity);
}
