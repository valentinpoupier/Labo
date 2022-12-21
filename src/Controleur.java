import persone.Personne;

import java.util.List;

public interface Controleur {
    List<Personne> inscription(List<Personne> personneList);

    void stage();
    void afficherListeStage();
}
