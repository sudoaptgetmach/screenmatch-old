package org.mach.modelos;

import org.mach.calculos.Classificavel;

import java.util.ArrayList;
import java.util.List;

public class Titulo implements Classificavel {

    private final String nome;
    private final int anoDeLancamento;
    private final int duracaoEmMinutos;
    private final String fichatecnica;
    private final boolean incluidoNoPlano;

    private List<Integer> avaliacoes = new ArrayList<>();
    private int totalAvaliacoes = 0;
    private int somaDasAvaliacoes = 0;

    public Titulo(String nome, int anoDeLancamento, int duracaoEmMinutos, String fichatecnica) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
        this.duracaoEmMinutos = duracaoEmMinutos;
        this.fichatecnica = fichatecnica;
        this.incluidoNoPlano = false;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public String getFichatecnica() {
        return fichatecnica;
    }

    public String isIncluidoNoPlano() {
        return incluidoNoPlano ? "Sim." : "Não.";
    }

    public void adicionarAvaliacao(int novaAvaliacao) {
        this.avaliacoes.add(novaAvaliacao);
        this.totalAvaliacoes++;
        this.somaDasAvaliacoes += novaAvaliacao;
    }

    public double getMediaAvaliacoes() {
        if (totalAvaliacoes == 0) {
            return 0;
        }
        return (double) somaDasAvaliacoes / totalAvaliacoes;
    }

    public int getTotalAvaliacoes() {
        return totalAvaliacoes;
    }

    @Override
    public int getClassificacao() {
        return 0;
    }

    public String toString(){

        return this instanceof Filme ? "Filme: " + this.getNome() + " ("+this.getAnoDeLancamento()+")" : "Série: " + this.getNome() + " ("+this.getAnoDeLancamento()+")";

    }
}