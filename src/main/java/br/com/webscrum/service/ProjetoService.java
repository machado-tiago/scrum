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
		projeto.setId(null);
		projetoRepository.save(projeto);
		Sprint sprint = sprintService.add(projeto);
		sprint.setDescricao("Product Backlog");
		sprintService.merge(sprint);
	}

	public ProjetoRepository getProjetoRepository() {
		return projetoRepository;
	}

	public void setProjetoRepository(ProjetoRepository projetoRepository) {
		this.projetoRepository = projetoRepository;
	}

	public SprintService getSprintService() {
		return sprintService;
	}

	public void setSprintService(SprintService sprintService) {
		this.sprintService = sprintService;
	}

	public Projeto get(Integer id) {
		return projetoRepository.getOne(id);
	}

	public Projeto merge(Projeto projeto) {
		return projetoRepository.save(projeto);
	}

}
