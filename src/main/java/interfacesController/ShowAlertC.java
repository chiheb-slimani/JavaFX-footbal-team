package interfacesController;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ShowAlertC {

    public static void showAlert(String title, String message) {
        // Create a new stage for the alert
        Stage alertStage = new Stage();
        alertStage.initModality(Modality.APPLICATION_MODAL);  // Blocks input to the main window
        alertStage.setTitle(title);

        // Create an alert dialog with an "OK" button
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);

        // Create a custom layout for the alert dialog
        Button closeButton = new Button("Close");
        closeButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-padding: 10px 20px; -fx-font-size: 14px;");
        closeButton.setOnAction(e -> alertStage.close());

        // Add the button to a layout (VBox)
        VBox layout = new VBox(10);
        layout.getChildren().add(closeButton);
        layout.setStyle("-fx-background-color: #ecf0f1; -fx-padding: 20px; -fx-border-radius: 10px;");
        layout.setAlignment(javafx.geometry.Pos.CENTER);

        // Create the scene and set it to the stage
        Scene scene = new Scene(layout, 300, 150);  // Smaller alert size
        alertStage.setScene(scene);
        alertStage.setResizable(false);  // Prevent resizing
        alertStage.showAndWait();  // Show the alert and wait until it is closed
    }
}
