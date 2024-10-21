package org.mach;

import java.util.ArrayList;
import java.util.List;

public class Filme {

    private final String nome;
    private final int anoDeLancamento;
    private final int duracaoEmMinutos;
    private final boolean incluidoNoPlano;
    private final String fichatecnica;

    private final List<Integer> avaliacoes = new ArrayList<>();
    private int totalAvaliacoes = 0;
    private int somaDasAvaliacoes = 0;

    public Filme(String nome, int anoDeLancamento, int duracaoEmMinutos, boolean incluidoNoPlano, String fichatecnica) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
        this.duracaoEmMinutos = duracaoEmMinutos;
        this.incluidoNoPlano = incluidoNoPlano;
        this.fichatecnica = fichatecnica;
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

    public String isIncluidoNoPlano() {
        return incluidoNoPlano ? "Sim." : "Não.";
    }

    public String getFichatecnica() {
        return fichatecnica;
    }

    public void adicionarAvaliacao(int novaAvaliacao) {
        this.avaliacoes.add(novaAvaliacao);
        this.totalAvaliacoes++;
        this.somaDasAvaliacoes += novaAvaliacao;
    }

    private double calcularMediaAvaliacoes() {
        if (totalAvaliacoes == 0) {
            return 0;
        }
        return (double) somaDasAvaliacoes / totalAvaliacoes;
    }

    public double getMediaAvaliacoes() {
        return calcularMediaAvaliacoes();
    }

    public int getTotalAvaliacoes() {
        return totalAvaliacoes;
    }

}