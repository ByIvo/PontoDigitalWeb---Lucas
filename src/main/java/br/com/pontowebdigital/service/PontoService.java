package br.com.pontowebdigital.service;

import java.util.Date;
import java.util.List;

import br.com.pontowebdigital.model.Ponto;

public interface PontoService extends DefaultService<Ponto, Integer>
{
	List<Ponto> findAllByFuncionarioId(Integer id);
	
	List<Ponto> findBetweenDates(Integer id, Date dataI, Date dataF);
}
