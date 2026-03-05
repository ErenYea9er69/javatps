
import java.util.Collection;

public class TestPharmacie {

    public static void main(String[] args) {
        DossierPharmacie maPharmacie = new DossierPharmacie("Pharmacie");

        maPharmacie.nouveauPatient("mahdi", new String[]{"Doliprane", "Viks"});
        maPharmacie.nouveauPatient("salim", new String[]{"Panadole", "Micosole"});

        maPharmacie.nouveauPatient("sirine", new String[]{"Sirop"});

        maPharmacie.affiche();

        boolean ok = maPharmacie.ajoutMedicament("salim", "bousalem");
        System.out.println("Ajout réussi ? " + ok);
        maPharmacie.affichePatient("salim");

        Collection<String> quiPrend = maPharmacie.affichePatientAvecMedicament("Doliprane");
        System.out.println(quiPrend);
    }
}
