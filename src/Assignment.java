import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

public class Assignment {
    private LocalDateTime day;
    private EnumTest whichClass;
    private EnumTest work;
    private int priority;
    Random rand;

    public Assignment(LocalDateTime parse, Course course, Category category, int priority) {
        day = LocalDateTime.now();
        whichClass = new EnumTest(Course.SLAVERYANDSERVITUDE);
        work = new EnumTest(Category.HOMEWORK);
        rand = new Random();
        this.priority = rand.nextInt(4);
    }

    public Assignment(LocalDateTime day, EnumTest whichClass, EnumTest work, int priority) {
        this.day = day;
        this.whichClass = whichClass;
        this.work = work;
        this.priority = priority;
    }

    public LocalDateTime getDay() {
        return day;
    }

    public void setDay(LocalDateTime day) {
        this.day = day;
    }

    public EnumTest getWhichClass() {
        return whichClass;
    }

    public void setWhichClass(EnumTest whichClass) {
        this.whichClass = whichClass;
    }

    public EnumTest getWork() {
        return work;
    }

    public void setWork(EnumTest work) {
        this.work = work;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Assignment{" + day + whichClass + work + priority + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assignment that = (Assignment) o;
        return priority == that.priority &&
                Objects.equals(day, that.day) &&
                Objects.equals(whichClass, that.whichClass) &&
                Objects.equals(work, that.work);
    }

    @Override
    public int hashCode() {

        return Objects.hash(day, whichClass, work, priority, rand);
    }

    public int compareTo(Assignment dateTime) {
        if (getDay().compareTo(dateTime.getDay()) == 0)
            if (getDay().isEqual(dateTime.getDay())) {
                return 0;
        } else if (getDay().isAfter(dateTime.getDay())) {
                return 1;
            } else {
                return -1;
            }
        return getDay().compareTo(dateTime.getDay());
        //return getDay() - dateTime. getDay();
    }

    public static Assignment valueOf(String assignmentValue) {
        assignmentValue = assignmentValue.substring(assignmentValue.indexOf("{") + 1, assignmentValue.indexOf("}"));
        assignmentValue = assignmentValue.replaceAll("priority: ", "");
        String[] values = assignmentValue.split(", ");
        return new Assignment(LocalDateTime.parse(values[0]), Course.valueOf(values[1]), Category.valueOf(values[2]), Integer.parseInt(values[3]));
    }


}
