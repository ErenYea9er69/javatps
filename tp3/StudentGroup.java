import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class StudentGroup {
    private HashSet<Student> set;
    private String id;

    public StudentGroup(String id) {
        this.id = id;
        set = new HashSet<Student>();
    }

    public HashSet<Student> getSet() {
        return set;
    }

    public String getId() {
        return id;
    }

    public void addStudent(Student st) {
        set.add(st);
    }

    public void sort() {
        List<Student> students = new ArrayList<>(set);
        Collections.sort(students);
        
        System.out.println("Etudiants du groupe " + id + " triés par moy");
        for (Student st : students) {
            System.out.println(st.getId() + " Moy: " + st.average());
        }
    }
}
