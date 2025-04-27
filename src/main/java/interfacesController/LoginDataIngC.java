package interfacesController;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.stage.Stage;
import model.Equipe.Equipe;
import model.staff.DataIng;


public class LoginDataIngC {    @FXML
private TextField nomField, prenomField, mailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;
    @FXML
    private Button retourButton;
    private void showAlert(String title, String message) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle(title);
    alert.setContentText(message);
    alert.showAndWait();
}
    public Scene getDataIngLoginscene () throws Exception {
        // Load the FXML and set the scene
        javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("/fxml/LoginDataIng.fxml"));
        Scene scene = new Scene(loader.load());
        return scene;
    }
    @FXML
    private void handleretour(){ Stage stage = (Stage) retourButton.getScene().getWindow();
        MenuC menuC= new MenuC();
        try {
            stage.setScene(menuC.getMenuscene());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }}
    @FXML
    private void handleLogin() {
        try {
            // Set manager details
            DataIng dataIng = new DataIng();
            dataIng.setNom(nomField.getText());
            dataIng.setPrenom(prenomField.getText());
            dataIng.setMail(mailField.getText());
                        Equipe.getEquipe().setDataIng(dataIng);


            Stage stage = (Stage) loginButton.getScene().getWindow();
            DataIngC dataIngC = new DataIngC();
            stage.setScene(dataIngC.getDataIngScene());
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Login Failed", "Please check your details and try again.");
        }
    }

}
