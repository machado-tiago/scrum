package br.com.webscrum.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sprint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int n_sprint;
	private String descricao;
	private float duracao;
	private boolean atual;

	
	public Sprint() {
	}

	public boolean isAtual() {
		return atual;
	}

	public void setAtual(boolean atual) {
		this.atual = atual;
	}

	public void setN_sprint(int n_sprint) {
		this.n_sprint = n_sprint;
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


	public void sprintNewProject() {
		this.setN_sprint(0);
		this.setDescricao("Planejamento do Projeto e Arquitetura do Sistema");
	}

	public Integer getN_sprint() {
		return n_sprint;
	}

	public void setSprint(Integer n_sprint) {
		this.n_sprint = n_sprint;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
