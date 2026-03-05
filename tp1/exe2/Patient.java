import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Patient {
    private String nom;
    private Set<String> ordonnance;

    public Patient(String n) {
        nom = n;
        ordonnance = new HashSet<String>();
    }

    public String getNom() {
        return nom;
    }

    // -- teste si l’ordonnance est vide ou pas
    public boolean ordonnanceVide() {
        return ordonnance.isEmpty();
    }

    // Ajoute un medicament à l’ordonnance
    public void ajoutMedicament(String m) {
        ordonnance.add(m);
    }

    // Affiche le nom du patient ainsi que son ordonnance
    public void affiche() {
        System.out.println("Patient : " + nom);
        if (ordonnanceVide()) {
            System.out.println("L'ordonnance est vide.");
        } else {
            System.out.println("Ordonnance : " + ordonnance);
        }
    }

    // teste si l’ordonnance contient un médicament
    public boolean contientMedicament(String m) {
        return ordonnance.contains(m);
    }

    // --trie l’ordonnance du patient selon l’ordre alphabétique
    public void trieOrdonnace() {
        ordonnance = new TreeSet<String>(ordonnance);
    }
}
