import animals.*;

import java.util.List;

public class Main {
    public static void nourrirAnimal(Animal a) {
        System.out.println("Nourrissage de " + a.getName());
        System.out.println(a.faireDuBruit());
    }

    public static void main(String[] args) {
        Lion simba = new Lion("Simba", 5, 190.0, "Africain");
        Lion nala = new Lion("Nala", 4, 135.0, "Berbère");
        Perroquet coco = new Perroquet("Coco", 3, 0.4, "Vert", "Bonjour");
        Perroquet rio = new Perroquet("Rio", 2, 0.5, "Rouge", "Ola !");
        Requin jaws = new Requin("Jaws", 10, 680.0, "Grand Blanc", 5.5);

        Enclos savane = new Enclos("Savane Africaine", "Mammifères", 4);
        Enclos aquarium = new Enclos("Grand Aquarium", "Poissons", 3);
        Enclos voliere = new Enclos("Volière Tropicale", "Oiseaux", 5);

        savane.ajouterAnimal(simba);
        savane.ajouterAnimal(nala);
        aquarium.ajouterAnimal(jaws);
        voliere.ajouterAnimal(coco);
        voliere.ajouterAnimal(rio);

        System.out.println("\n=== BIENVENUE AU ZOO ===\n");
        savane.afficherAnimaux();
        aquarium.afficherAnimaux();
        voliere.afficherAnimaux();

        savane.reveillerAnimaux();
        voliere.reveillerAnimaux();
        aquarium.reveillerAnimaux();

        System.out.println("\n=== Test nourrirAnimal ===");
        List<Animal> animaux = List.of(simba, nala, coco, rio, jaws);
        for (Animal a : animaux) {
            nourrirAnimal(a);
        }

        System.out.println("\n=== Interface Nourrissable ===");
        for (Animal a : animaux) {
            if (a instanceof Nourrissable n) {
                System.out.println(a.getName() + " :");
                n.afficherRegime();
                n.manger("nourriture quotidienne");
            }
        }
    }
}