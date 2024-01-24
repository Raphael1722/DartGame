package org.example.dartgame;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import org.controlsfx.control.spreadsheet.Grid;

import java.util.function.ToIntBiFunction;



public class PlayerScreen{

    private String newName;
    private int newAge;
    private String newUsername;
    private Player spielerOwn;

    public PlayerScreen(Stage stage){

        //Grundriss erstellen
        BorderPane createP = new BorderPane();
        createP.getStyleClass().add("pane");
        GridPane grid = new GridPane();
        grid.getStyleClass().add("left");
        GridPane gridRight = new GridPane();
        Scene first = new Scene(createP,1300, 800);

        //Textfield erstellen
        TextField oneTxt =  new TextField();
        TextField twoTxt =  new TextField();
        TextField threeTxt =  new TextField();

        //Labels erstellen
        Label one = new Label("Name");
        Label two = new Label("Alter");
        Label three = new Label("Benutzername");

        // Buttons erstellen
        Button back = new Button("Ally Pally");
        Button confirm = new Button("Bestätigen");

        //GrösseTextfield bestimmen
        oneTxt.setPrefSize(10,125);
        twoTxt.setPrefSize(10,125);
        threeTxt.setPrefSize(10,125);

        //Nodes zum grid hinzufügen
        grid.add(oneTxt, 0, 2);
        grid.add(twoTxt, 0, 5);
        grid.add(threeTxt, 0, 8);
        grid.add(one,0,1);
        grid.add(two,0,4);
        grid.add(three,0,7);

        //Grid grösse und Anzahl bestimmen
        grid.getColumnConstraints().add(new ColumnConstraints(600));
        // +
        grid.getRowConstraints().add(new RowConstraints(50));
        grid.getRowConstraints().add(new RowConstraints(100));
        grid.getRowConstraints().add(new RowConstraints(100));
        grid.getRowConstraints().add(new RowConstraints(50));
        grid.getRowConstraints().add(new RowConstraints(100));
        grid.getRowConstraints().add(new RowConstraints(100));
        grid.getRowConstraints().add(new RowConstraints(50));
        grid.getRowConstraints().add(new RowConstraints(100));
        grid.getRowConstraints().add(new RowConstraints(100));
        grid.getRowConstraints().add(new RowConstraints(50));

        //grid in BorderPane einbinden
        createP.setLeft(grid);

        //grid rechts grösse und anzahl bestimmen
        gridRight.getColumnConstraints().add(new ColumnConstraints(75));
        gridRight.getColumnConstraints().add(new ColumnConstraints(250));
        gridRight.getColumnConstraints().add(new ColumnConstraints(75));
        //+
        gridRight.getRowConstraints().add(new RowConstraints(150));
        gridRight.getRowConstraints().add(new RowConstraints(200));
        gridRight.getRowConstraints().add(new RowConstraints(100));
        gridRight.getRowConstraints().add(new RowConstraints(200));
        gridRight.getRowConstraints().add(new RowConstraints(150));

        //Buttons hinzufügen
        gridRight.add(back,1,3);
        gridRight.add(confirm,1,1);

        //Grössen bestimmen
        back.setPrefSize(250, 200);
        confirm.setPrefSize(250,200);

        //BorderPane einbinden
        createP.setRight(gridRight);

        //Daten nehmen
        confirm.setOnAction(event ->{
            String duere ="Hallo";
            try{
            setNewName(oneTxt.getText());
            setNewAge(Integer.parseInt(twoTxt.getText()));
            setNewUsername(threeTxt.getText());
            }catch (NumberFormatException e){
                System.out.println("Diese Daten, haben nicht den korrekten Datentyp");
            }

                    //Spieler wird mit den Daten erstellt
                    spielerOwn = new Player(getNewName(), getNewAge(), getNewUsername(),0, 100);

                    //Clear Textfield
                    oneTxt.setText("");
                    twoTxt.setText("");
                    threeTxt.setText("");
        });
        back.setOnAction(event ->{
            new AllyPally(stage,getSpielerOwn());
        });



        //Stylesheet einbinden
        first.getStylesheets().add(getClass().getResource("StylesheetPlayerScreen.css").toExternalForm());

        //Stage bennenen und zeigen
        stage.setScene(first);
        stage.setResizable(false);
        stage.setTitle("Player Menu");
        stage.show();
    }

    //Getter und Setter
    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public int getNewAge() {
        return newAge;
    }

    public void setNewAge(int newAge) {
        this.newAge = newAge;
    }

    public String getNewUsername() {
        return newUsername;
    }

    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
    }

    public Player getSpielerOwn() {
        return spielerOwn;
    }

    public void setSpielerOwn(Player spielerOwn) {
        this.spielerOwn = spielerOwn;
    }
}
