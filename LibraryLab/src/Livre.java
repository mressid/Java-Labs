public class Livre extends Document {
    private String auteur;
    private String isbn;
    private int nombrePages;
    // Constructeur
    public Livre(String id, String titre, int anneePublication,
                 String auteur, String isbn, int nombrePages) { super(id, titre,
            anneePublication); // Appel au constructeur parent
        this.auteur = auteur;
        this.isbn = isbn;
        this.nombrePages = nombrePages;
    }
    // Getters et Setters
    public String getAuteur() {
        return auteur;
    }
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public int getNombrePages() {
        return nombrePages;
    }
    public void setNombrePages(int nombrePages) {
        this.nombrePages = nombrePages;
    }
    // Implémentation des méthodes abstraites (POLYMORPHISME)
    @Override
    public String getType() {
        return "Livre";
    }
    @Override
    public int getDureeEmpruntMax() {
        return 21; // 21 jours pour un livre
    }
    // Redéfinition de la méthode afficherInfos (POLYMORPHISME)
    @Override
    public void afficherInfos() {
        super.afficherInfos(); // Appel à la méthode parent
        System.out.println("Auteur: " + auteur);
        System.out.println("ISBN: " + isbn);
        System.out.println("Nombre de pages: " + nombrePages);
        System.out.println("Durée d'emprunt max: " +
                getDureeEmpruntMax() + " jour");
    }
}