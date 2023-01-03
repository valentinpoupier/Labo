package horaire;


import java.time.LocalDateTime;
import java.time.LocalTime;

public class Horaire implements Comparable<Horaire>{
    private LocalDateTime debut;
    private LocalTime fin;

    public Horaire(LocalDateTime debut, LocalTime fin) {
        this.debut = debut;
        this.fin = fin;
    }

    public LocalDateTime getDebut() {
        return debut;
    }

    public LocalTime getFin() {
        return fin;
    }

    @Override
    public int compareTo(Horaire o) {
        return this.debut.compareTo(o.debut);
    }
}
