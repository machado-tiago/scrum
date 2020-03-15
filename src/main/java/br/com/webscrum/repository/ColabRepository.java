package br.com.webscrum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.webscrum.model.Colaborador;

@Repository
public interface ColabRepository extends JpaRepository<Colaborador, Integer> {

}
