public class DVD extends Document {
    private String realisateur;
    private int dureeMinutes;

    public DVD(String id, String titre, int anneePublication,
               String realisateur, int dureeMinutes) {
        super(id, titre, anneePublication);
        this.realisateur = realisateur;
        this.dureeMinutes = dureeMinutes;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public int getDureeMinutes() {
        return dureeMinutes;
    }

    public void setDureeMinutes(int dureeMinutes) {
        this.dureeMinutes = dureeMinutes;
    }

    @Override
    public String getType() {
        return "DVD";
    }

    @Override
    public int getDureeEmpruntMax() {
        return 14; // 14 jours pour un DVD
    }

    @Override
    public void afficherInfos() {
        super.afficherInfos();
        System.out.println("Réalisateur: " + realisateur);
        System.out.println("Durée: " + dureeMinutes + " minutes");
        System.out.println("Durée d'emprunt max: " +
                getDureeEmpruntMax() + " jours");
    }
}