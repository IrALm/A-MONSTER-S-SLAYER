/* **********************************************************************************
 * Cette partie du projet a été réalisée par AGANZE LWABOSHI MOISE le 21 octobre 2023
 ************************************************************************************/

package niveau;

/**
 * Interface InterTxt définissant les méthodes d'affichage pour le terminal.
 */
public interface InterTxt {
    
    /**
     * Méthode permettant à l'utilisateur de saisir pour poursuivre avec la lecture des consignes du jeu.
     *
     * @return La valeur saisie par l'utilisateur.
     */
    public int msgSuiv();

    /**
     * Affiche l'objectif principal du niveau 1 du jeu.
     *
     * @param str Objectif principal du niveau 1.
     */
    public void msgStart(String str);

    /**
     * Affiche les règles du jeu.
     */
    public void msgRegle();

    /**
     * Affiche le vainqueur à la fin de la partie.
     *
     * @param a true si le joueur a gagné, false sinon.
     */
    public void msgAffWinner(boolean a);

    /**
     * Affiche le déplacement du personnage.
     *
     * @param str Description du déplacement.
     */
    public void msgDplP(String str);

    /**
     * Notifie quand le personnage rencontre l'armée des monstres.
     *
     * @param str Message de rencontre.
     */
    public void msgrencP(String str);

    /**
     * Notifie quand le personnage tue le monstre.
     *
     * @param str Message de victoire.
     */
    public void msgBeatM(String str);

    /**
     * Affiche le nombre de munitions restantes.
     *
     * @param a Nombre de munitions.
     */
    public void msgMin(int a);

    /**
     * Notifie que le monstre frappe le personnage.
     *
     * @param str Message de coup reçu.
     */
    public void msgBeatP(String str);

    /**
     * Affiche le niveau de vie du personnage.
     *
     * @param s Niveau de vie du personnage.
     */
    public void msgLifeP(int s);

    /**
     * Affiche le début du combat.
     */
    public void msgStart();

    /**
     * Affiche le nombre de monstres à combattre.
     *
     * @param m Nombre de monstres.
     */
    public void msgNbM(int m);

    /**
     * Affiche chaque monstre individuellement.
     *
     * @param m Message d'identification du monstre.
     */
    public void msgIdM(int m);

    /**
     * Affiche le niveau de vie des monstres.
     *
     * @param m Niveau de vie des monstres.
     */
    public void msgNvL(int m);

    /**
     * Affiche un message de fin de combat.
     */
    public void msgFin();

    /**
     * Affiche le score.
     *
     * @param i Score du joueur.
     */
    public void msgAffScore(int i);

    /**
     * Affiche le personnage, son niveau de vie et ses munitions.
     *
     * @param str nom du personnage.
     * @param a   Nombre des minutions.
     */
    public void msgArmPch(String str, int a);

    /**
     * Méthode pour afficher un message demandant à l'utilisateur s'il veut faire une nouvelle partie.
     *
     * @return La valeur saisie par l'utilisateur.
     */
    public int msgRec();

    /**
     * Affiche un message de remerciement à la fin du programme.
     */
    public void msgEnd();

    /**
     * Affiche un message indiquant que le monstre a été tué.
     *
     * @param str nom du personnage.
     */
    public void msgKillM(String str);

    /**
     * Affiche le nom du personnage, ses munitions et ses bombes.
     *
     * @param str nom du personnage.
     * @param a   Nombre des minutions
     * @param b   Nombre des bombes
     */
    public void msgArmPchl2(String str, int a, int b);

    /**
     * Affiche les règles du niveau 2.
     */
    public void msgRegleLevel2();

    /**
     * Méthode pour afficher un message demandant à l'utilisateur s'il veut faire une nouvelle partie (niveau 2).
     *
     * @return La valeur saisie par l'utilisateur.
     */
    public int msgRec2();

    /**
     * Affiche le nombre de bombes.
     *
     * @param a Nombre de bombes.
     */
    public void msgB(int a);

    /**
     * Affiche le niveau de vie du monstre.
     *
     * @param i Niveau de vie du monstre.
     */
    public void msgLifeM(int i);

    /**
     * Affiche les règles du niveau 3.
     */
    public void msgRegleLevel3();
}
