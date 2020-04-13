package br.com.webscrum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.webscrum.model.Sprint;
import br.com.webscrum.repository.SprintRepository;

@Service
public class SprintService {
	@Autowired
	SprintRepository sprintRepository;

	public List<Sprint> getAll() {
		return sprintRepository.findAll();
	}

	public Sprint add(Sprint sprint) {
		sprint.setId(null);
		sprintRepository.save(sprint);
		return sprint;
	}

	public Sprint merge(Sprint sprint) {
		return sprintRepository.saveAndFlush(sprint);
	}

	public Sprint get(Integer integer) {
		return sprintRepository.getOne(integer);
	}
}
