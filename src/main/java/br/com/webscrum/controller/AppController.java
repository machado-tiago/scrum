package br.com.webscrum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("projeto/form")
	public String projetoAdd() {
		return "projeto/form";
	}
}
