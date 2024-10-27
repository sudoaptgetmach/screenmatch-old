package org.mach.factories;

import org.mach.modelos.Filme;
import org.mach.modelos.Serie;
import org.mach.modelos.Titulo;

import java.util.ArrayList;
import java.util.List;

public class ModeloFactory {

    public static Titulo criarTitulo(String tipo, String nome, int anoDeLancamento, int duracao, String fichaTecnica) {
        switch (tipo.toLowerCase()) {
            case "filme":
                return new Filme(nome, anoDeLancamento, duracao, fichaTecnica);
            case "serie":
                return new Serie(nome, anoDeLancamento, duracao, fichaTecnica);
            default:
                throw new IllegalArgumentException("Tipo de título desconhecido: " + tipo);
        }
    }

    public static List<Filme> criarListaDeFilmes() {
        List<Filme> filmes = new ArrayList<>();
        filmes.add(new Filme("Filme 1", 2000, 120, "Diretor: Fulano"));
        filmes.add(new Filme("Filme 2", 2005, 130, "Diretor: Fulano"));
        filmes.add(new Filme("Filme 3", 2010, 140, "Diretor: Fulano"));
        return filmes;
    }

    public static List<Serie> criarListaDeSeries() {
        List<Serie> series = new ArrayList<>();
        series.add(new Serie("Serie 1", 2015, 45, "Diretor: Fulano"));
        series.add(new Serie("Serie 2", 2018, 50, "Diretor: Fulano"));
        series.add(new Serie("Serie 3", 2020, 55, "Diretor: Fulano"));
        return series;
    }
}