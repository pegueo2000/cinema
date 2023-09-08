package org.edu.epo.metier;

import java.io.Serializable;

public class Salle implements Serializable {
    private int numSalle;
    private String nomSalle;
    private int capacite;

    public Salle(int numSalle, String nomSalle, int capacite) {
        this.numSalle = numSalle;
        this.nomSalle = nomSalle;
        this.capacite = capacite;
    }

    public Salle() {
    }

    public Salle(String nomSalle, int capacite) {
        this.nomSalle = nomSalle;
        this.capacite = capacite;
    }

    public int getNumSalle() {
        return numSalle;
    }

    public void setNumSalle(int numSalle) {
        this.numSalle = numSalle;
    }

    public String getNomSalle() {
        return nomSalle;
    }

    public void setNomSalle(String nomSalle) {
        this.nomSalle = nomSalle;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
}
