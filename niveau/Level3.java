


package niveau;
/**
 * Représente le troisième level  du jeu, étendant la classe Game.
 */
public class Level3 extends Game {

    /* ATTRIBUTS DE LA CLASSE */

    private Troll tr;
    private int qte_venin;
    private int antidote;

    /**
     * Constructeur de la classe Level3.
     * @param p Le personnage 
     * @param t Le Troll 
     */
    public Level3(Personnage p, Troll t) {
        super(p);
        this.tr = t;
        this.qte_venin = 0;
        this.antidote = this.tr.poison;
    }

    /**
     * Ajoute une quantité de venin 
     * @param a La quantité de venin à ajouter.
     */
    public void addPoison(int a) {
        this.qte_venin += a;
    }

    /**
     * Diminue la quantité de venin 
     * @param a La quantité de venin à retirer.
     */
    public void remPoison(int a) {
        this.qte_venin -= a;
    }

    /**
     * Override de la méthode fight de la classe Game.
     * Effectue un combat avec le Troll, générant un nombre aléatoire.
     * @return Un entier représentant le résultat du combat :
     *         2 : la vie du Troll diminue de 5,
     *         1 : le joueur touche le Troll (il le touche avec -1),
     *         0 : le joueur est touché par le Troll (diminue de 5),
     *         3 : le joueur touche le Troll mais il est protégé (résistance du bouclier diminue de 1).
     *         Si le bouclier se casse, le joueur est empoisonné et doit chercher le remède.
     */
    @Override
    public int fight() {
        return (int) (Math.random() * 4);
    }
    /**
     * Méthode permettant de faire les tests au Level 3
     * @param a l'entier retourné par la méthode fight()
     * @param tr le troll 
     */
    private void test( int a , Troll tr){
        
        if ( a == 1){
            this.menu.msgBeatM(this.p.get_name());//affichage
            tr.decr_life(1);// decremente la vie du troll
            this.menu.msgLifeM(tr.life);//affichage 
            tr.decr_f(1);// decremente sa force
            if(this.tr.life==0){
                tr.die();// le troll est mort
                this.addScore();//ajoute le score 
            }
            
            this.p.armp.decharge_m(1);
            if(this.p.armp.get_m() <= 0 ){
                this.p.armp.recharger_m(30);// recharge les minutions
                System.out.println("°°° Minutions rechargées °°°");
                System.out.println("-----------------------------");
            } 
            this.menu.msgMin(this.p.armp.get_m());//afficfage
            this.menu.msgB(this.p.armp.get_b());//affichage

        }
        else if(a == 2){
            if(this.tr.life > 5){
                this.menu.msgBeatM(this.p.get_name());// affichage à la console
                System.out.println(" en lui lancant une grenade");
                System.out.println("------------------------------------------------------------");
                tr.decr_life(5);// decremente la vie
                tr.decr_f(1);// decremente la force 
                this.menu.msgLifeM(tr.life);//affichage
                this.p.armp.decharge_b(1);
                if(this.p.armp.get_b() == 0 ){
                    this.p.armp.recharger_b(5);// recharge les bombes 
                    System.out.println("°°Bombe rechargé°°");
                    System.out.println("-------------------");
                }
            }
            else{
                this.menu.msgKillM(this.p.get_name());// affichage
                tr.decr_life(tr.life);// decremente la vie 
                tr.decr_f(tr.get_f());// decremente la force 
                tr.die();// le troll meurt
                this.p.armp.decharge_b(1);// decharge les bombes
                if(this.p.armp.get_b() == 0 ){
                        this.p.armp.recharger_b(5);// recharge les bombes 
                        System.out.println("°°Bombe rechargé°°");
                        System.out.println("-------------------");
                }
                this.addScore();//ajoute le score 
                this.menu.msgB(this.p.armp.get_b());//affichage
                this.menu.msgLifeM(tr.life);//affichage
            }
            
        }
        
        else if( a == 3 ){
                if(this.p.armp.get_res_bouclier() > 0){
                    System.out.println( this.p.get_name() + " ¤¤¤esquive le cout¤¤¤ " ) ;
                    System.out.println("-------------------------------------------------");
                    this.p.armp.dim_res_bc();// diminue la resistance du bouclier
                }
                else{
                    this.menu.msgBeatP(this.p.get_name());//affichage
                    this.p.decr_life(tr.get_f());//decrémente la vie du personnage
                    if(this.p.life > 0){
                        this.menu.msgLifeP(this.p.life);//afficfage : affiche le niveau de vie du personnage 
    
                    }
                    this.menu.msgLifeM(tr.life);//affichage
                    System.out.println(" ̣!!!****  "+this.p.get_name() + " est empoisonné  ****!!! ");
                    System.out.println("-------------------------------------------------------------");
                    this.addPoison(5);// ajoute le poison dans l'organisme
                }
        }
        else{
                this.menu.msgBeatP(this.p.get_name());//afficfage
                this.p.decr_life(tr.get_f());// decrémente la vie du personnage
                if(this.p.life > 0){
                    this.menu.msgLifeP(this.p.life);//afficfage : affiche le niveau de vie du personnage 

                }
                this.menu.msgLifeM(tr.life);//affichage
            }
    }
    /**
     * Réinitialise les éléments du jeu pour une nouvelle partie du Level 3.
     * Réinitialise le personnage, les munitions, le Troll ennemi et le score.
     */
    @Override
    public void reunit() {
        // Réinitialise le personnage
        this.p.init();

        // Réinitialise les munitions du personnage
        this.p.armp.init();

        // Réinitialise le Troll 
        this.tr.init();

        // Réinitialise le score
        this.score = 0;
    }
    /**
     * Permet au joueur de décider s'il veut rejouer le level 3 du jeu après la fin d'une partie.
     * Affiche un message de demande à l'utilisateur , en cas de réponse positive,
     * réinitialise le jeu et relance une nouvelle partie. Si la réponse est négative,
     * affiche un message de fin de jeu.
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
            } else {
                // Si la réponse est négative, affiche un message de fin de jeu
                this.menu.msgEnd();
            }
        } catch (Exception e) {
            // En cas d'erreur, imprime la trace de la pile
            e.printStackTrace();
        }
    }
    /**
     * Vérifie l'état du personnage après une action, telle qu'un combat ou la recherche d'un antidote.
     * Si la vie du personnage est inférieure ou égale à zéro, affiche le résultat de la partie,
     * le score, et propose de rejouer. Sinon, affiche des messages de victoire,
     * libère un premier ami, et propose de rechercher un antidote si le joueur a du venin.
     * @param x La coordonnée x du personnage.
     * @param y La coordonnée y du personnage.
     * @param str Le message à afficher lors de la libération du premier ami.
     */
    private void verif(double x, double y, String str) {
        // Si la vie du personnage est inférieure ou égale à zéro, affiche le résultat de la partie et propose de rejouer
        if (this.p.life <= 0) {
            this.menu.msgAffWinner(stop(this.p));
            this.menu.msgAffScore(this.score);
            this.menu.msgFin();
            this.replay();
        } else {
            // Si le personnage est en vie, affiche des messages de victoire
            this.menu.msgWinBattle();
            this.menu.msgLib(str);

            // Si le personnage a du venin, propose de rechercher un antidote
            if (this.qte_venin > 0) {
                this.menu.msgFindAntidote();
                // Tant que le personnage a du venin, recherche un antidote
                while (this.qte_venin > 0) {
                    this.findAntidote(x, y);
                }
            }
        }
    }
    /** 
     * Methode privée pour simuler un combat entre le personnage et le troll 
     * @param tmp l'entier retourné par la méthode fight()
     * @param copy1 le troll à combattre 
     */
    private void fightPersVsTroll(int tmp , Troll copy1){
        System.out.println(" vie_troll : " +copy1.get_Id() + "  " + copy1.life);
         while( this.p.life > 0 &&  copy1.life >0){
                if(this.p.life < 15){
                    this.p.incr_life(20);
                    System.out.println(" \n°°°°°° Vous etes regeneré °°°°°°°\n");
                }
                tmp = this.fight();
                this.test(tmp,copy1) ;
                if(this.p.life <=0){
                        System.out.println("\nVOUS ETES MORT\n");
                        System.out.println("-------------------");
                }
                if(copy1.life <= 0){
                    System.out.println("\n LE TROL EST MORT ^ " + copy1.get_Id() +"\n");
                    System.out.println("-------------------------");
                }
                System.out.println("Poison dans l'organisme du personnage : " + this.qte_venin);
                System.out.println("-----------------------------------------------------------");
         }
    }
    /**
     * methode privée permettant au personnage d'aller chercher l'antidote dans la grotte
     * @param x abscisse
     * @param y oordonnée 
     * */    
    private void findAntidote(double x , double y){
                int rep ;
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                System.out.println("Vous devez aller chercher le remede ! il se trouve à la position: ( " + x + " , " + y + " )");
                try{
                    rep = this.menu.msgSuiv();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                this.renc(x,y);
                System.out.println(" \n ^^^^^^^^^^^Antidote trouvé : prenez le!^^^^^^^^^\n ");
                try{
                    rep = this.menu.msgSuiv();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                this.remPoison(5);
                if(this.qte_venin > 0){
                    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                    System.out.println("!!!! ¨¨¨¨ il vous reste du venin dans l'organisme ¨¨¨!!!! \n~~~~~ Vous devez chercher un autre antidote ~~~~~~~ \n");
                    x = x +(Math.random()* 30);
                    y = y +(Math.random()* 50);
                    System.out.println("Vous devez aller chercher le remede ! il se trouve à la position:  ( " + x + " , " + y + " ) \n");
                    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                    try{
                        rep = this.menu.msgSuiv();
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                    this.renc(x,y);
                    System.out.println(" \n ^^^^^^^^^^^^Antidote trouve : prenez le! ^^^^^^^^ \n ");
                    try{
                        rep = this.menu.msgSuiv();
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                    this.remPoison(5) ;
                }
    }
    /**
     * Initialise le niveau 3 en effectuant les opérations nécessaires :
     * décharge les bombes et munitions du personnage, recharge les munitions et bombes,
     * affiche le statut du personnage (nom, munitions, bombes, résistance du bouclier),
     * remet la vie du personnage à zéro, initialise son niveau de vie à 40,
     * affiche le niveau de vie du personnage, incrémente la vie du Troll ennemi,
     * et affiche un message de début de combat.
     */
    @Override
    public void start() {
        // Décharge les bombes du personnage
        this.p.armp.decharge_b(this.p.armp.get_b());

        // Décharge les munitions du personnage
        this.p.armp.decharge_m(this.p.armp.get_m());

        // Recharge les munitions du personnage (30 munitions)
        this.p.armp.recharger_m(30);

        // Recharge les bombes du personnage (5 bombes)
        this.p.armp.recharger_b(5);

        // Affiche le statut du personnage (nom, munitions, bombes, résistance du bouclier)
        this.menu.msgArmPchl3(this.p.get_name(), this.p.armp.get_m(), this.p.armp.get_b(), this.p.armp.get_res_bouclier());

        // Remet la vie du personnage à 0
        this.p.decr_life(this.p.life);

        // Initialise le niveau de vie du personnage à 40
        this.p.incr_life(40);

        // Affiche le niveau de vie du personnage
        this.menu.msgLifeP(this.p.life);

        // Incrémente la vie du Troll ennemi de 15
        this.tr.incr_life(15);

        // Affiche le message de début de combat
        this.menu.msgStart();
    }
    /**
     * Méthode principale pour jouer au Level 3 du jeu. La séquence du jeu comprend les étapes suivantes :
     * 1. Initialisation du niveau avec la méthode start.
     * 2. Augmentation de la résistance du bouclier du personnage.
     * 3. Création d'un Troll clone, rencontre avec le premier ami, combat et vérification de l'état du personnage.
     * 4. Libération de la mémoire du Troll clone.
     * 5. Décrémentation et incrémentation de la vie du personnage, réinitialisation du niveau avec la méthode start.
     * 6. Création d'un deuxième Troll clone, rencontre, combat et vérification de l'état du personnage.
     * 7. Libération de la mémoire du deuxième Troll clone.
     * 8. Décrémentation et incrémentation de la vie du personnage, réinitialisation du niveau avec la méthode start.
     * 9. Création d'un troisième Troll clone, rencontre, combat et vérification de l'état du personnage.
     * 10. Affichage du résultat de la partie, du score et du message de fin.
     */
    @Override
    public void play() {
        String str1 = " Cloe";
        String str2 = " Robin ";
        int tmp = 0;
        double x, y;

        // Initialise le niveau
        this.start();

        // Augmente la résistance du bouclier du personnage
        this.p.armp.augm_res_bc(5);

        // Crée un clone du Troll
        Troll copy1 = tr.clone();
        copy1.setId(0);
        x = copy1.x + (Math.random() * 30);
        y = copy1.y + (Math.random() * 50);

        // Rencontre avec le premier ami, combat et vérification de l'état du personnage
        this.renc(copy1.x, copy1.y);
        this.fightPersVsTroll(tmp, copy1);
        this.verif(x, y, str1);
        copy1 = null;

        // Décrémente et incrémente la vie du personnage, réinitialise le niveau
        this.p.decr_life(this.p.life);
        this.p.incr_life(40);

        // Crée un deuxième clone du Troll
        Troll copy2 = tr.clone();
        copy2.setId(1);
        copy2.set_x(x + 50);
        copy2.set_y(y + 52);
        x = copy2.x + (Math.random() * 30);
        y = copy2.y + (Math.random() * 50);

        // Affiche le statut du personnage et le niveau de vie
        this.menu.msgArmPchl2(this.p.get_name(), this.p.armp.get_m(), this.p.armp.get_b());//affichage
        this.menu.msgLifeP(this.p.life);//affichage
        this.menu.msgStart();//affichage

        // Rencontre avec le deuxième ami, combat et vérification de l'état du personnage
        this.renc(copy2.x, copy2.y);
        this.fightPersVsTroll(tmp, copy2);
        this.verif(x, y, str2);
        copy2 = null;

        // Décrémente et incrémente la vie du personnage, réinitialise le niveau
        this.p.decr_life(this.p.life);
        this.p.incr_life(40);

        // Crée un troisième clone du Troll
        Troll copy3 = tr.clone();
        copy3.setId(2);
        copy3.set_x(x + 80);
        copy3.set_y(y + 82);
        copy3.incr_f(10);
        x = copy3.x + (Math.random() * 30);
        y = copy3.y + (Math.random() * 50);

        // Affiche le statut du personnage et le niveau de vie
        this.menu.msgArmPchl2(this.p.get_name(), this.p.armp.get_m(), this.p.armp.get_b());//afficfage
        this.menu.msgLifeP(this.p.life);//affichage
        this.menu.msgStart();//affichage

        // Rencontre avec le troisième ami, combat et vérification de l'état du personnage
        this.renc(copy3.x, copy3.y);

        // Idem une troisième fois où cette fois il doit libérer le dernier et affronter le monstre final
        this.fightPersVsTroll(tmp, copy3);

        // Affiche le résultat de la partie, le score et le message de fin
        this.menu.msgAffWinner(stop(this.p));//affichage
        this.menu.msgAffScore(this.score);//affichage
        this.menu.msgFin();//affichage
    }

}


