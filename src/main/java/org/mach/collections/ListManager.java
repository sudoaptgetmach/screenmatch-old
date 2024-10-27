package org.mach.collections;

import org.mach.factories.ModeloFactory;
import org.mach.modelos.Filme;
import org.mach.modelos.Serie;
import org.mach.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListManager {

    public static void main(String[] args) {
        ArrayList<String> buscaPorAtores = new ArrayList<>();
        List<Filme> listaDeFilmes = ModeloFactory.criarListaDeFilmes();
        List<Serie> listaDeSeries = ModeloFactory.criarListaDeSeries();

        buscaPorAtores.add("Aline");
        buscaPorAtores.add("João");
        buscaPorAtores.add("Carlos");
        buscaPorAtores.add("Felipe");

        System.out.println(buscaPorAtores);
        Collections.sort(buscaPorAtores);
        System.out.println(buscaPorAtores);

        System.out.println("Lista de Filmes:");
        listaDeFilmes.forEach(System.out::println);

        System.out.println("Lista de Series:");
        listaDeSeries.forEach(System.out::println);

        Collections.sort(listaDeFilmes);
        System.out.println("Lista de Filmes Ordenada:");
        listaDeFilmes.forEach(System.out::println);

        Collections.sort(listaDeSeries);
        System.out.println("Lista de Series Ordenada:");
        listaDeSeries.forEach(System.out::println);

        listaDeSeries.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Lista de Series ordenada por Ano de Lançamento (Primeiro ao Último):");
        listaDeSeries.forEach(System.out::println);

        listaDeSeries.sort(Comparator.comparing(Titulo::getAnoDeLancamento).reversed());
        System.out.println("Lista de Series ordenada por Ano de Lançamento (Último ao Primeiro):");
        listaDeSeries.forEach(System.out::println);
    }
}