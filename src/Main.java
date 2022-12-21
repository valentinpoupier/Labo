import persone.Personne;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static ScannerInput input = new ScannerInput();
    private static List<Personne> personneList = new ArrayList<>();

    public static void main(String[] args) {
        Controleur controleur;
        do {

            controleur = switch (input.read("1. Inscrire un/des personne(s) ; 2. Ajouter/modifier/supprimer Stage ; autre. Quitter")) {
                case "1" -> {
                    Controleur ctrl = getCreateControleur();
                    ctrl.inscription();
                    yield ctrl;
                }
                case "2" -> {
                    Controleur ctrl = getCreateControleur();
                    ctrl.stage();
                    yield ctrl;
                }
                default -> null;
            };
        } while (controleur != null);
        System.out.println("au revoir");

    }

    private static Controleur getCreateControleur() {
        return new CreateControleur(input, personneList);
    }
}