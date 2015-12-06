package br.com.pontowebdigital.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
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
import br.com.pontowebdigital.model.Regra;
import br.com.pontowebdigital.service.PontoService;

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

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/{id, dataI, dataF}", method = { RequestMethod.GET })
	public @ResponseBody String calculoBetweenDates(@PathVariable Integer id, Date dataI, Date dataF) {
		List<Ponto> listaPontos = service.findBetweenDates(id, dataI, dataF);
		String valores;
		Double thn = (double) 0, the = (double) 0, tht = (double) 0, vn = (double) 0, ve = (double) 0, vt = (double) 0, he = (double) 0;
		Regra semanal = service.findRegra(id, "SEMANAL");
		Regra diario = service.findRegra(id, "DIARIO");
		for (Ponto ponto : listaPontos) {
			if (ponto.getEntrada().getDay() == 6 || ponto.getEntrada().getDay() == 0) {
				tht = tht + ponto.getSaida().getTime() - ponto.getEntrada().getTime();
				he = (ponto.getSaida().getTime() - ponto.getEntrada().getTime()) - diario.getHorasTrabalho();
				he = he + ((he * diario.getporcentagemHoraExtra()) / 100);
				the = the + he;
				thn = tht - the;
			} else {
				tht = tht + ponto.getSaida().getTime() - ponto.getEntrada().getTime();
				he = (ponto.getSaida().getTime() - ponto.getEntrada().getTime()) - diario.getHorasTrabalho();
				he = he + ((he * semanal.getporcentagemHoraExtra()) / 100);
				the = the + he;
				thn = tht - the;
			}
		}
		vn = thn * semanal.getValor();
		ve = the * semanal.getValor();
		vt = vn + ve;
		
		valores = thn + ";" + vn + ";" + the + ";" + ve + ";" + tht + ";" + vt + ";"; 
		

		return valores;

	}
}
