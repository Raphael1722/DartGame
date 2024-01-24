package org.example.dartgame;
public class Player  extends Person {
    String username;
    int winCounter;
    int credit;

    public Player(String name, int age, String username){
        super(name,age);
        this.username = username;
        this.winCounter = 0;
        this.credit = 50;
    }

    public void earnCredit(int gewinn){
        this.credit += gewinn;
    }

    public int calculateWin(int pot, int anzahlWürfe){
        int win = pot * 3 / anzahlWürfe - 8;
        return win;
    }

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