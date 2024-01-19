package org.example.dartgame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class AllyPally {
    private int varModus;
    private int schwierigkeit;

    public AllyPally(Stage stage) {
        //Grundriss erstellen
        BorderPane screen = new BorderPane();
        screen.getStyleClass().add("pane");
        Scene main = new Scene(screen, 800, 600);
        GridPane gridTop = new GridPane();
        GridPane gridCenter = new GridPane();
        ChoiceBox mode = new ChoiceBox();
        ChoiceBox difficulty = new ChoiceBox();
        Label modeL = new Label("Modus");
        Label difficultyL = new Label("Schwierigkeit");
        modeL.getStyleClass().add("text");
        difficultyL.getStyleClass().add("text");
        Label allyPally = new Label("Ally Pally");
        allyPally.getStyleClass().add("title");

        Button goOn = new Button("Weiter");

        //Grid Grösse und Anzahl erstellen
        gridTop.getColumnConstraints().add(new ColumnConstraints(200));
        gridTop.getColumnConstraints().add(new ColumnConstraints(400));
        gridTop.getColumnConstraints().add(new ColumnConstraints(200));
        //+
        gridTop.getRowConstraints().add(new RowConstraints(200));
        //Titel zu Grid hinzufügen
        gridTop.add(allyPally, 1, 0);

        //Grid Grösse und Anzahl bestimmen
        gridCenter.getColumnConstraints().add(new ColumnConstraints(200));
        gridCenter.getColumnConstraints().add(new ColumnConstraints(200));
        gridCenter.getColumnConstraints().add(new ColumnConstraints(200));
        gridCenter.getColumnConstraints().add(new ColumnConstraints(200));
        //+
        gridCenter.getRowConstraints().add(new RowConstraints(50));
        gridCenter.getRowConstraints().add(new RowConstraints(150));
        gridCenter.getRowConstraints().add(new RowConstraints(150));
        gridCenter.getRowConstraints().add(new RowConstraints(50));

        //Grid in BorderPane hinzufügen
        screen.setTop(gridTop);
        screen.setCenter(gridCenter);

        //Mode Label und Choicebox hinzufügen
        gridCenter.add(mode, 2, 0);
        gridCenter.add(modeL, 1, 0);
        //Difficulty Label und Choicebox hinzufügen
        gridCenter.add(difficulty, 2, 2);
        gridCenter.add(difficultyL, 1, 2);
        //Weiter-button hinzufügen
        gridCenter.add(goOn, 3, 2);
        //Grösse Weiter-button setzten
        goOn.setPrefSize(150, 50);

        //Daten in Choicebox geben
        mode.getItems().addAll("501", "301");
        difficulty.getItems().addAll("Einfach", "Mittel", "Schwer");

        //Wenn Weiter-button gedrückt, Daten werden in die Variablen eingetragen, um diese beim Spiel zu verwenden
        goOn.setOnAction(event -> {
            if (mode.getValue() == "501") {
                setVarModus(501);
            } else {
                setVarModus(301);
            }
            if (difficulty.getValue() == "Einfach") {
                setSchwierigkeit(10);
            }
            if (difficulty.getValue() == "Mittel") {
                setSchwierigkeit(15);
            }
            if (difficulty.getValue() == "Schwer") {
                setSchwierigkeit(20);
            }
        });


        //Stylesheet eibinden
        main.getStylesheets().add(getClass().getResource("StylesheetAllyPally.css").toExternalForm());
        //Stage bennenen und zeigen
        stage.setTitle("Ally Pally");
        stage.setScene(main);
        stage.show();
    }

    //Getter und Setter
    public int getVarModus() {
        return varModus;
    }

    public void setVarModus(int varModus) {
        this.varModus = varModus;
    }

    public int getSchwierigkeit() {
        return schwierigkeit;
    }

    public void setSchwierigkeit(int schwierigkeit) {
        this.schwierigkeit = schwierigkeit;
    }
}
