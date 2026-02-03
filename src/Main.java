import Services.EtudiantService;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EtudiantService gestion = new EtudiantService();
        int choix;

        do {
            choix = menu();

            switch (choix) {
                case 1 -> gestion.ajouterEtudiant(scanner);
                case 2 -> gestion.afficherTous();
                case 3 -> gestion.afficherBoursiers();
                case 4 -> gestion.afficherNonBoursiers();
                case 5 -> gestion.rechercherMatricule(scanner);
                case 6 -> System.out.println("Somme des bourses : " + gestion.sommeBourses());
                case 7 -> System.out.println("Somme des aides : " + gestion.sommeAides());
                case 0 -> System.out.println("Fin du programme ");
            }

        } while (choix != 0);
    }

    public static int menu() {
        Scanner sc = new Scanner(System.in);
        int choix;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Ajouter étudiant");
            System.out.println("2. Afficher tous");
            System.out.println("3. Afficher boursiers");
            System.out.println("4. Afficher non boursiers");
            System.out.println("5. Rechercher par matricule");
            System.out.println("6. Somme des bourses");
            System.out.println("7. Somme des aides");
            System.out.println("0. Quitter");
            System.out.print("Choix : ");
            choix = sc.nextInt();
        } while (choix < 0 || choix > 7);

        return choix;
    }
}
