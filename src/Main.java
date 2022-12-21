import persone.Personne;
import stage.Stage;
import stage.StageList;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class Main implements Serializable {
    private static ScannerInput input = new ScannerInput();
    private static List<Personne> personneList = new ArrayList<>();
    private static Map<Stage,List<Personne>> stageList = new TreeMap<>(Comparator.comparing(Stage::getHoraire));

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
        StageList stageList1 =  new StageList(Main.stageList);
        //stageList1.saveToFile("myfile.ser");
    }

    private static Controleur getCreateControleur() {
        return new CreateControleur(input, personneList, stageList);
    }
}