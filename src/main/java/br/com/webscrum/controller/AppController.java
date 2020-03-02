package br.com.webscrum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AppController {

	@RequestMapping("/")
	public String login() {
		return "login";
	}


	@GetMapping(value = { "/home" })
	public String projetos() {
		return "redirect:/projeto/all";
	}
	@RequestMapping("projeto/form")
	public String projetoAdd() {
		return "projeto/form";
	}
}
