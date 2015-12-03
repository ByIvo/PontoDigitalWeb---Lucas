package br.com.pontowebdigital.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.com.pontowebdigital.dao.PontoDAO;
import br.com.pontowebdigital.dao.GenericDAO;
import br.com.pontowebdigital.model.Ponto;

@Repository
@Transactional
public class PontoDAOImpl extends GenericDAO<Ponto, Integer> implements PontoDAO {

	public PontoDAOImpl() {
		super(Ponto.class);
	}

}
