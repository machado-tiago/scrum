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
	private int sprintAtual;
	
	public Projeto() {
		this.setStatus("Planejamento do Projeto e de Arquitetura");
	}

	public int getIndexSprintAtual() {
		return this.sprintAtual;
	}

	public Sprint getSprintAtual() {
		return this.sprints.get(getIndexSprintAtual());
	}

	private Integer getSprintIndex(Sprint sprint) {
		return sprints.indexOf(sprint);
	}

	public void setSprintAtual(Sprint sprint) {
		this.getSprintAtual().setAtual(false);
		sprint.setAtual(true);
		this.sprintAtual = this.getSprintIndex(sprint);
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}




	public boolean isEncerrado() {
		if (status == "cancelado" | status == "encerrado") {
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

	public void adicionarColab(Colaborador colaborador) {
		colaboradores.add(colaborador);
	}

	public void removerColab(Colaborador colaborador) {
		colaboradores.remove(colaboradores.indexOf(colaborador));
	}

	@Autowired
	public void addSprintZero(Sprint sprint) {
		sprint.setDescricao("Sem Sprint");
		sprints.add(sprint);
	}

	@Autowired
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
