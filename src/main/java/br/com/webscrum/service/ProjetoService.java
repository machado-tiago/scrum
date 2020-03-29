package br.com.webscrum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.webscrum.model.Projeto;
import br.com.webscrum.model.Sprint;
import br.com.webscrum.repository.ProjetoRepository;
import br.com.webscrum.repository.SprintRepository;

@Service
public class ProjetoService {

	@Autowired
	ProjetoRepository projetoRepository;

	@Autowired
	SprintRepository sprintRepository;

	public List<Projeto> getAll() {
		return projetoRepository.findAll();
	}

	public List<Projeto> currentProjects() {
		return projetoRepository.currentProjects();
	}

	public void add(Projeto projeto, Sprint sprint) {
		projeto.addSprintZero(sprint);
		sprintRepository.save(sprint);
		projetoRepository.save(projeto);
	}

	public Projeto getProjeto(String id) {
		return projetoRepository.getOne(Integer.valueOf(id));
	}
}
