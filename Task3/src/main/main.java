/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import CustomButton.CustomButton;
import CustomWidgets.CustomWidgets;
import java.io.File;
import java.nio.file.Paths;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author dima82.91
 */
public class main extends Application {

    @Override
    public void start(Stage primaryStage) {
        //setting different nodes to borderpane
        BorderPane border = new BorderPane();
        border.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        border.setLeft(getGridLayout());
        border.setCenter(addFlowPane());
        border.setBottom(addHBox());

        Scene scene = new Scene(border, 782, 450);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    Pane getGridLayout() {
        VBox vbox = new VBox();
        StackPane stack = new StackPane();

        Rectangle nameIcon = new Rectangle(180.0, 100.0);
        nameIcon.setFill(Color.ORANGE);

        Text nameText = new Text("Dumitru");
        nameText.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        nameText.setFill(Color.WHITE);

        String imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator + "user.png";
        String imageURI = Paths.get(imgPath).toUri().toString();

        ImageView imageView = new ImageView(new Image(imageURI));
        imageView.setFitHeight(150);
        imageView.setFitWidth(180);

        stack.getChildren().addAll(nameIcon, nameText);

        StackPane.setMargin(nameText, new Insets(0, 120, 60, 0));

        vbox.getChildren().addAll(stack, imageView);

        return vbox;
    }

    public HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);

        Button shareButton = CustomButton.iconCustomButton("share.png", 50, 50);
        Button homeButton = CustomButton.iconCustomButton("home.png", 50, 50);
        Button bluetoothButton = CustomButton.iconCustomButton("bt.png", 50, 50);
        //divide buttons space in 3 
        Region region1 = new Region();
        hbox.setHgrow(region1, Priority.ALWAYS);
        Region region2 = new Region();
        hbox.setHgrow(region2, Priority.ALWAYS);
        Region region3 = new Region();
        hbox.setHgrow(region2, Priority.ALWAYS);

        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(shareButton, homeButton, region1, region2, bluetoothButton, region3);

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);

        Button speakerButton = CustomButton.iconCustomButton("speaker.png", 30, 30);
        Text currentTime = new Text("07:59");
        currentTime.setFill(Color.WHITE);
        currentTime.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        vbox.getChildren().addAll(speakerButton, currentTime);
        vbox.setAlignment(Pos.CENTER);
        hbox.getChildren().add(vbox);

        return hbox;
    }

    public FlowPane addFlowPane() {
        FlowPane flow = new FlowPane();

        flow.getChildren().add(CustomWidgets.timerWidget("time", "min:sec", 00));
        flow.getChildren().add(CustomWidgets.staticWidget("calories", "kcal", 571));
        flow.getChildren().add(CustomWidgets.staticWidget("distance", "km", 1.51));
        flow.getChildren().add(CustomWidgets.socialmediaWidget("TV", "tv.png"));
        flow.getChildren().add(CustomWidgets.staticWidget("hear rate", "beats/min", 93));
        flow.getChildren().add(CustomWidgets.progressBarWidget("time", "min:sec", 00));
        flow.getChildren().add(CustomWidgets.staticWidget("power", "watts", 216));
        flow.getChildren().add(CustomWidgets.socialmediaWidget("UTube", "youtube.png"));
        flow.getChildren().add(CustomWidgets.effortLevelWidget("effort level", 15));
        flow.getChildren().add(CustomWidgets.pauseStopWidget());
        flow.getChildren().add(CustomWidgets.staticWidget("speed", "spm", 94));
        flow.getChildren().add(CustomWidgets.socialmediaWidget("TuneUp", "tune.png"));
        CustomWidgets.startTimer();
        return flow;
    }
}
