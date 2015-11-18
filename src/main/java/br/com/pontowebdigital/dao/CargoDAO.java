package br.com.pontowebdigital.dao;

import java.util.List;

import br.com.pontowebdigital.model.Cargo;

public interface CargoDAO
{
	List<Cargo> findAll();
	
	Cargo save(Cargo entity);
	
	Cargo saveOrUpdate(Cargo entity);
	
	Cargo find(Integer id);
	
	void remove(Cargo entity);
	
	void remove(Integer id);
	
	Cargo update(Cargo entity);
}
