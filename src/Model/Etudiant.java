package Model;

public class Etudiant {
    private static int compteur = 0;

    private String matricule;
    private String nom;
    private int age;
    private String telephone;
    private boolean boursier;
    private float montantBourse;
    private float montantAide;

    public Etudiant(String nom, int age, String telephone,
                    boolean boursier, float montantBourse, float montantAide) {

        compteur++;
        this.matricule = String.format("M-%05d", compteur);
        this.nom = nom;
        this.age = age;
        this.telephone = telephone;
        this.boursier = boursier;
        this.montantBourse = montantBourse;
        this.montantAide = montantAide;
    }

    public String getMatricule() {
        return matricule;
    }

    public boolean isBoursier() {
        return boursier;
    }

    public float getMontantBourse() {
        return montantBourse;
    }

    public float getMontantAide() {
        return montantAide;
    }

    @Override
    public String toString() {
        return "Matricule: " + matricule +
                " | Nom: " + nom +
                " | Age: " + age +
                " | Téléphone: " + telephone +
                " | Boursier: " + (boursier ? "Oui" : "Non") +
                " | Bourse: " + montantBourse +
                " | Aide: " + montantAide;
    }
}
