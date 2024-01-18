package org.example.dartgame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class AllyPally {

    public AllyPally(){
        //Grundriss erstellen
        BorderPane screen = new BorderPane();
        Scene main = new Scene(screen, 500, 500);
        GridPane gridTop = new GridPane();
        GridPane gridBottom = new GridPane();
        ChoiceBox mode = new ChoiceBox();
        ChoiceBox difficulty = new ChoiceBox();
    }

}
