package br.com.pontowebdigital.service;

import java.util.List;

import br.com.pontowebdigital.model.Entidade;

public interface DefaultService<ENTIDADE extends Entidade, ID> {

	List<ENTIDADE> findAll();

	ENTIDADE save(ENTIDADE entity);
	
	ENTIDADE saveOrUpdate(ENTIDADE entity);

	ENTIDADE find(ID id);
	
	void remove(ENTIDADE entity);
	
	void remove(Integer id);

	ENTIDADE update(ENTIDADE entity);
}
