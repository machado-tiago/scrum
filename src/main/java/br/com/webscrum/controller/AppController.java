package br.com.webscrum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.webscrum.model.Colaborador;
import br.com.webscrum.service.ColabService;

@Controller
public class AppController {
	@Autowired
	ColabService colabService;

	@RequestMapping("/")
	public String login() {
		return "login";
	}


	@GetMapping(value = { "/home" })
	public String projetos() {
		return "redirect:/projeto/all";
	}

	@RequestMapping("projeto/form")
	public String projetoAdd(Model model) {
		System.out.println("Consulta ao banco de dados");
		List<Colaborador> colaboradores = colabService.getAll();
		model.addAttribute("listaColab", colaboradores);
		return "projeto/form";
	}
}
