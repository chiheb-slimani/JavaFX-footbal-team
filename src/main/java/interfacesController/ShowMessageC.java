package interfacesController;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ShowMessageC {

    public static void showMessage(String message) {
        // Create a new stage (popup window)
        Stage messageStage = new Stage();
        messageStage.initModality(Modality.APPLICATION_MODAL);  // Blocks input to the main window
        messageStage.setTitle("Message");

        // Create a label to display the message
        Label messageLabel = new Label(message);
        messageLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #3498db;");

        // Create a Button to close the message window
        Button closeButton = new Button("Close");
        closeButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-padding: 10px 20px; -fx-font-size: 14px;");
        closeButton.setOnAction(e -> messageStage.close());

        // Layout the label and button in a VBox for better vertical alignment
        VBox layout = new VBox(20);
        layout.getChildren().addAll(messageLabel, closeButton);
        layout.setStyle("-fx-background-color: #ecf0f1; -fx-padding: 20px; -fx-border-radius: 10px;");
        layout.setAlignment(javafx.geometry.Pos.CENTER);

        // Create the scene and set it to the stage
        Scene scene = new Scene(layout, 300, 150);  // Smaller and cleaner popup size
        messageStage.setScene(scene);
        messageStage.setResizable(false);  // Prevent resizing
        messageStage.showAndWait();  // Show the stage and wait until it is closed
    }
}
