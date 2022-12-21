package stage;

import persone.Personne;

import java.util.List;

public class Stage {
    public String nom;
    public int tarif;
    public List<Personne> inscrit;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

    public List<Personne> getInscrit() {
        return inscrit;
    }

    public void setInscrit(List<Personne> inscrit) {
        this.inscrit = inscrit;
    }
}
