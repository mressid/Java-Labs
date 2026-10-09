package animals;

import java.util.ArrayList;
import java.util.List;

public class Enclos {
    private String _nom;
    private String _type;
    private Integer _capaciteMax;
    private List<Animal> _animaux = new ArrayList<>();

    public Enclos(String nom, String type, Integer capaciteMax) {
        this._nom = nom;
        this._type = type;
        this._capaciteMax = capaciteMax;
    }

    public String getNom() {
        return _nom;
    }

    public void setNom(String nom) {
        this._nom = nom;
    }

    public String getType() {
        return _type;
    }

    public void setType(String type) {
        this._type = type;
    }

    public Integer getCapaciteMax() {
        return _capaciteMax;
    }

    public void setCapaciteMax(Integer capaciteMax) {
        this._capaciteMax = capaciteMax;
    }

    public List<Animal> getAnimaux() {
        return _animaux;
    }

    public boolean ajouterAnimal(Animal a) {
        if (_animaux.size() < _capaciteMax) {
            _animaux.add(a);
            System.out.println(a.getName() + " ajoute a " + _nom);
            return true;
        }
        System.out.println("Enclos " + _nom + " est plein !");
        return false;
    }

    public void reveillerAnimaux() {
        System.out.println("\n=== Reveil de " + _nom + " ===");
        for (Animal a : _animaux) {
            System.out.println(a.faireDuBruit());
        }
    }

    public void afficherAnimaux() {
        System.out.println("Enclos [" + _type + "] " + _nom + " (" + _animaux.size() + "/" + _capaciteMax + ") :");
        _animaux.forEach(a -> System.out.println(" - " + a));
    }
}
