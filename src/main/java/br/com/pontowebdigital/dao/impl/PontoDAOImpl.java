package br.com.pontowebdigital.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
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

	@Override
	public List<Ponto> findAllByFuncionarioId(Integer id) {
		Session session = (Session) getEntityManager().getDelegate();
		Criteria cb = session.createCriteria(Ponto.class);
		cb.add(Restrictions.eq("funcionario.id", "id"));
		List results = cb.list();

		return results;
	}

}
