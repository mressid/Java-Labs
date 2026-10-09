import java.util.ArrayList;
public class Membre {
    private String idMembre;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private ArrayList<Emprunt> empruntsEnCours;
    // Constructeur
    public Membre(String idMembre, String nom, String prenom,
                  String email, String telephone) {
        this.idMembre = idMembre;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.empruntsEnCours = new ArrayList<>();
    }
    // Getters et Setters
    public String getIdMembre() {
        return idMembre;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public ArrayList<Emprunt> getEmpruntsEnCours() {
        return empruntsEnCours;
    }
    // Méthodes métier
    public void ajouterEmprunt(Emprunt emprunt) {
        empruntsEnCours.add(emprunt);
    }
    public void retirerEmprunt(Emprunt emprunt) {
        empruntsEnCours.remove(emprunt);
    }
    public int getNombreEmpruntsEnCours() {
        return empruntsEnCours.size();
    }
    public boolean peutEmprunter() {
        return empruntsEnCours.size() < 5; // Maximum 5 emprunts
    }
    public void afficherInfos() {
        System.out.println("=== Informations Membre ===");
        System.out.println("ID: " + idMembre);
        System.out.println("Nom: " + nom + " " + prenom);
        System.out.println("Email: " + email);
        System.out.println("Téléphone: " + telephone);
        System.out.println("Emprunts en cours: " +
                empruntsEnCours.size());
    }

    @Override
    public String toString() {
        return "Membre[id=" + idMembre + ", nom=" + nom + " " + prenom +
                ", email=" + email + ", emprunts=" + empruntsEnCours.size() + "]";
    }
}