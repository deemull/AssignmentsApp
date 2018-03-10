public class EnumTest {
    DayOfWeek day;
    Category work;
    Course thisClass;


    public EnumTest(DayOfWeek day) {
        this.day = day;
    }

    public EnumTest(Category work) {
        this.work = work;
    }

    public EnumTest(Course thisClass) {
        this.thisClass = thisClass;
    }

    public void tellItLikeItIs() {
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are bad.");
                break;

            case FRIDAY:
                System.out.println("Fridays are better.");
                break;

            case SATURDAY:
            case SUNDAY:
                System.out.println("Weekends are best.");
                break;

            default:
                System.out.println("Midweek days are so-so.");
                break;
        }
    }

    public void hardestClass() {
        switch (thisClass) {
            case DATASTRUCTURES:
                System.out.println("This class is my hardest class! ");
                break;

            case INTROTOTHEOLOGY:
                System.out.println("This class is critical and enlightening! ");
                break;

            case SLAVERYANDSERVITUDE:
                System.out.println("This class is easy, but a bit strenuous. ");
                break;

            case ELEMENTARYLINEARALGEBRA:
                System.out.println("This class is easy so far. ");
                break;

            case INTRODUCTIONTOBIOINFORMATICS:
                System.out.println("This class is easy, with a fun atmosphere. ");
                break;

            default:
                System.out.println("Class is class. ");
        }
    }
    public void workWorth() {
        switch (work) {
            case QUIZ:
            case HOMEWORK:
                System.out.println("Quizzes and homework are worth 10% of your grade. ");
                break;

            case TEST:
                System.out.println("Tests are worth 15% of your grade. ");
                break;

            case PRESENTATION:
                System.out.println("The presentation is worth 20% of your grade. ");
                break;

            case FINAL_EXAM:
                System.out.println("The final exam is worth 25% of your grade. ");
                break;

            default:
                System.out.println("A's before baes. ");
        }
    }

}
