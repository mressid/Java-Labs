package animals;

public interface Nourrissable {
    void manger(String nourriture);
    Double getRationJournaliere();

    default void afficherRegime() {
        System.out.println("Ration journalière : " + getRationJournaliere() + " kg");
    }
}
