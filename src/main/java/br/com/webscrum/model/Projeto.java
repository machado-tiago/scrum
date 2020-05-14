package br.com.webscrum.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	@Enumerated(EnumType.STRING)
	private ProjectStatus projectStatus;
	@Autowired
	@ManyToMany
	private List<Colaborador> colaboradores;
	@OneToMany(mappedBy = "projeto")
	private List<Sprint> sprints;
	private Integer sprintAtual;
	private String cliente;
	// ####-----INCLUIR MODELO DE DOMÍNIO/DIAGRAMA DE CLASSE COMO ATRIBUTOS-----###
	
	public Projeto() {
		this.projectStatus = ProjectStatus.INITIATION;
		this.sprintAtual = 0;
	}

	public ProjectStatus getProjectStatus() {
		return projectStatus;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public void setProjectStatus(ProjectStatus projectStatus) {
		this.projectStatus = projectStatus;
	}

	public String printSprints() {
		String sprintList = "";
		for (Sprint sprint : sprints) {
			sprintList += sprint.toString() + "/";
		}
		return sprintList;
	}


	public Integer getSprintAtualIndex() {
		return this.sprintAtual;

	}

	public Sprint getSprintAtual() {
		return this.sprints.get(getSprintAtualIndex());
	}

	public void setSprintAtual(Sprint sprint) {
		this.getSprintAtual().setAtual(false);
		sprint.setAtual(true);
		this.sprintAtual = this.getSprintIndex(sprint);
	}

	private Integer getSprintIndex(Sprint sprint) {
		return sprints.indexOf(sprint);
	}

	public void setSprintAtual(Integer integer) {
		this.getSprintAtual().setAtual(false);
		sprints.get(integer).setAtual(true);
		this.sprintAtual = integer;
	}


	public boolean isEncerrado() {
		if (projectStatus.name() == "CANCELADO" | projectStatus.name() == "CONCLUIDO") {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return String.format("Projeto - Id: %s, Nome: %s, Status: %s, Colaboradores: %s, Sprints: %s", 
				id,
				nome,
				this.projectStatus.getDescricao(),
				this.printColabs(),
				this.printSprints());
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

	public ProjectStatus getUseCaseStatus() {
		return projectStatus;
	}

	public void setStatus(ProjectStatus projectStatus) {
		this.projectStatus = projectStatus;
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
