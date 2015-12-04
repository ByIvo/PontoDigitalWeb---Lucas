package br.com.pontowebdigital.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.pontowebdigital.model.Ponto;
import br.com.pontowebdigital.service.PontoService;
import br.com.pontowebdigital.service.impl.PontoServiceImpl;

@Controller
@RequestMapping("admin/pontos")
public class PontoController {

	@Autowired
	private PontoService service;

	@ResponseBody
	@RequestMapping(value = "/", method = { RequestMethod.GET })
	public List<Ponto> findAll() {
		return service.findAll();
	}

	@ResponseBody
	@RequestMapping(value = "/", method = { RequestMethod.POST })
	public Ponto addEntity(@ModelAttribute("ponto") Ponto entity) {

		entity = service.saveOrUpdate(entity);
		return entity;
	}

	@ResponseBody
	@RequestMapping(method = { RequestMethod.POST })
	public Ponto deleteEntity(@ModelAttribute("ponto") Ponto entity) {
		service.remove(entity);

		return entity;
	}

	@RequestMapping(value = "{id}", method = { RequestMethod.DELETE })
	public @ResponseBody Ponto deleteEntityById(@PathVariable Integer id) {
		service.remove(id);
		return null;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.GET })
	public @ResponseBody List<Ponto> relatorioByFuncionario(@PathVariable Integer id) {
		return service.findAllByFuncionarioId(id);
	}

	@RequestMapping(value = "/{id, dataI, dataF}", method = { RequestMethod.GET })
	public @ResponseBody List<Ponto> relatorioBetweenDates(@PathVariable Integer id, Date dataI, Date dataF) {
		return service.findBetweenDates(id, dataI, dataF);

	}
}
