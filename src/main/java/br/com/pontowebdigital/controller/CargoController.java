package br.com.pontowebdigital.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.pontowebdigital.model.Cargo;

@Controller()
@RequestMapping("/cargo")
public class CargoController {

	private List<Cargo> cargos;
	private static Integer id;

	static {
		id = 0;
	}

	public static final int getNovoCargoId() {
		return id++;
	}

	public CargoController() {
		cargos = new ArrayList<Cargo>();
	}

	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public String cargoCadastro(Cargo cargo) {
		return "cargoCadastro";
	}

	@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
	public @ResponseBody Cargo novoCargo(@ModelAttribute("cargo") Cargo cargo) {
		if (cargo.getId() == null) {
			int novoId = getNovoCargoId();
			cargo.setId(novoId);
		}

		cargos.add(cargo);

		return cargo;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody List<Cargo> buscarCargos() {
		return cargos;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Cargo buscarCargoById(@RequestParam Integer id) {
		for (Cargo cargo : cargos) {
			if (cargo.getId().equals(id)) {
				return cargo;
			}
		}

		return null;
	}
}
