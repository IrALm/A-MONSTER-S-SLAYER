/* 
 * Cette partie du projet a été réalisée par AGANZE LWABOSHI MOISE le 09 novembre 2023
 */

package niveau;

/**
 * Classe abstraite Game, représentant un niveau de jeu.
 * Les différents niveaux de jeu hériteront de cette classe.
 */
public abstract class Game {

    /**
     * Les attributs de la classe Game, communs à chaque niveau de jeu.
     */
    protected Personnage p;
    protected int score;
    protected Menu menu;

    /**
     * Constructeur de la classe Game.
     *
     * @param p Personnage associé au niveau de jeu.
     */
    public Game(Personnage p) {
        this.p = p;
        this.score = 0;
        this.menu = new Menu();
    }

    /**
     * Méthode pour incrémenter le score.
     */
    public void addScore() {
        this.score += 1;
    }

    /**
     * Méthode pour vérifier si le personnage a été tué.
     *
     * @param p Personnage à vérifier.
     * @return true si le personnage a été tué, sinon false.
     */
    public boolean stop(Personnage p) {
        return p.life <= 0;
    }

    /**
     * Méthode pour déplacer le personnage dans le jeu.
     *
     * @param x Coordonnée x à atteindre.
     * @param y Coordonnée y à atteindre.
     */
    public void renc(double x, double y) {
        while (this.p.x < x) {
            this.p.set_x(1 + (Math.random() * 5));
        }
        if (this.p.x > x) {
            this.p.x = x;
        }
        while (this.p.y < y) {
            this.p.set_y(1 + (Math.random() * 5));
        }
        if (this.p.y > y) {
            this.p.y = y;
        }
        this.menu.msgDplP(this.p.get_name()); // Message d'affichage à la console
    }
    /**
     * Methode public permettant juste de faire l'affichage à la console pour préciser qu'on entamme le niveau supérieu au Level 1 et level 2
     */
    public void startNivDiff(){

        // Variable pour stocker la réponse de l'utilisateur.
        int rep;

        // Affiche des informations sur le score et le niveau de difficulté.
        System.out.println("\n******************************************************************************\n");
        System.out.println(" \nVotre score à ce niveau est  : " + this.score);
        System.out.println("\n ATTENTION : vous atteignez le niveau difficile de ce level!\n");
        System.out.println(" \nA ce niveau, il y a 20 monstres à combattre \n !!!!!!!! Vous devez tous les éliminer!!!!!!!!! \n");

        // Demande à l'utilisateur s'il souhaite passer au niveau suivant.
        try {
            rep = this.menu.msgSuiv();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Réinitialise les munitions du personnage, décrémente sa vie et celle du monstre.
        System.out.println("\n******************************************************************************\n");
    }

    /**
     * Méthode abstraite à implémenter dans les sous-classes pour démarrer le jeu.
     */
    public abstract void start();

    /**
     * Méthode abstraite à implémenter dans les sous-classes pour réinitialiser les attributs nécessaires.
     */
    public abstract void reunit();

    /**
     * Méthode abstraite à implémenter dans les sous-classes pour lancer une partie.
     */
    public abstract void play();

    /**
     * Méthode abstraite à implémenter dans les sous-classes pour relancer une partie.
     */
    public abstract void replay();

    /**
     * Méthode abstraite à implémenter dans les sous-classes pour simuler un combat entre le personnage et le monstre.
     *
     * @return Résultat du combat.
     */
    public abstract int fight();
}
