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

	public void add(Projeto projeto) {
		projetoRepository.save(projeto);
	}
}
