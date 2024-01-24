package org.example.dartgame;

//imports
import com.almasb.fxgl.core.Updatable;
import eu.hansolo.tilesfx.addons.Switch;
import eu.hansolo.tilesfx.tools.Point;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.dialog.Wizard;

import javax.swing.*;
import java.io.Console;
import java.nio.channels.ClosedByInterruptException;
import java.security.Key;
import static javafx.application.Application.launch;

//Klasse Dart wo dann das Dart gespielt wird
public class Dart{
    //final Variablen
    private static final int PREFERED_WIDTH = 1300;
    private static final int PREFERED_HIGHT = 800;

    private static int step = 15;
    //Variablen
    private BorderPane root;
    private BorderPane rootWinn;
    private FlowPane flow;
    private Label winn;
    private TextField anzahlDart;
    private TextField textField;
    private TextField labelPoint;
    private Circle dart;
    private boolean status;
    private int counter;
    private int point = 501;
    private int dartCounter = 0;
    private Stage primarySage;
    private Scene winnScreen;
    private FlowPane flowLeft;
    private Label name;
    private Label winCounter;
    private Player player;
    private Button erneutSpielen;
    private GridPane gridWin;
    private Label creditAmount;
    private int amount;
    private int wurf;
    private int anfangPunkte;


    //start Methode wo alles gestartet wird
    public Dart(Stage primaryStage, int point, int step, Player spieler,int amount, int wurf) throws InterruptedException {
        this.point = point;
        this.anfangPunkte = point;
        this.step = step;
        primarySage = primaryStage;
        player = spieler;
        this.amount = amount;
        this.wurf = wurf;



        //Border und Flow Pane erstellen
        root = new BorderPane();
        flow = new FlowPane();
        flowLeft = new FlowPane();
        rootWinn = new BorderPane();
        //Label für Spieler
        name = new Label(player.getUsername());
        winCounter = new Label("Wincounter: "+player.getWincounter());
        creditAmount = new Label("Credits: "+player.getCredit());
        //Label für Gewonnen
        winn = new Label("Du hast Gewonnen gut gemacht");
        rootWinn.setTop(winn);
        winn.getStyleClass().add("winn");
        //Grösse und Anzahl für gridPane definieren
        gridWin = new GridPane();
        gridWin.getRowConstraints().add(new RowConstraints(200));
        gridWin.getRowConstraints().add(new RowConstraints(100));
        //+
        gridWin.getColumnConstraints().add(new ColumnConstraints(200));
        gridWin.getColumnConstraints().add(new ColumnConstraints(50));
        //Button für Gewonnen
        erneutSpielen = new Button("Erneut Spielen");
        erneutSpielen.setShape(new Circle(1.5));
        erneutSpielen.setPrefSize(200,100);
        rootWinn.setRight(gridWin);
        //Button in CSS einbinden
        erneutSpielen.getStyleClass().add("buttonSpielen");
        //GridPane in BorderPane einbinden
        gridWin.add(erneutSpielen, 0,1);
        //Label Anzahl Darts
        anzahlDart = new TextField();
        anzahlDart.appendText("Du hast: " + Integer.toString(dartCounter) + " würfe gebraucht");
        anzahlDart.setDisable(true);
        anzahlDart.getStyleClass().add("anzahlDart");
        rootWinn.setBottom(anzahlDart);
        //Text Field erstellen
        textField = new TextField();
        textField.setPromptText("Hier Punkte eingeben");
        textField.setPrefSize(260, 100);
        textField.setDisable(true);
        root.setPrefSize(PREFERED_WIDTH, PREFERED_HIGHT);
        rootWinn.setPrefSize(PREFERED_WIDTH,PREFERED_HIGHT);
        //Textfield welches die Punkte welche man noch hat anzeigen soll
        labelPoint = new TextField();
        labelPoint.appendText("\t" + Integer.toString(point));
        labelPoint.setDisable(true);
        //Style für Label Point
        labelPoint.getStyleClass().add("Points");
        //Style für Text Field
        textField.getStyleClass().add("Text");
        //gemacht das man nicht automatisch beim starten auf das Testfeld orientiert ist
        textField.setFocusTraversable(false);
        //FlowPane Vertical ausgerichtet
        flow.setOrientation(Orientation.VERTICAL);

        //in rechte Border Pane ein Flow Pane gemacht
        root.setRight(flow);

        //FlowPane links Vertical ausgerichtet
        flowLeft.setOrientation(Orientation.VERTICAL);
        //FlowPane links in Border Pane hinzufügen
        root.setLeft(flowLeft);
        //Labels in FlowPane hinzufügen
        flowLeft.getChildren().add(name);
        flowLeft.getChildren().add(winCounter);
        flowLeft.getChildren().add(creditAmount);

        //Text Field und Point Label in Flow Pain gemacht
        flow.getChildren().add(labelPoint);
        flow.getChildren().add(textField);

        //Variablen Wert gegeben
        status = true;
        counter = 0;


        //Neue Scene erstellt
        Scene scene = new Scene(root);
        winnScreen = new Scene(rootWinn);
        //Stylesheet angegeben
        scene.getStylesheets().add(getClass().getResource("StyleDart.css").toExternalForm());
        winnScreen.getStylesheets().add(getClass().getResource("StyleDart.css").toExternalForm());
        //an root Style Class pane gegeben
        root.getStyleClass().add("pane");
        rootWinn.getStyleClass().add("paneWinn");
        //Labels in CSS einbinden
        name.getStyleClass().add("name");
        winCounter.getStyleClass().add("winCounter");
        creditAmount.getStyleClass().add("winCounter");

        //Titel an Stage gegeben
        primarySage.setTitle("Dart Game");
        //Funktion newDart() aufgerufen um einen neuen Dart zu erstellen

        newDart();

        /*Event Handler auf Key UP pressed. Wenn UP gedrückt wird und status true ist, wird Funktion dartLinksRechts() ausgeführt
        Wenn Status nicht True ist und der counter auf 1 wird Funktion dartObenUnten ausgeführt sonst Funktion takePoint.
         */
        scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            KeyCode code = event.getCode();
            if (code == KeyCode.UP && status == true) {
                textField.clear();
                textField.setPromptText("Hier Punkte eingeben");
                dartLinksRechts();
            } else if (code == KeyCode.UP && counter == 1) {
                dartObenUnten();
                textField.setDisable(false);
            } else if(code == KeyCode.ENTER && counter == 2){
                dartCounter += 1;
                anzahlDart.clear();
                anzahlDart.appendText("Du hast: " + Integer.toString(dartCounter) + " Würfe gebraucht");
                takePoint();
            }
        });
        //Event handler Key UP released. Wenn der Key UP losgelassen wird soll der Status auf false wechseln und counter +1
        scene.addEventHandler(KeyEvent.KEY_RELEASED, event -> {
            KeyCode code1 = event.getCode();
            if (code1 == KeyCode.UP) {
                status = false;
                counter++;
            }
        });
        erneutSpielen.setOnAction(actionEvent -> {
            new AllyPally(primaryStage,player);
        });

        //Scene setzten und zeigen
        primarySage.setScene(scene);
        primarySage.setResizable(false);
        primarySage.show();

    }
    //Funktion newDart. Wird ein neuer Kreis also der Dart erstellt und geaddet.
    public void newDart(){
        dart = new Circle(100,700,3);
        root.getChildren().add(dart);
        dart.getStyleClass().add("dart");
    }
    //Funktion dartLinksRecht um Dart nach rechts zu verschieben
    public void dartLinksRechts(){
        dart.setCenterX(dart.getCenterX() + step);
    }
    //Funktion dartObenUnten um Dart nach oben zu bewegen
    public void dartObenUnten(){
        dart.setCenterY(dart.getCenterY() - step);
    }
    //Funktion takePoint soll Punkte von Textfield nehmen und Minus rechnen.
    public void takePoint(){
        status = true;
        counter = 0;
        try{
            int geworfenePunkte = Integer.parseInt(textField.getText());
            if(geworfenePunkte < 0 || geworfenePunkte > 60) {
                textField.clear();
                textField.appendText("Nicht möglich");
                dart.setCenterY(700);
                dart.setCenterX(100);
                textField.setDisable(true);
            }
            else {
                setPoint(point - geworfenePunkte);
                textField.clear();
                textField.setPromptText("Hier Punkte eingeben");
                if (point == 0) {
                    //Winscreen anzeigen lassem
                    primarySage.setTitle("Gewonnen");
                    primarySage.setScene(winnScreen);
                    //Spieler bekommte durch den Win Wincounter mehr und bekommt Credits
                    player.setWincounter(+1);
                    player.earnCredit(+20);
                    //Wenn die Wette stimmt, bekommt der Spieler das doppelte vom Einsatz zurück
                    if(dartCounter < wurf){
                        player.earnCredit(player.calculateWin(amount,wurf,anfangPunkte));
                    }
                } else if (point < 0) {
                    setPoint(point + geworfenePunkte);
                    labelPoint.clear();
                    labelPoint.appendText("\t" + Integer.toString(point));
                    dart.setCenterY(700);
                    dart.setCenterX(100);
                    textField.setDisable(true);
                } else {
                    labelPoint.clear();
                    labelPoint.appendText("\t" + Integer.toString(point));
                    dart.setCenterY(700);
                    dart.setCenterX(100);
                    textField.setDisable(true);
                }
            }
        }catch (NumberFormatException numberFormatException){
            textField.clear();
            textField.appendText("Das war keine Zahl Null Punkte");
            textField.setDisable(true);
            dart.setCenterX(100);
            dart.setCenterY(700);
        }
    }
    //Getter und Setter
    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}