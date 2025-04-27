package interfacesController;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Equipe.Equipe;
import model.staff.Joueur;

import java.io.IOException;

public class ComptableC implements Loader {

    @FXML
    private TableView<Joueur> playersTable;

    @FXML
    private TableColumn<Joueur, String> colNom;

    @FXML
    private TableColumn<Joueur, String> colPrenom;

    @FXML
    private TableColumn<Joueur, String> colPosition;

    @FXML
    private TableColumn<Joueur, Integer> colContractMonths;

    @FXML
    private TableColumn<Joueur, Double> colSalary;

    @FXML
    private TableColumn<Joueur, String> colAction;

    @FXML
    private Button retour;  // Make sure this fx:id matches the one in your FXML file

    private ObservableList<Joueur> players = Equipe.getEquipe().getJoueurs();

    public void initialize() {
        // Configure "Retour" button
        if (retour != null) {
            retour.setOnAction(event -> {
                Stage stage = (Stage) retour.getScene().getWindow();
                MenuC menuController = new MenuC();
                try {
                    stage.setScene(menuController.getMenuscene());
                } catch (IOException e) {
                    throw new RuntimeException("Error returning to the menu", e);
                }
            });
        }

        // Set up column-cell bindings
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
        colContractMonths.setCellValueFactory(new PropertyValueFactory<>("contractMonths"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));

        // Configure "Action" column with a custom button
        colAction.setCellFactory(param -> new TableCell<>() {
            private final Button modifyButton = new Button("Modify");

            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || getTableRow().getItem() == null) {
                    setGraphic(null);
                } else {
                    setGraphic(modifyButton);
                    modifyButton.setOnAction(event -> {
                        Joueur selectedPlayer = getTableRow().getItem();
                        openModifyPlayerPanel();
                    });
                }
            }
        });

        // Initialize mock player data (replace with actual data retrieval)
        // Example: players.add(new Joueur("John", "Doe", "Midfielder", 12, 30000.0));

        // Set data in TableView
        playersTable.setItems(players);
    }

    private void openModifyPlayerPanel() {
        // Get the selected player from the TableView
        Joueur selectedPlayer = playersTable.getSelectionModel().getSelectedItem();

        if (selectedPlayer == null) {
            // Handle case where no item is selected
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please select a player to modify.");
            alert.showAndWait();
            return;
        }

        try {Equipe.getEquipe().setJoueurAvecBonus(selectedPlayer);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Modifier.fxml"));
            Parent root = loader.load();

            // Get the controller and pass the selected player
            ModifierC controller = loader.getController();
            // Pass the player to the modification panel

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();

            // Refresh the TableView after closing the modification panel
            playersTable.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

@Override
    public Scene getScene() throws IOException {
        javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("/fxml/Comptable.fxml"));
        return new Scene(loader.load());
    }

}
