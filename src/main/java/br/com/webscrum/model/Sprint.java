package br.com.webscrum.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Sprint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private float duracao;
	private boolean atual;
	@Autowired
	@OneToMany
	private List<UseCase> usecases;

	public Sprint() {
	}

	@Autowired
	public void addUseCase(UseCase usecase) {
		usecases.add(usecase);
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

}
