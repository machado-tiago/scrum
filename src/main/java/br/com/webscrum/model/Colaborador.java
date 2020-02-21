package br.com.webscrum.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Colaborador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_colab;
	private String nome;
	private String funcao;

	public Colaborador(Integer id_colab, String nome, String funcao) {
		super();
		this.id_colab = id_colab;
		this.nome = nome;
		this.funcao = funcao;
	}

	public Integer getId_colab() {
		return id_colab;
	}

	public void setId_colab(Integer id_colab) {
		this.id_colab = id_colab;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

}
