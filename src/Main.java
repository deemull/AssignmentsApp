import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
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
        //Given two dates, output the earlier.
        if (date1.isBefore(date2)) {
            System.out.println(date1);
        } else {
            System.out.println(date2);
        }
        //create a file with 100 random "month/day/year hour:minutes on each line
        //see Dates.txt
        //store the data into an Arraylist of LocalDateTime objects
        Random rand = new Random();
        ArrayList<String> dates = new ArrayList<>();
        File readFile = new File("Dates");
        Scanner fileScan = new Scanner(readFile);
        while (fileScan.hasNextLine()) {
            String date = fileScan.next();
            dates.add(date);
        }
        System.out.println(dates);
        //Output the number of stored dates in a year
    }

}
