package org.mach;

import org.mach.calculos.CalculoTempo;
import org.mach.calculos.FiltroRecomendacao;
import org.mach.modelos.Episodio;
import org.mach.modelos.Filme;
import org.mach.modelos.Serie;
import org.mach.modelos.Titulo;

import java.util.ArrayList;

public class AppManager {
    private final Filme filmeTeste;
    private final Filme filme;
    private final Filme filme2;
    private final Serie serie;
    private final Serie serie2;
    private final FiltroRecomendacao filtro;
    private final Episodio episodio;
    private final CalculoTempo calculadora;

    ArrayList<Titulo> listaDeTitulos = new ArrayList<>();

    public AppManager() {
        this.filmeTeste = new Filme("teste", 2009, 300, "Lorem ipsum.");
        this.filme = new Filme("Filme 1", 2000, 300, "Lorem ipsum.");
        this.filme2 = new Filme("Filme 2", 2022, 300, "Lorem ipsum.");
        this.serie = new Serie("Serie 1", 1998, 30, "Lorem ipsum.");
        this.serie2 = new Serie("Serie 2", 2020, 30, "Lorem ipsum.");
        this.filtro = new FiltroRecomendacao();
        this.episodio = new Episodio();
        this.calculadora = new CalculoTempo();
    }

    public void run() {
        calculadora.calculoTempo(filme);
        calculadora.calculoTempo(serie);

        System.out.println("Nome: " + serie.getNome());
        System.out.println("Ano de lançamento: " + serie.getAnoDeLancamento());
        System.out.println("Incluido no plano: " + serie.isIncluidoNoPlano());
        System.out.println();
        System.out.println("Duração do filme (em minutos): " + serie.getDuracaoEmMinutos());
        System.out.println("Ficha técnica do filme: " + serie.getFichatecnica());
        System.out.println();
        System.out.println("Média de avaliações: " + serie.getMediaAvaliacoes());
        System.out.println("Quantidade de avaliações: " + serie.getTotalAvaliacoes());
        System.out.println("Quantidade de visualiações do primeiro episódio: " + episodio.getNumeroVisualiacoes());
        System.out.println("Classificacao: " + episodio.getClassificacao());

        System.out.println("Quantidade total de minutos: " + calculadora.getTempoTotal());
        filtro.filtra(episodio);
    }

    public void runTeste() {

        filmeTeste.adicionarAvaliacao((int) (Math.random() * 10));
        filmeTeste.adicionarAvaliacao((int) (Math.random() * 10));
        filme.adicionarAvaliacao((int) (Math.random() * 10));
        filme.adicionarAvaliacao((int) (Math.random() * 10));
        filme2.adicionarAvaliacao((int) (Math.random() * 10));
        filme2.adicionarAvaliacao((int) (Math.random() * 10));
        serie.adicionarAvaliacao((int) (Math.random() * 10));
        serie.adicionarAvaliacao((int) (Math.random() * 10));
        serie2.adicionarAvaliacao((int) (Math.random() * 10));
        serie2.adicionarAvaliacao((int) (Math.random() * 10));

        System.out.println("Nome: " + filmeTeste.getNome());
        System.out.println("Ano de lançamento: " + filmeTeste.getAnoDeLancamento());
        System.out.println("Incluido no plano: " + filmeTeste.isIncluidoNoPlano());
        System.out.println();
        System.out.println("Duração do filme (em minutos): " + filmeTeste.getDuracaoEmMinutos());
        System.out.println("Ficha técnica do filme: " + filmeTeste.getFichatecnica());

        listaDeTitulos.add(filmeTeste);
        listaDeTitulos.add(filme);
        listaDeTitulos.add(filme2);
        listaDeTitulos.add(serie);
        listaDeTitulos.add(serie2);
        System.out.println("Quantidade de títulos no catálogo: " + listaDeTitulos.size());

        listaDeTitulos.forEach(titulo -> {
            System.out.println(titulo);

            if (titulo instanceof Filme filmeInstance) {
                System.out.println("Classificação: " + filmeInstance.getClassificacao());
            } else if (titulo instanceof Serie serieInstance) {
                System.out.println("Classificação: " + serieInstance.getClassificacao());
            }
        });
    }
}