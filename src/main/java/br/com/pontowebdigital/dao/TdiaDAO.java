package br.com.pontowebdigital.dao;

import java.util.List;

import br.com.pontowebdigital.model.Tdia;

public interface TdiaDAO
{
	List<Tdia> findAll();
	
	Tdia save(Tdia entity);
	
	Tdia saveOrUpdate(Tdia entity);
	
	Tdia find(Integer id);
	
	void remove(Tdia entity);
	
	void remove(Integer id);
	
	Tdia update(Tdia entity);
}
