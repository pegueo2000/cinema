package org.edu.epo.metier;

import java.io.Serializable;
import java.util.Date;

public class Creneau implements Serializable {
    private int numCren;
    private Date dateCren;
    private Date heureDebut;

    public Creneau() {
    }

    public Creneau(int numCren, Date dateCren, Date heureDebut) {
        this.numCren = numCren;
        this.dateCren = dateCren;
        this.heureDebut = heureDebut;
    }

    public int getNumCren() {
        return numCren;
    }

    public Creneau(Date dateCren, Date heureDebut) {
        this.dateCren = dateCren;
        this.heureDebut = heureDebut;
    }

    public void setNumCren(int numCren) {
        this.numCren = numCren;
    }

    public Date getDateCren() {
        return dateCren;
    }

    public void setDateCren(Date dateCren) {
        this.dateCren = dateCren;
    }

    public Date getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(Date heureDebut) {
        this.heureDebut = heureDebut;
    }
}
