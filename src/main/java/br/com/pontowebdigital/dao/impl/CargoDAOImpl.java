package br.com.pontowebdigital.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.pontowebdigital.dao.CargoDAO;
import br.com.pontowebdigital.dao.GenericDAO;
import br.com.pontowebdigital.model.Cargo;

@Repository
@Transactional
public class CargoDAOImpl extends GenericDAO<Cargo, Integer> implements CargoDAO
{
	
	public CargoDAOImpl()
	{
		super(Cargo.class);
	}
	
	
}
