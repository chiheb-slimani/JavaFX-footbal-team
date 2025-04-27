package interfacesController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Equipe.Equipe;
import model.statistiques.StatistiqueDefenseur;
import model.statistiques.StatistiqueMatch;
import model.statistiques.StatistiqueAttaquant;

public class AfficherStatAC {

    @FXML private TableView<StatistiqueDefenseur> tableView;
    @FXML private TableColumn<StatistiqueMatch, Integer> matchidColumn;
    @FXML private TableColumn<StatistiqueMatch, Integer> noteColumn;
    @FXML private TableColumn<StatistiqueMatch, Integer> minutesColumn;
    @FXML private TableColumn<StatistiqueMatch, Integer> sprintDistanceColumn;
    @FXML private TableColumn<StatistiqueAttaquant, Integer> butsColumn;
    @FXML private TableColumn<StatistiqueAttaquant, Integer> assistsColumn;

    private ObservableList<StatistiqueDefenseur> stats = FXCollections.observableArrayList();

    public void initialize() {
        // Mock Data for testing
        stats= Equipe.getEquipe().getJoueurAvecBonus().getStatistiqueJoueur().getStats();

        // Set up column-cell bindings
        matchidColumn.setCellValueFactory(new PropertyValueFactory<>("matchid"));
        noteColumn.setCellValueFactory(new PropertyValueFactory<>("note"));
        minutesColumn.setCellValueFactory(new PropertyValueFactory<>("minutes"));
        sprintDistanceColumn.setCellValueFactory(new PropertyValueFactory<>("sprintDistance"));
        butsColumn.setCellValueFactory(new PropertyValueFactory<>("buts"));
        assistsColumn.setCellValueFactory(new PropertyValueFactory<>("assists"));

        // Set data for the TableView
        tableView.setItems(stats);

    }
}
