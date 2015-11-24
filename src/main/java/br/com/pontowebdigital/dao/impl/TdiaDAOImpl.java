package br.com.pontowebdigital.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.com.pontowebdigital.dao.TdiaDAO;
import br.com.pontowebdigital.dao.GenericDAO;
import br.com.pontowebdigital.model.Tdia;

@Repository
@Transactional
public class TdiaDAOImpl extends GenericDAO<Tdia, Integer> implements TdiaDAO
{
	
	public TdiaDAOImpl()
	{
		super(Tdia.class);
	}
	
	
}
