package org.edu.epo.metier;

import java.util.Date;

public class Film {
    private int numFilm;
    private String titreFilm;
    private Date dureeFilm;

    public Film() {
    }

    public Film(String titreFilm, Date dureeFilm) {
        this.titreFilm = titreFilm;
        this.dureeFilm = dureeFilm;
    }

    public Film(int numFilm, String titreFilm, Date dureeFilm) {
        this.numFilm = numFilm;
        this.titreFilm = titreFilm;
        this.dureeFilm = dureeFilm;
    }

    public int getNumFilm() {
        return numFilm;
    }

    public void setNumFilm(int numFilm) {
        this.numFilm = numFilm;
    }

    public String getTitreFilm() {
        return titreFilm;
    }

    public void setTitreFilm(String titreFilm) {
        this.titreFilm = titreFilm;
    }

    public Date getDureeFilm() {
        return dureeFilm;
    }

    public void setDureeFilm(Date dureeFilm) {
        this.dureeFilm = dureeFilm;
    }
}
