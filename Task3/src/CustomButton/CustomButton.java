package CustomButton;

import java.io.File;
import java.nio.file.Paths;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

/**
 *
 * @author dima82.91
 */
public class CustomButton {
    
    public static Button iconCustomButton(String imgName,int width,int height){
    Button button = new Button();
    button.setPrefSize(width, height);
    String imgPath = System.getProperty("user.dir")+ File.separator + "images" + File.separator + imgName;
    String imgURI = Paths.get(imgPath).toUri().toString();
    Image homeImage = new Image(imgURI, button.getWidth(), button.getHeight(), false, true, true);
    BackgroundImage backgroundHomeImage = new BackgroundImage(homeImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(button.getWidth(), button.getHeight(), true, true, true, false));

    Background backGround = new Background(backgroundHomeImage);
    button.setBackground(backGround);
    return button;
    }
}
