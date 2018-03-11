import java.time.LocalDateTime;
import java.util.ArrayList;

public class Assignment {
    LocalDateTime day;
    EnumTest whichClass;
    EnumTest work;
    ArrayList<Integer> priority;

    public Assignment() {
        day = LocalDateTime.now();
        whichClass = new EnumTest(Course.SLAVERYANDSERVITUDE);
        work = new EnumTest(Category.HOMEWORK);
        priority = new ArrayList<>();
    }

    public Assignment(LocalDateTime day, EnumTest whichClass, EnumTest work, ArrayList<Integer> priority) {
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

    public ArrayList<Integer> getPriority() {
        return priority;
    }

    public void setPriority(ArrayList<Integer> priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Assignment{" + day + whichClass + work + priority + '}';
    }

}
