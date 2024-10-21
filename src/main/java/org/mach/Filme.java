package org.mach;

import java.util.ArrayList;
import java.util.List;

public class Filme {

    private final String nome;
    private final int anoDeLancamento;
    private final boolean incluidoNoPlano;
    private final List<Double> notas;

    public Filme(String nome, int anoDeLancamento, boolean incluidoNoPlano, List<Double> notas) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
        this.incluidoNoPlano = incluidoNoPlano;
        this.notas = new ArrayList<>(notas);
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public double getNota() {
        if (notas.isEmpty()) {
            return 0;
        }
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.size();
    }

    public double calcularRating() {
        return getNota();
    }

    public int getQuantidadeAvaliacoes() {
        return notas.size();
    }
}