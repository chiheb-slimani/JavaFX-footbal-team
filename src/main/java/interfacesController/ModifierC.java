package interfacesController;



import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Equipe.Equipe;
import model.staff.Joueur;

public class ModifierC {

    @FXML
    private TextField nomField, prenomField, numeroField, contractField, salaryField, factorAField, factorBField;
    @FXML
    private Label totalLabel;

    private Joueur joueur;

    public void initialize() {
        joueur = Equipe.getEquipe().getJoueurAvecBonus();

        // Populate fields
        nomField.setText(joueur.getNom());
        prenomField.setText(joueur.getPrenom());
        numeroField.setText(String.valueOf(joueur.getNumero()));
        contractField.setText(String.valueOf(joueur.getContractMonths()));
        salaryField.setText(String.valueOf(joueur.getSalary()));
        calculateTotal();
    }

    @FXML
    private void calculateTotal() {
        try {
            int months = Integer.parseInt(contractField.getText());
            int salary = Integer.parseInt(salaryField.getText());
            int factorA = Integer.parseInt(factorAField.getText());
            int factorB = Integer.parseInt(factorBField.getText());

            int cleanSheets = joueur.getStatistiqueJoueur().getStats().stream()
                    .mapToInt(stat -> stat.getCleansheet())
                    .sum();
            int ballRecoveries = joueur.getStatistiqueJoueur().getStats().stream()
                    .mapToInt(stat -> stat.getRecuperationDeBalles())
                    .sum();

            int total = (months * salary) + (factorA * cleanSheets) + (factorB * ballRecoveries);
            totalLabel.setText(String.valueOf(total));
        } catch (NumberFormatException e) {
            totalLabel.setText("Invalid Input");
        }
    }

    @FXML
    private void saveChanges() {
        // Save changes to the selectedPlayer
        joueur.setNom(nomField.getText());
        joueur.setPrenom(prenomField.getText());
        joueur.setNumero(Integer.parseInt(numeroField.getText()));
        joueur.setContractMonths(Integer.parseInt(contractField.getText()));
        joueur.setSalary(Integer.parseInt(salaryField.getText()));


        // Update the main TableView (handled in parent controller)
        Stage stage = (Stage) nomField.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void goBack() {
        Stage stage = (Stage) nomField.getScene().getWindow();
        stage.close();
    }
}
