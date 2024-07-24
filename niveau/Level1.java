/**
 * Cette classe représente le premier niveau du jeu.
 * Elle a été réalisée par AGANZE LWABOSHI MOISE le 21 octobre 2023.
 */
package niveau;

import java.util.ArrayList;

/**
 * La classe Level1 étend la classe Game et représente le premier niveau du jeu.
 */
public class Level1 extends Game {

    private Monstre m; // Instance du monstre au level 1
    private ArrayList<Monstre> armeMonstre; // Liste d'instances de monstres au niveau facile 
    private ArrayList<Monstre> armeNivD; // Liste d'instances de monstres pour un niveau difficile
    private int nbMonstre; // Nombre de monstres dans le niveau facile
    private int nbNivD; // Nombre des monstres dans le niveau difficile

    /**
     * Constructeur de la classe Level1.
     *
     * @param p Le personnage 
     * @param m L'instance du monstre pour le niveau.
     */
    public Level1(Personnage p, Monstre m) {
        super(p); // Appel du constructeur de la classe mère (Game) avec le personnage en paramètre
        this.m = m; // Initialisation de l'instance de monstre
        this.armeMonstre = new ArrayList<>(); // Initialisation de la liste d'instances de monstres
        this.nbMonstre = 15; // Initialisation du nombre de monstres
        this.armeNivD = new ArrayList<>(); // Initialisation de la liste d'instances de monstres pour le niveau difficile
        this.nbNivD = 20; // Initialisation du nombre des monstres au niveau difficle
    }
    /**
     * Méthode privée pour générer une armée de monstres.
     *
     * @param m L'instance du monstre à cloner.
     * @param a La liste d'instances de monstres à remplir.
     * @param t Le nombre de monstres à générer.
     */
    private void addMonstre(Monstre m, ArrayList<Monstre> a, int t) {
        Monstre copy;
        
        for (int i = 0; i < t; i++) {
            // Clone de l'instance de monstre
            copy = this.m.clone();
            
            // Attribution d'un identifiant unique
            copy.setId(i);
            
            // Positionnement dans la grotte (exemple : chaque monstre à une position en x et y égale à (i+1)*2)
            copy.set_x((i + 1) * 2);
            copy.set_y((i + 1) * 2);
            
            // Ajout du monstre cloné à la liste
            a.add(i, copy);
        }
    }
    /**
     * Méthode implémentant le combat entre le personnage et le monstre.
     * Elle renvoie de manière aléatoire un nombre compris entre 0 et 1, représentant
     * le résultat du combat (0 pour une défaite, 1 pour une victoire).
     *
     * @return Le résultat du combat, où 0 indique une défaite et 1 une victoire.
     */
    @Override
    public int fight() {
        return (int) (Math.random() * 2);
    }
    /**
     * Méthode de test basée sur le résultat du combat retourné par la méthode fight().
     * Si le résultat est 1, cela signifie que le personnage a vaincu le monstre. Dans ce cas :
     *   - Affiche un message indiquant que le personnage a tué le monstre.
     *   - Ajoute des points au score du joueur.
     *   - Décrémente la vie du monstre.
     *   - Indique que le monstre est mort.
     *   - Décharge une munition de l'arme du personnage.
     *   - Affiche le nombre de minutes restantes dans l'arme du personnage.
     *   - Affiche le niveau de vie du monstre.
     * Si le résultat est 0, cela signifie que le monstre a touché le personnage. Dans ce cas :
     *   - Affiche un message indiquant que le monstre a touché le personnage.
     *   - Décrémente la vie du personnage.
     *   - Affiche le niveau de vie du personnage.
     *   - Affiche le niveau de vie du monstre.
     *
     * @param a             Le résultat du combat (0 pour une défaite, 1 pour une victoire).
     * @param armeMonstre   La liste d'instances de monstres
     * @param i             L'indice du monstre dans la liste.
     */
    private void test(int a, ArrayList<Monstre> armeMonstre, int i) {
        if (a == 1) {
            // Le personnage a vaincu le monstre
            this.menu.msgKillM(this.p.get_name()); // Affichage : le personnage tue le monstre
            this.addScore(); // Ajoute le score à chaque fois qu'il tue un monstre
            armeMonstre.get(i).decr_life(1); // Décrémente la vie du monstre
            armeMonstre.get(i).die(); // Indique que le monstre est mort
            this.p.armp.decharge_m(1); // Décharge son arme
            this.menu.msgMin(this.p.armp.get_m()); // Affichage : nombre des munitions restantes
            this.menu.msgLifeM(armeMonstre.get(i).life); // Affiche le niveau de vie du monstre
        } else {
            // Le monstre a touché le personnage
            this.menu.msgBeatP(this.p.get_name()); // Affichage : le monstre touche le personnage
            this.p.decr_life(1); // Décrémente la vie du personnage
            this.menu.msgLifeP(this.p.life); // Affichage : niveau de vie du personnage
            this.menu.msgLifeM(armeMonstre.get(i).life); // Affichage : niveau de vie du monstre
        }
    }
    /**
     * Méthode permettant au joueur de relancer une partie s'il le souhaite.
     * Elle réinitialise le personnage, l'arme du personnage, le monstre, génère une nouvelle armée de monstres,
     * et remet le score à zéro.
     */
    @Override
    public void reunit() {
        this.p.init(); // Réinitialise le personnage
        this.p.armp.init(); // Réinitialise l'arme du personnage
        this.m.init(); // Réinitialise le monstre
        this.addMonstre(this.m, this.armeMonstre, this.nbMonstre); // Génère une nouvelle armée de monstres
        this.score = 0; // Remet le score à zéro
    }
    /**
     * Relance le jeu en réinitialisant tous les attributs pour une nouvelle partie.
     * Affiche un menu à l'utilisateur pour décider s'il souhaite rejouer ou non.
     * Si l'utilisateur choisit de rejouer, fait appel à la méthode reunit() et appelle la méthode play().
     * 
     * @throws Exception En cas d'erreur lors du processus de replay.
     */
    @Override
    public void replay() {
        try {
            // Affiche un menu à l'utilisateur pour décider s'il souhaite rejouer
            int rep = menu.msgRec2();

            // Si l'utilisateur choisit de rejouer
            if (rep == 1) {
                // Réinitialise les attributs du jeu
                this.reunit();
                
                // Appelle la méthode play() pour commencer la nouvelle partie
                this.play();
            }
        } 
        catch (Exception e) {
            // Affiche la trace de la pile en cas d'exception
            e.printStackTrace();
        }
    }
    /**
     * Redéfinit la méthode start()
     */
    @Override
    public void start() {
        // Recharge 30 munitions pour le personnage.
        this.p.armp.recharger_m(30);

        // Affiche le nom du personnage et le nombre de munitions qu'il possède.
        this.menu.msgArmPch(this.p.get_name(), this.p.armp.get_m());

        // Initialise la vie du personnage à 20.
        this.p.incr_life(20);

        // Incrémente la vie du monstre de 1.
        this.m.incr_life(1);
    }
    /**
     * Méthode privée qui gère le passage au niveau difficile.
     * À ce niveau, le joueur doit combattre 20 monstres.
     */
    private void nivDiff() {

        this.startNivDiff();// affiche un message à la console précisant qu'on entre dans le niveau superieur du jeu 
        this.p.armp.decharge_m(this.p.armp.get_m());
        this.p.decr_life(this.p.life);
        this.m.decr_life(this.m.life);

        // Déplace le monstre dans la grotte .
        this.m.set_x(this.m.x + this.nbMonstre * 2);
        this.m.set_y(this.m.y + this.nbMonstre * 2);

        // Redémarre le niveau.
        this.start();

        // Initialise l'armée des monstres pour le niveau difficile.
        this.addMonstre(this.m, this.armeNivD, this.nbNivD);

        // Affiche le nombre de monstres à combattre.
        this.menu.msgNbM(this.nbNivD);

        // Commence le combat entre le personnage et les monstres.
        this.fightPersVsMonstres(this.p, this.armeNivD, this.nbNivD);
    }
    /**
     * Cette méthode gère le combat entre le personnage et les monstres.
     * Elle utilise les méthodes définies ci-dessus pour coordonner le déroulement du jeu.
     *
     * @param p Le personnage 
     * @param armeMonstre L'armée des monstres.
     * @param nbMonstre Le nombre de monstres dans la partie.
     */
    private void fightPersVsMonstres(Personnage p, ArrayList<Monstre> armeMonstre, int nbMonstre) {

        // Variable pour itérer à travers la boucle de combat.
        int i = 0;

        // Variable temporaire pour stocker des valeurs temporaires pendant le combat.
        int tmp;

        // Variable pour stocker la réponse de l'utilisateur.
        int rep;
        while(i < nbMonstre  && !this.stop(p)){ //stop() renvoie un booléen vérifiant si la vie du personnage =0
                if( armeMonstre.get(i).get_Id() % 10 == 0){
                    p.decr_life(p.life);
                    p.incr_life(20);
                    System.out.println(" \n°°°°°° Vous etes regeneré °°°°°°°\n");
                }
                this.renc(armeMonstre.get(i).x , armeMonstre.get(i).y);// pour deplacer le personnage vers l'arme des monstres
                this.menu.msgLifeP(p.life);//affichage : Niveau de vie du personnage 
                armeMonstre.get(i).setId(i); // Monstre Numero i dans la liste car je les différenncie par leurs indices 
                this.menu.msgIdM(armeMonstre.get(i).get_Id());//affichage : Monstre numero i
                this.menu.msgStart();//affichage : Debut du combat 
                System.out.println( p.get_name() + " ____ est en face du monstre :  ");
                try{
                    rep = this.menu.msgSuiv();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
                tmp = this.fight(); // renvoi soit 0 ou 1 . 
                this.test(tmp, armeMonstre , i ) ;// fais le test
                System.out.println ("\n\n ***************************************************************\n\n");
                while( tmp == 0 && !this.stop(p)){ // tant que le monstre n'est pas mort et le personnage aussi , on reste dans la boucle
                        System.out.println( " \n !!!!!!!! le monstre n'est pas encore mort : !!!!!  \n ") ;
                         try{
                            rep = this.menu.msgSuiv();
                        }
                        catch(Exception e){
                            e.printStackTrace();
                        }
                        System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
                        armeMonstre.get(i).setId(i);
                        this.menu.msgIdM(armeMonstre.get(i).get_Id()); //affichage : monstre numero i
                        tmp = this.fight();
                        this.test(tmp , armeMonstre , i ) ;
                System.out.println ("\n\n ***************************************************************\n\n");

                }
                if (!this.stop(p)){
                    i++;
                } 
                else{
                     break; // si le personnage est mort , on sort de la boucle et là , il perd la partie 
                }
        }

    }
    /**
     * Méthode qui gère le déroulement d'une partie complète.
     * Elle initialise le jeu, ajoute les monstres, gère les niveaux de difficulté,
     * et affiche le résultat de la partie à la fin.
     */
    @Override
    public void play() {

        // Variable pour stocker la réponse de l'utilisateur.
        int rep;

        // Démarre la partie en initialisant le jeu.
        this.start();

        // Initialise l'armée des monstres pour le niveau de base.
        this.addMonstre(this.m, this.armeMonstre, this.nbMonstre);

        // Affiche le nombre de monstres à combattre.
        this.menu.msgNbM(this.nbMonstre);

        // Lance le combat entre le personnage et les monstres.
        this.fightPersVsMonstres(this.p, this.armeMonstre, this.nbMonstre);

        // Vérifie si le joueur a réussi à passer le niveau de base.
        if (!this.stop(this.p)) {
            // Si le joueur a reussi, passe au niveau de difficulté supérieur.
            this.nivDiff();

            // Boucle pour permettre au joueur de rejouer le niveau en cas d'échec.
            while (this.stop(this.p)) {
                System.out.println(" \n\n °°°°°°°°°°Vous avez failli à votre mission à ce niveau °°°°°°°°°° ! \n" +
                        " Pour passer au niveau suivant, vous allez devoir rejouer ce niveau \n\n");

                try {
                    rep = this.menu.msgSuiv();

                    // Si le joueur choisit de rejouer, réinitialise le score et relance le niveau de difficulté.
                    if (rep == 1) {
                        this.score = 15;
                        this.nivDiff();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        // Affiche le résultat de la partie et le vainqueur.
        this.menu.msgAffWinner(stop(this.p));

        // Affiche le score final.
        this.menu.msgAffScore(this.score);

        // Affiche un message de fin de partie.
        this.menu.msgFin();
    }
}



