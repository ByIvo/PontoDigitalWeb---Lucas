package br.com.pontowebdigital.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.com.pontowebdigital.dao.RegraTrabalhoDAO;
import br.com.pontowebdigital.dao.GenericDAO;
import br.com.pontowebdigital.model.RegraTrabalho;

@Repository
@Transactional
public class RegraTrabalhoDAOImpl extends GenericDAO<RegraTrabalho, Integer> implements RegraTrabalhoDAO
{
	
	public RegraTrabalhoDAOImpl()
	{
		super(RegraTrabalho.class);
	}
	
	
}
