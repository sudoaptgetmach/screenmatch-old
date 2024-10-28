package org.mach.modelos;

import com.google.gson.annotations.SerializedName;
import org.mach.calculos.Classificavel;

import java.util.ArrayList;
import java.util.List;

public class Titulo implements Classificavel, Comparable<Titulo> {

    @SerializedName("Title")
    private final String nome;
    @SerializedName("Year")
    private final int anoDeLancamento;
    private final int duracaoEmMinutos;
    @SerializedName("Plot")
    private final String fichatecnica;
    private boolean incluidoNoPlano;

    private final List<Integer> avaliacoes = new ArrayList<>();
    private int totalAvaliacoes = 0;
    private int somaDasAvaliacoes = 0;

    public Titulo(String nome, int anoDeLancamento, int duracaoEmMinutos, String fichatecnica) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
        this.duracaoEmMinutos = duracaoEmMinutos;
        this.fichatecnica = fichatecnica;
        this.incluidoNoPlano = false;
    }

    public Titulo(TituloOmdb titulo) {
        this.nome = titulo.title();
        this.anoDeLancamento = Integer.parseInt(titulo.year());
        this.duracaoEmMinutos = Integer.parseInt(titulo.runtime().substring(0, 3));
        this.fichatecnica = titulo.plot();
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

    @Override
    public String toString() {
        if (this instanceof Filme) {
            return "Filme: " + this.getNome() + " (" + this.getAnoDeLancamento() + ")" + "\nDuração: " + this.getDuracaoEmMinutos() + "\nSinopse: " + this.getFichatecnica();
        } else if (this instanceof Serie) {
            return "Serie: " + this.getNome() + " (" + this.getAnoDeLancamento() + ")" + "\nDuração: " + this.getDuracaoEmMinutos() + "\nSinopse: " + this.getFichatecnica();
        } else {
            return "Titulo: " + this.getNome() + " (" + this.getAnoDeLancamento() + ")" + "\nDuração: " + this.getDuracaoEmMinutos() + "\nSinopse: " + this.getFichatecnica();
        }
    }

    @Override
    public int compareTo(Titulo o) {
        return this.getNome().compareTo(o.getNome());
    }
}