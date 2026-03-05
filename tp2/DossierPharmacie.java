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

    public void nouveauPatient(String nom, String[] ord) {
        String nomLower = nom.toLowerCase();
        Patient p = new Patient(nom);
        for (String m : ord) {
            p.ajoutMedicament(m);
        }
        patients.put(nomLower, p);
    }

    public boolean ajoutMedicament(String nom, String m) {
        Patient p = patients.get(nom.toLowerCase());
        if (p != null) {
            p.ajoutMedicament(m);
            return true;
        }
        return false;
    }

    public void affichePatient(String nom) {
        Patient p = patients.get(nom.toLowerCase());
        if (p != null) {
            p.affiche();
        } else {
            System.out.println("Le patient " + nom + " nexiste pas dans le dossier.");
        }
    }

    public void affiche() {
        System.out.println("Pharmacie : " + nom);
        for (Patient p : patients.values()) {
            p.affiche();
        }
    }

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
