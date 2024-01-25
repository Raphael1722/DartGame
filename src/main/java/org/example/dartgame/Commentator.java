package org.example.dartgame;
/**
 * Dies ist die Klasse von dem Commentator welcher in einem folgendem Update hinzugefügt wird er erbt von Person
 *
 * @author MüllerR
 * @author NussL
 * @version 1.0
 */
public class Commentator extends Person {

    public Commentator(String name, int age){
        super(name,age);
    }
    //Methode welche
    public void sayPoints(int points){
        System.out.println("Du hast " + points + " geworfen");
    }
}
