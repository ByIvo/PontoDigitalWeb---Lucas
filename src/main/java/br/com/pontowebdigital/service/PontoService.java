package br.com.pontowebdigital.service;

import java.util.List;

import br.com.pontowebdigital.model.Ponto;

public interface PontoService extends DefaultService<Ponto, Integer>
{
	List<Ponto> findAllByFuncionarioId(Integer id);
}
