package br.com.webscrum.model;

public enum UseCaseStatus {
	// adaptação do PMBOK e SDLC (Software Development Life Cycle: análise de requisitos, projeto, implementação, teste e manutenção)
	
	//OMITIDOS OS STATUS DA SPRINT	
		//SPRINTPLANNING("Planejamento"), //SE DEFINE O QUE SERÁ EXECUTADO NA SPRINT E DETALHAMENTO DE ATIVIDADES - ANÁLOGO À INICIAÇÃO
		//SPRINTEXECUTION("Execução"), - Não precisa incluir, pois podemos reutilizar a outra EXECUCAO

	USERSTORY("História do Usuário"),
	ANALISE("Análise de Requisitos"), // requisitos serão mais detalhados nesse momento - DIAGRAMA DE SEQUENCIA (utiliza os elementos conceito do modelo de Domínio)
	DESIGN("Projeto"), // DIAGRAMA DE CLASSE
	DEVELOPMENT("Implementação"),
	TESTING("Teste"),//podemos especificar posteriormente os testes
	DEPLOYMENT("Implantação"),
	CONCLUIDO("Concluído"),
	CANCELADO("Cancelado");
	
	private String descricao;

	private UseCaseStatus(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}


}
