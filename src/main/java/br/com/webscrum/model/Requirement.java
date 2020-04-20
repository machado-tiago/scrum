package br.com.webscrum.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Requirement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String requisito;
	private boolean tipoFuncional;
	private String solicitante;
	private String aceite;
	@ManyToOne
	@JoinColumn(name = "usecase_id")
	private UseCase usecase;

	public Integer getId() {
		return id;
	}

	public UseCase getUsecase() {
		return usecase;
	}

	public void setUsecase(UseCase usecase) {
		this.usecase = usecase;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRequisito() {
		return requisito;
	}

	public void setRequisito(String requisito) {
		this.requisito = requisito;
	}

	public boolean isTipoFuncional() {
		return tipoFuncional;
	}

	public void setTipoFuncional(boolean tipoFuncional) {
		this.tipoFuncional = tipoFuncional;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getAceite() {
		return aceite;
	}

	public void setAceite(String aceite) {
		this.aceite = aceite;
	}

	public Requirement() {
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
		Requirement other = (Requirement) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
