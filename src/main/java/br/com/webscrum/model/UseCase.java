package br.com.webscrum.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UseCase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String usecase;
	private String prioridade;
	private String ator;
	private String status;
	@OneToMany
	private List<Requirement> requirements = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsecase() {
		return usecase;
	}

	public void setUsecase(String usecase) {
		this.usecase = usecase;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public String getAtor() {
		return ator;
	}

	public void setAtor(String ator) {
		this.ator = ator;
	}

	public List<Requirement> getRequirements() {
		return requirements;
	}

	public void setRequirements(List<Requirement> requirements) {
		this.requirements = requirements;
	}

	public UseCase() {
		this.setStatus("planejamento");
		// colocar depois a data de criação
	}

	@Override
	public String toString() {
		return String.format("UseCase: [id=%s, usecase=%s, prioridade=%s, ator=%s, status=%s, requirements=%s]", id,
				usecase, prioridade, ator, status, requirements);
	}

}
