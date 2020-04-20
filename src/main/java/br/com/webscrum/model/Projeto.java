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
	@OneToMany(mappedBy = "projeto")
	private List<Sprint> sprints;
	private Integer sprintAtual;
	
	public Projeto() {
		this.setStatus("análise e planejamento");
		this.sprintAtual = 0;
	}

	public void addSprint(Sprint sprint) {
		sprints.add(sprint);
	}

	public String printSprints() {
		String sprintList = "";
		for (Sprint sprint : sprints) {
			sprintList += sprint.toString() + "/";
		}
		return sprintList;
	}

	public Integer getIndexSprintAtual() {
		return this.sprintAtual;
	}

	public Integer getSprintAtual() {
		return this.sprintAtual;

	}

	public Sprint getSprint(Integer index) {
		return this.sprints.get(index);

	}

	public Sprint sprintAtual() {
		return this.sprints.get(getIndexSprintAtual());
	}

	private Integer getSprintIndex(Sprint sprint) {
		return sprints.indexOf(sprint);
	}

	public void setSprintAtual(Sprint sprint) {
		this.sprintAtual().setAtual(false);
		sprint.setAtual(true);
		this.sprintAtual = this.getSprintIndex(sprint);
	}

	public void setSprintAtual(Integer integer) {
		this.sprintAtual().setAtual(false);
		sprints.get(integer).setAtual(true);
		this.sprintAtual = integer;
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
		return String.format("Projeto - Id: %s, Nome: %s, Status: %s, Colaboradores: %s, Sprints: %s", id, nome, status,
				this.printColabs(), this.printSprints());
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

	public void delSprint(Sprint sprint) {
		sprints.remove(sprint);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
		Projeto other = (Projeto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
