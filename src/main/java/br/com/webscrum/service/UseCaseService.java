package br.com.webscrum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.webscrum.model.Projeto;
import br.com.webscrum.model.Sprint;
import br.com.webscrum.model.UseCase;
import br.com.webscrum.repository.SprintRepository;
import br.com.webscrum.repository.UseCaseRepository;

@Service
public class UseCaseService {
	@Autowired
	UseCaseRepository useCaseRepository;

	@Autowired
	ProjetoService projetoService;

	public UseCaseRepository getUseCaseRepository() {
		return useCaseRepository;
	}

	public void setUseCaseRepository(UseCaseRepository useCaseRepository) {
		this.useCaseRepository = useCaseRepository;
	}

	public SprintRepository getSprintRepository() {
		return sprintRepository;
	}

	public void setSprintRepository(SprintRepository sprintRepository) {
		this.sprintRepository = sprintRepository;
	}

	@Autowired
	SprintRepository sprintRepository;

	public List<UseCase> getAll() {
		return useCaseRepository.findAll();
	}

	public UseCase add(Integer projeto_id, UseCase usecase) {
		Projeto projeto = projetoService.get(projeto_id); // só traz do model o que está lá,
																					// então tem q puxar do banco
		usecase.setSprint(projeto.getSprint(0));
		usecase.setId(null);// sistema está trazendo os atributos do novo use case com o id do antigo
		useCaseRepository.save(usecase);
		System.out.println(projeto.toString());
		return usecase;
	}

	public void merge(String id, UseCase usecase) {
		usecase.setId(Integer.valueOf(id));
		useCaseRepository.save(usecase);
	}

	public UseCase get(String id) {
		return useCaseRepository.getOne(Integer.valueOf(id));
	}

	public void delete(String id_uc) {
		UseCase usecase = useCaseRepository.getOne(Integer.valueOf(id_uc));
		System.out.println(usecase.getSprint());
		Sprint sprint = usecase.getSprint();
		sprint.removeUseCase(usecase);
		sprintRepository.save(sprint);
		useCaseRepository.deleteById(Integer.valueOf(id_uc));
	}
}