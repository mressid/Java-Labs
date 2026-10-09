import java.util.ArrayList;

public class Bibliotheque {

    private String nom;
    private String adresse;
    private ArrayList<Document> catalogue;
    private ArrayList<Membre> membres;
    private ArrayList<Emprunt> emprunts;
    private ArrayList<Reservation> reservations;

    public Bibliotheque(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
        this.catalogue = new ArrayList<>();
        this.membres = new ArrayList<>();
        this.emprunts = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public ArrayList<Document> getCatalogue() {
        return catalogue;
    }

    public ArrayList<Membre> getMembres() {
        return membres;
    }

    public ArrayList<Emprunt> getEmprunts() {
        return emprunts;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public String addDocument(Document d) {
        if (d != null) {
            catalogue.add(d);
        }
        return "document added ";
    }

    public void ajouterDocument(Document d) {
        addDocument(d);
    }

    public String addMembre(Membre m) {
        if (m != null) {
            membres.add(m);
        }
        return "membre added ";
    }

    public void ajouterMembre(Membre m) {
        addMembre(m);
    }

    public Membre rechercherMembre(String idMembre) {
        for (Membre m : membres) {
            if (idMembre.equals(m.getIdMembre())) {
                return m;
            }
        }
        return null;
    }

    public Reservation trouverReservation(String idDocument) {
        for (Reservation r : reservations) {
            if (r.getTargetDocument().getId().equals(idDocument)) {
                return r;
            }
        }
        return null;
    }

    public String empruntDocument(String idMembre, String idDocument) {

        Membre membre = rechercherMembre(idMembre);

        Document document = null;
        for (Document d : catalogue) {
            if (idDocument.equals(d.getId())) {
                document = d;
                break;
            }
        }

        if (membre == null || document == null) {
            return "impossible";
        }

        if (document.isEstEmprunte()) {
            return "document déjà emprunté";
        }

        if (!membre.peutEmprunter()) {
            return "limite d'emprunts atteinte";
        }

        Emprunt e = new Emprunt(membre, document);
        emprunts.add(e);
        membre.ajouterEmprunt(e);
        document.setEstEmprunte(true);

        return "emprunt réussi";
    }

    public boolean emprunterDocument(String idMembre, String idDocument) {
        return "emprunt réussi".equals(empruntDocument(idMembre, idDocument));
    }

    public String reserverDocument(String idMembre, String idDocument) {
        Membre membre = rechercherMembre(idMembre);

        Document document = null;
        for (Document d : catalogue) {
            if (idDocument.equals(d.getId())) {
                document = d;
                break;
            }
        }

        if (membre == null || document == null) {
            return "impossible";
        }

        if (!document.isEstEmprunte()) {
            return "impossible : le document n'est pas emprunté";
        }

        Reservation r = trouverReservation(idDocument);
        if (r == null) {
            r = new Reservation(document);
            reservations.add(r);
        }

        return r.ajouterMembre(membre);
    }

    public String retournerDocument(String idEmprunt) {

        for (Emprunt e : emprunts) {

            if (idEmprunt.equals(e.getIdEmprunt()) && e.getDateRetourEffectif() == null) {

                e.effectuerRetour();
                e.getMembre().retirerEmprunt(e);

                // Notification automatique pour le premier membre ayant réservé
                Reservation r = trouverReservation(e.getDocument().getId());
                if (r != null && r.hasReservations()) {
                    r.notifierPremierMembre();
                }

                if (e.getAmende() > 0) {
                    return "Document retourné avec succès (Amende: " + e.getAmende() + "€)";
                }

                return "Document retourné avec succès";
            }
        }

        return "Emprunt introuvable";
    }

    public ArrayList<Document> rechercherDocument(String titre) {

        ArrayList<Document> resultats = new ArrayList<>();

        for (Document d : catalogue) {

            if (d.getTitre().equalsIgnoreCase(titre)) {
                resultats.add(d);
            }
        }

        return resultats;
    }

    public int compterEmpruntsEnCours() {
        int count = 0;
        for (Emprunt e : emprunts) {
            if (e.getDateRetourEffectif() == null) {
                count++;
            }
        }
        return count;
    }

    public void afficherStatistiques() {

        System.out.println("\n=== STATISTIQUES ===");
        System.out.println("Nom : " + nom);
        System.out.println("Adresse : " + adresse);

        System.out.println("Nombre de documents : " + catalogue.size());
        System.out.println("Nombre de membres : " + membres.size());
        System.out.println("Nombre d'emprunts au total : " + emprunts.size());
        System.out.println("Nombre d'emprunts en cours : " + compterEmpruntsEnCours());

        int nbLivres = 0, nbMagazines = 0, nbDVDs = 0;
        for (Document d : catalogue) {
            if (d instanceof Livre) nbLivres++;
            else if (d instanceof Magazine) nbMagazines++;
            else if (d instanceof DVD) nbDVDs++;
        }

        System.out.println(" - Livres : " + nbLivres);
        System.out.println(" - Magazines : " + nbMagazines);
        System.out.println(" - DVDs : " + nbDVDs);
        System.out.println("Nombre de réservations enregistrées : " + reservations.size());
    }

}

