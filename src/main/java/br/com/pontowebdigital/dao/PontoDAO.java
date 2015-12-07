package br.com.pontowebdigital.dao;

import java.util.Date;
import java.util.List;

import br.com.pontowebdigital.model.Ponto;
import br.com.pontowebdigital.model.Regra;

public interface PontoDAO
{
	List<Ponto> findAll();
	
	Ponto save(Ponto entity);
	
	Ponto saveOrUpdate(Ponto entity);
	
	Ponto find(Integer id);
	
	Ponto findLastPonto(Integer id);
	
	List<Ponto> findAllByFuncionarioId(Integer id);
	
	List<Ponto> findBetweenDates(Integer id, Date dataI, Date dataF);
	
	Regra findRegra(Integer id, String tipo);
	
	void remove(Ponto entity);
	
	void remove(Integer id);
	
	Ponto update(Ponto entity);
}
