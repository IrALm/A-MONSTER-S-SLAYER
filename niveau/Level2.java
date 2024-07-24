

package niveau;
import java.util.ArrayList;

/**
 * Représente le deuxième level du jeu, étendant la classe Game.
 */
public class Level2 extends Game {

    /* ATTRIBUTS DE LA CLASSE */

    private GeantMonstre ml2;
    private ArrayList<GeantMonstre> gm , gmNivD;
    private int nbGm , nbNivD;

    /**
     * Constructeur de la classe Level2.
     * @param p Le personnage 
     * @param ml2 Le monstre géant du niveau 2.
     */
    public Level2(Personnage p , GeantMonstre ml2  ){
        super(p);
        this.ml2 = ml2;
        this.gm = new ArrayList<GeantMonstre>();
        this.gmNivD = new ArrayList<GeantMonstre>();
        this.nbGm = 15 ;
        this.nbNivD = 20 ;
    }

    /* DÉFINITION ET IMPLÉMENTATION DES MÉTHODES */
    /* pour générer une armée des monstres */

    /**
     * Ajoute des monstres à la liste donnée.
     * @param ml2 Le prototype du monstre géant à cloner.
     * @param gm La liste où ajouter les monstres.
     * @param nbGm Le nombre de monstres à ajouter.
     */
    private void addMonstre(GeantMonstre ml2, ArrayList<GeantMonstre> gm, int nbGm){
        GeantMonstre copy;
        for (int i = 0; i < nbGm; i++ ){
            copy = ml2.clone();
            copy.setId(i);
            copy.set_x((i + 1) * 2);
            copy.set_y((i + 1) * 2);
            gm.add(i, copy);
        }
    }

    /**
     * Remplace la méthode fight de la classe Game.
     * @return Un entier représentant le résultat du combat.
     *         2 : monstre tué, 1 : monstre touché, 0 : échec.
     */
    @Override
    public int fight(){
        return (int) (Math.random() * 3); // Nombre entre 0 et 2 : 2 (tuer), 1 (toucher), 0 (échouer).
    }
    /**
     * Méthode de test basée sur le résultat du combat retourné par la méthode fight().
     * Si le résultat est 1, cela signifie que le personnage a touché le monstre. Dans ce cas :
     *   - Affiche un message indiquant que le personnage a touché le monstre.
     *   - Décrémente la vie du monstre.
     *   - Décharge une munition de l'arme du personnage.
     *   - Affiche le nombre de minutions restantes dans l'arme du personnage.
     *   - Affiche le niveau de vie du monstre.
     * Si le résultat est 0, cela signifie que le monstre a touché le personnage. Dans ce cas :
     *   - Affiche un message indiquant que le monstre a touché le personnage.
     *   - Décrémente la vie du personnage.
     *   - Affiche le niveau de vie du personnage.
     *   - Affiche le niveau de vie du monstre.
     * Si le resultat est 2 :
     *   - Le personnage a tué le monstre 
     *     suivie des messages d'affichage comme au cas précédent.... 
     *
     * @param a             Le résultat du combat (0 pour une défaite, 1 pour une victoire).
     * @param armeMonstre   La liste d'instances de monstres
     * @param i             L'indice du monstre dans la liste.
     */
    private void test( int a , ArrayList<GeantMonstre> gm ,  int i ){
        
        if ( a == 1){
            this.menu.msgBeatM(this.p.get_name());//affichage: le personnage touche le monstre
            gm.get(i).decr_life(1);// decrémenter la vie du monstre de 1
            this.menu.msgLifeM(gm.get(i).life);//affichage niveau de vie du monstre
            gm.get(i).decr_f(1);//decremente la force du monstre de 1 une fois qu'il a été touché
            if(gm.get(i).life==0){
                gm.get(i).die();
                this.addScore();//une fois le monstre mort , on incrémente le score
            }
            
            this.p.armp.decharge_m(1);//on decharge les minutions de 1 à chaque du personnage
            if(this.p.armp.get_m() == 0 ){
                this.p.armp.recharger_m(30);
                System.out.println("°°° Minutions rechargées °°°");
                System.out.println("------------------------------");
            } 
            this.menu.msgMin(this.p.armp.get_m());//afficfage : nombre des minutions restants
            this.menu.msgB(this.p.armp.get_b());//affichage : nombre des bombes restants

        }
        else if(a == 2){
            this.menu.msgKillM(this.p.get_name());//affichage : le personnage tue le monstre
            gm.get(i).decr_life(gm.get(i).life);// décrementer la vie du monstre
            gm.get(i).decr_f(gm.get(i).get_f());// reduire sa force 
            gm.get(i).die();// le monstre meurt
            this.p.armp.decharge_b(1);//decharger bombe de -1
            if(this.p.armp.get_b() == 0 ){
                    this.p.armp.recharger_b(5);// recharge les bombes
                    System.out.println("°°°Bombe rechargé°°°") ;
                    System.out.println("-------------------");
            }
            this.addScore();// ajoute le score
            this.menu.msgB(this.p.armp.get_b());//affichage: nombre des bombes restants 
            this.menu.msgLifeM(gm.get(i).life);//affichage: niveau de vie du monstre
        }
        else{
                this.menu.msgBeatP(this.p.get_name());//afficfage: le monstre touche le personnage
                this.p.decr_life(gm.get(i).get_f());// decremente la vie du personnage
                if(this.p.life > 0){
                    this.menu.msgLifeP(this.p.life);//afficfage : affiche le niveau de vie du personnage 

                }
                this.menu.msgLifeM(gm.get(i).life);//affichage : le niveau de vie du monstre
            }
    }
    /**
     * Cette méthode gère le combat entre le personnage et les monstres.
     * Elle utilise les méthodes définies ci-dessus pour coordonner le déroulement du jeu.
     *
     * @param p Le personnage 
     * @param gm L'armée des monstres.
     * @param nbGm Le nombre de monstres dans la partie.
     */

