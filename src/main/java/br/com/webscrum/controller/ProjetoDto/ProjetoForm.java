package br.com.webscrum.controller.ProjetoDto;

import java.time.LocalDate;

import br.com.webscrum.model.Projeto;

public class ProjetoForm {
    private String nome;
    private String objetivo;
    private String inicioSprints;

    public Projeto converter(Projeto projeto){
        projeto.setNome(this.nome);
        projeto.setObjetivo(this.objetivo);
        projeto.setInicioSprints(LocalDate.parse(this.inicioSprints));
        return projeto;
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

    public String getInicioSprints() {
        return inicioSprints;
    }

    public void setInicioSprints(String inicioSprints) {
        this.inicioSprints = inicioSprints;
    }

}