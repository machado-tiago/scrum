package br.com.webscrum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.webscrum.model.Projeto;
import br.com.webscrum.service.ProjetoService;

@RestController
@RequestMapping(value = { "/projeto" })
public class ProjetoController {
	@Autowired
	ProjetoService projetoService;


	@RequestMapping(value = { "/", "/all" })
	@Autowired
	@ResponseBody
	public List<Projeto> projetos() {
		System.out.println("Consulta ao banco de dados");
		return projetoService.getAll();
	}

	@PostMapping("/add")
	public boolean addProjeto(@RequestBody Projeto projeto) {
		projetoService.add(projeto);
		return true;
	}
}
