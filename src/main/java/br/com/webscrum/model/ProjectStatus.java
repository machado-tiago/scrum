package br.com.webscrum.model;

public enum ProjectStatus {
	// adaptação do PMBOK e SDLC (Software Development Life Cycle: análise de requisitos, projeto, implementação, teste e manutenção)
	INITIATION("Iniciação"), // determinar o real problema que será resolvido, identificar stakeholder,
							// definir objetivos do projeto, determinasr o escopo, os recursos e principais
							// restrições
	REQUIREMENTS("Análise de Requisitos"), // USER HISTORIES
	DESIGN("Arquiterura e Projeto"),
	EXECUCAO("Execução"), 
	CONCLUIDO("Concluído"),
	CANCELADO("Cancelado");
	
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}

	private ProjectStatus(String descricao) {
		this.descricao = descricao;
	}


}
