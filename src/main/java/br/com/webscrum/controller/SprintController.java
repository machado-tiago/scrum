package br.com.webscrum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.webscrum.model.Sprint;
import br.com.webscrum.service.SprintService;

@Controller
@RequestMapping(value = { "{id_projeto}/sprint" })
public class SprintController {

	@Autowired
	SprintService sprintService;


	@GetMapping("/add")
	public String addUSprint(@PathVariable("id_projeto") String id_projeto, Model model,
			RedirectAttributes attributes) {
		Sprint sprintSelect = sprintService.add(id_projeto);
		attributes.addFlashAttribute("sprintSelectedId", sprintSelect.getId());
		System.out.println("SprintId: " + sprintSelect.getId());
		return "redirect:../../projeto/planning/" + id_projeto;
	}

//	@PostMapping("/merge/{id_projeto}/{id_uc}") // retirar o projeto
//	public String mergeUseCase(@PathVariable("id_projeto") String id_projeto, @PathVariable("id_uc") String id_uc,
//			@ModelAttribute UseCase usecase, Model model, UseCaseStatus usecasestatus) {
//		usecase.setUseCaseStatus(usecasestatus);
//		usecaseService.merge(id_uc, usecase);
//		return "redirect: ../../../../../projeto/planning/" + usecase.getSprint().getProjeto().getId();
//	}
//
//	@GetMapping("/open/{id_projeto}/{id_uc}")
//	public String openUseCase(@PathVariable("id_projeto") String id_projeto, @PathVariable("id_uc") String id_uc,
//			Projeto projeto, Model model) {
//		model.addAttribute("usecase", usecaseService.get(id_uc));
//		model.addAttribute("projeto", projetoService.get(Integer.valueOf(id_projeto)));
//		model.addAttribute("usecasestatus", UseCaseStatus.values());
//		return "projeto/usecase";
//	}
//
//	@PostMapping("/del/{id_projeto}/{id_uc}")
//	public String delUseCase(@PathVariable("id_projeto") String id_projeto, @PathVariable("id_uc") String id_uc) {
//		usecaseService.delete(id_uc);
//		return "redirect: ../../../../../projeto/planning/" + id_projeto;
//	}

}
