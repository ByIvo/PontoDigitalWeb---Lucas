package br.com.pontowebdigital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.pontowebdigital.model.Funcionario;
import br.com.pontowebdigital.service.FuncionarioService;

@Controller
@RequestMapping("admin/Funcionarios")
public class FuncionarioController
{
	
	@Autowired
	private FuncionarioService service;
	
	@ResponseBody
	@RequestMapping(value="/",method = { RequestMethod.GET })
	public List<Funcionario> findAll()
	{
		return service.findAll();
	}
	
	@ResponseBody
	@RequestMapping(value="/add", method = { RequestMethod.POST })
	public Funcionario addEntity(@ModelAttribute("Funcionario") Funcionario entity)
	{
		entity = service.saveOrUpdate(entity);
		return entity;
	}
		
	@ResponseBody
	@RequestMapping(method = { RequestMethod.POST })
	public Funcionario deleteEntity(@ModelAttribute("Funcionario") Funcionario entity)
	{
		service.remove(entity);
		
		return entity;
	}
	
	@RequestMapping(value = "{id}", method = { RequestMethod.DELETE })
	public @ResponseBody Funcionario deleteEntityById(@PathVariable Integer id)
	{
		service.remove(id);
		
		return null;
	}
	
	@RequestMapping(value = "{id}", method = { RequestMethod.GET })
	public @ResponseBody Funcionario findEntity(@PathVariable Integer id)
	{
		return service.find(id);
	}
}