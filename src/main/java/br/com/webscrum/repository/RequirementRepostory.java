package br.com.webscrum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.webscrum.model.Requirement;

@Repository
public interface RequirementRepostory extends JpaRepository<Requirement, Integer> {

}
