package CustomModal;

import CustomWidgets.CustomWidgets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author dima82.91
 */
public class CustomModal extends CustomWidgets {

    public static Stage CustomModal() {
        Stage dialog = new Stage();
        BorderPane border = new BorderPane();
        border.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, new CornerRadii(0), Insets.EMPTY)));
        dialog.initModality(Modality.APPLICATION_MODAL);

        HBox hbox = new HBox();
        Label warningLabel = new Label("The exercise is temporarily suspended!");

        Button stopButton = new Button("STOP");
        stopButton.setTextFill(Color.WHITE);
        stopButton.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
        stopButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });

        Button restartButton = new Button("RESTART");
        restartButton.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
        restartButton.setTextFill(Color.WHITE);
        restartButton.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                CustomWidgets.startTimer();
                dialog.close();
            }
        });

        hbox.setPadding(new Insets(0, 0, 10, 0));
        hbox.getChildren().addAll(stopButton, restartButton);
        hbox.setSpacing(20);
        hbox.setAlignment(Pos.CENTER);

        border.setCenter(warningLabel);
        border.setBottom(hbox);

        Scene scene = new Scene(border, 300, 250, Color.CADETBLUE);

        dialog.setScene(scene);
        return dialog;
    }
}
