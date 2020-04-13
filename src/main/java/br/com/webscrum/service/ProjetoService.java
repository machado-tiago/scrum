package br.com.webscrum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.webscrum.model.Projeto;
import br.com.webscrum.model.Sprint;
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
		Sprint sprint = new Sprint();
		sprint.setDescricao("Product Backlog");
		sprintService.add(sprint); // está salvando corretamente no banco de dados e o objeto já retorna o id
		projeto.newProject(sprint);
		projeto.setId(null);
		projetoRepository.save(projeto);
	}

	public Projeto get(String id) {
		return projetoRepository.getOne(Integer.valueOf(id));
	}

	public Projeto merge(Projeto projeto) {
		return projetoRepository.save(projeto);
	}
}
