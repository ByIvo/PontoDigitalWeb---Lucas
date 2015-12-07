package br.com.pontowebdigital.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.com.pontowebdigital.dao.FuncionarioDAO;
import br.com.pontowebdigital.dao.GenericDAO;
import br.com.pontowebdigital.model.Funcionario;
import br.com.pontowebdigital.model.Ponto;

@Repository
@Transactional
public class FuncionarioDAOImpl extends GenericDAO<Funcionario, Integer> implements FuncionarioDAO {

	public FuncionarioDAOImpl() {
		super(Funcionario.class);
	}

	@Override
	public Funcionario findFuncionario(Integer id) {
		Session session = (Session) getEntityManager().getDelegate();
		Criteria cb = session.createCriteria(Funcionario.class);
		cb.add(Restrictions.eq("id", id));
		return (Funcionario) cb.uniqueResult();
	}

}
