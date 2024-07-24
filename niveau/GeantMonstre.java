package niveau;

/**
 * Classe représentant un monstre de niveau 2 : GeantMonstre.
 * Hérite de la classe Monstre.
 */
public class GeantMonstre extends Monstre {
    private int force;

    /**
     * Constructeur de la classe GeantMonstre.
     *
     * @param x    Coordonnée x initiale du monstre.
     * @param y    Coordonnée y initiale du monstre.
     * @param life Points de vie initiaux du monstre.
     */
    public GeantMonstre(double x, double y, int life) {
        super(x, y, life);
        this.force = 5;
    }

    /**
     * Getter pour récupérer la force du monstre.
     *
     * @return La force du monstre.
     */
    public int get_f() {
        return this.force;
    }

    /**
     * Méthode pour réduire la force du monstre.
     *
     * @param b nombre à soustraire à la force actuelle.
     * @return La nouvelle force après la soustraction.
     */
    public int decr_f(int b) {
        return this.force -= b;
    }

    /**
     * Méthode pour augmenter la force du monstre.
     *
     * @param b nombre à ajouter à la force actuelle.
     * @return La nouvelle force après l'addition.
     */
    public int incr_f(int b) {
        return this.force += b;
    }

    /**
     * Méthode d'initialisation du monstre avec des valeurs par défaut.
     */
    @Override
    public void init() {
        this.life = 0;
        this.x = 51 + (Math.random() * 100);
        this.y = 51 + (Math.random() * 100);
    }

    /**
     * Méthode de clonage du monstre.
     *
     * @return Un nouveau GeantMonstre avec les mêmes attributs que l'instance actuelle.
     */
    @Override
    public GeantMonstre clone() {
        return new GeantMonstre(this.x, this.y, this.life);
    }
}
