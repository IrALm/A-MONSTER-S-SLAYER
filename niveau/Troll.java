package niveau;

/**
 * La classe Troll représente la catégorie des monstres de niveau 3.
 * Un Troll est une variante de GeantMonstre avec un attribut supplémentaire, le poison.
 */
public class Troll extends GeantMonstre {

    // Attribut supplémentaire
    protected int poison;

    // Constructeur
    /**
     * Constructeur de la classe Troll.
     *
     * @param x      Coordonnée x initiale du Troll.
     * @param y      Coordonnée y initiale du Troll.
     * @param life   Points de vie initiaux du Troll.
     * @param poison Niveau de poison du Troll.
     */
    public Troll(double x, double y, int life, int poison) {
        super(x, y, life);
        this.poison = poison;
    }

    /**
     * Méthode de clonage du Troll.
     *
     * @return Un nouveau Troll avec les mêmes attributs que l'instance actuelle.
     */
    @Override
    public Troll clone() {
        return new Troll(this.x, this.y, this.life, this.poison);
    }

    /**
     * Méthode d'initialisation du Troll à une position de départ.
     */
    @Override
    public void init() {
        this.life = 0;
        this.x = 101 + (Math.random() * 100);
        this.y = 101 + (Math.random() * 100);
    }
}
