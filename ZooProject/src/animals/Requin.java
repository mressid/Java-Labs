package animals;

public class Requin extends Animal implements Nourrissable {
    private String _espece;
    private Double _longeur;

    public Requin(String espece, String name, Integer age, Double poids, Double longeur, String espace) {
        super(name, age, poids, espace);
        this._espece = espece;
        this._longeur = longeur;
    }

    public Requin(String name, Integer age, Double poids, String espece, Double longeur) {
        this(espece, name, age, poids, longeur, "Poisson");
    }

    public String getEspece() {
        return _espece;
    }

    public void setEspece(String espece) {
        this._espece = espece;
    }

    public Double getLongeur() {
        return _longeur;
    }

    public void setLongeur(Double longeur) {
        this._longeur = longeur;
    }

    @Override
    public String faireDuBruit() {
        return "%s ...(silence)...".formatted(getName());
    }

    public void nager() {
        System.out.printf("%s nage silencieusement...%n", getName());
    }

    @Override
    public void manger(String nourriture) {
        System.out.println("%s engloutit : %s".formatted(getName(), nourriture));
    }

    @Override
    public Double getRationJournaliere() {
        return getPoids() * 0.02;
    }

    @Override
    public String toString() {
        return "%s | %s | %fm".formatted(super.toString(), _espece, _longeur);
    }
}
