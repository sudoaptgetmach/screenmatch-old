package org.mach;

import org.mach.modelos.Filme;
import org.mach.modelos.Serie;

public class Main {
    public static void main(String[] args) {
        Filme teste = new Filme("teste", 2009, 300, "Lorem ipsum.");
        teste.adicionarAvaliacao(10);
        teste.adicionarAvaliacao(3);
        teste.adicionarAvaliacao(0);
        teste.adicionarAvaliacao(1);
        teste.adicionarAvaliacao(4);

        System.out.println("Nome: " + teste.getNome());
        System.out.println("Ano de lançamento: " + teste.getAnoDeLancamento());
        System.out.println("Incluido no plano: " + teste.isIncluidoNoPlano());
        System.out.println();
        System.out.println("Duração do filme (em minutos): " + teste.getDuracaoEmMinutos());
        System.out.println("Ficha técnica do filme: " + teste.getFichatecnica());
        System.out.println();
        System.out.println("Média de avaliações: " + teste.getMediaAvaliacoes());
        System.out.println("Quantidade de avaliações: " + teste.getTotalAvaliacoes() + "\n");

        Serie serie_teste = new Serie("teste", 1999, 30, "Lorem ipsum.");

        System.out.println("Nome: " + serie_teste.getNome());
        System.out.println("Ano de lançamento: " + serie_teste.getAnoDeLancamento());
        System.out.println("Incluido no plano: " + serie_teste.isIncluidoNoPlano());
        System.out.println();
        System.out.println("Duração do filme (em minutos): " + serie_teste.getDuracaoEmMinutos());
        System.out.println("Ficha técnica do filme: " + serie_teste.getFichatecnica());
        System.out.println();
        System.out.println("Média de avaliações: " + serie_teste.getMediaAvaliacoes());
        System.out.println("Quantidade de avaliações: " + serie_teste.getTotalAvaliacoes());

    }
}