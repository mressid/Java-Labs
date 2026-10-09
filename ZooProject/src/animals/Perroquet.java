package animals;

public class Perroquet extends Animal implements Nourrissable {
    private String _couleur;
    private String _motAppris;

    public Perroquet(String couleur, String name, Integer age, Double poids, String motAppris, String espace) {
        super(name, age, poids, espace);
        this._couleur = couleur;
        this._motAppris = motAppris;
    }

    public Perroquet(String name, Integer age, Double poids, String couleur, String motAppris) {
        this(couleur, name, age, poids, motAppris, "Oiseau");
    }

    @Override
    public String faireDuBruit() {
        return "%s crie: %s !".formatted(getName(), _motAppris);
    }

    public String getMotAppris() {
        return _motAppris;
    }

    public void setMotAppris(String motAppris) {
        this._motAppris = motAppris;
    }

    public String getCouleur() {
        return _couleur;
    }

    public void setCouleur(String couleur) {
        this._couleur = couleur;
    }

    public String parler() {
        return "%s dit %s !".formatted(getName(), _motAppris);
    }

    @Override
    public void manger(String nourriture) {
        System.out.println("%s picore : %s".formatted(getName(), nourriture));
    }

    @Override
    public Double getRationJournaliere() {
        return getPoids() * 0.10;
    }

    @Override
    public String toString() {
        return super.toString() + " | Plumage: %s".formatted(_couleur);
    }
}
