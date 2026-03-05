import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Student implements Comparable<Student> {
    private String id;
    private Curriculum myCurriculum;
    private HashMap<String, ArrayList<Double>> resultats;

    public Student(String i, Curriculum c) {
        id = i;
        myCurriculum = c;
        resultats = new HashMap<String, ArrayList<Double>>();
    }

    public String toString() {
        return "Student [id=" + id + ", myCurriculum=" + myCurriculum + ", resultats=" + resultats + "]";
    }

    public String getId() {
        return id;
    }

    public Curriculum getMyCurriculum() {
        return myCurriculum;
    }

    public boolean addNote(String s, Double d) {
        if (!myCurriculum.getMod_Coef().containsKey(s)) {
            return false;
        }
        if (!resultats.containsKey(s)) {
            resultats.put(s, new ArrayList<Double>());
        }
        return resultats.get(s).add(d);
    }

    public double average(String s) {
        ArrayList<Double> notes = resultats.get(s);
        if (notes == null || notes.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (Double note : notes) {
            sum += note;
        }
        return sum / notes.size();
    }

    public Double average() {
        double totalWeightedAverage = 0;
        double totalCoefficients = 0;
        HashMap<String, Integer> modCoefs = myCurriculum.getMod_Coef();

        for (Map.Entry<String, Integer> entry : modCoefs.entrySet()) {
            String module = entry.getKey();
            int coef = entry.getValue();
            double avg = average(module);
            totalWeightedAverage += avg * coef;
            totalCoefficients += coef;
        }

        if (totalCoefficients == 0) return 0.0;
        return totalWeightedAverage / totalCoefficients;
    }

    public int compareTo(Student st) {
        return this.average().compareTo(st.average());
    }
}
