public class Magazine extends Document {
    private int numeroEdition;
    private String mois;

    public Magazine(String id, String titre, int anneePublication,
                    int numeroEdition, String mois) {
        super(id, titre, anneePublication);
        this.numeroEdition = numeroEdition;
        this.mois = mois;
    }

    public int getNumeroEdition() {
        return numeroEdition;
    }

    public void setNumeroEdition(int numeroEdition) {
        this.numeroEdition = numeroEdition;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    @Override
    public String getType() {
        return "Magazine";
    }

    @Override
    public int getDureeEmpruntMax() {
        return 7; // 7 jours pour un magazine
    }

    @Override
    public void afficherInfos() {
        super.afficherInfos();
        System.out.println("Numéro d'édition: " + numeroEdition);
        System.out.println("Mois: " + mois);
        System.out.println("Durée d'emprunt max: " +
                getDureeEmpruntMax() + " jours");
    }
}