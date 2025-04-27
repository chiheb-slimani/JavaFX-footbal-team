package interfacesController;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Equipe.Equipe;
import model.statistiques.StatistiqueDefenseur;
import model.statistiques.StatistiqueMatch;

import java.io.IOException;

public class AjoutStatC {

    @FXML private TextField idMatchField;
    @FXML private TextField butsField;
    @FXML private TextField sprintdistance;
    @FXML private TextField minutesField;
    @FXML private TextField cr1;
    @FXML private TextField cr2;

    @FXML private Button handleAddStats;
    @FXML private Button handleCancel;

    // Event handler for adding statistics
    @FXML
    private void handleAddStats() {
        try {
            // Parse input values
            int idMatch = Integer.parseInt(idMatchField.getText());
            int buts = Integer.parseInt(butsField.getText());
            int sprintDistance = Integer.parseInt(sprintdistance.getText());
            int minutes = Integer.parseInt(minutesField.getText());
            int critere1 = Integer.parseInt(cr1.getText());
            int critere2 = Integer.parseInt(cr2.getText());

            // Create new StatistiqueMatch object
            StatistiqueDefenseur newStat = new StatistiqueDefenseur(idMatch, buts, minutes, sprintDistance, critere1, critere2);
            Equipe.getEquipe().getJoueurAvecBonus().getStatistiqueJoueur().ajouterStatistique(newStat);
            // Mock logic to add statistics (replace with real logic as needed)
            System.out.println("Statistique ajoutée: " + newStat);

            // Display success alert
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Succès");
            alert.setHeaderText(null);
            alert.setContentText("Les statistiques ont été ajoutées avec succès !");
            alert.showAndWait();

            // Clear the input fields
            clearFields();
        } catch (NumberFormatException e) {
            // Display error alert for invalid inputs
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez entrer des valeurs valides dans tous les champs.");
            alert.showAndWait();
        }
    }
@FXML
Button annuler;
    // Event handler for cancel button
    @FXML
    private void handleCancel() {
        Stage stage = (Stage) annuler.getScene().getWindow();
        DataIngC controller = new DataIngC();
        try {
            stage.setScene(controller.getDataIngScene());
        } catch (IOException e) {

    }}

    // Utility method to clear input fields
    private void clearFields() {
        idMatchField.clear();
        butsField.clear();
        sprintdistance.clear();
        minutesField.clear();
        cr1.clear();
        cr2.clear();
    }
    public Scene getAjoutStatCScene() throws IOException { javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("/fxml/Ajoutstat.fxml"));
        Scene scene = new Scene(loader.load());
        return scene;}
}
