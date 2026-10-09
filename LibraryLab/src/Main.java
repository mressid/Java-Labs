import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    var listmems = new ArrayList<>(List.of(
            new Membre("Member-01", "Amine", "essid", "essid@gmail.com", "8932312131"),
            new Membre("Member-02", "Salma", "Mansour", "salma@gmail.com", "8932312135"),
            new Membre("Member-03", "Goback", "Ben Khaled", "goback@gmail.com", "8932312132"),
            new Membre("Member-04", "Sadek", "Ben Sadek", "sadek@gmail.com", "8942312132")
    ));

    System.out.println("=== LISTE DES MEMBRES ===");
    for (var item : listmems) {
        System.out.println(item);
    }

    // Initialisation de la bibliothèque
    var biblio = new Bibliotheque("Bibliothèque Centrale", "Avenue Habib Bourguiba, Tunis");

    // Inscription des membres
    for (var m : listmems) {
        biblio.addMembre(m);
    }

    // Création de différents documents
    var livre1 = new Livre("L001", "1984", 1949, "George Orwell", "978-0451524935", 328);
    var livre2 = new Livre("L002", "Le Petit Prince", 1943, "Antoine de Saint-Exupéry", "978-0156012195", 96);
    var mag1 = new Magazine("M001", "Science & Vie", 2024, 1289, "Janvier");
    var dvd1 = new DVD("D001", "Inception", 2010, "Christopher Nolan", 148);

    biblio.addDocument(livre1);
    biblio.addDocument(livre2);
    biblio.addDocument(mag1);
    biblio.addDocument(dvd1);

    // Test du polymorphisme
    System.out.println("\n=== TEST DU POLYMORPHISME (afficherInfos) ===");
    livre1.afficherInfos();
    System.out.println();
    mag1.afficherInfos();
    System.out.println();
    dvd1.afficherInfos();

    // Emprunts de documents
    System.out.println("\n=== OPERATIONS D'EMPRUNT ===");
    System.out.println("Emprunt L001 par Member-01 : " + biblio.empruntDocument("Member-01", "L001"));
    System.out.println("Emprunt D001 par Member-01 : " + biblio.empruntDocument("Member-01", "D001"));
    System.out.println("Emprunt L001 par Member-02 (déjà emprunté) : " + biblio.empruntDocument("Member-02", "L001"));

    // Test du système de réservation (Exercice en cours complété)
    System.out.println("\n=== SYSTEME DE RESERVATION (Partie 4 : Ex 1) ===");
    System.out.println("Réservation L001 par Member-02 : " + biblio.reserverDocument("Member-02", "L001"));
    System.out.println("Réservation L001 par Member-03 : " + biblio.reserverDocument("Member-03", "L001"));

    var resL001 = biblio.trouverReservation("L001");
    if (resL001 != null) {
        resL001.afficherReservations();
    }

    // Retour d'un document et notification du premier membre en attente
    System.out.println("\n=== RETOUR ET NOTIFICATION AUTOMATIQUE ===");
    var empruntL001 = biblio.getEmprunts().getFirst();
    System.out.println("Retour de " + empruntL001.getIdEmprunt() + " : " +
            biblio.retournerDocument(empruntL001.getIdEmprunt()));

    // Affichage des statistiques
    biblio.afficherStatistiques();
}

