package br.com.webscrum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.webscrum.model.Requirement;
import br.com.webscrum.repository.RequirementRepostory;

@Service
public class RequirementService {
	@Autowired
	RequirementRepostory requirementRepository;

	public List<Requirement> getAll() {
		return requirementRepository.findAll();
	}

	public Requirement add(Requirement requirement) {
		requirement.setId(null);
		requirementRepository.save(requirement);
		return requirement;
	}

	public void merge(Requirement requirement) {
		requirementRepository.save(requirement);
	}

	public Requirement get(Integer integer) {
		return requirementRepository.getOne(integer);
	}
}
