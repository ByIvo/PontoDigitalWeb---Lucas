package br.com.pontowebdigital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.pontowebdigital.model.RegraTrabalho;
import br.com.pontowebdigital.service.RegraTrabalhoService;

@Controller
@RequestMapping("admin/regratrabalhos")
public class RegraTrabalhoController
{
	
	@Autowired
	private RegraTrabalhoService service;
	
	@ResponseBody
	@RequestMapping(value="/",method = { RequestMethod.GET })
	public List<RegraTrabalho> findAll()
	{
		return service.findAll();
	}
	
	@ResponseBody
	@RequestMapping(value="/add", method = { RequestMethod.POST })
	public RegraTrabalho addEntity(@ModelAttribute("regraTrabalho") RegraTrabalho entity)
	{
		entity = service.saveOrUpdate(entity);
		return entity;
	}
		
	@ResponseBody
	@RequestMapping(method = { RequestMethod.POST })
	public RegraTrabalho deleteEntity(@ModelAttribute("regraTrabalho") RegraTrabalho entity)
	{
		service.remove(entity);
		
		return entity;
	}
	
	@RequestMapping(value = "{id}", method = { RequestMethod.DELETE })
	public @ResponseBody RegraTrabalho deleteEntityById(@PathVariable Integer id)
	{
		service.remove(id);
		
		return null;
	}
	
	@RequestMapping(value = "{id}", method = { RequestMethod.GET })
	public @ResponseBody RegraTrabalho findEntity(@PathVariable Integer id)
	{
		return service.find(id);
	}
}
