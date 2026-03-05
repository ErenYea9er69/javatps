
public class Main {

    public static void main(String[] args) {
        Curriculum c1 = new Curriculum("info");
        c1.addModCoef("dev", 3);
        c1.addModCoef("french", 2);

        Student s1 = new Student("Karim", c1);

        s1.addNote("dev", 13.0);
        s1.addNote("dev", 20.0);

        s1.addNote("french", 17.0);
        s1.addNote("french", 19.0);
        s1.addNote("french", 15.0);

        Student s2 = new Student("sirine", c1);
        s2.addNote("dev", 10.0);
        s2.addNote("dev", 12.0);
        s2.addNote("french", 8.0);
        s2.addNote("french", 10.0);

        Student s3 = new Student("mehdi", c1);
        s3.addNote("dev", 18.0);
        s3.addNote("french", 18.0);

        StudentGroup group = new StudentGroup("G1");
        group.addStudent(s1);
        group.addStudent(s2);
        group.addStudent(s3);

        System.out.println("Karim moy dev " + s1.average("dev"));
        System.out.println("Karim moy french " + s1.average("french"));
        System.out.println("Karim moy totale " + s1.average());

        group.sort();
    }
}
