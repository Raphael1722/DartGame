package org.example.dartgame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.*;

import static javafx.application.Application.launch;

public class AllyPally {
    private int varModus;
    private int schwierigkeit;
    private BorderPane screen;
    private GridPane grid;
    private GridPane insane;
    private Label allyPally;
    private ChoiceBox mode;
    private ChoiceBox difficulty;
    private int amount;
    private int wurf;


    public AllyPally(Stage stage, Player spieler) {
        //Grundriss erstellen
        insane = new GridPane();
        screen = new BorderPane();
        screen.getStyleClass().add("pane");
        grid = new GridPane();
        Scene main = new Scene(screen, 1300, 800);
        allyPally = new Label("Ally Pally");
        mode = new ChoiceBox();
        difficulty = new ChoiceBox();
        Label modeL = new Label("Modus");
        Label difficultyL = new Label("Schwierigkeit");
        allyPally.getStyleClass().add("allyPally");
        modeL.getStyleClass().add("next");
        difficultyL.getStyleClass().add("next");
        mode.getStyleClass().add("CheckBox");
        difficulty.getStyleClass().add("CheckBox");



        Button goOn = new Button("Weiter");

        screen.setTop(allyPally);
        screen.setCenter(grid);
        screen.setRight(insane);

        grid.add(modeL,0,0);
        grid.add(mode,1,0);
        grid.add(difficultyL,0,1);
        grid.add(difficulty,1,1);

        insane.getRowConstraints().add(new RowConstraints(200));
        insane.getRowConstraints().add(new RowConstraints(220));
        insane.getRowConstraints().add(new RowConstraints(260));

        grid.getRowConstraints().add(new RowConstraints(300));
        grid.getRowConstraints().add(new RowConstraints(300));

        insane.add(goOn, 0, 1);

        //Grösse Weiter-button setzten
        goOn.setPrefSize(300, 50);
        goOn.snapPositionX(1000);
        goOn.snapPositionY(400);

        //Daten in Choicebox geben
        mode.getItems().addAll("501", "301");
        difficulty.getItems().addAll("Einfach", "Mittel", "Schwer");

        //Wenn Weiter-button gedrückt, Daten werden in die Variablen eingetragen, um diese beim Spiel zu verwenden
        goOn.setOnAction(event -> {
            if (mode.getValue() == "501") {
                setVarModus(501);
                wurf = 12;
            } else {
                setVarModus(301);
                wurf = 9;
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

            amount = Integer.parseInt(JOptionPane.showInputDialog(null, "Du hast "+spieler.getCredit()+" Credits. Geben sie ihren Einsatz ein, um die Punktzah in "+wurf+ " Würfen zu knaken!"));
            if(amount > spieler.getCredit()){
                amount = Integer.parseInt(JOptionPane.showInputDialog(null, "Du hast zu wenig Credits"));
            }
            spieler.setCredit(spieler.getCredit() - amount);
            try {
                new Dart(stage,getVarModus(),getSchwierigkeit(), spieler, amount, wurf);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        //Stylesheet eibinden
        main.getStylesheets().add(getClass().getResource("StylesheetAllyPally.css").toExternalForm());
        //Stage bennenen und zeigen
        stage.setTitle("Ally Pally");
        stage.setResizable(false);
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
