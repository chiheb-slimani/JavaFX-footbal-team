package interfacesController;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.stage.Stage;
import model.Equipe.Equipe;
import model.staff.Manager;


import javafx.scene.image.ImageView;


public class LoginManagerC {
    @FXML
    private TextField nomField, prenomField, mailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;
    @FXML
    private Button retourButton;


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
            Manager manager = new Manager();
            manager.setNom(nomField.getText());
            manager.setPrenom(prenomField.getText());
            manager.setMail(mailField.getText());
            manager.setPassword(passwordField.getText());
            System.out.println(manager.getNom());
           Equipe.getEquipe().setManager(manager);


            Stage stage = (Stage) loginButton.getScene().getWindow();
            ManagerController managerController = new ManagerController();
            stage.setScene(managerController.getManagerControllerscene());
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Login Failed", "Please check your details and try again.");
        }
    }


    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
    public Scene getManagerLoginscene () throws Exception {
        // Load the FXML and set the scene
        javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("/fxml/LoginManager.fxml"));
        Scene scene = new Scene(loader.load());
        return scene;
    }

}
