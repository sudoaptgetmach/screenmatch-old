package org.mach.calculos;

import org.mach.modelos.Titulo;

public class CalculoTempo {

    private int tempoTotal;

    public String getTempoTotal() {
        return tempoTotal + " minutos.";
    }

    public void calculoTempo(Titulo titulo) {
        tempoTotal += titulo.getDuracaoEmMinutos();
    }
}
