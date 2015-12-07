package br.com.pontowebdigital.controller;

import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.joda.time.Minutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.pontowebdigital.model.Funcionario;
import br.com.pontowebdigital.model.Ponto;
import br.com.pontowebdigital.model.Regra;
import br.com.pontowebdigital.service.FuncionarioService;
import br.com.pontowebdigital.service.PontoService;

@Controller
@RequestMapping("admin/pontos")
public class PontoController {

	@Autowired
	private PontoService service;
	private FuncionarioService fservice;

	@ResponseBody
	@RequestMapping(value = "/", method = { RequestMethod.GET })
	public List<Ponto> findAll() {
		return service.findAll();
	}

	@ResponseBody
	@RequestMapping(value = "/", method = { RequestMethod.POST })
	public Ponto addEntity(@ModelAttribute("ponto") Ponto entity) {
		Date data = new Date();
		if (entity.getEntrada() == null) {
			entity.setEntrada(data);
			entity = service.saveOrUpdate(entity);
		} else {
			entity.setSaida(data);
			entity = service.saveOrUpdate(entity);
			return null;
		}
		return entity;
	}

	@RequestMapping(value = "{id}", method = { RequestMethod.POST })
	public Ponto addPonto(@PathVariable Integer id) {
		Ponto ponto = service.findLastPonto(id);
		Funcionario f = fservice.find(id);
		Date date = new Date();
		if (ponto.getSaida() == null) {
			ponto.setSaida(date);
			service.saveOrUpdate(ponto);
		} else {
			Ponto pontoNovo = new Ponto();
			pontoNovo.setEntrada(date);
			service.saveOrUpdate(pontoNovo);
		}

		return null;
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

	@RequestMapping(value = "{id}", method = { RequestMethod.GET })
	public @ResponseBody Ponto findEntity(@PathVariable Integer id) {
		return service.find(id);
	}
	// @RequestMapping(value = "/{id, dataI, dataF}", method = {
	// RequestMethod.GET })
	// public @ResponseBody List<Ponto> relatorioBetweenDates(@PathVariable
	// Integer id, Date dataI, Date dataF) {
	// return service.findBetweenDates(id, dataI, dataF);
	// }

	@RequestMapping(value = "/teste", method = { RequestMethod.GET })
	public @ResponseBody String calculoTeste() {
		List<Ponto> listaPontos = service.findAll();
		LocalTime manhaEntrada = new LocalTime(7, 30, 00, 00), manhaSaida = new LocalTime(11, 30, 00, 00),
				tardeEntrada = new LocalTime(13, 30, 00, 00), tardeSaida = new LocalTime(17, 30, 00, 00),
				entradaLocalTime, saidaLocalTime;
		double thn = 0, the = 0, thec = 0, tht = 0, vn = 0, ve = 0, vt = 0, he = 0;
		double horasTrabalhadas = 0, horasExtras, horasExtrasCalculadas, intervalo, porcentagem, totalHorasNormais, valorPorHora = 5.50;
		for (Ponto ponto : listaPontos) {
			// Converte a entrada e saída em DateTime do Joda
			DateTime entrada = new DateTime(ponto.getEntrada()), saida = new DateTime(ponto.getSaida());
			// Transforma em LocalTime
			entradaLocalTime = toLocalTime(entrada);
			saidaLocalTime = toLocalTime(saida);
			// Procura as horas trabalhadas
			intervalo = intervaloEmDouble(entradaLocalTime, saidaLocalTime);
			horasTrabalhadas = horasTrabalhadas + intervalo;
			// Verifica o dia da Semana
			if (entrada.dayOfWeek().equals(6) || entrada.dayOfWeek().equals(0)) {
				porcentagem = 100;
			} else {
				porcentagem = 60;
			}
			// Verifica se achou alguma hora extra
			he = verificarHoraExtra(manhaEntrada, manhaSaida, tardeEntrada, tardeSaida, entradaLocalTime,
					saidaLocalTime);
			thec = thec + ((he * porcentagem) / 100);
			the = the + he;
			System.out.println("Total de Horas Extras até agora: " + the + "\n");

		}
		horasExtras = the * 100;
		horasExtras = horasExtras / 60;
		horasExtrasCalculadas = thec * 100;
		horasExtrasCalculadas = horasExtrasCalculadas / 60;

		totalHorasNormais = horasTrabalhadas - the;
		vn = totalHorasNormais * valorPorHora;
		ve = thec * valorPorHora;
		System.out.println("hora Extra Calculada " + horasExtrasCalculadas);
		System.out.println("Horas Trabalhadas: " + horasTrabalhadas + "\nHoras Normais: " + totalHorasNormais
				+ " - Valor das Horas Normais: " + vn + "\n Horas Extras trabalhadas: " + horasExtras
				+ " Valor das Horas Extras: " + ve);
		return "Horas Trabalhadas: " + horasTrabalhadas + "\nHoras Normais: " + totalHorasNormais
				+ " - Valor das Horas Normais: " + vn + "\n Horas Extras trabalhadas: " + horasExtras
				+ " Valor das Horas Extras: " + ve;

	}

	private LocalTime toLocalTime(DateTime data) {
		LocalTime dataConvertida = new LocalTime(data.getHourOfDay(), data.getMinuteOfHour(), data.getSecondOfMinute(),
				data.getMillisOfSecond());

		return dataConvertida;
	}

	private double verificarHoraExtra(LocalTime manhaEntrada, LocalTime manhaSaida, LocalTime tardeEntrada,
			LocalTime tardeSaida, LocalTime entrada, LocalTime saida) {
		double he = 0;
		System.out.println("chamou o verifica Hora Extra");
		// chegou antes do horário da manhã anttes do horário
		if (entrada.isBefore(manhaEntrada.minusMinutes(10))) {
			System.out.println("Achou Hora Extra - entrou no 1 if");
			he = intervaloEmDouble(manhaEntrada, entrada);
			// chegou antes do horário da tarde
		} else if (entrada.isAfter(manhaSaida) && entrada.isBefore(tardeEntrada.minusMinutes(10))) {
			System.out.println("Achou Hora Extra - entrou no 2 if");
			he = intervaloEmDouble(tardeEntrada, entrada);
			// saiu depois do horário da manhã
		} else if (saida.isAfter(manhaSaida.plusMinutes(10)) && saida.isBefore(tardeEntrada)) {
			System.out.println("Achou Hora Extra - entrou no 3 if");
			he = intervaloEmDouble(manhaSaida, saida);
			// saiu depois do horário da tarde
		} else if (saida.isAfter(tardeSaida.plusMinutes(10))) {
			System.out.println("Achou Hora Extra - entrou no 4 if");
			he = intervaloEmDouble(saida, tardeSaida);
		}
		;

		return he;
	}

	private LocalTime intervaloEmLocalTime(LocalTime l1, LocalTime l2) {
		LocalTime horaConvertida;
		int emMinutos = Minutes.minutesBetween(l1, l2).getMinutes();
		int horas = emMinutos / 60;
		int minutos = emMinutos % 60;
		int segundos = emMinutos * 60;
		int mili = segundos * 1000;
		horaConvertida = new LocalTime(horas, minutos, segundos, mili);

		return horaConvertida;
	}

	private double intervaloEmDouble(LocalTime l1, LocalTime l2) {
		double horas, minutos;
		int emMinutos = Minutes.minutesBetween(l1, l2).getMinutes();
		System.out.println("achou os minutos: " + emMinutos);
		horas = emMinutos / 60;
		System.out.println("Transformou os minutos em horas :" + horas);
		minutos = emMinutos % 60;
		System.out.println("Achou o resto :" + minutos);
		minutos = minutos / 60;
		System.out.println("Transformou o resto em double :" + minutos);
		horas = horas + minutos;
		System.out.println("Resultado: " + horas + "\n --------------------------------------\n");
		return horas;
	}

	/*
	 * @SuppressWarnings("deprecation")
	 * 
	 * @RequestMapping(value = "{id, dataI, dataF}", method = {
	 * RequestMethod.GET }) public @ResponseBody String
	 * calculoBetweenDates(@PathVariable Integer id, Date dataI, Date dataF) {
	 * List<Ponto> listaPontos = service.findBetweenDates(id, dataI, dataF);
	 * String valores; Double thn = (double) 0, the = (double) 0, tht = (double)
	 * 0, vn = (double) 0, ve = (double) 0, vt = (double) 0, he = (double) 0;
	 * Regra semanal = service.findRegra(id, "SEMANAL"); Regra diario =
	 * service.findRegra(id, "DIARIO"); for (Ponto ponto : listaPontos) { if
	 * (ponto.getEntrada().getDay() == 6 || ponto.getEntrada().getDay() == 0) {
	 * tht = tht + ponto.getSaida().getTime() - ponto.getEntrada().getTime(); he
	 * = (ponto.getSaida().getTime() - ponto.getEntrada().getTime()) -
	 * diario.getHorasTrabalho(); he = he + ((he *
	 * diario.getporcentagemHoraExtra()) / 100); the = the + he; thn = tht -
	 * the; } else { tht = tht + ponto.getSaida().getTime() -
	 * ponto.getEntrada().getTime(); he = (ponto.getSaida().getTime() -
	 * ponto.getEntrada().getTime()) - diario.getHorasTrabalho(); he = he + ((he
	 * * semanal.getporcentagemHoraExtra()) / 100); the = the + he; thn = tht -
	 * the; } } vn = thn * semanal.getValor(); ve = the * semanal.getValor(); vt
	 * = vn + ve;
	 * 
	 * valores = thn + ";" + vn + ";" + the + ";" + ve + ";" + tht + ";" + vt +
	 * ";";
	 * 
	 * 
	 * return valores;
	 * 
	 * }
	 */
}
