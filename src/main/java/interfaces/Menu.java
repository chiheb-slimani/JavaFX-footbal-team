package interfaces;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Menu extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Menu.fxml"));
        StackPane root = loader.load(); // Ensure the FXML root is a StackPane

        ImageView imageView = (ImageView) root.lookup("#imageView");
        if (imageView == null) {
            throw new RuntimeException("ImageView with fx:id 'imageView' not found in FXML.");
        }

        Scene scene = new Scene(root, 800, 600);


        scene.getStylesheets().add(getClass().getResource("/css/Menu.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle("TeaMManagement");
        primaryStage.setResizable(false);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
