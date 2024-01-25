package org.example.dartgame;
/**
 * Dies ist die Klasse von dem Spieler sie erbt von Person
 *
 * @author MüllerR
 * @author NussL
 * @version 1.0
 */
public class Player  extends Person {
    String username;
    int winCounter;
    int credit;

    //Konstruktor
    public Player(String name, int age, String username){
        super(name,age);
        this.username = username;
        this.winCounter = 0;
        this.credit = 50;
    }
    /**
     * Dies ist die Methode das der Spieler Geld verdienen kann
     *
     * @author MüllerR
     * @author NussL
     * @version 1.0
     */
    //Spieler bekommt Credits
    public void earnCredit(int gewinn){
        this.credit += gewinn;
    }

    /**
     * Dies ist die Methode welche den Gewinn berechnet
     *
     * @author MüllerR
     * @author NussL
     * @version 1.0
     */
    //Der Gewinn wird berechnet, mit den Anzahl Würfen die man gebraucht hat
    public int calculateWin(int pot, int anzahlWuerfe,int points){
        if (points == 501){
            int win = (pot * 4) / (anzahlWuerfe - 8);
            return win;
        }
        else  {
            int win = (pot*4)/(anzahlWuerfe-5);
            return win;
        }
    }

    //Getter und Setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getWincounter() {
        return winCounter;
    }

    public void setWincounter(int wincounter) {
        this.winCounter = wincounter;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}