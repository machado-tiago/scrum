package br.com.webscrum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.webscrum.model.Projeto;
import br.com.webscrum.model.Sprint;
import br.com.webscrum.repository.SprintRepository;

@Service
public class SprintService {
	@Autowired
	SprintRepository sprintRepository;

	@Autowired
	ProjetoService projetoService;

	public List<Sprint> getAll() {
		return sprintRepository.findAll();
	}

	public Sprint add(Projeto projeto) {
		Sprint sprint = new Sprint();
		sprint.setProjeto(projeto);
		sprintRepository.save(sprint);
		return sprint;
	}

	public Sprint add(String projeto_id) {
		Sprint sprint = new Sprint();
		sprint.setProjeto(projetoService.get(Integer.valueOf(projeto_id)));
		sprintRepository.save(sprint);
		return sprint;
	}

	public Sprint getPrevious(Sprint sprint){
		return sprintRepository.findPrevious(sprint.getId());
	}

	public Sprint merge(Sprint sprint) {
		return sprintRepository.saveAndFlush(sprint);
	}

	public Sprint get(String sprint_id) {
		return sprintRepository.getOne(Integer.valueOf(sprint_id));
	}
}
