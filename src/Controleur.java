import persone.Personne;
import java.util.TreeSet;

public interface Controleur {
    TreeSet<Personne> inscription(TreeSet<Personne> personneList);

    void stage();
    void afficherListeStage();
}
