/* **********************************************************************************
 * Cette partie du projet a été réalisée par AGANZE LWABOSHI MOISE le 21 octobre 2023
 ************************************************************************************/

package niveau;

/**
 * La classe Personnage représente l'entité du joueur dans le jeu.
 */
public class Personnage extends Grotte {
    private String name;
    protected Arme armp;

    // Constructeur
    /**
     * Constructeur de la classe Personnage.
     *
     * @param name Nom du personnage.
     * @param x    Coordonnée x initiale du personnage.
     * @param y    Coordonnée y initiale du personnage.
     * @param life Points de vie initiaux du personnage.
     */
    public Personnage(String name, double x, double y, int life) {
        super(x, y, life);
        this.name = name;
        this.armp = new Arme();
    }

    // Getter
    /**
     * Getter pour obtenir le nom du personnage.
     *
     * @return Le nom du personnage.
     */
    public String get_name() {
        return this.name;
    }
}
