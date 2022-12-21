package horaire;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Horaire {
    private LocalDateTime heuredebut;
    private LocalDateTime heurefin;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    public Horaire() {
        this.heuredebut = LocalDateTime.now();
        this.heurefin = LocalDateTime.now();
        this.dateDebut = LocalDate.now();
        this.dateFin = LocalDate.now();
    }

    public LocalDateTime getHeuredebut() {
        return heuredebut;
    }

    public void setHeuredebut(LocalDateTime heuredebut) {
        this.heuredebut = heuredebut;
    }

    public LocalDateTime getHeurefin() {
        return heurefin;
    }

    public void setHeurefin(LocalDateTime heurefin) {
        this.heurefin = heurefin;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

}
