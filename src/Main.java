import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n\nHello, AssignmentsApp!\n");
        // Output the current date-time
        LocalDateTime today = LocalDateTime.now();
        System.out.println(today);
        //Output tomorrow's date using a formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
        String formatDateTime = today.format(formatter);
        System.out.println(formatDateTime);
        //Add 5 weeks to today's LocalDateTime
        System.out.println(today.plusWeeks(5));
        //Initialize a LocalDateTime object to your birthdate and the time 12:35AM
        DateTimeFormatter birthDate = DateTimeFormatter.ofPattern("10-02-1996 12:35:00 P.M.");
        //System.out.println(birthDate.);
    }

}
