package br.com.webscrum.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class UseCase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_uc;
	private String usecase;
	private String prioridade;
	private String ator;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Autowired
	@OneToMany
	private List<Requirement> requirements;

	public Integer getId_uc() {
		return id_uc;
	}

	public void setId_uc(Integer id) {
		this.id_uc = id;
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


}
