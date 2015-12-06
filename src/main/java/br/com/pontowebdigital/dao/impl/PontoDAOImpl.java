package br.com.pontowebdigital.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.com.pontowebdigital.dao.PontoDAO;
import br.com.pontowebdigital.dao.GenericDAO;
import br.com.pontowebdigital.model.Ponto;
import br.com.pontowebdigital.model.Regra;

@Repository
@Transactional
public class PontoDAOImpl extends GenericDAO<Ponto, Integer> implements PontoDAO {

	public PontoDAOImpl() {
		super(Ponto.class);
	}

	@Override
	@SuppressWarnings({ "unchecked" })
	public List<Ponto> findAllByFuncionarioId(Integer id) {
		Session session = (Session) getEntityManager().getDelegate();
		Criteria cb = session.createCriteria(Ponto.class);
		cb.add(Restrictions.eq("funcionario.id", id));

		return cb.list();
	}

	@Override
	@SuppressWarnings({ "unchecked" })
	public List<Ponto> findBetweenDates(Integer id, Date dataI, Date dataF) {
		Session session = (Session) getEntityManager().getDelegate();
		Criteria cb = session.createCriteria(Ponto.class);
		Criterion funcionarioId = Restrictions.eq("funcionario.id", id);
		Criterion dataInicial = Restrictions.gt("entrada", dataI);
		Criterion dataFinal = Restrictions.lt("saida", dataF);
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(funcionarioId);
		disjunction.add(dataInicial);
		disjunction.add(dataFinal);
		cb.add(disjunction);

		return cb.list();
	}

	@Override
	public Regra findRegra(Integer id, String tipo) {
		Session session = (Session) getEntityManager().getDelegate();
		Criteria cb = session.createCriteria(Regra.class);
		cb.add(Restrictions.eq("regraTrabalho.id", id));
		cb.add(Restrictions.eq("tipoDia", tipo));
		cb.setMaxResults(1);
		Regra regra = (Regra) cb.uniqueResult();
		
		return regra;
	}

}
