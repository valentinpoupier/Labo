package stage;

import horaire.Horaire;
import persone.Personne;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Stage {
    private String nom;
    private int tarif;
    private TreeSet<Personne> inscrit;
    private Horaire horaire;

    public Stage(Horaire horaire, TreeSet<Personne> inscrit) {
        this.tarif = 0;
        this.inscrit = inscrit;
        this.horaire = horaire;
    }

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

    public TreeSet<Personne> getInscrit() {
        return inscrit;
    }

    public void setInscrit(TreeSet<Personne> inscrit) {
        this.inscrit = inscrit;
    }

    public String toStringInscrit(){
        String inscrit = this.inscrit.stream().map(p -> "nom: "+p.getNom().toUpperCase() + " club: " + p.getClub()).collect(Collectors.joining("; "));
        return inscrit;
    }

    public Horaire getHoraire() {
        return horaire;
    }

    public void setHoraire(Horaire horaire) {
        this.horaire = horaire;
    }

    @Override
    public String toString() {
        String tostring = "Stage{" +
                "nom='" + nom + '\'' +
                ", tarif=" + tarif +
                ", inscrit=" + toStringInscrit() +
                ", horaire=" + horaire.getDebut()+" à "+ horaire.getFin() +
                "} \n";
        return tostring.replace(",","\n");
    }
}
