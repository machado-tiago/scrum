package br.com.webscrum.model;

import java.io.File;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class UseCase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String usecase;
	private String userstory;
	private String fluxoAlternativo;
	private File diagramaSequencia;
	private String prioridade;
	private String ator;
	@Enumerated(EnumType.STRING)
	private UseCaseStatus useCaseStatus;
	@ManyToOne
	@JoinColumn(name = "sprint_id")
	private Sprint sprint;
	@OneToMany(mappedBy = "usecase")
	private List<Requirement> requirements;

	public Integer getId() {
		return id;
	}

	public String getUserstory() {
		return userstory;
	}

	public File getDiagramaSequencia() {
		return diagramaSequencia;
	}

	public String getFluxoAlternativo() {
		return fluxoAlternativo;
	}

	public void setFluxoAlternativo(String seqAlternativa) {
		this.fluxoAlternativo = seqAlternativa;
	}

	public void setDiagramaSequencia(File diagramaSequencia) {
		this.diagramaSequencia = diagramaSequencia;
	}

	public void setUserstory(String descricao) {
		this.userstory = descricao;
	}
	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
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
		this.setUseCaseStatus(UseCaseStatus.USERSTORY);
		// colocar depois a data de criação
	}

	public UseCaseStatus getUseCaseStatus() {
		return useCaseStatus;
	}

	public void setUseCaseStatus(UseCaseStatus useCaseStatus) {
		this.useCaseStatus = useCaseStatus;
	}

	@Override
	public String toString() {
		return String.format("UseCase: [id=%s, usecase=%s, prioridade=%s, ator=%s, status=%s, requirements=%s]", id,
				usecase, prioridade, ator, useCaseStatus, requirements);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UseCase other = (UseCase) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
