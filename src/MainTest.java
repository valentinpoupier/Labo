import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez la date au format jj/mm/aaaa :");
        String dateInput = scanner.nextLine();
        LocalDate date = LocalDate.parse(dateInput, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("Entrez l'heure au format hh:mm :");
        String timeInput = scanner.nextLine();
        LocalTime time = LocalTime.parse(timeInput, DateTimeFormatter.ofPattern("HH:mm"));

        System.out.println("Date : " + date);
        System.out.println("Heure : " + time);
        LocalDateTime dateTime = LocalDateTime.of(date,time);
    }
}

