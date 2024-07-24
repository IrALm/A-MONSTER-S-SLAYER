package niveau;
/* **********************************************************************************
 * Cette partie du projet a été réalisé par AGANZE LWABOSHI MOISE le 21 octobre 2023
 ************************************************************************************/
import java.util.InputMismatchException;
import java.util.Scanner;
//******************************************************************************* */
//DEFINITION DE LA CLASSE MENU IMPLEMENTANT LA CLASSE INTERFACE InterText
/* Toutes les méthodes abstraites definies dans Intertxt sont implementés dans cette classe 
   EN GROS TOUT CE QUI CONCERNE L'AFFICHAGE A ETE IMPLEMENTE ICI */
//***************************************************************************************** */

public class Menu implements InterTxt{
    // constructeur
    public Menu(){}

/* **********************************************************************
 * L'IMPLEMENTATION DES METHODES
 ********************************************************************/
    @Override

    public int msgSuiv(){
        boolean bool;
        Scanner console = new Scanner(System.in) ;
        int s = 3;
        do{
            bool = true;
            try{
                 System.out.print("\n >>>>Taper 1 pour déclancher l'action : \n");
                s= console.nextInt();
                if(s != 1){
                    System.out.println("Mauvaise saisie! \n");
                    bool = false;
                }
            }
            catch(InputMismatchException e){
                System.out.println(" La saisie n'est pas un entier \n");
                console.nextLine();
                bool = false;
            }
        }
        while(!bool);
        return s;
    }
    @Override
    public void msgStart(String str){

        System.out.println(" \n BIENVENU   " + str + " . \n\n\n" +  " ¤ Vous vous appretez à jouer un jeu de combat.\n ¤ Tout au long de ce jeu , vous allez combattre des monstres : \n ¤ Du plus faible au plus rédoutable ! \n ¤ L'objectif étant de les éliminer tous jusqu'à la fin \n");
        System.out.println("\n ¤ Vos 4 amis : Loic , Abass , Cloe et Robin ont été capturés par Ces infroyables et impitoyables Monstres rancuniers \n ¤ ils sont emprisonés dans la grotte et n'entendent que votre héroisme pour etre libérer du malheur qui les accable.\n ¤ C'est ainsi que , cher " + str + " , vous etes convié à etre sans pitié\n ¤ Lors de ces combats sanguinaires qui vous attendent. ");
        this.msgSuiv();
    }
    @Override
    public void msgRegle(){
        int rep;
        System.out.println("\n#### |REGLE DU JEU : LEVEL 1 |#### \n");
        System.out.print("\n*******************************************************************************************************************************************\n");
        System.out.println("¤ Au debut de la partie ,\n¤ Votre niveau de vie est 20! \n¤ Vous etes muni d'un calibre 12 avec 30  Munitions rechargeables \n en fonction de votre évolution dans le jeu \n ");
        System.out.println("¤ Si le monstre vous touche, votre niveau de vie dimunie de 1 \n");
        System.out.println("¤ Si vous le toucher , vous le tuer \n ");
        System.out.println("¤ La partie se termine si vous arriver à eliminer tous les monstres! \n ");
        System.out.println("¤ S'ils vous tuent la partie se termine et , vous perdez !\n Ce level a un niveau facile  et un niveau difficile \n");
        System.out.println("¤ Votre mission à ce niveau est de libérer Loic\n ¤ Il a été capturé par les monstres et se retrouve pieger dans la grotte \n");
        System.out.println(" \n ******* Pret pour Demarrer la partie ? *******  \n ***** ALLEZ , LET'S GO !!!!! BONNE CHANCE *****  \n " );
        try{
            rep = this.msgSuiv(); 
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.print("\n************************************************************************************************************************************************\n");
    }
    @Override
    public void msgAffWinner( boolean a ){
        if (!a ){
            System.out.println(" \n FELICITATIONS !! VOUS AVEZ REMPORTER LA PARTIE \n") ;
            System.out.print("\n**********************************************************\n");
        }
        else{
            System.out.print("\nVOUS AVEZ PERDU\n");
            System.out.print("\n**********************************************************\n");
        }
    }
    @Override
    public void msgDplP(String str){ System.out.println(  " \n " + str + " se deplace \n --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n ");}
    @Override
    public void msgBeatM(String str){  System.out.println("\n ***** " + str + " touche le monstre \n ");}
    @Override
    public void msgMin(int a){ System.out.println( "\n ^^^^^ MUNITIONS RESTANS : " + a + "\n"); }
    @Override
    public void msgBeatP(String str){ System.out.println( " \n  ***** Le monstre touche " + str + "\n ");}
     @Override
    public void msgLifeP(int s){  System.out.println( " \n ¤¤¤¤¤ NIVEAU DE VIE : " + s + " \n");}
    @Override
    public void msgArmPch(String str , int a){ System.out.println ( " \n ||¤¤¤ ARME DE "  + str + " ¤¤¤ CHARGEE || ¤¤¤¤ MUNITION : " + a + "\n");}
    @Override
    public void msgStart(){ System.out.println(" \n [ ##### DEBUT COMBAT ####  ] \n ");}
    @Override
    public void msgNbM(int m){ System.out.println(" \n @@@ nombre des monstres à combattre : " + m + " \n");}
    @Override
    public void msgIdM(int m){ System.out.println("  \n ¨monstre numero ^ : " + m + " \n") ;}
    @Override
    public void msgNvL(int m){  System.out.println(" \n  ²²²monstre_vie : " + m + " \n");}
    @Override
    public void msgFin(){ System.out.println(" #### FIN DE LA PARTIE ####  ") ;}
    @Override
    public void msgAffScore(int i){ System.out.println(" \n ²²²²²Votre score est : " + i + " \n");}
    @Override
    public void msgEnd(){ System.out.println("\n#### |MERCI D'AVOIR JOUER !!! |####\n");}
    @Override
    public void msgKillM(String str){ System.out.println("\n °°°°° " +str+"  tue le monstre\n");}

    @Override
    public void msgrencP(String str){
        System.out.print("\n**********************************************************\n");
        System.out.println("\n" + str + " est arrivé ! \n ");
        System.out.print("\n**********************************************************\n");
    }        

    @Override
    public int msgRec(){
        boolean test;
        Scanner console = new Scanner(System.in) ;
        int s=2;
        do{
            test = true;
            try{
                System.out.println("\n *******TANT QUE VOUS N'AVEZ PAS REMPORTE LA PARTIE , VOUS NE POUVEZ PAS PASSEZ AU LEVEL SUIVANT *****  \n . TAPEZ 1 POUR REJOUER LA PARTIE :  \n  ");
                s = console.nextInt(); 
                if(s != 1){
                    System.out.println("Mauvaise saisie! \n");
                    test = false;
                }
            }
            catch(InputMismatchException e){
                System.out.println(" La saisie n'est pas un entier \n");
                console.nextLine();
                test = false;
            }
            
        }
        while(!test);
        return s;
    }
    public void msgLib( String str ){
        System.out.println( "\n ¤$¤$¤$¤$¤$¤$¤$¤$¤$¤$¤$¤$¤$¤$¤ " + str + " a été libérer grace à votre courage et votre lutte acharnée .\n");
    }
    public void msgBonusLevel1(){
        System.out.println( "\n ¤$¤$¤$¤$¤$¤$¤$¤$¤$¤$¤$¤ comme Bonus : vous avez debloqué dans la classe Arme  des Bombes £¤£¤£¤£¤£¤ \n ");
    }

//  CONCERNE LEVEL 2
@Override
 public void msgRegleLevel2(){
        
        int rep;
        System.out.println("\n#### |REGLE DU JEU : LEVEL 2 |#### \n");
        System.out.print("\n*************************************************************************************************************************************************\n ");
        System.out.print("\n FELICITATIONS! VOUS AVEZ ATTEINT LE LEVEL 2\n");
        System.out.println(" ¤ Au debut de cette partie ,\n ¤ Votre niveau de vie est 40 \n ¤ et vous etes munis d'un calibre 12  avace 30 minutions ainsi que de 5 grenades\n ");
        System.out.println(" ¤ Si le monstre vous touche en premier,\n ¤ votre niveau de vie dimunie de 5 \n");
        System.out.println(" ¤ Si vous lui tirer dessus  , vous l'affaiblissez. \n ¤ Si vous le toucher 5fois,\n ¤ vous le tuer.Si vous lui lancer une grenade, il meurt directement\n ");
        System.out.println(" ¤ La partie se termine si vous arriver à eliminer tous les monstres! \n ");
        System.out.println(" ¤ S'ils vous tuent la partie se termine et , vous perdez \n ¤ Comme au Levl précedent , ce level a un niveau facile et un difficile\n");
        System.out.println(" \n ******* Pret pour Demarrer la partie ? *******  \n ***** ALLEZ , LET'S GO !!!!! BONNE CHANCE *****  \n " );
        System.out.println("¤ Votre mission à ce niveau est de libérer Abass \n ¤ Il a été capturé par les monstres et se retrouve pieger dans la grotte \n");
        try{
            rep = this.msgSuiv();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.print("\n***************************************************************************************************************************************************\n");
 }
    @Override
    public int msgRec2(){
        boolean test;
        Scanner console = new Scanner(System.in) ;
        int s=2;
        do{
            test = true;
            try{
                System.out.println(" \n### VOULEZ-VOUS REJOUER LA PARTIE ? \n taper 1 si oui , tapez 0 sinon :  ");
                s = console.nextInt(); 
                if(s != 1 && s!=0 ){
                    System.out.println("Mauvaise saisie! \n");
                    test = false;
                }
            }
            catch(InputMismatchException e){
                System.out.println(" La saisie n'est pas un entier \n");
                console.nextLine();
                test = false;
            }
            
        }
        while(!test);
        return s;
    }
    @Override
    public void msgB(int a){ System.out.println(" °°°BOMBE RESTANT : " + a);}
    @Override
    public void msgLifeM(int i ){ System.out.println(" °°°MONSTRE VIE : " + i ) ;}
    @Override
    public void msgArmPchl2(String str , int a , int b){ System.out.println ( " \n ¤¤¤¤¤ARME DE "  + str + " ¤¤¤¤¤¤¤¤CHARGE , MINUTION : " + a + "  BOMBE : " + b);}
    public void msgBonusLevel2(){
        System.out.println( "\n ¤$¤$¤$¤$¤$¤$¤$¤$¤$¤$¤$¤ comme Bonus : vous avez debloqué dans la classe Arme  Un bouclier de protection  £¤£¤£¤£¤£¤ \n ");
    }
    /* concerne le level 3 */
    @Override
    public void msgRegleLevel3(){
        
        int rep;
        System.out.println("\n#### |REGLE DU JEU : LEVEL 3 |#### \n");
        System.out.print("\n***************************************************************************************************************************************************\n");
        System.out.print("\n FELICITATIONS! VOUS AVEZ ATTEINT LE LEVEL 3\n");
        System.out.println(" ¤ Au debut de cette partie ,\n ¤ Votre niveau de vie est 40 \n ¤ et vous etes munis d'un calibre 12 avace 30 munitions ainsi que de 5 grenades\n ¤ avec un bouclier supplementaire vous permettant d'esquiver les couts de monstres\n ¤ Mais attention , il est succeptible d'etre casser\n");
        System.out.println(" ¤ Si le monstre vous touche en premier,\n ¤ votre niveau de vie dimunie de 5 \n");
        System.out.println(" ¤ Si vous lui tirer dessus  , vous l'affaiblissez. \n ¤ Si vous le toucher 15fois,\n ¤ vous le tuer\n. ¤ Si vous lui lancer une grenade, vous l'affaiblissez d'avantage\n ");
        System.out.println(" ¤ La partie se termine si vous arriver à eliminer le dernier monstre. \n ¤ Attention, dans cette partie , les monstres sont de plus en plus fort au fur et à mesure que vous etes entrain d'evoluer .\n");
        System.out.println(" ¤ Si le monstre vous tue , vous perdez \n");
        System.out.println(" \n ******* Pret pour Demarrer la partie ? *******  \n ***** ALLEZ , LET'S GO !!!!! BONNE CHANCE *****  \n " );
        System.out.println("¤ Votre mission à ce niveau est de libérer Cloe et Robin\n ¤ Les deux pauvres innocents ont été capturés par les monstres et se retrouvent pieger dans la grotte \n");
        try{
            rep = this.msgSuiv();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.print("\n***************************************************************************************************************************************************\n");
   }
    public int msgFindAntidote(){
        boolean bool;
        Scanner console = new Scanner(System.in) ;
        int s = 3;
        do{
            bool = true;
            try{
                System.out.println("\n OUPS! Lors de votre affrontement avec le monstre , vous avez été empoisoné!\n");
                System.out.println("\nTapez 1 pour aller chercher le remède : \n");
                s= console.nextInt();
                if(s != 1){
                    System.out.println("Mauvaise saisie! \n");
                    bool = false;
                }
            }
            catch(InputMismatchException e){
                System.out.println(" La saisie n'est pas un entier \n");
                console.nextLine();
                bool = false;
            }
        }
        while(!bool);
        return s;
    }
    public int msgWinBattle(){
        boolean bool;
        Scanner console = new Scanner(System.in) ;
        int s = 3;
        do{
            bool = true;
            try{
                System.out.println("\n FELICITATIONS , VOUS AVEZ ELIMINE LE  TROL \n");
                System.out.println("\n Lors de votre prochain combat ,\n le monstre que vous allez affronter est plus redoutable que ce précedent!\n");
                System.out.println("\n >>>>>Tapez 1 pour poursuivre le jeu :   \n");
                s= console.nextInt();
                if(s != 1){
                    System.out.println("Mauvaise saisie! \n");
                    bool = false;
                }
            }
            catch(InputMismatchException e){
                System.out.println(" La saisie n'est pas un entier \n");
                console.nextLine();
                bool = false;
            }
        }
        while(!bool);
        System.out.print("\n**********************************************************\n");
        return s;
    }
    public void msgArmPchl3(String str , int a , int b ,int d){ System.out.println ( " \n ¤¤¤¤¤ARME DE "  + str + " ¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤CHARGE , MINUTION : " + a + "  BOMBE : " + b + " RESISTANCE BOUCLIER : " + d );}

}