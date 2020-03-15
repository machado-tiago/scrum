package br.com.webscrum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.webscrum.model.Colaborador;
import br.com.webscrum.repository.ColabRepository;

@Service
public class ColabService {
	@Autowired
	ColabRepository colabRepository;

	public List<Colaborador> getAll() {
		return colabRepository.findAll();
	}

	public void add(Colaborador colab) {
		colabRepository.save(colab);
	}
}
