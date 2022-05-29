/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CustomWidgets;

import static CustomModal.CustomModal.CustomModal;
import java.io.File;
import java.nio.file.Paths;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author dima82.91
 */
public class CustomWidgets {

    protected static Timeline timeline;

    protected static DoubleProperty progressDoubleProperty = new SimpleDoubleProperty(0);
    static IntegerProperty secondsIntegerProperty = new SimpleIntegerProperty(00);
    static IntegerProperty minutesIntegerProperty = new SimpleIntegerProperty(20);

    static int effortLevelValue;

    private static ProgressBar pb = new ProgressBar();
    static Label secondsLabel = new Label();
    static Label minutesLabel = new Label();

    private static int minutes = 19;
    private static int seconds = 60;

    public static void startTimer() {
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(
                (new KeyFrame(Duration.seconds(1), e -> CountDown()))
        );
        timeline.playFromStart();
    }

    public static void CountDown() {
        if (seconds == 0) {
            minutes--;
            seconds = 59;
        } else {
            seconds--;
        }
        if(minutes<0){
            timeline.stop();
        }
        secondsIntegerProperty.set(seconds);
        minutesIntegerProperty.set(minutes);
        progressDoubleProperty.set((1d - (minutes * 5) / 100d)); //setting progress using formula
    }

    public static StackPane timerWidget(String measurementName, String metricUnit, double metricValue) {

        Label colonLabel = new Label(":");
        colonLabel.setTextFill(Color.WHITE);
        colonLabel.setFont(Font.font("Arial", FontWeight.BOLD, 30));

        minutesLabel.setTextFill(Color.WHITE);
        minutesLabel.setFont(Font.font("Arial", FontWeight.BOLD, 30));

        secondsLabel.setTextFill(Color.WHITE);
        secondsLabel.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        //binding label property on seconds or minutes change
        secondsLabel.textProperty().bind(secondsIntegerProperty.asString());
        minutesLabel.textProperty().bind(minutesIntegerProperty.asString());

        HBox hbox = new HBox();//hbox for timer
        hbox.getChildren().addAll(minutesLabel, colonLabel, secondsLabel);
        StackPane.setMargin(hbox, new Insets(70, 0, 0, 40));

        StackPane stack = new StackPane();

        Rectangle rect = new Rectangle(150.0, 120.0);
        rect.setFill(Color.DARKSLATEGREY);

        Text measure = new Text(measurementName);
        measure.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        measure.setFill(Color.WHITE);
        StackPane.setMargin(measure, new Insets(0, 0, 80, 0));

        Text metric = new Text(metricUnit);
        metric.setFont(Font.font("Arial", 18));
        metric.setFill(Color.WHITE);
        StackPane.setMargin(metric, new Insets(0, 0, 20, 0));

        stack.getChildren().addAll(rect, measure, metric, hbox);

        return stack;
    }

    ;
    
    public static StackPane progressBarWidget(String measurementName, String metricUnit, double metricValue) {
        Label timerLabel = new Label("20:00");
        timerLabel.setTextFill(Color.WHITE);
        //setting progress if progressDoubleProperty changes
        pb.progressProperty().bind(progressDoubleProperty);

        StackPane.setMargin(timerLabel, new Insets(80, 0, 0, 0));

        StackPane stack = new StackPane();
        Rectangle rect = new Rectangle(150.0, 120.0);
        rect.setFill(Color.DARKSLATEGREY);

        Text measure = new Text(measurementName);
        measure.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        measure.setFill(Color.WHITE);

        StackPane.setMargin(pb, new Insets(0, 0, 10, 0));

        Text metric = new Text(metricUnit);
        metric.setFont(Font.font("Arial", 18));
        metric.setFill(Color.WHITE);

        StackPane.setMargin(metric, new Insets(0, 0, 60, 0));

        stack.getChildren().addAll(rect, metric, pb, timerLabel);

        return stack;
    };
    
        public static StackPane socialmediaWidget(String socialmediaName, String imageName) {
        StackPane stack = new StackPane();

        Rectangle rect = new Rectangle(150.0, 120.0);
        rect.setFill(Color.ORANGE);

        stack.getChildren().add(rect);

        Text socialmediaText = new Text(socialmediaName);
        socialmediaText.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        socialmediaText.setFill(Color.WHITE);
        stack.getChildren().add(socialmediaText);

        StackPane.setMargin(socialmediaText, new Insets(20, 80, 80, 0));

        String imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator + imageName;
        String imageURI = Paths.get(imgPath).toUri().toString();

        ImageView imageView = new ImageView(new Image(imageURI));
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);

