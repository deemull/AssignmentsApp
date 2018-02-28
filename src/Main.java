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
        LocalDateTime birthDate = LocalDateTime.of(1996, 10, 2,12, 35);
        //Output the day of the week (Sunday - Saturday) that you were born
        System.out.println(birthDate.getDayOfWeek());
        //Output the number of days you were alive
        int years = (int) birthDate.toLocalDate().toEpochDay();
        int days = (int) (today.toLocalDate().toEpochDay() - years);
        System.out.println(days);
        //Output the number of days between two dates
        LocalDateTime date1 = LocalDateTime.of(1587, 8, 23, 11, 34);
        LocalDateTime date2 = LocalDateTime.of(1951, 8, 23, 11, 34);
        System.out.println(date2.toLocalDate().toEpochDay() - date1.toLocalDate().toEpochDay());
        
    }

}
