

import java.util.TreeMap;
import java.util.Map;
import java.util.Scanner;

public class Annuaire {
    private Map<String, Fiche> tableAssociative;

    public Annuaire() {
        this.tableAssociative = new TreeMap<>();
    }

    public void ajouter(String nom, String tel, String adresse) {
        Fiche fiche = new Fiche(nom, tel, adresse);
        tableAssociative.put(nom, fiche);
    }

    public void rechercher(String nom) {
        Fiche fiche = tableAssociative.get(nom);
        if (fiche != null) {
            System.out.println(fiche);
        } else {
            System.out.println("Aucune fiche trouvée pour : " + nom);
        }
    }

    public void afficherTout() {
        if (tableAssociative.isEmpty()) {
            System.out.println("L'annuaire est vide.");
        } else {
            for (Fiche fiche : tableAssociative.values()) {
                System.out.println(fiche);
            }
        }
    }

    public static void main(String[] args) {
        Annuaire annuaire = new Annuaire();
        Scanner scanner = new Scanner(System.in);
        String commande;

        System.out.println("Commandes : +nom, ?nom, ! (tout), . (quitter)");

        while (true) {
            System.out.print("> ");
            commande = scanner.nextLine().trim();

            if (commande.equals(".")) {
                System.out.println("Bye!");
                break;
            } else if (commande.startsWith("+")) {
                String nom = commande.substring(1).trim();
                System.out.print("Numéro de téléphone : ");
                String tel = scanner.nextLine().trim();
                System.out.print("Adresse : ");
                String adresse = scanner.nextLine().trim();
                annuaire.ajouter(nom, tel, adresse);
                System.out.println("Fiche ajoutée pour " + nom);
            } else if (commande.startsWith("?")) {
                String nom = commande.substring(1).trim();
                annuaire.rechercher(nom);
            } else if (commande.equals("!")) {
                annuaire.afficherTout();
            } else if (commande.equalsIgnoreCase("bye")) {
                System.out.println("Bye!");
                break;
            } else {
                System.out.println("Commande inconnue. Utilisez +nom, ?nom, ! ou .");
            }
        }
        scanner.close();
    }
}
