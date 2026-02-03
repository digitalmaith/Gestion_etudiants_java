package Services;

import Model.Etudiant;
import java.util.ArrayList;
import java.util.Scanner;

public class EtudiantService {

    private ArrayList<Etudiant> etudiants = new ArrayList<>();

    public void ajouterEtudiant(Scanner scanner) {
        System.out.println("\n=== Ajout d'un étudiant ===");

        System.out.print("Nom : ");
        String nom = scanner.nextLine();

        int age;
        do {
            System.out.print("Age (>=18) : ");
            age = Integer.parseInt(scanner.nextLine());
        } while (age < 18);

        String telephone;
        do {
            System.out.print("Téléphone (77/76/70 + 7 chiffres) : ");
            telephone = scanner.nextLine();
        } while (!telephone.matches("^(77|76|70)[0-9]{7}$"));

        System.out.print("Boursier (oui/non) : ");
        boolean boursier = scanner.nextLine().equalsIgnoreCase("oui");

        float bourse = 0;
        if (boursier) {
            System.out.print("Montant bourse : ");
            bourse = Float.parseFloat(scanner.nextLine());
        }

        System.out.print("Montant aide : ");
        float aide = Float.parseFloat(scanner.nextLine());

        Etudiant e = new Etudiant(nom, age, telephone, boursier, bourse, aide);
        etudiants.add(e);

        System.out.println("Étudiant ajouté avec succès !");
        System.out.println("Matricule : " + e.getMatricule());
    }

    public void afficherTous() {
        if (etudiants.isEmpty()) {
            System.out.println("Aucun étudiant.");
            return;
        }
        etudiants.forEach(System.out::println);
    }

    public void afficherBoursiers() {
        etudiants.stream()
                .filter(Etudiant::isBoursier)
                .forEach(System.out::println);
    }

    public void afficherNonBoursiers() {
        etudiants.stream()
                .filter(e -> !e.isBoursier())
                .forEach(System.out::println);
    }

    public void rechercherMatricule(Scanner scanner) {
        System.out.print("Entrer le matricule : ");
        String mat = scanner.nextLine();

        for (Etudiant e : etudiants) {
            if (e.getMatricule().equals(mat)) {
                System.out.println(e);
                return;
            }
        }
        System.out.println("Aucun étudiant trouvé.");
    }

    public float sommeBourses() {
        float somme = 0;
        for (Etudiant e : etudiants) {
            if (e.isBoursier()) {
                somme += e.getMontantBourse();
            }
        }
        return somme;
    }

    public float sommeAides() {
        float somme = 0;
        for (Etudiant e : etudiants) {
            somme += e.getMontantAide();
        }
        return somme;
    }
}
