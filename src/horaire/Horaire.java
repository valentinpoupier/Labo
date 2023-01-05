package horaire;


import java.time.LocalDateTime;
import java.time.LocalTime;

public record Horaire(LocalDateTime debut, LocalTime fin) implements Comparable<Horaire> {

    @Override
    public int compareTo(Horaire o) {
        return this.debut.compareTo(o.debut);
    }
}
