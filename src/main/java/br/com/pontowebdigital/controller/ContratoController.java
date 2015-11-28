package br.com.pontowebdigital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.pontowebdigital.model.Contrato;
import br.com.pontowebdigital.service.ContratoService;

@Controller
@RequestMapping("admin/contratos")
public class ContratoController
{
	
	@Autowired
	private ContratoService service;
	
	@ResponseBody
	@RequestMapping(value="/",method = { RequestMethod.GET })
	public List<Contrato> findAll()
	{
		return service.findAll();
	}
	
	@ResponseBody
	@RequestMapping(value="/", method = { RequestMethod.POST })
	public Contrato addEntity(@ModelAttribute("contrato") Contrato entity)
	{
		entity = service.saveOrUpdate(entity);
		return entity;
	}
		
	@ResponseBody
	@RequestMapping(method = { RequestMethod.POST })
	public Contrato deleteEntity(@ModelAttribute("contrato") Contrato entity)
	{
		service.remove(entity);
		
		return entity;
	}
	
	@RequestMapping(value = "{id}", method = { RequestMethod.DELETE })
	public @ResponseBody Contrato deleteEntityById(@PathVariable Integer id)
	{
		service.remove(id);
		
		return null;
	}
	
	@RequestMapping(value = "{id}", method = { RequestMethod.GET })
	public @ResponseBody Contrato findEntity(@PathVariable Integer id)
	{
		return service.find(id);
	}
}
