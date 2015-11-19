package br.com.pontowebdigital.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.pontowebdigital.dao.ContratoDAO;
import br.com.pontowebdigital.dao.GenericDAO;
import br.com.pontowebdigital.model.Contrato;

@Repository
@Transactional
public class ContratoDAOImpl extends GenericDAO<Contrato, Integer> implements ContratoDAO
{
	
	public ContratoDAOImpl()
	{
		super(Contrato.class);
	}
	
	
}
