import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    static Random rand = new Random();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\n\nHello, AssignmentsApp!\n");

        //Output the current date-time.
        LocalDateTime today = LocalDateTime.now();
        System.out.println("\nThe current date-time is " + today);

        //Output tomorrow's date using a formatter.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
        String formatDateTime = today.format(formatter);
        System.out.println("Tomorrow's formatted date is " + formatDateTime);

        //Add 5 weeks to today's LocalDateTime.
        LocalDateTime fiveWeeksLater = today.plusWeeks(5);
        System.out.println("The five weeks, the date will be " + fiveWeeksLater);

        //Initialize a LocalDateTime object to your birthdate and the time 12:35 PM.
        LocalDateTime birthDate = LocalDateTime.of(1999, 2, 7, 12, 35);
        System.out.println("Your birthdate is " + birthDate);

        //Output the day of the week (Sunday-Saturday) that you were born.
        System.out.println("The day of the week of your birthdate was " + birthDate.getDayOfWeek());

        //Output the number of days you've been alive.
        System.out.println("The number of days you have been alive is " + ChronoUnit.DAYS.between(birthDate, today) + " days.");

        //Output the number of days between two dates.
        LocalDateTime obamaInauguration = LocalDateTime.of(2009, 2, 20, 12, 0);
        System.out.println("The number of days between your birthdate and Obama's inauguration is " + ChronoUnit.DAYS.between(birthDate, obamaInauguration) + " days.");

        //Given two dates, output the earlier.
        System.out.println("The earlier date is " + FindEarlierDate(today, obamaInauguration));

        //Create a file with 100 random "month/day/year  hour:minutes" (in that format) on each line.
        ArrayList<LocalDateTime> hundredRandomDates = randomDateArray(100);
        hundredRandomDates.forEach(d -> System.out.println("Date is " + d));

        //Output the number of stored dates in the year [Y].
        System.out.print("\nWhat is the year you want to find the dates of? ");
        ArrayList<LocalDateTime> datesOfUserYear = searchByYear(hundredRandomDates, sc.nextInt());
        System.out.println("The number of dates with that year is " + datesOfUserYear.size());

        //Count the number of stored dates in the current year.
        ArrayList<LocalDateTime> datesOfCurrentYear = searchByYear(hundredRandomDates, today.getYear());
        System.out.println("\nThe number of dates in the current year is " + datesOfCurrentYear.size());

        //Count the number of duplicates.
        ArrayList<LocalDateTime> duplicatedDates = seekDuplicates(hundredRandomDates);
        System.out.println("\nThere are " + duplicatedDates.size() + " duplicated dates.");

        // Sort the dates in chronological order.
        Collections.sort(hundredRandomDates);
        System.out.println("\nThe sorted dates are as followed: ");
        hundredRandomDates.forEach(d -> System.out.println(d));

        //Count the number of duplicates in a sorted list without using a Java Set.
        System.out.println("\nWithout using a Set, the number of duplicated dates are " + countDuplicates(hundredRandomDates));

        //Count the number of evening (after 6pm) dates.
        ArrayList<LocalDateTime> eveningDates = searchDatesInTimeframe(hundredRandomDates, 18, 24);
        System.out.println("\nThe number of evening dates are " + eveningDates.size());

        //Count the number of dates in each of the individual 12 months without using a Java Map.
        System.out.print("\nWhat is the number of the month you are searching the dates for? ");
        int month = sc.nextInt();
        if (month > 12 || month < 1) System.out.println("That month value is not valid.");
        else {
            ArrayList<LocalDateTime> datesOfMonth = searchByMonth(hundredRandomDates, month);
            System.out.println("The number of dates in month " + month + " is " + datesOfMonth.size());
        }

        //Count the number of dates in each of the individual 12 months using a Java Map.
        if (month >= 1 && month <= 12) {
            System.out.println("Using a Java Map, the number of dates in month " + month + " is " + mapByMonthSearch(hundredRandomDates, month));
        }

        //Determine the index of the latest LocalDateTime.
        System.out.println("\nThe index of the latest LocalDateTime is " + indexLatestDate(hundredRandomDates));

        //Determine the indexes of the elements that have the earliest starting time, regardless of date.
        System.out.println("\nThe index of the date with the earliest starting time is " + indexEarliestTime(hundredRandomDates));

        //foreach: something.foreach(num --> sout(num)
        //Output a date in the format "January 1st, 2018".
        System.out.print("\nWhat is the index of the date you want to be outputted in the format \"January 1st, 2018\"? ");
        System.out.println("The formatted date is " + formattedDate(hundredRandomDates.get(sc.nextInt())));
        //I had completely forgotten to submit the previous story, so if it looks like I completed this story incredibly quickly, it's because I temporarily removed this code so I could post the for the previous story.
        //Define and use a DayOfWeek enumerated type.
        EnumTest firstDay = new EnumTest(DayOfWeek.MONDAY);
        firstDay.tellItLikeItIs();
        EnumTest thirdDay = new EnumTest(DayOfWeek.WEDNESDAY);
        thirdDay.tellItLikeItIs();
        EnumTest fifthDay = new EnumTest(DayOfWeek.FRIDAY);
        fifthDay.tellItLikeItIs();
        EnumTest sixthDay = new EnumTest(DayOfWeek.SATURDAY);
        sixthDay.tellItLikeItIs();
        EnumTest seventhDay = new EnumTest(DayOfWeek.SUNDAY);
        seventhDay.tellItLikeItIs();

        //Define and use a Course enumerated type.
        EnumTest firstClass = new EnumTest(Course.ELEMENTARYLINEARALGEBRA);
        firstClass.hardestClass();
        EnumTest nextClass = new EnumTest(Course.DATASTRUCTURES);
        nextClass.hardestClass();
        EnumTest enlightenClass = new EnumTest(Course.INTROTOTHEOLOGY);
        enlightenClass.hardestClass();
        EnumTest bioClass = new EnumTest(Course.INTRODUCTIONTOBIOINFORMATICS);
        bioClass.hardestClass();
        EnumTest onlyClass = new EnumTest(Course.SLAVERYANDSERVITUDE);
        onlyClass.hardestClass();

        //Define and use a Category enumerated type.
        EnumTest thisWork = new EnumTest(Category.QUIZ);
        thisWork.workWorth();
        EnumTest homeWork = new EnumTest(Category.HOMEWORK);
        homeWork.workWorth();
        EnumTest presentWork = new EnumTest(Category.PRESENTATION);
        presentWork.workWorth();
        EnumTest testWork = new EnumTest(Category.TEST);
        testWork.workWorth();
        EnumTest finalWork = new EnumTest(Category.FINAL_EXAM);
        finalWork.workWorth();

        //In the driver, generate 2 random assignments named assign1 and assign2.
        Assignment assign1 = new Assignment(LocalDateTime.now(), new EnumTest(Course.SLAVERYANDSERVITUDE),
                new EnumTest(Category.HOMEWORK), rand.nextInt(4));
        Assignment assign2 = new Assignment(LocalDateTime.parse(values[0]), Course.valueOf(values[1]), Category.valueOf(values[2]), Integer.parseInt(values[3]));

        //Copy assign1 to assign3
        Assignment assign3 = new Assignment(LocalDateTime.parse(values[0]), Course.valueOf(values[1]), Category.valueOf(values[2]), Integer.parseInt(values[3]));
        assign1.equals(assign3);
        System.out.println(assign1);
        System.out.println(assign3);

        //Override an Assignment.equals() method (see class)
        //Which of assign1, assign2, or assign3 is the earliest?
        int ans = assign1.compareTo(assign2);
        System.out.println(ans);
        int ans2 = assign2.compareTo(assign3);
        System.out.println(ans2);
        int ans3 = assign3.compareTo(assign1);
        System.out.println(ans3);


        //TODO Write [X] randomly generated assignments to the file 'input.dat'
        System.out.print("\nHow many assignments do you want saved onto the file? ");
        generateAssignmentsFile("input.dat", sc.nextInt());

        //TODO Read assignments from the file and store them in an Assignment object
        ArrayList<Assignment> assignmentsArray = fileToListAssignment("input.dat");
        assignmentsArray.forEach(assignment -> System.out.println("Assignment in array: " + assignment));

        //TODO Remove any duplicate assignments (Java Set)
        ArrayList<Assignment> uniqueAssignments = removeDuplicateAssignments(assign1, assign2, assign3);
        System.out.println("The unique assignments are " + uniqueAssignments);

        //TODO Count the number of assignments for Course [C]
        //TODO What are the Course [C] assignments?
        //TODO Sort the assignments in reverse chronological order
        //Collections.sort(Assignment object, (a,b) --> a > b)
        //TODO Sort the assignments by increasing priority order
        //TODO Sort the assignments by Course
        //TODO Which assignments are due today?
        //TODO Which assignments are due within [X] days?
        //TODO Which assignments are past due, sorted by Course
        //TODO What is the next assignment due for each course?
        //TODO What are the highest priority assignments that are still due, sorted by date.
    }

    private static String formattedDate(LocalDateTime date) {
        String newDate = "";
        newDate += date.format(DateTimeFormatter.ofPattern("MMMM "));
        newDate += intToOrdinal(date.getDayOfMonth());
        newDate += date.format(DateTimeFormatter.ofPattern(", yyyy"));
        return newDate;
    }

    private static String intToOrdinal(int num) {
        String[] suffixes = new String[]{"th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th"};
        //I probably should have made this into a switch/case.
        if (num % 100 == 11 || num % 100 == 12 || num % 100 == 13) {
            return num + "th";
        } else {
            return num + suffixes[num % 10];
        }

    }

    private static Integer indexEarliestTime(ArrayList<LocalDateTime> dateList) {
        LocalDateTime earliestDateTime = dateList.get(0);
        for (LocalDateTime date : dateList) {
            if (earliestDateTime.toLocalTime().isAfter(date.toLocalTime())) earliestDateTime = date;
        }
        return dateList.indexOf(earliestDateTime);
    }

    private static Integer indexLatestDate(ArrayList<LocalDateTime> dateList) {
        return dateList.indexOf(Collections.max(dateList));
    }

    private static Integer mapByMonthSearch(ArrayList<LocalDateTime> dateList, int month) {
        return mapByMonth(dateList).get(month);
    }

    private static Map<Integer, Integer> mapByMonth(ArrayList<LocalDateTime> dateList) {
        Map<Integer, Integer> returnMap = new HashMap<>();
        for (LocalDateTime date : dateList) {
            Integer count = returnMap.get(date.getMonthValue());
            returnMap.put(date.getMonthValue(), (count == null) ? 1 : count + 1);
        }
        return returnMap;
    }

    private static ArrayList<LocalDateTime> searchByMonth(ArrayList<LocalDateTime> dateList, int month) {
        return (ArrayList) dateList.stream()
                .filter(date -> date.getMonthValue() == month)
                .collect(Collectors.toList());
    }

    private static ArrayList searchDatesInTimeframe(ArrayList<LocalDateTime> dateList, int startHour, int endHour) {
        return (ArrayList) dateList.stream()
                .filter(date -> date.getHour() >= startHour && date.getHour() < endHour)
                .collect(Collectors.toList());
    }

    private static int countDuplicates(ArrayList<LocalDateTime> hundredRandomDates) {
        int count = 0;
        for (LocalDateTime date : hundredRandomDates) {
            if (Collections.frequency(hundredRandomDates, date) >= 2) count++;
        }
        return count;
    }


    private static ArrayList<LocalDateTime> seekDuplicates(ArrayList<LocalDateTime> userList) {
        ArrayList<LocalDateTime> returnArray = new ArrayList<>();
        Set<LocalDateTime> dateSet = new HashSet<>();
        for (LocalDateTime date : userList) {
            if (dateSet.contains(date)) returnArray.add(date);
            dateSet.add(date);
        }
        return returnArray;
    }

    private static ArrayList<LocalDateTime> searchByYear(ArrayList<LocalDateTime> listOfLocalDateTimes, int year) {
        return (ArrayList) listOfLocalDateTimes.stream()
                .filter(date -> date.getYear() == year)
                .collect(Collectors.toList());
    }

    private static ArrayList<LocalDateTime> randomDateArray(int NumElements) {
        ArrayList<LocalDateTime> returnArray = new ArrayList<>();
        for (int i = 0; i < NumElements; i++) {
            returnArray.add(randDateGenerator());
        }
        return returnArray;
    }

    private static LocalDateTime randDateGenerator() {
        long startOfTime = ChronoUnit.MINUTES.between(LocalDateTime.of(0, 1, 1, 0, 0), LocalDateTime.now());
        long minutes = rand.nextInt((int) startOfTime);
        return LocalDateTime.now().minusMinutes(minutes);
    }

    private static LocalDateTime FindEarlierDate(LocalDateTime date1, LocalDateTime date2) {
        LocalDateTime earlyDate = date1;
        if (date2.isBefore(date1)) {
            earlyDate = date2;
        }
        return earlyDate;
    }

    private static Assignment randomAssignmentGenerator() {
        return new Assignment(randDateGenerator(), Course.DATASTRUCTURES, Category.HOMEWORK, rand.nextInt(4));
    }

    private static void generateAssignmentsFile(String fileName, int numAssignments) {
        File inFile = new File(fileName);
        int count = numAssignments;
        try (PrintWriter pw = new PrintWriter(inFile)) {
            while (count != 0) {
                pw.println(randomAssignmentGenerator());
                count--;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<Assignment> fileToListAssignment(String fileName) {
        ArrayList<Assignment> returnArray = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(line -> returnArray.add(Assignment.valueOf(line)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnArray;
    }

    private static ArrayList<Assignment> removeDuplicateAssignments(ArrayList<Assignment> assignmentsArray) {
        return new ArrayList<>(new HashSet<>(assignmentsArray));
    }

    private static ArrayList<Assignment> removeDuplicateAssignments(Assignment... assignments) {
        ArrayList<Assignment> assignmentsArray = new ArrayList<>();
        Collections.addAll(assignmentsArray, assignments);
        return removeDuplicateAssignments(assignmentsArray);
    }

}

