import horaire.DateHoraire;
import horaire.Horaire;
import persone.Personne;
import stage.Stage;

import java.util.*;

public class CreateControleur implements Controleur {
    private final Input input;
    private final Map<Stage, TreeSet<Personne>> stageList;

    public CreateControleur(Input input, Map<Stage, TreeSet<Personne>> stageList) {
        this.input = input;
        this.stageList = stageList;
    }
    @Override
    public TreeSet<Personne> inscription(TreeSet<Personne> personneList) {
        TreeSet<Personne> addpersonne= new TreeSet<>(Comparator.comparing(Personne::getNom));
        addpersonne.addAll(personneList);
        String request = input.read("1. Ajouter une personne ; 2. Supprimer une personne ; Q. Quitter: ");
        while (!request.equalsIgnoreCase("q")) {
            switch (request) {
                case "1" -> {
                    Personne personne = new Personne();
                    personne.setNom(input.read("Nom: ").toUpperCase());
                    request = input.read("Club: ");
                    if (Objects.equals(request, "")){
                        addpersonne.add(personne);
                    }else {
                        personne.setClub(request);
                        addpersonne.add(personne);
                    }
                }
                case "2" -> {
                    if (personneList.size() == 0) {
                        System.out.println("La liste est vide");
                    } else {
                        request = input.read("Indiquer le nom de la personne que vous souhaitez supprimez: ");
                        request = request.toUpperCase();
                        for (Personne p : personneList) {
                            if (Objects.equals(p.getNom(), request)) {
                                personneList.remove(p);
                            }
                        }
                    }
                }
            }
            for (Personne p : addpersonne) {
                System.out.println();
                System.out.printf("Nom: %s %nClub: %s %n", p.getNom(), p.getClub());
                System.out.println("-----------------");
            }
            request = input.read("1. Ajouter une personne ; 2. Supprimer une personne ; Q. Quitter: ");
        }
        return addpersonne;
    }

    @Override
    public void stage() {
        TreeSet<Personne> personneListStage = new TreeSet<>(Comparator.comparing(Personne::getNom));
        String request = input.read("1. Ajouter un stage ; 2. Supprimer ; Q. Quitter: ");
        while (!request.equalsIgnoreCase("q")) {
            switch (request) {
                case "1" -> {
                    Horaire horaire = new Horaire(new DateHoraire().dateTime(), new DateHoraire().time());
                    Stage stage = new Stage(horaire, personneListStage);
                    request = input.read("Nom du stage: ");
                    stage.setNom(request);
                    stage.setInscrit(inscription(personneListStage));
                    stageList.put(stage, stage.getInscrit());
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
            request = input.read("1. Ajouter un stage ; 2. Modifier ; 3. Supprimer ; Q. Quitter");
        }
    }

    @Override
    public void afficherListeStage() {
        if (stageList.size()==0){
            System.out.println("horraire vide");
        }else {
            for (Stage s : stageList.keySet()) {
                System.out.printf(s.toString());
            }
        }
    }

}
