package br.com.webscrum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.webscrum.model.Projeto;
import br.com.webscrum.model.Sprint;
import br.com.webscrum.model.UseCase;
import br.com.webscrum.service.ProjetoService;
import br.com.webscrum.service.SprintService;
import br.com.webscrum.service.UseCaseService;

@Controller
@RequestMapping(value = { "/usecase" })
public class UseCaseController {
	@Autowired
	UseCaseService usecaseService;
	
	@Autowired
	ProjetoService projetoService;

	@Autowired
	SprintService sprintService;



	@PostMapping("/add")
	public String addUseCase(@Valid UseCase usecase, @ModelAttribute("projeto") Projeto projeto, Sprint sprint,
			BindingResult result, Model model, RedirectAttributes attributes) { // ModelAttribute tem que estar dentro
																				// do form
		if (result.hasErrors()) {
			model.addAttribute("mensagemForm", "Erro! Campo obrigatório não preenchido." + result.toString());
			return "projeto/form";
		} else {
			usecaseService.add(projeto.getId(), usecase);

			attributes.addFlashAttribute("mensagemForm",
					"Novo Caso de uso Cadastrado com Sucesso!");
			return "redirect:../projeto/planning/" + projeto.getId();
		}
	}

	@PostMapping("/merge/{id_projeto}/{id_uc}")
	public String mergeUseCase(@PathVariable("id_projeto") String id_projeto, @PathVariable("id_uc") String id_uc,
			@ModelAttribute UseCase usecase, Model model) {
		usecaseService.merge(id_uc, usecase);
		return "redirect: ../../../../../projeto/planning/" + id_projeto;
	}

	@GetMapping("/open/{id_projeto}/{id_uc}")
	public String openUseCase(@PathVariable("id_projeto") String id_projeto, @PathVariable("id_uc") String id_uc,
			Projeto projeto, Model model) {
		model.addAttribute("usecase", usecaseService.get(id_uc));
		model.addAttribute("projeto", projetoService.get(Integer.valueOf(id_projeto)));
		return "projeto/usecase";
	}

	@PostMapping("/del/{id_projeto}/{id_uc}")
	public String delUseCase(@PathVariable("id_projeto") String id_projeto, @PathVariable("id_uc") String id_uc) {
		usecaseService.delete(id_uc);
		return "redirect: ../../../../../projeto/planning/" + id_projeto;
	}

}
