package org.example.dartgame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static javafx.application.Application.launch;

public class Menue extends Application {
    public void start(Stage primaryStage) {
        GridPane main = new GridPane();
        Scene ground = new Scene(main, 1300, 800, Color.GREY);

        Button dart = new Button("Dart spielen");
        Button player = new Button("Spieler erstellen");

        main.add(dart, 700, 700);
        main.add(player, 200, 200);

        primaryStage.setTitle("Nussi isch ume!");
        primaryStage.setScene(ground);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
