package br.com.webscrum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.webscrum.model.Sprint;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Integer> {

}
