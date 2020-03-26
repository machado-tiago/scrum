package br.com.webscrum.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Projeto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private double orcamento;

	@javax.validation.constraints.NotEmpty
	private String nome;
	private String objetivo;
	private String status;
	@Autowired
	@ManyToMany
	private List<Colaborador> colaboradores;
	
	@Autowired
	@OneToMany
	private List<Sprint> sprints;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Projeto() {
	}

	public Integer sprintAtual() {
		Integer numero = 0;
		for (Sprint sprint : sprints) {
			if (sprint.isAtual()) {
				numero = sprint.getN_sprint();
			}
		}
		return numero;
	}

	public void iniciarProjeto() {
		this.setStatus("planejamento");
	}

	public boolean encerrarProjeto(String status) {
		if (status == "cancelado" | status == "encerrado") {
			this.setStatus(status);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return String.format("Projeto - Id: %s, Nome: %s, Status: %s, Colaboradores: %s", id, nome, status,
				printColabs());
	}

	public String printColabs() {
		String colabList = "";
		for (Colaborador colaborador : colaboradores) {
			colabList += colaborador.getNome() + "/";
		}
		return colabList;
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

	public Integer getid() {
		return id;
	}

	public void setid(Integer id) {
		this.id = id;
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
