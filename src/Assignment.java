import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Assignment {
    private LocalDateTime day;
    private EnumTest whichClass;
    private EnumTest work;
    private int priority;
    Random rand;

    public Assignment() {
        day = LocalDateTime.now();
        whichClass = new EnumTest(Course.SLAVERYANDSERVITUDE);
        work = new EnumTest(Category.HOMEWORK);
        rand = new Random();
        priority = rand.nextInt(4);
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

    public String compareTo(LocalDateTime dateTime) {
        if (getDay().isBefore(dateTime)) {
            return "BEFORE";
        } else if (getDay().isAfter(dateTime)) {
            return "AFTER";
        } else {
            return "EQUALS";
        }
    }

}
