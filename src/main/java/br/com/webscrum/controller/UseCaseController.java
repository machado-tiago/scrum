package br.com.webscrum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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



	@PostMapping("/add") // SALVAR NO RESUMO
	public String addUseCase(@Valid UseCase usecase, @ModelAttribute("projeto") Projeto projeto, Sprint sprint,
			BindingResult result, Model model, RedirectAttributes attributes) { // ModelAttribute tem que estar dentro
																				// do form
		if (result.hasErrors()) {
			model.addAttribute("mensagemForm", "Erro! Campo obrigatório não preenchido." + result.toString());
			return "projeto/form";
		} else {
			projeto = projetoService.get(Integer.toString(projeto.getId())); // só traz do model o que está lá, então
																				// tem q puxar do banco
			sprint = projeto.getSprint(0); // define o sprint que será registrado o novo caso de uso como o 0,
											// ProductBacklog
			sprint.addUseCase(usecaseService.add(usecase));// falta salvar essa mudança no banco
			System.out.println(projeto.toString());
			sprintService.merge(sprint);
			attributes.addFlashAttribute("mensagemForm",
					"Novo Projeto Cadastrado com Sucesso!");
			return "redirect:../projeto/planning/" + projeto.getId();
		}
	}

}
