package br.com.webscrum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.webscrum.model.Projeto;
import br.com.webscrum.repository.ProjetoRepository;

@Service
public class ProjetoService {

	@Autowired
	ProjetoRepository projetoRepository;

	@Autowired
	SprintService sprintService;

	public List<Projeto> getAll() {
		return projetoRepository.findAll();
	}

	public List<Projeto> currentProjects() {
		return projetoRepository.currentProjects();
	}

	public void add(Projeto projeto) {
		projeto.newProject();
//		sprintService.add(projeto.getSprints().get(0));
		projetoRepository.save(projeto);
	}

	public Projeto getProjeto(String id) {
		return projetoRepository.getOne(Integer.valueOf(id));
	}
}
