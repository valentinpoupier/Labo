import horaire.DateHoraire;
import horaire.Horaire;
import persone.Personne;
import stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CreateControleur implements Controleur {
    private final Input input;
    private List<Personne> personneList;
    private Map<Stage, List<Personne>> stageList;

    public CreateControleur(Input input, List<Personne> personneList, Map<Stage, List<Personne>> stageList) {
        this.input = input;
        this.stageList = stageList;
    }
    @Override
    public List<Personne> inscription(List<Personne> personneList) {
        String request = input.read("1. Ajouter ; 2. Supprimer ; Q. Quitter: ");
        while (!request.equalsIgnoreCase("q")){
            switch (request){
                case "1" -> {
                    Personne personne = new Personne();
                    personne.nom = input.read("Nom: ");
                    personne.club = input.read("Club: ");
                    personneList.add(personne);
                }
                case "2" -> {
                    request = input.read("Indiquer le nom de la personne que vous souhaitez supprimez: ");
                    for (Personne p : personneList) {
                        if (Objects.equals(p.getNom(), request)) {
                            personneList.remove(p);
                        }
                    }
                }
            }
            for (Personne p : personneList) {
                System.out.println("-----------------");
                System.out.printf("Nom: %s %nClub: %s %n", p.getNom(), p.getClub());
                System.out.println("-----------------");
            }
            request = input.read("1. Ajouter ; 2. Supprimer ; Q. Quitter");
        }
        return personneList;
    }

    @Override
    public void stage() {
        List<Personne> personneListStage = new ArrayList<>();
        String request = input.read("1. Ajouter un stage ; 2. Supprimer ; Q. Quitter: ");
        while (!request.equalsIgnoreCase("q")){
            switch (request){
                case "1" -> {
                    Horaire horaire = new Horaire(new DateHoraire().dateTime(),new DateHoraire().time());
                    Stage stage = new Stage(horaire,personneListStage);
                    request = input.read("Nom du stage: ");
                    stage.setNom(request);
                    stage.setInscrit(inscription(personneListStage));
                    stageList.put(stage,stage.getInscrit());
                }
                case "2" -> {
                    request = input.read("Indiquer le nom du stage que vous souhaitez supprimez: ");
                    for (Stage s : stageList.keySet()) {
                        if (Objects.equals(s.getNom(), request)) {
                            stageList.remove(s);
                        }
                    }
                }
            }
            request = input.read("1. Ajouter ; 2. Modifier ; 3. Supprimer ; Q. Quitter");
        }
    }

    @Override
    public void afficherListeStage() {
        for (Stage s : stageList.keySet()) {
            System.out.printf(s.toString());
        }
    }

}
