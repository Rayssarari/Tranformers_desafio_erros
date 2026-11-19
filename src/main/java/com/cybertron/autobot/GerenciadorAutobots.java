package com.cybertron.autobot;

import java.util.ArrayList;
import java.util.List;

/**
 * Gerencia os Autobots da base.
 */
public class GerenciadorAutobots {
    private List<Autobot> autobots = new ArrayList<>();

    //definindo o que cada número é.
    private static final double LIMITE_ENERGON_ELITE = 500;
    private static final double LIMITE_ENERGON_PADRAO = 200;
    private static final double ENERGON_RECUPERADO_REPARO = 100;

    public void adicionar(Autobot autobot) {
        autobots.add(autobot);
    }
//usado for each para percorrer cada elemento da lista
    public double calcularEnergonTotal() {
        double total = 0;
        for (Autobot autobot : autobots) {
            total += autobot.getEnergon();
        }
        return total;
    }

    //Mudado == para um equals(), para comparar o conteúdo ou o valor lógico
    public Autobot buscar(String nome) {
        for (Autobot autobot : autobots) {
            if (autobot.getNome().equals(nome)) {
                return autobot;
            }
        }
        return null;
    }
//mudado o try/catch para um aviso com a exceção.
    public void reparar(Autobot autobot) {
            if (autobot.getEnergon() < 0) {
                throw new reparoException("Energon negativo");
            }
            autobot.adicionarEnergon(ENERGON_RECUPERADO_REPARO);
    }

//Mudado os números para nomes específicos
    public String classificar(Autobot autobot) {
        if (autobot.getEnergon() > LIMITE_ENERGON_ELITE) {
            return "ELITE";
        } else if (autobot.getEnergon() > LIMITE_ENERGON_PADRAO) {
            return "PADRAO";
        } else {
            return "RESERVA";
        }
    }
}

