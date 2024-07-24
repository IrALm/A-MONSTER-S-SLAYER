/* **********************************************************************************
 * Cette partie du projet a été réalisée par AGANZE LWABOSHI MOISE le 21 octobre 2023
 ************************************************************************************/

package niveau;

/**
 * La classe Monstre représentant la catégorie des monstres de niveau 1 (élémentaire).
 */
public class Monstre extends Grotte {
    // Attributs
    private boolean alive;
    private int id; // pour pouvoir l'identifier

    // Constructeur
    /**
     * Constructeur de la classe Monstre.
     *
     * @param x    Coordonnée x initiale du monstre.
     * @param y    Coordonnée y initiale du monstre.
     * @param life Points de vie initiaux du monstre.
     */
    public Monstre(double x, double y, int life) {
        super(x, y, life);
        this.alive = true;
        this.id = 0;
    }

    // Getters
    /**
     * Getter pour obtenir l'état de vie du monstre.
     *
     * @return true si le monstre est en vie, false sinon.
     */
    public boolean get_alive() {
        return this.alive;
    }

    /**
     * Getter pour obtenir l'identifiant du monstre.
     *
     * @return L'identifiant du monstre.
     */
    public int get_Id() {
        return this.id;
    }

    // Méthodes
    /**
     * Méthode pour notifier que le monstre est mort.
     */
    public void die() {
        this.alive = false;
    }

    /**
     * Méthode pour définir l'identifiant du monstre.
     *
     * @param i Identifiant à définir.
     * @return L'identifiant défini.
     */
    public int setId(int i) {
        return this.id = i + 1;
    }

    /**
     * Méthode pour initialiser le monstre à la position de départ.
     */
    @Override
    public void init() {
        this.life = 0;
        this.x = 1 + (Math.random() * 50);
        this.y = 1 + (Math.random() * 50);
    }

    /**
     * Méthode de clonage du monstre.
     *
     * @return Un nouveau Monstre avec les mêmes attributs que l'instance actuelle.
     */
    @Override
    public Monstre clone() {
        return new Monstre(this.x, this.y, this.life);
    }
}
