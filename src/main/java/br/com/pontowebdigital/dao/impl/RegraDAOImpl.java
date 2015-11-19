package br.com.pontowebdigital.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.com.pontowebdigital.dao.RegraDAO;
import br.com.pontowebdigital.dao.GenericDAO;
import br.com.pontowebdigital.model.Regra;

@Repository
@Transactional
public class RegraDAOImpl extends GenericDAO<Regra, Integer> implements RegraDAO
{
	
	public RegraDAOImpl()
	{
		super(Regra.class);
	}
	
	
}
