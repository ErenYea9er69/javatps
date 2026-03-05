

public class Fiche {
    private String nom;
    private String tel;
    private String adresse;

    public Fiche(String nom, String tel, String adresse) {
        this.nom = nom;
        this.tel = tel;
        this.adresse = adresse;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Nom: " + nom + ", Tel: " + tel + ", Adresse: " + adresse;
    }
}
