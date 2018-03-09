import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

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
        readFile();
        //Random rand = new Random();
        //DateTimeFormatter formatFile = DateTimeFormatter.ofPattern("MM/dd/yy HH:mm");
        ArrayList<LocalDateTime> dates = new ArrayList<>();
        //File readFile = new File("dates.txt");
        Scanner fileScan = new Scanner(System.in);

        //store the data into an Arraylist of LocalDateTime objects
        ArrayList<LocalDateTime> storeDates = storeData();
        System.out.println(storeDates);

        //Output the number of stored dates in the year [Y]
        System.out.println("Year? ");
        int year = fileScan.nextInt();
        ArrayList<LocalDateTime> numStoredDates = printDate(dates, year);
        System.out.println(numStoredDates);

        //Count the number of stored dates in the current year
        int numDates = countNumDates(dates);

        //Count the number of duplicates

        //Sort the dates in chronological order
        Collections.sort(dates);
        System.out.println(dates);
        //Count the number of evening (after6pm) dates

        //

    }

    public static void readFile() {
        File readFile = new File("dates.txt");
        try (PrintWriter printWriter = new PrintWriter(readFile)) {
            LocalDateTime today = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM:dd:yy HH:mm");
            Random randNum = new Random();
            int randDate = randNum.nextInt(100);
            int num = 100;
            for (int i = 0; i < num; i++) {
                LocalDateTime day = today.plusDays(randDate);
                LocalDateTime hour = today.plusHours(randDate).plusMinutes(randDate);
                String formatDay = day.format(formatter);
                String formatHour = hour.format(formatter);
                printWriter.println(formatDay);
                printWriter.println(formatHour);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }

    }

    public static ArrayList<LocalDateTime> storeData() {
        File infile = new File("dates.txt");
        ArrayList<LocalDateTime> dates = new ArrayList<>();
        try (Scanner newScan = new Scanner(infile)) {
            while (newScan.hasNext()) {
                String dateString = newScan.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy HH:mm");
                LocalDateTime date = LocalDateTime.parse(dateString, formatter);
                dates.add(date);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return dates;
    }

    public static ArrayList<LocalDateTime> printDate(ArrayList<LocalDateTime> dates, int year) {
        ArrayList<LocalDateTime> specYear = new ArrayList<>();
        for (int i = 0; i < dates.size(); i++) {
            if (dates.get(i).getYear() == year) {
                specYear.add(dates.get(i));
            }
        }
        return specYear;

    }

    public static int countNumDates(ArrayList<LocalDateTime> dates) {
        LocalDateTime today = LocalDateTime.now();
        int count = 0;
        for (int i = 0; i < dates.size(); i++) {
            if (dates.get(i).getYear() == today.getYear()) {
                count++;
            }
        }
        return count;
    }
    /*public static int countDuplicates(ArrayList<LocalDateTime> dates) {
        int count = 0;
        Set<LocalDateTime> date = new HashSet<>();
        for (int i = 0; i < dates.size(); i++) {
            if (dates.get(i) == dates.get(i+1)) {
                count++;
            }
        }

    }
    */

}
