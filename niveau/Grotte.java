/* **********************************************************************************
 * Cette partie du projet a été réalisée par AGANZE LWABOSHI MOISE le 21 octobre 2023
 ************************************************************************************/

package niveau;
/**
 * Classe abstraite représentant un monde virtuel avec une position et une vie.
 */
public abstract class Grotte {
    protected double x, y;
    protected int life;

    /**
     * Constructeur de la classe Grotte.
     *
     * @param x    Coordonnée x de la grotte.
     * @param y    Coordonnée y de la grotte.
     * @param life Points de vie initiaux de l'object se trouvant dans  la grotte.
     */
    public Grotte(double x, double y, int life) {
        this.x = x;
        this.y = y;
        this.life = life;
    }
    /**
     * Méthode pour réduire la vie dans la grotte.
     *
     * @param a nombre à soustraire à la vie actuelle.
     */
    public void decr_life(int a) {
        this.life -= a;
    }

    /**
     * Méthode pour augmenter la vie dans la grotte.
     *
     * @param b nombre à ajouter à la vie actuelle.
     */
    public void incr_life(int b) {
        this.life += b;
    }

    /**
     * Méthode  indiquant si l'object se trouvant dans la grotte est morte.
     */
    public void die() {
        this.life = 0;
    }

    /**
     *
     * @param dx La quantité à ajouter à la coordonnée x actuelle.
     * @return La nouvelle coordonnée x après l'ajout.
     */
    public double set_x(double dx) {
        return this.x += dx;
    }

    /**
     *
     * @param dy La quantité à ajouter à la coordonnée y actuelle.
     * @return La nouvelle coordonnée y après l'ajout.
     */
    public double set_y(double dy) {
        return this.y += dy;
    }

    /**
     * Méthode d'initialisation de l'object se trouvant dans  la grotte avec des valeurs par défaut.
     */
    public void init() {
        this.life = 0;
        this.x = 0;
        this.y = 0;
    }
}
