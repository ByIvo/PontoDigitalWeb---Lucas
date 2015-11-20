package br.com.pontowebdigital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.pontowebdigital.model.Cargo;
import br.com.pontowebdigital.service.CargoService;

@Controller
@RequestMapping("admin/cargos")
public class CargoController
{
	
	@Autowired
	private CargoService service;
	
	@ResponseBody
	@RequestMapping(value="/",method = { RequestMethod.GET })
	public List<Cargo> findAll()
	{
		return service.findAll();
	}
	
	@ResponseBody
	@RequestMapping(value="/add", method = { RequestMethod.POST })
	public Cargo addEntity(@ModelAttribute("cargo") Cargo entity)
	{
		entity = service.saveOrUpdate(entity);
		return entity;
	}
	
	@ResponseBody
	@RequestMapping(method = { RequestMethod.POST })
	public Cargo deleteEntity(@ModelAttribute("cargo") Cargo entity)
	{
		service.remove(entity);
		
		return entity;
	}
	
	@RequestMapping(value = "{id}", method = { RequestMethod.DELETE })
	public @ResponseBody Cargo deleteEntityById(@PathVariable Integer id)
	{
		service.remove(id);
		
		return null;
	}
	
	@RequestMapping(value = "{id}", method = { RequestMethod.GET })
	public @ResponseBody Cargo findEntity(@PathVariable Integer id)
	{
		return service.find(id);
	}
}