        stack.setAlignment(Pos.BOTTOM_LEFT);
        stack.getChildren().add(imageView);

        return stack;
    }

    ;
        
    public static StackPane staticWidget(String measurementName, String metricUnit, double metricValue) {
        StackPane stack = new StackPane();

        Rectangle rect = new Rectangle(150.0, 120.0);
        rect.setFill(Color.DARKSLATEGREY);

        Text measure = new Text(measurementName);
        measure.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        measure.setFill(Color.WHITE);

        StackPane.setMargin(measure, new Insets(0, 0, 80, 0));

        Text metric = new Text(metricUnit);

        metric.setFont(Font.font("Arial", 18));
        metric.setFill(Color.WHITE);
        StackPane.setMargin(metric, new Insets(0, 0, 40, 0));

        Text value = new Text(String.valueOf(metricValue));

        value.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        value.setFill(Color.WHITE);
        StackPane.setMargin(value, new Insets(50, 0, 0, 0));

        stack.getChildren().addAll(rect, measure, metric, value);

        return stack;
    }

    ;
    public static StackPane pauseStopWidget() {
        StackPane stack = new StackPane();
        VBox vbox = new VBox();
        Rectangle rect = new Rectangle(150.0, 120.0);

        Button stopButton = new Button("PAUSE\n STOP");
        stopButton.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        stopButton.setStyle("-fx-background-color: red;");

        stopButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                timeline.stop();
                CustomModal().showAndWait();
            }
        });

        Button coolDownButton = new Button("COOL DOWN");
        coolDownButton.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, null, null)));
        coolDownButton.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        stopButton.setPrefSize(150, 59);
        coolDownButton.setPrefSize(150, 59);

        vbox.getChildren().addAll(stopButton, coolDownButton);

        stack.getChildren().addAll(rect, vbox);

        return stack;
    }

    ;
    
      public static StackPane effortLevelWidget(String measurementName, int effortLevel) {
        StackPane stack = new StackPane();
        HBox hbox = new HBox();
        VBox vbox = new VBox();
        Rectangle rect = new Rectangle(150.0, 120.0);
        rect.setFill(Color.DARKSLATEGREY);
        Text measure = new Text(measurementName);

        measure.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        measure.setFill(Color.WHITE);
        StackPane.setMargin(measure, new Insets(0, 0, 80, 0));

        Label efforLevelLabel = new Label();
        efforLevelLabel.setTextFill(Color.WHITE);
        efforLevelLabel.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        efforLevelLabel.setText(Integer.toString(effortLevel));

        Button incrementButton = new Button("+");
        incrementButton.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        incrementButton.setBackground(Background.EMPTY);
        incrementButton.setTextFill(Color.WHITE);
        incrementButton.setPadding(new Insets(0, 10, 0, 10));

        Button decrementButton = new Button("-");
        decrementButton.setFont(Font.font("Arial", FontWeight.BOLD, 32));
        decrementButton.setTextFill(Color.WHITE);
        decrementButton.setBackground(Background.EMPTY);
        decrementButton.setPadding(new Insets(0, 10, 0, 10));

        effortLevelValue = effortLevel;

        decrementButton.setOnAction(new EventHandler<ActionEvent>() {
            //setting minimum effort level 0
            public void handle(ActionEvent event) {
                if (effortLevelValue - 1 >= 0) {
                    effortLevelValue = effortLevelValue - 1;
                    efforLevelLabel.setText(Integer.toString(effortLevelValue));
                }
            }
        });
        //setting maximum effort level 30
        incrementButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (effortLevelValue + 1 <= 30) {
                    effortLevelValue = effortLevelValue + 1;
                    efforLevelLabel.setText(Integer.toString(effortLevelValue));
                }
            }
        });
        hbox.getChildren().addAll(incrementButton, decrementButton);
        hbox.setAlignment(Pos.CENTER);

        vbox.getChildren().addAll(measure, efforLevelLabel, hbox);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);

        stack.getChildren().addAll(rect, vbox);

        return stack;
    }
;
}
