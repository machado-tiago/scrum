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
	private Integer sprint;

	
	public Sprint(Integer id_sprint, Integer sprint) {
		super();
		this.id_sprint = id_sprint;
		this.sprint = sprint;
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
