import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

interface Statisticable {
    float getValue();
}

class Note implements Statisticable {
    private String intitule;
    private float valeur;

    public Note(String intitule, float valeur) {
        this.intitule = intitule;
        this.valeur = valeur;
    }

    public String getIntitule() { return intitule; }
    
    @Override
    public float getValue() { return valeur; }
}

class Etudiant implements Statisticable, Comparable<Etudiant> {
    private String matricule;
    private String nom;
    private ArrayList<Note> listeNotes;

    public Etudiant(String matricule, String nom) {
        this.matricule = matricule;
        this.nom = nom;
        this.listeNotes = new ArrayList<>();
    }

    public void addNote(Note n) {
        listeNotes.add(n);
    }

    @Override
    public float getValue() {
        if (listeNotes.isEmpty()) return 0;
        float somme = 0;
        for (Note n : listeNotes) {
            somme += n.getValue();
        }
        return somme / listeNotes.size();
    }

    @Override
    public int compareTo(Etudiant autre) {
        return this.matricule.compareTo(autre.matricule);
    }

    public String getMatricule() { return matricule; }
    public String getNom() { return nom; }
    public ArrayList<Note> getListeNotes() { return listeNotes; }

    @Override
    public String toString() {
        return String.format("[Matricule: %s | Nom: %-10s | Moyenne: %5.2f]", 
                             matricule, nom, getValue());
    }
}

class Stats {
    public static float calculerMoyenne(List<? extends Statisticable> liste) {
        if (liste.isEmpty()) return 0;
        float somme = 0;
        for (Statisticable s : liste) somme += s.getValue();
        return somme / liste.size();
    }

    public static Statisticable getMaximum(List<? extends Statisticable> liste) {
        if (liste.isEmpty()) return null;
        Statisticable max = liste.get(0);
        for (Statisticable s : liste) {
            if (s.getValue() > max.getValue()) max = s;
        }
        return max;
    }

    public static Statisticable getMinimum(List<? extends Statisticable> liste) {
        if (liste.isEmpty()) return null;
        Statisticable min = liste.get(0);
        for (Statisticable s : liste) {
            if (s.getValue() < min.getValue()) min = s;
        }
        return min;
    }
}

class CompareNom implements Comparator<Etudiant> {
    @Override
    public int compare(Etudiant e1, Etudiant e2) {
        return e1.getNom().compareTo(e2.getNom());
    }
}

class CompareMoyenne implements Comparator<Etudiant> {
    @Override
    public int compare(Etudiant e1, Etudiant e2) {
        return Float.compare(e1.getValue(), e2.getValue());
    }
}

public class GestionEtudiants {
    public static void main(String[] args) {
        Etudiant e1 = new Etudiant("A100", "Zied");
        e1.addNote(new Note("Java", 15));
        e1.addNote(new Note("Ops", 12));

        Etudiant e2 = new Etudiant("B250", "Amel");
        e2.addNote(new Note("Java", 18));
        e2.addNote(new Note("Ops", 17));

        Etudiant e3 = new Etudiant("A050", "Bassem");
        e3.addNote(new Note("Java", 10));
        e3.addNote(new Note("Ops", 11));

        ArrayList<Etudiant> promo = new ArrayList<>();
        promo.add(e1);
        promo.add(e2);
        promo.add(e3);

        System.out.println("--- Statistiques du Groupe ---");
        System.out.println("Moyenne de classe : " + Stats.calculerMoyenne(promo));
        System.out.println("Meilleur étudiant : " + Stats.getMaximum(promo));
        System.out.println("Moins bon étudiant : " + Stats.getMinimum(promo));

        System.out.println("\n--- Tri par Matricule (Comparable) ---");
        Collections.sort(promo);
        promo.forEach(System.out::println);

        System.out.println("\n--- Tri par Nom (Comparator) ---");
        Collections.sort(promo, new CompareNom());
        promo.forEach(System.out::println);

        System.out.println("\n--- Tri par Moyenne (Comparator) ---");
        Collections.sort(promo, new CompareMoyenne());
        promo.forEach(System.out::println);
    }
}