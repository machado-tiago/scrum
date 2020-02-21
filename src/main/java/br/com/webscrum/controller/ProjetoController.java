package br.com.webscrum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.webscrum.model.Projeto;
import br.com.webscrum.service.ProjetoService;

@RestController
public class ProjetoController {
	@Autowired
	ProjetoService projetoService;


	@RequestMapping(value = { "/", "/projetos" })
	@Autowired
	public List<Projeto> projetos() {
		System.out.println("Consulta ao banco de dados");
		return projetoService.getAll();

	}
}
