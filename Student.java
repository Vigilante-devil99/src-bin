import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student> {
    int rollNo;
    String name;
    double marks;

    Student(int rollNo, String name, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    public int compareTo(Student other) {
        return Integer.compare(this.rollNo, other.rollNo);
    }

    @Override
    public String toString() {
        return "[" + rollNo + ", " + name + ", " + marks + "]";
    }
}


class MarksDescComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Double.compare(s2.marks, s1.marks);
    }
}

public class SortingDemo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(104, "Vibhu", 88.5));
        students.add(new Student(101, "Amit", 92.0));
        students.add(new Student(103, "Rohan", 75.0));

        
        Collections.sort(students);
        System.out.println("Sorted by Roll No (Natural): " + students);

       
        Collections.sort(students, new MarksDescComparator());
        System.out.println("Sorted by Marks (Descending): " + students);
    }
}
