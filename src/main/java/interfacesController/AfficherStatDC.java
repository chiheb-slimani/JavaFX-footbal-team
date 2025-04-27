package interfacesController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import model.Equipe.Equipe;
import model.statistiques.StatistiqueDefenseur;
import model.statistiques.StatistiqueMatch;
import model.statistiques.StatistiqueAttaquant;

import java.io.IOException;

public class AfficherStatDC {

    @FXML private TableView<StatistiqueDefenseur> tableView;
    @FXML private TableColumn<StatistiqueMatch, Integer> matchidColumn;
    @FXML private TableColumn<StatistiqueMatch, Integer> noteColumn;
    @FXML private TableColumn<StatistiqueMatch, Integer> minutesColumn;
    @FXML private TableColumn<StatistiqueMatch, Integer> sprintDistanceColumn;
    @FXML private TableColumn<StatistiqueDefenseur, Integer> cleanSheetColumn;
    @FXML private TableColumn<StatistiqueDefenseur, Integer> recuperationDeBallesColumn;

    @FXML private TextField matchIdField;
    @FXML private TextField noteField;
    @FXML private TextField minutesField;
    @FXML private TextField sprintDistanceField;
    @FXML private TextField cleanSheetField;
    @FXML private TextField recuperationDeBallesField;
@FXML private Button retour;
    @FXML private Button supprimerButton;
    @FXML private Button modifierButton;

    private ObservableList<StatistiqueDefenseur> stats = FXCollections.observableArrayList();

    public void initialize() {
        retour.setOnAction(event -> {
            Stage stage = new Stage();
            stage= (Stage) retour.getScene().getWindow();
            DataIngC d = new DataIngC();
            try {
                stage.setScene(d.getDataIngScene());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });
        // Mock data initialization (or replace with actual data retrieval logic)
        stats = Equipe.getEquipe().getJoueurAvecBonus().getStatistiqueJoueur().getStats();

        // Set up column-cell bindings
        matchidColumn.setCellValueFactory(new PropertyValueFactory<>("matchid"));
        noteColumn.setCellValueFactory(new PropertyValueFactory<>("note"));
        minutesColumn.setCellValueFactory(new PropertyValueFactory<>("minutes"));
        sprintDistanceColumn.setCellValueFactory(new PropertyValueFactory<>("sprintDistance"));
        cleanSheetColumn.setCellValueFactory(new PropertyValueFactory<>("cleansheet"));
        recuperationDeBallesColumn.setCellValueFactory(new PropertyValueFactory<>("recuperationDeBalles"));

        // Set data for the TableView
        tableView.setItems(stats);

        // Use lambda expressions for button actions
        supprimerButton.setOnAction(event -> {
            // Get selected item
            StatistiqueDefenseur selectedStat = tableView.getSelectionModel().getSelectedItem();
            if (selectedStat != null) {
                // Remove the selected item from the observable list
                stats.remove(selectedStat);
            }
        });

        modifierButton.setOnAction(event -> {
            // Get the selected item
            StatistiqueDefenseur selectedStat = tableView.getSelectionModel().getSelectedItem();
            if (selectedStat != null) {
                try {
                    // Parse and update values from input fields
                    selectedStat.setMatchid(Integer.parseInt(matchIdField.getText()));
                    selectedStat.setNote(Integer.parseInt(noteField.getText()));
                    selectedStat.setMinutes(Integer.parseInt(minutesField.getText()));
                    selectedStat.setSprintDistance(Integer.parseInt(sprintDistanceField.getText()));
                    selectedStat.setCleanSheet(Integer.parseInt(cleanSheetField.getText()));
                    selectedStat.setRecuperationDeBalles(Integer.parseInt(recuperationDeBallesField.getText()));

                    // Refresh the TableView to display updated values
                    tableView.refresh();
                } catch (NumberFormatException e) {
                    System.err.println("Invalid input: " + e.getMessage());
                    // Add error handling or user feedback here
                }
            }
        });
    }

    public Scene getScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AfficherStatD.fxml"));
        return new Scene(loader.load());
    }
}
