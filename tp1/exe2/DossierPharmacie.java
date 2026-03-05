import java.util.Collection;
import java.util.HashMap;
import java.util.ArrayList;

public class DossierPharmacie {
    private String nom;
    private HashMap<String, Patient> patients;

    public DossierPharmacie(String n) {
        nom = n;
        patients = new HashMap<String, Patient>();
    }

    // --Ajoute un nouveau patient de nom et ordonnance données --/
    public void nouveauPatient(String nom, String[] ord) {
        String nomLower = nom.toLowerCase();
        Patient p = new Patient(nom); // On garde le nom original pour l'affichage
        for (String m : ord) {
            p.ajoutMedicament(m);
        }
        patients.put(nomLower, p);
    }

    // Ajoute un nouveau medicament sur un patient déjà existant.
    // Renvoie false si le patient n’existe pas et true si l’ajout a pu être effectué
    public boolean ajoutMedicament(String nom, String m) {
        Patient p = patients.get(nom.toLowerCase());
        if (p != null) {
            p.ajoutMedicament(m);
            return true;
        }
        return false;
    }

    // Affiche le nom et l’ordonance du patient donné
    public void affichePatient(String nom) {
        Patient p = patients.get(nom.toLowerCase());
        if (p != null) {
            p.affiche();
        } else {
            System.out.println("Le patient " + nom + " n'existe pas dans le dossier.");
        }
    }

    // affiche le nom de la pharmacie et tous les patients du dossier
    public void affiche() {
        System.out.println("Pharmacie : " + nom);
        for (Patient p : patients.values()) {
            p.affiche();
            System.out.println("-------------------------");
        }
    }

    // retourne la collection des noms des patients qui prennent le medicament m
    public Collection<String> affichePatientAvecMedicament(String m) {
        Collection<String> patientsAyantMedicament = new ArrayList<>();
        for (Patient p : patients.values()) {
            if (p.contientMedicament(m)) {
                patientsAyantMedicament.add(p.getNom());
            }
        }
        return patientsAyantMedicament;
    }
}
