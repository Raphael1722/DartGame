package org.example.dartgame;
/**
 * Dies ist die Abstrakte Klasse Person welche das Grundgerüst von Commentator und Player ist
 *
 * @author MüllerR
 * @author NussL
 * @version 1.0
 */
public abstract class Person {
    private String name;
    private int age;

    //Konstruktor
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    //Getter und Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}