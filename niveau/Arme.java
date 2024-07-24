/* **********************************************************************************
 * Cette partie du projet a été réalisée par AGANZE LWABOSHI MOISE le 21 octobre 2023
 ************************************************************************************/

package niveau;

/**
 * Classe représentant une arme dans le jeu.
 */
public class Arme {
    // Attributs
    private int minution;
    private int bombe;
    private int resistance_bouclier;

    /**
     * Constructeur de la classe Arme.
     * Initialise les attributs minution, bombe et resistance_bouclier à zéro.
     */
    public Arme() {
        this.minution = 0;
        this.bombe = 0;
        this.resistance_bouclier = 0;
    }

    /**
     * Méthode pour recharger les munitions de l'arme.
     *
     * @param m Quantité à ajouter aux munitions.
     */
    public void recharger_m(int m) {
        this.minution += m;
    }

    /**
     * Méthode pour décharger les munitions 
     *
     * @param b Quantité à soustraire aux munitions.
     */
    public void decharge_m(int b) {
        this.minution -= b;
    }

    /**
     * Méthode pour recharger les bombes .
     *
     * @param b Quantité à ajouter aux bombes.
     */
    public void recharger_b(int b) {
        this.bombe += b;
    }

    /**
     * Méthode pour décharger les bombes 
     *
     * @param b Quantité à soustraire aux bombes.
     */
    public void decharge_b(int b) {
        this.bombe -= b;
    }

    /**
     * Méthode pour diminuer la résistance du bouclier.
     */
    public void dim_res_bc() {
        this.resistance_bouclier -= 1;
    }

    /**
     * Méthode pour augmenter la résistance du bouclier 
     *
     * @param nb Quantité à ajouter à la résistance du bouclier.
     */
    public void augm_res_bc(int nb) {
        this.resistance_bouclier += nb;
    }

    /**
     * Méthode d'initialisation des valeurs des attributs à zéro.
     */
    public void init() {
        this.minution = this.resistance_bouclier = this.bombe = 0;
    }

    // Getters
    /**
     * Getter pour obtenir le nombre de munitions
     *
     * @return Le nombre de munitions.
     */
    public int get_m() {
        return this.minution;
    }

    /**
     * Getter pour obtenir le nombre de bombes 
     *
     * @return Le nombre de bombes.
     */
    public int get_b() {
        return this.bombe;
    }

    /**
     * Getter pour obtenir la résistance du bouclier 
     *
     * @return La résistance du bouclier.
     */
    public int get_res_bouclier() {
        return this.resistance_bouclier;
    }
}
