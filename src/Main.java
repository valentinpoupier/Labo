import persone.Personne;
import stage.Stage;

import java.util.*;

public class Main {
    private static ScannerInput input = new ScannerInput();
    private static TreeSet<Personne> personneList = new TreeSet<>(Comparator.comparing(Personne::getNom));
    private static Map<Stage,TreeSet<Personne>> stageList = new TreeMap<>(Comparator.comparing(Stage::getHoraire));

    public static void main(String[] args) {
        Controleur controleur;
        do {
            controleur = switch (input.read("1. Ajouter/supprimer Stage ; 2. Afficher horaire ; autre. Quitter")) {
                case "1" -> {
                    Controleur ctrl = getCreateControleur();
                    ctrl.stage();
                    yield ctrl;
                }
                case "2" -> {
                    Controleur ctrl = getCreateControleur();
                    ctrl.afficherListeStage();
                    yield ctrl;
                }
                default -> null;
            };
        } while (controleur != null);
        System.out.println("au revoir");
    }
    private static Controleur getCreateControleur() {
        return new CreateControleur(input, stageList);
    }
}