package br.com.webscrum.controller.SprintDto;

import org.springframework.web.bind.annotation.RequestParam;

import br.com.webscrum.model.Sprint;
import lombok.Getter;


@Getter
public class SprintForm {
    public String duracao;

    public Sprint converter(Sprint sprint){
        sprint.setDuracao(Integer.valueOf(this.duracao));
        return sprint;
    }

    public SprintForm(String duracao) {
        this.duracao=duracao;
    }
    
    

}