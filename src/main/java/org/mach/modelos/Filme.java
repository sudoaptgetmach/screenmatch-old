package org.mach.modelos;

public class Filme extends Titulo {

    private String diretor;

    public Filme(String nome, int anoDeLancamento, int duracaoEmMinutos, String fichatecnica) {
        super(nome, anoDeLancamento, duracaoEmMinutos, fichatecnica);
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao() {
        return (int) (this.getMediaAvaliacoes() / 2);
    }
}