package animals;

public class Lion extends Animal implements Nourrissable {
    private String _race;

    public Lion(String race, String name, Integer age, Double poids, String espace) {
        super(name, age, poids, espace);
        this._race = race;
    }

    public Lion(String name, Integer age, Double poids, String race) {
        this(race, name, age, poids, "Felin");
    }

    public String getRace() {
        return _race;
    }

    public void setRace(String race) {
        this._race = race;
    }

    @Override
    public String toString() {
        return "%s, Lion => Race: %s".formatted(super.toString(), _race);
    }

    @Override
    public String faireDuBruit() {
        return "%s RUGIT ! ROARRR".formatted(getName());
    }

    public void rugir() {
        System.out.println(getName() + " Rugit: ROARRR !");
    }

    @Override
    public void manger(String nourriture) {
        System.out.printf("%s devore : %s%n", getName(), nourriture);
    }

    @Override
    public Double getRationJournaliere() {
        return getPoids() * 0.04;
    }
}
