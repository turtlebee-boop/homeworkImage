package sample;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main extends Application {

    ImageView myImageView = new ImageView();

    Stage stage = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception{

        //nothing changed

        Button btnBrowse = new Button("browse");
        btnBrowse.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();

            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

            File file = fileChooser.showOpenDialog(null);

            try {
                BufferedImage bufferedImage = ImageIO.read(file);
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                myImageView.setImage(image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        VBox root = new VBox();
        root.getChildren().addAll(btnBrowse, myImageView);
        stage.setTitle("viewing image");
        stage.setScene(new Scene(root, 500, 600));
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
