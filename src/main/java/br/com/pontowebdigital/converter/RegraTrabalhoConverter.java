package br.com.pontowebdigital.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.pontowebdigital.model.Regra;
import br.com.pontowebdigital.service.RegraService;

@Component
public class RegraTrabalhoConverter implements Converter<String, Regra>
{
	@Autowired
	private RegraService service;

	@Override
	public Regra convert(String source)
	{
		try {
			Integer id = Integer.parseInt(source);

			return service.find(id);
		} catch (Exception ex) {
			return null;
		}
	}

}
