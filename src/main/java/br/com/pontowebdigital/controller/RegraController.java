package br.com.pontowebdigital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.pontowebdigital.model.Regra;
import br.com.pontowebdigital.service.RegraService;

@Controller
@RequestMapping("admin/Regras")
public class RegraController
{
	
	@Autowired
	private RegraService service;
	
	@ResponseBody
	@RequestMapping(value="/",method = { RequestMethod.GET })
	public List<Regra> findAll()
	{
		return service.findAll();
	}
	
	@ResponseBody
	@RequestMapping(value="/add", method = { RequestMethod.POST })
	public Regra addEntity(@ModelAttribute("Regra") Regra entity)
	{
		entity = service.saveOrUpdate(entity);
		return entity;
	}
		
	@ResponseBody
	@RequestMapping(method = { RequestMethod.POST })
	public Regra deleteEntity(@ModelAttribute("Regra") Regra entity)
	{
		service.remove(entity);
		
		return entity;
	}
	
	@RequestMapping(value = "{id}", method = { RequestMethod.DELETE })
	public @ResponseBody Regra deleteEntityById(@PathVariable Integer id)
	{
		service.remove(id);
		
		return null;
	}
	
	@RequestMapping(value = "{id}", method = { RequestMethod.GET })
	public @ResponseBody Regra findEntity(@PathVariable Integer id)
	{
		return service.find(id);
	}
}
