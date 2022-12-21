package horaire;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateHoraire {

    public LocalDateTime dateTime(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez la date au format jj/mm/aaaa :");
        String dateInput = scanner.nextLine();
        LocalDate date = LocalDate.parse(dateInput, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("Entrez l'heure du commencement du stage au format hh:mm :");
        String timeInput = scanner.nextLine();
        LocalTime time = LocalTime.parse(timeInput, DateTimeFormatter.ofPattern("HH:mm"));

        System.out.println("Date : " + date);
        System.out.println("Heure : " + time);
        return LocalDateTime.of(date,time);
    }

    public LocalTime time(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez l'heure de fin du stage au format hh:mm :");
        String timeInput = scanner.nextLine();
        return LocalTime.parse(timeInput, DateTimeFormatter.ofPattern("HH:mm"));
    }
}
