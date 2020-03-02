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

	public List<Projeto> getAll() {
		return projetoRepository.findAll();
	}

	public List<Projeto> currentProjects() {
		return projetoRepository.currentProjects();
	}

	public void add(Projeto projeto) {
		projeto.setStatus("planejamento");
		projetoRepository.save(projeto);
	}
}
