package org.example.dartgame;
public class Commentator extends Person {

    public Commentator(String name, int age){
        super(name,age);
    }
    public void sayPoints(int points){
        System.out.println("Du hast " + points + " geworfen");
    }
}
