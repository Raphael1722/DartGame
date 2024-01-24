package org.example.dartgame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

import static javafx.application.Application.launch;

public class Menue extends Application {

    private Player spieler = new Player("Gast", 100,"Guestuser",0,0);
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Grundriss erstellen
        BorderPane border = new BorderPane();
        GridPane main = new GridPane();
        GridPane top = new GridPane();
        //Node in Stylesheet einbinden
        border.getStyleClass().add("top");
        Scene ground = new Scene(border, 1300, 800, Color.BLACK);

        //Nodes erstellen
        Button dart = new Button("Ally Pally");
        Button player = new Button("Spieler erstellen");
        Label title = new Label("Ally Pally 4life");
        title.getStyleClass().add("title");

        //main-grid Grösse und anzhal definieren
        main.getColumnConstraints().add(new ColumnConstraints(260));
        main.getColumnConstraints().add(new ColumnConstraints(260));
        main.getColumnConstraints().add(new ColumnConstraints(260));
        main.getColumnConstraints().add(new ColumnConstraints(260));
        main.getColumnConstraints().add(new ColumnConstraints(260));
        //+
        main.getRowConstraints().add(new RowConstraints(200));

        //Grösse festlegen
        dart.setPrefSize(260,200);
        player.setPrefSize(260,200);
        title.setPrefSize(500,200);

        //Nodes eibinden in grid
        main.add(dart, 3,0);
        main.add(player, 1, 0);

        //Grids in BorderPane einbinden
        border.setTop(top);
        border.setCenter(main);

        //Grid Grösse und anzahl bestimmen
        top.getRowConstraints().add(new RowConstraints(300));
        //+
        top.getColumnConstraints().add(new ColumnConstraints(400));
        top.getColumnConstraints().add(new ColumnConstraints(500));
        top.getColumnConstraints().add(new ColumnConstraints(400));

        //Titel einbinden in grid
        top.add(title, 1,0);

        //player-button click -> andere screen zu Spieler erstellen
        player.setOnAction(event ->{
            new PlayerScreen(primaryStage);
        });

        //Dartspielen-button click -> andere Screen zu Ally Pally
        dart.setOnAction(event ->{
            new AllyPally(primaryStage, getSpieler());
        });

        //Stylesheet einbinden
        ground.getStylesheets().add(getClass().getResource("Stylesheet.css").toExternalForm());

        //Stage bennenen und zeigen
        primaryStage.setTitle("Darts Menue");
        primaryStage.setResizable(false);
        primaryStage.setScene(ground);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }

    public Player getSpieler() {
        return spieler;
    }

    public void setSpieler(Player spieler) {
        this.spieler = spieler;
    }
}











