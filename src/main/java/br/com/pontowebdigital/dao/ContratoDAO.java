package br.com.pontowebdigital.dao;

import java.util.List;

import br.com.pontowebdigital.model.Contrato;

public interface ContratoDAO {
	List<Contrato> findAll();

	Contrato save(Contrato entity);

	Contrato saveOrUpdate(Contrato entity);

	Contrato find(Integer id);

	void remove(Contrato entity);

	void remove(Integer id);

	Contrato update(Contrato entity);
}
