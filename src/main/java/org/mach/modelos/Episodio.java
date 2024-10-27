package org.mach.modelos;

import org.mach.calculos.Classificavel;

public class Episodio implements Classificavel {

    private String nome;
    private int temporada;
    private int id;
    private final int numeroVisualiacoes = (int) (Math.random() * 300);

    private Serie serie;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public int getNumeroVisualiacoes() {
        return numeroVisualiacoes;
    }

    @Override
    public int getClassificacao() {
        if (numeroVisualiacoes > 100) {
            return (int) (Math.random() * 5);
        }
        return 2;
    }
}
