package org.edu.epo.metier;
public class Projeter {
    private int numCreneau;
    private int numFilm;
    private int numSalle;
    private double tarif;

    public Projeter() {
    }

    public Projeter(int numCreneau, int numFilm, int numSalle, double tarif) {
        this.numCreneau = numCreneau;
        this.numFilm = numFilm;
        this.numSalle = numSalle;
        this.tarif = tarif;
    }

    public int getNumCreneau() {
        return numCreneau;
    }

    public void setNumCreneau(int numCreneau) {
        this.numCreneau = numCreneau;
    }

    public int getNumFilm() {
        return numFilm;
    }

    public void setNumFilm(int numFilm) {
        this.numFilm = numFilm;
    }

    public int getNumSalle() {
        return numSalle;
    }

    public void setNumSalle(int numSalle) {
        this.numSalle = numSalle;
    }

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }
}
