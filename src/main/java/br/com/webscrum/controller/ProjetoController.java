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

import br.com.webscrum.controller.ProjetoDto.ProjetoForm;
import br.com.webscrum.model.Projeto;
import br.com.webscrum.service.ProjetoService;
import br.com.webscrum.service.SprintService;

@Controller
@RequestMapping(value = { "/projeto" })
public class ProjetoController {
	@Autowired
	ProjetoService projetoService;

	@Autowired
	SprintService sprintService;

	@GetMapping(value = { "/all" })
	public String projetos(Model model) {
		List<Projeto> projetos = projetoService.currentProjects();
		model.addAttribute("projetos", projetos);
		return "home";
	}

	@PostMapping("/add")
	public String addProjeto(@Valid Projeto projeto, BindingResult result, Model model,
			RedirectAttributes attributes) { // projeto é instanciado automaticamente
		if (result.hasErrors()) {
			model.addAttribute("mensagemForm", "Erro! Campo obrigatório não preenchido." + result.toString());
			return "projeto/form";
		} else {
			projetoService.add(projeto);
			attributes.addFlashAttribute("mensagemForm",
					"Novo Projeto Cadastrado com Sucesso!");
			return "redirect:" + projeto.getId();
		}
	}

	@GetMapping(value = "/{id}")
	public String abrir(@PathVariable("id") String id, Model model) {
		Projeto projeto = projetoService.get(Integer.valueOf(id));
		model.addAttribute("projeto", projeto);
		System.out.println(projeto.toString());
		return "projeto/projeto_home";
	}

	@PostMapping(value = "/{id}")
	public String atualizar(@PathVariable("id") String id, ProjetoForm projetoForm){
		Projeto projeto = projetoService.get(Integer.valueOf(id));
		projetoForm.converter(projeto);
		System.out.println(projeto.toString());
		//projetoService.merge(projeto);
		return "redirect:"  + projeto.getId();
	}

	@GetMapping(value = "/planning/{id}")
	public String planning(@PathVariable("id") String id, Model model) {
		Projeto projeto = projetoService.get(Integer.valueOf(id));
		model.addAttribute("projeto", projeto);
		System.out.println(projeto.toString());
		return "projeto/sprint_planning";
	}

	@GetMapping(value = "/planning/{proj_id}/{sprint_id}")
	public String backToSprint(@PathVariable("proj_id") String proj_id,@PathVariable("sprint_id") String sprint_id, Model model) {
		Projeto projeto = projetoService.get(Integer.valueOf(proj_id));
		model.addAttribute("projeto", projeto);
		model.addAttribute("sprintSelectedId", sprint_id);
		System.out.println(projeto.toString());
		return "projeto/sprint_planning";
	}
}
