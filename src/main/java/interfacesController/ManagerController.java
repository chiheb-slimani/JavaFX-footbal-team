package interfacesController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Equipe.Equipe;
import model.staff.Joueur;
import model.staff.Manager;
import org.w3c.dom.Text;

import java.io.IOException;


public class ManagerController {

    @FXML
    private TableView<Joueur> playerTable;
    @FXML
    private TableColumn<Joueur, String> nomColumn;
    @FXML
    private TableColumn<Joueur, String> prenomColumn;
    @FXML
    private TableColumn<Joueur, Integer> numeroColumn;
    @FXML
    private TableColumn<Joueur, String> positionColumn;

    @FXML
    private TextField nomField;
    @FXML
    private TextField prenomField;
    @FXML
    private TextField numeroField;
    @FXML
    private TextField positionField;

    @FXML
    private Button ajouterButton;
    @FXML
    private Button effacerButton;
    @FXML
    private Button modifierButton;

    @FXML
    private Button retourButton;
    @FXML
    private SplitMenuButton selectionnerMenuButton;

    @FXML
    private MenuItem afficherSelectionne;

    private ObservableList<Joueur> joueurs = Equipe.getEquipe().getJoueurs();

    @FXML
    public void initialize() {
        // Link columns to Joueur properties
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomColumn.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        numeroColumn.setCellValueFactory(new PropertyValueFactory<>("numero"));
        positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));

        // Set data for the TableView
        playerTable.setItems(joueurs);

        // Set up the selectionnerMenuButton action
        selectionnerMenuButton.setOnAction(event -> {
            String currentText = selectionnerMenuButton.getText();

            if ("Selectionner".equals(currentText)) {

                handleSelectionnerAction();

            } else if ("Afficher Selectionné".equals(currentText)) {


                handleAfficherSelectionneAction();

            }
        });

        // MenuItem: Toggle between "Afficher Selectionné" and "Selectionner"
        afficherSelectionne.setOnAction(event -> {
            if ("Afficher Selectionné".equals(afficherSelectionne.getText())) {
                // Swap the text to "Selectionner"
                selectionnerMenuButton.setText("Afficher Selectionné");
                afficherSelectionne.setText("Selectionner");
            } else {
                // Swap the text to "Afficher Selectionné"
                selectionnerMenuButton.setText("Selectionner");
                afficherSelectionne.setText("Afficher Selectionné");
            }
        });

        // Add event handlers for buttons
        ajouterButton.setOnAction(event -> ajouterJoueur());
        effacerButton.setOnAction(event -> effacerJoueur());
        modifierButton.setOnAction(event -> modifierJoueur());
        retourButton.setOnAction(event -> retourner());
    }


    // Logic for "Selectionner" action
    private void handleSelectionnerAction() {
        Joueur selectedPlayer = playerTable.getSelectionModel().getSelectedItem();
        Equipe.getEquipe().getManager().addJoueur(selectedPlayer);
        ShowMessageC.showMessage("Jouer selectionné avec succes");
    }

    // Logic for "Afficher Selectionné" action
    private void handleAfficherSelectionneAction() {
        // Create a new stage for the popup
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle("Players Selected by Manager");

        // Create a TableView to display the selected players
        TableView<Joueur> selectedPlayersTable = new TableView<>();

        // Define columns
        TableColumn<Joueur, String> nomColumn = new TableColumn<>("Nom");
        TableColumn<Joueur, String> prenomColumn = new TableColumn<>("Prenom");
        TableColumn<Joueur, Integer> numeroColumn = new TableColumn<>("Numero");
        TableColumn<Joueur, String> positionColumn = new TableColumn<>("Position");

        // Link the columns to Joueur properties
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomColumn.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        numeroColumn.setCellValueFactory(new PropertyValueFactory<>("numero"));
        positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));

        // Add columns to the TableView
        selectedPlayersTable.getColumns().addAll(nomColumn, prenomColumn, numeroColumn, positionColumn);

        // Set the data (selected players from the manager)
        ObservableList<Joueur> selectedPlayers = FXCollections.observableArrayList(
                Equipe.getEquipe().getManager().getJoueurs()
        );
        selectedPlayersTable.setItems(selectedPlayers);

        // Make TableView fill the scene and resize columns
        selectedPlayersTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox.setVgrow(selectedPlayersTable, Priority.ALWAYS);

        // Styling for the TableView
        selectedPlayersTable.setStyle("""
        -fx-background-color: white; /* Table content background remains white */
        -fx-border-color: #d3d3d3; /* Subtle gray border for the table */
    """);

        // Style column headers (blue background, white text)
        selectedPlayersTable.lookupAll(".column-header").forEach(header -> header.setStyle("""
        -fx-background-color: #1E90FF; /* Blue header background */
        -fx-text-fill: white; /* White text for column titles */
        -fx-font-weight: bold; /* Bold header text */
    """));

        // Style rows to ensure the background stays white
        selectedPlayersTable.setRowFactory(tv -> {
            TableRow<Joueur> row = new TableRow<>();
            row.itemProperty().addListener((obs, oldItem, newItem) -> {
                if (!row.isEmpty()) {
                    row.setStyle("-fx-background-color: white;"); // Keep rows white
                }
            });
            return row;
        });

        // Close button
        Button closeButton = new Button("Close");
        closeButton.setStyle("""
        -fx-background-color: #1E90FF; /* Blue background */
        -fx-text-fill: white; /* White text */
        -fx-font-size: 14px; /* Text size */
        -fx-font-weight: bold; /* Bold text */
        -fx-border-color: #1E90FF; /* Match button border to background */
        -fx-border-radius: 5px; /* Rounded corners */
        -fx-background-radius: 5px; /* Rounded corners */
        -fx-padding: 8px 15px; /* Add padding for better spacing */
    """);
        closeButton.setOnAction(e -> popupStage.close());

        // Layout setup
        VBox layout = new VBox(10, selectedPlayersTable, closeButton);
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #ffffff;"); // White background for the popup

        // Scene setup
        Scene popupScene = new Scene(layout, 600, 450);
        popupStage.setScene(popupScene);

        // Show the popup
        popupStage.showAndWait();
    }




    private void ajouterJoueur() {
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String numeroText = numeroField.getText();
        String position = positionField.getText();

        try {
            int numero = Integer.parseInt(numeroText);
            Joueur joueur = new Joueur(nom, prenom, numero, position);
            joueurs.add(joueur);
            Equipe.getEquipe().getManager().addJoueur(joueur);
            clearFields();

        } catch (NumberFormatException e) {
            showAlert("Erreur", "Le numero doit etre un entier valide.");
        }
    }

    private void effacerJoueur() {
        Joueur selected = playerTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            joueurs.remove(selected);
        } else {
            showAlert("Erreur", "Aucun joueur selectionne.");
        }
    }

    private void modifierJoueur() {
        Joueur selected = playerTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setNom(nomField.getText());
            selected.setPrenom(prenomField.getText());
            try {
                selected.setNumero(Integer.parseInt(numeroField.getText()));
            } catch (NumberFormatException e) {
                showAlert("Erreur", "Le numero doit etre un entier valide.");
                return;
            }
            selected.setPosition(positionField.getText());
            playerTable.refresh();
        } else {
            showAlert("Erreur", "Aucun joueur selectionne.");
        }
    }




    private void retourner() {
        Stage stage = (Stage) retourButton.getScene().getWindow();
        LoginManagerC loginManager = new LoginManagerC();
        try {
            stage.setScene(loginManager.getManagerLoginscene());
        } catch (Exception e) {
            throw new RuntimeException(e);
    }}

    private void clearFields() {
        nomField.clear();
        prenomField.clear();
        numeroField.clear();
        positionField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
    public Scene getManagerControllerscene() throws IOException {javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("/fxml/Manager.fxml"));
        Scene scene = new Scene(loader.load());
        return scene;}

}
