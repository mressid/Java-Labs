package animals;

abstract public class Animal {
    private String _name;
    private Integer _age;
    private Double _poids;
    private String _espace;

    public Animal(String name, Integer age, Double poids, String espace) {
        setName(name);
        setAge(age);
        setPoids(poids);
        this._espace = espace;
    }

    public Animal() {
    }

    public abstract String faireDuBruit();

    public String getEspace() {
        return _espace;
    }

    public void setEspace(String espace) {
        this._espace = espace;
    }

    public String getEspece() {
        return _espace;
    }

    public void setEspece(String espece) {
        this._espace = espece;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this._name = name;
        }
    }

    public String getNom() {
        return _name;
    }

    public void setNom(String nom) {
        setName(nom);
    }

    public Integer getAge() {
        return _age;
    }

    public void setAge(Integer age) {
        if (age != null && age >= 0 && age <= 100) {
            this._age = age;
        } else {
            System.out.println("Erreur : age invalide (" + age + ")");
        }
    }

    public Double getPoids() {
        return _poids;
    }

    public void setPoids(Double poids) {
        if (poids != null && poids > 0) {
            this._poids = poids;
        }
    }

    @Override
    public String toString() {
        return "[%s] Name: %s | Age: %d | Poids: %.1f kg".formatted(_espace, _name, _age, _poids);
    }

    public void AfficheInfo() {
        System.out.println(this);
    }
}
