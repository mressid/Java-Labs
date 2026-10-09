public abstract class Document {
    // Attributs privés (ENCAPSULATION)
    private String id;
    private String titre;
    private int anneePublication;
    private boolean estEmprunte;
    // Constructeur
    public Document(String id, String titre, int anneePublication) {
        this.id = id;
        this.titre = titre;
        this.anneePublication = anneePublication;
        this.estEmprunte = false;
    }
    // Getters et Setters
    public String getId() {
        return id;
    }
    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public int getAnneePublication() {
        return anneePublication;
    }
    public void setAnneePublication(int anneePublication) {
        this.anneePublication = anneePublication;
    }
    public boolean isEstEmprunte() {
        return estEmprunte;
    }
    public void setEstEmprunte(boolean estEmprunte) {
        this.estEmprunte = estEmprunte;
    }
    // Méthodes abstraites (ABSTRACTION)
    public abstract String getType();
    public abstract int getDureeEmpruntMax();
    // Méthode concrète
    public void afficherInfos() {
        System.out.println("=== Informations du Document ===");
        System.out.println("ID: " + id);
        System.out.println("Titre: " + titre);
        System.out.println("Année: " + anneePublication);
        System.out.println("Type: " + getType());
        System.out.println("Statut: " + (estEmprunte ? "Emprunté" :
                "Disponible"));
    }
}
