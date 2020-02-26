package br.com.webscrum.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Projeto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_proj;
	private double orcamento;

	@javax.validation.constraints.NotEmpty
	private String nome;
	private String objetivo;
	private String status;
	@Autowired
	@OneToMany
	private List<Colaborador> colaboradores;
	@OneToMany
	@Autowired
	private List<Sprint> sprints;


	public Projeto() {

	}

	public boolean encerrarProjeto(String status) {
		if (status == "cancelado" | status == "encerrado") {
			setStatus(status);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return String.format(
				"Projeto: id=%s, nome=%s, objetivo=%s, status=%s, orcamento=%s colaboradores=%s, sprints=%s]", id_proj,
				nome, objetivo, status, orcamento, colaboradores, sprints);
	}


	public void alterarStatus(String status) {
		setStatus(status);
	}

	public void adicionarColab(Colaborador colaborador) {
		colaboradores.add(colaborador);
	}

	public void removerColab(Colaborador colaborador) {
		colaboradores.remove(colaboradores.indexOf(colaborador));
	}

	public void addSprint(Sprint sprint) {
		sprints.add(sprint);
	}

	public void delSprint(Sprint sprint) {
		sprints.remove(sprint);
	}

	public Integer getId_proj() {
		return id_proj;
	}

	public void setId_proj(Integer id_proj) {
		this.id_proj = id_proj;
	}

	public double getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(double orcamento) {
		this.orcamento = orcamento;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Colaborador> getColaboradores() {
		return colaboradores;
	}

	public void setColaboradores(List<Colaborador> colaboradores) {
		this.colaboradores = colaboradores;
	}

	public List<Sprint> getSprints() {
		return sprints;
	}

	public void setSprints(List<Sprint> sprints) {
		this.sprints = sprints;
	}

}