    private void fightPersVsMonstre( Personnage p , ArrayList<GeantMonstre> gm , int nbGm){
        int rep ;
        int i = 0 ;
        int tmp ;
        while(i < nbGm  && !this.stop(p)){
                if( gm.get(i).get_Id() % 5 == 0 ){
                    p.decr_life(p.life);
                    p.incr_life(40);
                    System.out.println(" \n°°°°°° Vous etes regeneré °°°°°°°\n");
                }
                this.renc(gm.get(i).x , gm.get(i).y);// deplacer le personnage jusqu'à la position des monstres 
                gm.get(i).setId(i);//monstre numero i
                this.menu.msgIdM(gm.get(i).get_Id());//afficfage : monstre numero i
                this.menu.msgStart();
                System.out.println( p.get_name() + " ____ est en face du monstre :  ");
                try{
                    rep = this.menu.msgSuiv();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
                tmp = this.fight();// combat
                this.test(tmp,gm, i ) ;// faire des tests
                if(p.life <=0){
                            System.out.println("\nVOUS ETES MORT\n");
                }
                while( tmp < 2 && p.life > 0 && gm.get(i).life != 0){
                        System.out.println( " \n !!!!!!!! le monstre n'est pas encore mort : !!!!!  \n ") ;
                         try{
                            rep = this.menu.msgSuiv();
                        }
                        catch(Exception e){
                            e.printStackTrace();
                        }
                        System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
                        gm.get(i).setId(i);//monstre numero i
                        this.menu.msgIdM(gm.get(i).get_Id()); //afficfage:monstre numero i
                        tmp = this.fight();// combat
                        this.test(tmp , gm , i ) ;//faire des tests
                        if( p.life <=0){
                            System.out.println("\nVOUS ETES MORT\n");
                        }
                }
                if ( p.life > 0){
                    i++;
                    System.out.println( "\n******************************************************************************\n");
                }
                else{
                     break;// si le personnage est mort , on sort de la boucle et là , il perd la partie 
                }
        }
    }
    /**
     * Démarre le niveau en effectuant les initialisations nécessaires,
     * rechargeant les munitions et bombes du personnage, ajustant la vie du personnage,
     * incrémentant la vie du monstre, et affichant des informations de départ.
     */
    @Override
    public void start() {
        // Décharge toutes les munitions du personnage
        this.p.armp.decharge_m(this.p.armp.get_m());

        // Recharge les munitions du personnage (30 munitions)
        this.p.armp.recharger_m(30);

        // Recharge les bombes du personnage (5 bombes)
        this.p.armp.recharger_b(5);

        // Affiche le statut du personnage (nom, munitions, bombes)
        this.menu.msgArmPchl2(this.p.get_name(), this.p.armp.get_m(), this.p.armp.get_b());

        // Remet la vie du personnage à 0
        this.p.decr_life(this.p.life);

        // Incrémente la vie du personnage de 40
        this.p.incr_life(40);

        // Affiche le niveau de vie du personnage
        this.menu.msgLifeP(this.p.life);

        // Incrémente la vie du monstre de 5
        this.ml2.incr_life(5);

        // Affiche le message de début de combat
        this.menu.msgStart();
    }

    /**
     * Réinitialise les éléments du jeu en réinitialisant le personnage,
     * les munitions, le monstre et le score pour une nouvelle partie.
     */
    @Override
    public void reunit() {
        // Réinitialise le personnage
        this.p.init();

        // Réinitialise les munitions du personnage
        this.p.armp.init();

        // Réinitialise le monstre
        this.ml2.init();

        // Réinitialise le score
        this.score = 0;
    }
    /**
     * Permet au joueur de rejouer au level 2 du jeu après la fin d'une partie.
     * Affiche un message de demande à la console, en cas de réponse positive,
     * réinitialise le jeu et relance une nouvelle partie.
     */
    @Override
    public void replay() {
        try {
            // Demande au joueur s'il souhaite rejouer
            int rep = menu.msgRec2();

            // Si la réponse est positive (1), réinitialise le jeu et relance une partie
            if (rep == 1) {
                this.reunit();
                this.play();
            }
        } catch (Exception e) {
            // En cas d'erreur, imprime la trace de la pile
            e.printStackTrace();
        }
    }
    /**
     * Méthode privée qui gère le passage au niveau difficile.
     * À ce niveau, le joueur doit combattre 20 monstres.
     */
    private void nivDiff(){
        
            this.startNivDiff();// affiche un message à la console   précisant qu'on entre dans le niveau superieur du jeu        
            this.p.armp.decharge_m(this.p.armp.get_m());
            this.p.armp.decharge_b(this.p.armp.get_b());
            this.p.decr_life(this.p.life);
            this.ml2.decr_life(this.ml2.life);
            this.ml2.set_x( this.ml2.x + this.nbGm * 2) ;
            this.ml2.set_y(this.ml2.y + this.nbGm * 2) ;
            this.start();
            this.addMonstre( this.ml2 , this.gmNivD , this.nbNivD );// crée l'armée des monstres 
            this.menu.msgNbM(this.nbNivD);//afficfage : nbre des monstres à affronter
            this.fightPersVsMonstre( this.p , this.gmNivD , this.nbNivD );

    }
    /**
     * Méthode principale pour jouer au niveau du jeu. La séquence du jeu comprend les étapes suivantes :
     * 1. Initialisation du niveau avec la méthode start.
     * 2. Ajout des monstres avec la méthode addMonstre.
     * 3. Affichage du nombre de monstres à affronter.
     * 4. Combat entre le personnage et les monstres avec la méthode fightPersVsMonstre.
     * 5. Si le personnage perd, propose une option pour rejouer et réinitialiser le niveau.
     * 6. Si le personnage réussit, affiche le message de victoire, le score et termine le jeu.
     */
    @Override
    public void play() {
        int rep;

        // Initialise le niveau
        this.start();

        // Ajoute les monstres
        this.addMonstre(this.ml2, this.gm, this.nbGm);

        // Affiche le nombre de monstres à affronter
        this.menu.msgNbM(this.nbGm);

        // Combat entre le personnage et les monstres
        this.fightPersVsMonstre(this.p, this.gm, this.nbGm);

        // Si le personnage ne réussit pas le niveau
        if (!this.stop(this.p)) {
            this.nivDiff();

            // Boucle tant que le personnage échoue
            while (this.stop(this.p)) {
                System.out.println(" \n\n °°°°°°°°°°Vous avez failli à votre mission à ce niveau °°°°°°°°°° ! \n Pour passer au level supérieur, vous allez devoir rejouer ce niveau \n\n");
                try {
                    // Propose de rejouer le niveau
                    rep = this.menu.msgSuiv();
                    if (rep == 1) {
                        this.score = 15;
                        this.nivDiff();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        // Affiche le message de fin en fonction du résultat du jeu
        this.menu.msgAffWinner(stop(this.p));

        // Affiche le score obtenu
        this.menu.msgAffScore(this.score);

        // Affiche le message de fin du jeu
        this.menu.msgFin();
    }

}

