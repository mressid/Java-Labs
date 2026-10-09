import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class Emprunt {
    private static int compteurId = 1;
    private String idEmprunt;
    private Membre membre;
    private Document document;
    private LocalDate dateEmprunt;
    private LocalDate dateRetourPrevu;
    private LocalDate dateRetourEffectif;
    private double amende;
    // Constructeur
    public Emprunt(Membre membre, Document document) {
        this.idEmprunt = "EMP" + String.format("%04d", compteurId++);
        this.membre = membre;
        this.document = document;
        this.dateEmprunt = LocalDate.now();
// Calcul automatique de la date de retour prévue
        this.dateRetourPrevu =
                dateEmprunt.plusDays(document.getDureeEmpruntMax());
        this.dateRetourEffectif = null;
        this.amende = 0.0;
    }
    // Getters
    public String getIdEmprunt() {
        return idEmprunt;
    }
    public Membre getMembre() {
        return membre;
    }
    public Document getDocument() {
        return document;
    }
    public LocalDate getDateEmprunt() {
        return dateEmprunt;
    }
    public LocalDate getDateRetourPrevu() {
        return dateRetourPrevu;
    }
    public LocalDate getDateRetourEffectif() {
        return dateRetourEffectif;
    }
    public double getAmende() {
        return amende;
    }
    // Méthodes métier
    public boolean estEnRetard() {
        if (dateRetourEffectif != null) {
            return dateRetourEffectif.isAfter(dateRetourPrevu);
        }
        return LocalDate.now().isAfter(dateRetourPrevu);
    }
    public long getJoursRetard() {
        LocalDate dateRef = (dateRetourEffectif != null) ?
                dateRetourEffectif : LocalDate.now();
        if (dateRef.isAfter(dateRetourPrevu)) {
            return ChronoUnit.DAYS.between(dateRetourPrevu, dateRef);
        }
        return 0;
    }
    public double calculerAmende() {
        long joursRetard = getJoursRetard();
        if (joursRetard > 0) {
            amende = joursRetard * 0.5; // 0.50€ par jour
        }
        return amende;
    }
    public void effectuerRetour() {
        this.dateRetourEffectif = LocalDate.now();
        calculerAmende();
        document.setEstEmprunte(false);
    }
    public void afficherInfos() {
        System.out.println("=== Informations Emprunt ===");
        System.out.println("ID: " + idEmprunt);
        System.out.println(StringTemplate.STR."Membre: \{membre.getNom()} \{membre.getPrenom()}");
        System.out.println(StringTemplate.STR."Document: \{document.getTitre()}");
        System.out.println(StringTemplate.STR."Date emprunt: \{dateEmprunt}");
        System.out.println("Date retour prévue: " + dateRetourPrevu);
        if (dateRetourEffectif != null) {
            System.out.println("Date retour effectif: " +
                    dateRetourEffectif);
            if (amende > 0) {
                System.out.println("Amende: " + amende + "€");
            }
        } else if (estEnRetard()) {
            System.out.println("RETARD: " + getJoursRetard() + "jour (s)");
        }
    }
}