package br.com.webscrum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.webscrum.model.Sprint;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Integer> {

    @Query("select t from Sprint t where id = (select max(id) from Sprint where id< :id_atual)")
    Sprint findPrevious(@Param("id") Integer id_atual);

}
