package org.example.dartgame;

import javafx.stage.Stage;

public class Start {
    private static Stage testing = new Stage();
    private static Menue test = new Menue();
    private AllyPally test2 = new AllyPally(testing);
    private PlayerScreen test3 = new PlayerScreen(testing);
    private Dart test4 = new Dart();
    public static void main(String[] args) throws Exception {

        test.start(testing);
    }
}
