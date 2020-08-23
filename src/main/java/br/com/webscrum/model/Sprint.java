package br.com.webscrum.model;

import br.com.webscrum.service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.*;

import javax.persistence.*;

@Entity
public class Sprint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private int duracao;
	private boolean atual;
	private LocalDate inicio;
	private LocalDate fim;

	@ManyToOne
	@JoinColumn(name = "projeto_id")
	private Projeto projeto;
	@OneToMany(mappedBy = "sprint")
	private List<UseCase> usecases;
	@Enumerated(EnumType.STRING)
	private SprintStatus sprintStatus;

	private static int SPRINT_DURATION = 21;
	
	public static int getSPRINT_DURATION() {
		return SPRINT_DURATION;
	}

	public static void setSPRINT_DURATION(int duration) {
		SPRINT_DURATION = duration;
	}


	public Sprint() {
		this.setDuracao(getSPRINT_DURATION());
		this.setSprintStatus(SprintStatus.PLANEJAMENTO);
	}

	public Sprint(SprintService sprintService) {
		this.setDuracao(getSPRINT_DURATION());
		this.setSprintStatus(SprintStatus.PLANEJAMENTO);
		this.setInicio(sprintService.getPrevious(this).getFim().plusDays(1));
	}

	public LocalDate getInicio() {
		return inicio;
	}

	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}

	public LocalDate getFim() {
		return fim;
	}

	public void setFim(LocalDate fim) {
		this.fim = fim;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
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

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public SprintStatus getSprintStatus() {
		return sprintStatus;
	}

	public void setSprintStatus(SprintStatus sprintStatus) {
		this.sprintStatus = sprintStatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void fimCalc(){
		this.setFim(this.getInicio().plusDays(this.getDuracao()-1));
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
