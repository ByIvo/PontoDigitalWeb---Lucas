package br.com.pontowebdigital.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.pontowebdigital.model.Cargo;
import br.com.pontowebdigital.service.CargoService;

@Component
public class CargoConverter implements Converter<String, Cargo>
{
	@Autowired
	private CargoService service;

	@Override
	public Cargo convert(String source)
	{
		try {
			Integer id = Integer.parseInt(source);

			return service.find(id);
		} catch (Exception ex) {
			return null;
		}
	}

}
