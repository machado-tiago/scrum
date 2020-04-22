package scrum;

import java.util.Arrays;

import br.com.webscrum.model.UseCase;
import br.com.webscrum.model.UseCaseStatus;

public class Teste {

	public static void main(String[] args) {

//		Projeto projeto = new Projeto();
//		System.out.println(projeto.getProjectStatus());
		UseCase usecase = new UseCase();
		usecase.getUseCaseStatus().ordinal();
		System.out.println(Arrays.asList((UseCaseStatus.values())));
		for (UseCaseStatus status : UseCaseStatus.values()) {

		}
		
		System.out.println();
//		ProjectStatus status = ProjectStatus.CONCLUIDO;
//		System.out.println(status.toString());
//		System.out.println(status.getDescricao());
//		System.out.println(status.name());
	}

}
