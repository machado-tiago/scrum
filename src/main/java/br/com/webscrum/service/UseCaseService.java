package br.com.webscrum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.webscrum.model.UseCase;
import br.com.webscrum.repository.UseCaseRepository;

@Service
public class UseCaseService {
	@Autowired
	UseCaseRepository useCaseRepository;

	public List<UseCase> getAll() {
		return useCaseRepository.findAll();
	}

	public UseCase add(UseCase usecase) {
		usecase.setId(null);// sistema está trazendo os atributos do novo use case com o id do antigo
		useCaseRepository.save(usecase);
		return usecase;
	}

	public void merge(String id, UseCase usecase) {
		usecase.setId(Integer.valueOf(id));
		useCaseRepository.save(usecase);
	}

	public UseCase get(String id) {
		return useCaseRepository.getOne(Integer.valueOf(id));
	}
}
