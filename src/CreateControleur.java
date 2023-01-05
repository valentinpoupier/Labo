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
    public void stage() {
        TreeSet<Personne> personneListStage = new TreeSet<>(Comparator.comparing(Personne::getNom));
        String request;
        do {
            request = input.read("1. Ajouter un stage ; 2. Supprimer ; 3. modifier un stage ; Q. Quitter: ");
            switch (request) {
                case "1" -> addStage(personneListStage);
                case "2" -> deleteStage();
                case "3" -> editStage(personneListStage);
            }
        } while (!request.equalsIgnoreCase("q"));
    }

    private void editStage(TreeSet<Personne> personneListStage) {
        if (stageList.size() == 0) {
            System.out.println("Liste stage vide");
        } else {
            String request = input.read("Indiquer le nom du stage à modifier: ");
            for (Stage s : stageList.keySet()) {
                if (s.getNom().equalsIgnoreCase(request)) {
                    System.out.println(s);
                    request = input.read("1. modifier le nom du stage ; 2. modifier liste de personne: ");
                    switch (request) {
                        case "1" -> {
                            request = input.read("Entrer nouveau nom : ");
                            s.setNom(request);
                        }
                        case "2" -> s.setInscrit(inscription(personneListStage));
                    }
                } else {
                    System.out.println("Stage non trouver");
                }
            }
        }
    }

    private void deleteStage() {
        if (stageList.size() == 0) {
            System.out.println("Liste stage vide");
        } else {
            String request = input.read("Indiquer le nom du stage que vous souhaitez supprimez: ");
            for (Stage s : stageList.keySet()) {
                if (s.getNom().equalsIgnoreCase(request)) {
                    stageList.remove(s);
                }
            }
        }
    }

    private void addStage(TreeSet<Personne> personneListStage) {
        Horaire horaire = new Horaire(new DateHoraire().dateTime(), new DateHoraire().time());
        Stage stage = new Stage(horaire, personneListStage);
        String request = input.read("Nom du stage: ");
        stage.setNom(request);
        stage.setInscrit(inscription(personneListStage));
        stageList.put(stage, stage.getInscrit());
    }

    @Override
    public void afficherListeStage() {
        if (stageList.size() == 0) {
            System.out.println("horraire vide");
        } else {
            for (Stage s : stageList.keySet()) {
                System.out.printf(s.toString());
            }
        }
    }

    @Override
    public TreeSet<Personne> inscription(TreeSet<Personne> personneList) {
        TreeSet<Personne> copypersonne = new TreeSet<>(Comparator.comparing(Personne::getNom));
        copypersonne.addAll(personneList);
        String request;
        do {
            request = input.read("1. Ajouter une personne ; 2. Supprimer une personne ; 3. modifier une personne ; Q. Quitter: ");
            switch (request) {
                case "1" -> addPersonne(copypersonne);
                case "2" -> supprimerPersonne(copypersonne);
                case "3" -> modifierPersonne(copypersonne);
            }
            for (Personne p : copypersonne) {
                System.out.println();
                System.out.printf("Nom: %s %nClub: %s %n", p.getNom(), p.getClub());
                System.out.println("-----------------");
            }

        } while (!request.equalsIgnoreCase("q"));
        return copypersonne;
    }

    private void addPersonne(TreeSet<Personne> addpersonne) {
        Personne personne = new Personne();
        personne.setNom(input.read("Nom: ").toUpperCase());
        String request = input.read("Club: ");
        if (Objects.equals(request, "")) {
            addpersonne.add(personne);
        } else {
            personne.setClub(request);
            addpersonne.add(personne);
        }
    }

    private void supprimerPersonne(TreeSet<Personne> personneList) {
        if (personneList.size() == 0) {
            System.out.println("La liste est vide");
        } else {
            String request = input.read("Indiquer le nom de la personne que vous souhaitez supprimez: ");
            request = request.toUpperCase();
            for (Personne p : personneList) {
                if (p.getNom().equalsIgnoreCase(request)) {
                    personneList.remove(p);
                }
            }
        }
    }

    private void modifierPersonne(TreeSet<Personne> personneList) {
        if (personneList.size() == 0) {
            System.out.println("Liste vide");
        } else {
            String request = input.read("Entrer le nom de la personne à modifier: ");
            for (Personne p : personneList) {
                if (p.getNom().equalsIgnoreCase(request)) {
                    System.out.println(p);
                    request = input.read("Entrer le nouveau nom: ");
                    p.setNom(request);
                    request = input.read("Modifier le club ? : o/n");
                    if (request.equalsIgnoreCase("o")) {
                        request = input.read("Entrer nouveau nom de club : ");
                        p.setClub(request);
                    }
                } else {
                    System.out.println("Nom de la personne introuvable");
                }
            }
        }
    }

}
