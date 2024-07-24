/* **********************************************************************************
 * Cette partie du projet a été réalisée par AGANZE LWABOSHI MOISE le 21 octobre 2023 
 ************************************************************************************/

package niveau;

import java.util.Scanner;

/**
 * Classe Application représentant le point d'entrée du programme.
 */
public class Application {
    /**
     * Méthode principale, point d'entrée du programme.
     *
     * @param args Les arguments de la ligne de commande.
     */
    public static void main(String[] args) {
        String name;
        Menu menu = new Menu();
        Scanner console = new Scanner(System.in);
        System.out.println("\n\n\n¤¤¤¤¤¤¤¤¤A Monst£r's $lay£r ¤¤¤¤¤¤¤¤¤¤¤ \n ");
        System.out.print("---------------------------------------\n");
        System.out.println("CREE LE NOM DE VOTRE PERSONNAGE : ");
        name = console.next();
        System.out.print("\n---------------------------------------\n");

        // création du personnage
        Personnage p = new Personnage(name, 0, 0, 0);

        // simulation level1
        
        Monstre m = new Monstre(1 + (Math.random() * 50), 1 + (Math.random() * 50), 0);
        Level1 g = new Level1(p, m);
        menu.msgStart(name);
        menu.msgRegle();
        g.play();
        while (p.life <= 0) {
            menu.msgRec();
            g.reunit();
            g.play();
        }
        menu.msgLib("Loic");
        menu.msgBonusLevel1();
        g.replay();

        // simulation level 2

        GeantMonstre ml2 = new GeantMonstre(m.x + (Math.random() * 100), m.y + (Math.random() * 100), 0);
        Level2 g2 = new Level2(p, ml2);
        menu.msgRegleLevel2();
        g2.play();
        while (p.life <= 0) {
            menu.msgRec();
            g2.reunit();
            g2.play();
        }
        menu.msgLib("Abass");
        menu.msgBonusLevel2();
        g2.replay();

        // simulation level 3

        Troll tr = new Troll(ml2.x + (Math.random() * 100), ml2.y + (Math.random() * 100), 0, 0);
        Level3 g3 = new Level3(p, tr);
        menu.msgRegleLevel3();
        g3.play();
        while(p.life <= 0){
            System.out.println(" \n °°°°°° Echec °°°° Vous reprenez la partie ! °°°°  \n ");
            g3.reunit();
            g3.play();
        }
        g3.replay();
        menu.msgEnd();


    }
}
