package br.com.webscrum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.webscrum.model.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {

	@Query("select p from Projeto p where status=null or status <> 'concluído' or status <> 'cancelado' ")
	List<Projeto> currentProjects();

}
