package org.mach.calculos;

import org.mach.modelos.Titulo;

public class FiltroRecomendacao {

    private String recomendacao;

    public void filtra(Classificavel classificavel) {
        if (classificavel.getClassificacao() >= 4) {
            System.out.println("Está entre os preferidos do momento.");
        } else if (classificavel.getClassificacao() >= 2) {
            System.out.println("Muito bem avaliado no momento.");
        } else {
            System.out.println("Adicione esse filme a sua lista pra assistir depois.");
        }
    }
}
