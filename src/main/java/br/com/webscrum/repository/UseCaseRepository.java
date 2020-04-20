package br.com.webscrum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.webscrum.model.Sprint;
import br.com.webscrum.model.UseCase;

@Repository
public interface UseCaseRepository extends JpaRepository<UseCase, Integer> {

	List<UseCase> findBySprint(Sprint sprint);

}
