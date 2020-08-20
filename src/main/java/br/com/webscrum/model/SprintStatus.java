package br.com.webscrum.model;

public enum SprintStatus {
	PLANEJAMENTO("Planejamento"),
	EXECUCAO("Execução"),
	CONCLUIDO("Concluído"),
	CANCELADO("Cancelado");

	private String descricao;

	private SprintStatus(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}


}
