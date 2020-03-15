package br.com.webscrum.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.webscrum.model.Projeto;
import br.com.webscrum.service.ProjetoService;

@Controller
@RequestMapping(value = { "/projeto" })
public class ProjetoController {
	@Autowired
	ProjetoService projetoService;


	@GetMapping(value = { "/all" })
	public String projetos(Model model) {
		System.out.println("Consulta ao banco de dados");
		List<Projeto> projetos = projetoService.currentProjects();
		model.addAttribute("projetos", projetos);
		return "home";
	}

	@PostMapping("/add")
	public String addProjeto(@Valid Projeto projeto, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			model.addAttribute("mensagemForm", "Erro! Campo obrigatório não preenchido." + result.toString());
			return "projeto/form";
		} else {
			projetoService.add(projeto);
			attributes.addFlashAttribute("mensagemForm",
					"Novo Projeto Cadastrado com Sucesso!" + "\r\n" + projeto.toString());
			return "redirect:/projeto/all";
		}
	}

	@GetMapping(value = "/{id}")
	public String abrir(@PathVariable("id") String id, Model model) {
		System.out.println("Consulta ao banco de dados ID");
		Projeto projeto = projetoService.getProjeto(id);
		model.addAttribute("projeto", projeto);
		System.out.println(projeto.toString());
		return "projeto/projeto_home";
	}

}
