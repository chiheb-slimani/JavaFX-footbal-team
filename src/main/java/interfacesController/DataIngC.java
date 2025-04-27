package interfacesController;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Equipe.Equipe;
import model.staff.Joueur;
import javafx.collections.ObservableList;

import java.io.IOException;

public class DataIngC {

    @FXML private TableView<Joueur> tableView;
    @FXML private TableColumn<Joueur, String> nomColumn;
    @FXML private TableColumn<Joueur, String> prenomColumn;
    @FXML private TableColumn<Joueur, String> positionColumn;
    @FXML private TableColumn<Joueur, Integer> numeroColumn;

    @FXML private Button ajouter;
@FXML private Button annuler;
    private ObservableList<Joueur> joueurs = Equipe.getEquipe().getJoueurs();

    public void initialize() {
        // Set up columns
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomColumn.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        numeroColumn.setCellValueFactory(new PropertyValueFactory<>("numero"));
        positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));

        // Set data for the TableView
        tableView.setItems(joueurs);
        annuler.setOnAction(event -> {Stage stage=new Stage();stage= (Stage) annuler.getScene().getWindow();
         LoginDataIngC login=new LoginDataIngC();
            try {
                stage.setScene(login.getDataIngLoginscene());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    @FXML
    private void handleAjouter() {
        Joueur selectedPlayer = tableView.getSelectionModel().getSelectedItem();
        if (selectedPlayer == null) {
            showError("No Player Selected", "Please select a player to proceed.");
            return;
        }

        // Update the selected player in the singleton
        Equipe.getEquipe().setJoueurAvecBonus(selectedPlayer);

        // Transition to the statistics addition screen
        Stage stage = (Stage) ajouter.getScene().getWindow();
        AjoutStatC ajoutStatC = new AjoutStatC();
        try {
            stage.setScene(ajoutStatC.getAjoutStatCScene());
        } catch (IOException e) {
            e.printStackTrace();
            showError("Error Loading Scene", "An error occurred while opening the Add Statistics screen.");
        }

        System.out.println("Ajouter clicked for player: " + selectedPlayer.getNom());
    }

    @FXML
    private void handleAfficher() {
        Joueur selectedPlayer = tableView.getSelectionModel().getSelectedItem();
        if (selectedPlayer == null) {
            showError("No Player Selected", "Please select a player to proceed.");
            return; // Prevent further execution
        }

        // Update the selected player in the singleton
        Equipe.getEquipe().setJoueurAvecBonus(selectedPlayer);

        Stage stage = (Stage) ajouter.getScene().getWindow();
        AfficherStatDC af = new AfficherStatDC();
        try {
            stage.setScene(af.getScene());
        } catch (IOException e) {
            e.printStackTrace();
            showError("Error Loading Scene", "An error occurred while opening the statistics screen.");
        }
    }

    @FXML
    private void handleModifier() {
        Joueur selectedPlayer = tableView.getSelectionModel().getSelectedItem();
        if (selectedPlayer != null) {
            System.out.println("Modifier clicked for " + selectedPlayer.getNom());
            // Logic to modify statistics for the selected player
        } else {
            showError("No Player Selected", "Please select a player to modify their statistics.");
        }
    }

    @FXML
    private void handleSupprimer() {
        Joueur selectedPlayer = tableView.getSelectionModel().getSelectedItem();
        if (selectedPlayer != null) {
            Equipe.getEquipe().getJoueurs().remove(selectedPlayer);
            tableView.refresh(); // Refresh the table view
            System.out.println("Supprimer clicked for " + selectedPlayer.getNom());
        } else {
            showError("No Player Selected", "Please select a player to delete.");
        }
    }

    private void showError(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public Scene getDataIngScene() throws IOException {
        javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("/fxml/DataIng.fxml"));
        return new Scene(loader.load());
    }
}
