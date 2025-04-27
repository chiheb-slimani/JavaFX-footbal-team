package interfacesController;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.stage.Stage;
import model.Equipe.Equipe;
import model.staff.Comptable;




public class LoginComptableC {
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
            Comptable comptable = new Comptable();
            comptable.setNom(nomField.getText());
            comptable.setPrenom(prenomField.getText());
            comptable.setMail(mailField.getText());
            comptable.setPassword(passwordField.getText());
            System.out.println(comptable.getNom());
            Equipe.getEquipe().setComptable(comptable);


            Stage stage = (Stage) loginButton.getScene().getWindow();
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("/fxml/Comptable.fxml"));
            Scene comptableScene = new Scene(loader.load());
            stage.setScene(comptableScene);


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
    public Scene getComptableLoginscene () throws Exception {
        javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("/fxml/LoginComptable.fxml"));
        Scene scene = new Scene(loader.load());
        return scene;
    }

}
