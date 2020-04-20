package br.com.webscrum.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Sprint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private float duracao;
	private boolean atual;
	@ManyToOne
	@JoinColumn(name = "projeto_id")
	private Projeto projeto;

	@OneToMany(mappedBy = "sprint")
	private List<UseCase> usecases;

	public Sprint() {

	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	private Integer getUseCaseIndex(UseCase usecase) {
		return usecases.indexOf(usecase);
	}

	public void addUseCase(UseCase usecase) {
		usecases.add(usecase);
	}

	public boolean removeUseCase(UseCase usecase) {
		return usecases.remove(usecase);
	}

	public List<UseCase> getUsecases() {
		return usecases;
	}


	public void setUsecases(List<UseCase> usecases) {
		this.usecases = usecases;
	}

	public boolean isAtual() {
		return atual;
	}

	public void setAtual(boolean atual) {
		this.atual = atual;
	}

	public double getDuracao() {
		return duracao;
	}

	public void setDuracao(float duracao) {
		this.duracao = duracao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("Sprint [id=%s, descricao=%s, duracao=%s, atual=%s, usecases=%s]", id, descricao,
				duracao,
				atual, this.printUseCases());
	}

	private String printUseCases() {
		String ucList = "";
		for (UseCase usecase : usecases) {
			ucList += usecase.getUsecase() + "/";
		}
		return ucList;
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
		Sprint other = (Sprint) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
