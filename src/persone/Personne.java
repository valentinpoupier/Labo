package persone;

public class Personne {
    public String nom;
    public String club;

    public Personne() {
        nom = "";
        club = "";
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
