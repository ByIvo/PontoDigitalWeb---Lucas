package br.com.pontowebdigital.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.pontowebdigital.model.Funcionario;
import br.com.pontowebdigital.service.FuncionarioService;

@Component
public class FuncionarioConverter implements Converter<String, Funcionario>
{
	@Autowired
	private FuncionarioService service;

	@Override
	public Funcionario convert(String source)
	{
		try {
			Integer id = Integer.parseInt(source);

			return service.find(id);
		} catch (Exception ex) {
			return null;
		}
	}

}
