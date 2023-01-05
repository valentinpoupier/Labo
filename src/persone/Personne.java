package persone;


import java.io.Serializable;

public class Personne implements Serializable {
    public String nom;
    public String club;

    public Personne() {
        club = "Club par défaut";
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }
}
