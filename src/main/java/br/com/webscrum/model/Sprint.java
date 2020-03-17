package br.com.webscrum.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sprint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_sprint;
	private int sprint;
	private String descricao;
	private float duracao;

	
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

	public Sprint() {
	}

	public void sprintNewProject() {
		this.setSprint(0);
		this.setDescricao("Planejamento do Projeto e Arquitetura do Sistema");
	}

	public Integer getSprint() {
		return sprint;
	}

	public void setSprint(Integer sprint) {
		this.sprint = sprint;
	}

	public Integer getId_sprint() {
		return id_sprint;
	}

	public void setId_sprint(Integer id_sprint) {
		this.id_sprint = id_sprint;
	}

}
