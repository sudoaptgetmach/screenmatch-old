package org.mach;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Filme teste = new Filme("teste", 2009, false, Arrays.asList(10.0, 3.0, 0.0, 1.0, 4.0));

        System.out.println("Nome: " + teste.getNome());
        System.out.println("Ano de lançamento: " + teste.getAnoDeLancamento());
        System.out.println("Incluido no plano: " + teste.isIncluidoNoPlano());
        System.out.println("Sua nota: " + teste.getNota());
        System.out.println("Rating: " + teste.calcularRating());
        System.out.println("Quantidade de avaliações: " + teste.getQuantidadeAvaliacoes());
    }
}