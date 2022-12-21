import persone.Personne;

import java.util.List;

public class CreateControleur implements Controleur {
    private final Input input;
    private List<Personne> personneList;

    public CreateControleur(Input input, List<Personne> personneList) {
        this.input = input;
        this.personneList = personneList;
    }
    @Override
    public void inscription() {
        List<Personne> personneList = this.personneList;
        String request = input.read("1. Ajouter ; 2. Modifier ; 3. Supprimer ; Q. Quitter: ");

        while (!request.equalsIgnoreCase("q")){
            switch (request){
                case "1" -> {
                    Personne personne = new Personne();
                    personne.nom = input.read("Nom: ");
                    personne.club = input.read("Club: ");
                    personneList.add(personne);
                    for (Personne p : personneList) {
                        System.out.println("-----------------");
                        System.out.printf("Nom: %s %nClub: %s %n",p.getNom(),p.getClub());
                        System.out.println("-----------------");
                    }
                    this.personneList = personneList;
                }
                case "2" -> {

                }
                case "3" -> {

                }
            }
            request = input.read("1. Ajouter ; 2. Modifier ; 3. Supprimer ; Q. Quitter");
        }
    }

    @Override
    public void stage() {

    }
}
