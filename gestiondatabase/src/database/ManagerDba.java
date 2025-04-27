package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerDba {
    private String requette;
    private DbaConnector dba;
    public ManagerDba() {
        this.requette = "CREATE TABLE IF NOT EXISTS `Manager` ("
                + "`idmanager` INT AUTO_INCREMENT PRIMARY KEY, "
                + "`nomprenommanager` VARCHAR(255) NOT NULL, "
                + "`emailm` VARCHAR(255) NOT NULL, "
                + "`passwordm` VARCHAR(255) NOT NULL, "
                + "`salarym` INT NOT NULL, "
                + "`contractmonthsm` INT NOT NULL "
                + ");";
        this.dba = new DbaConnector();

    }
    public void createManager(){
        dba.createTable(requette);
    }
    //========================ajouter joueur===============
    public void ajouterJoueur(JoueurRecord joueur) {
        String selectEquipeSQL = "SELECT idequipe FROM `Equipe` WHERE idmanager = ?;";
        String insertJoueurSQL = "INSERT INTO `Joueur` (nomprenomjoueur, position, emailj, passwordj, salaryj, contractmonthsj, num, idequipe, idmanager) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try (Connection connection = dba.getConnection();
             PreparedStatement selectStmt = connection.prepareStatement(selectEquipeSQL);
             PreparedStatement insertStmt = connection.prepareStatement(insertJoueurSQL)) {

            // Étape 1 : Récupérer l'ID de l'équipe à partir du Manager
            selectStmt.setInt(1, joueur.idmanager());
            try (ResultSet resultSet = selectStmt.executeQuery()) {
                if (resultSet.next()) {
                    int idequipe = resultSet.getInt("idequipe");

                    // Étape 2 : Insérer le joueur dans la base de données
                    insertStmt.setString(1, joueur.nomprenomjoueur());
                    insertStmt.setString(2, joueur.position());
                    insertStmt.setString(3, joueur.emailj());
                    insertStmt.setString(4, joueur.passwordj());
                    insertStmt.setInt(5, joueur.salaryj());
                    insertStmt.setInt(6, joueur.contractmonthsj());
                    insertStmt.setInt(7, joueur.num());
                    insertStmt.setInt(8, idequipe);
                    insertStmt.setInt(9, joueur.idmanager());

                    int rowsInserted = insertStmt.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("Joueur ajouté avec succès !");
                    }
                } else {
                    System.out.println("Aucune équipe trouvée pour le manager spécifié.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Une erreur s'est produite lors de l'ajout du joueur.");
        }
    }
    //=============== modification de joueur=================
    public void modifierJoueur(JoueurRecord joueur) {
        String updateSQL = "UPDATE `Joueur` SET nomprenomjoueur = ?, position = ?, emailj = ?, passwordj = ?, " +
                "salaryj = ?, contractmonthsj = ?, num = ? WHERE idjoueur = ?;";

        try (Connection connection = dba.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {

            // Assigner les valeurs aux paramètres
            preparedStatement.setString(1, joueur.nomprenomjoueur());
            preparedStatement.setString(2, joueur.position());
            preparedStatement.setString(3, joueur.emailj());
            preparedStatement.setString(4, joueur.passwordj());
            preparedStatement.setInt(5, joueur.salaryj());
            preparedStatement.setInt(6, joueur.contractmonthsj());
            preparedStatement.setInt(7, joueur.num());
            preparedStatement.setInt(8, joueur.idjoueur());

            // Exécuter la mise à jour
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Joueur modifié avec succès !");
            } else {
                System.out.println("Aucun joueur trouvé avec l'ID spécifié.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Une erreur s'est produite lors de la modification du joueur.");
        }
    }
    //========================supression de joueur======================
    public void supprimerJoueur(int idjoueur) {
        String deleteSQL = "DELETE FROM `Joueur` WHERE idjoueur = ?;";

        try (Connection connection = dba.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {

            // Assigner l'ID du joueur au paramètre
            preparedStatement.setInt(1, idjoueur);

            // Exécuter la suppression
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Joueur supprimé avec succès !");
            } else {
                System.out.println("Aucun joueur trouvé avec l'ID spécifié.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Une erreur s'est produite lors de la suppression du joueur.");
        }
    }
    public List<ManagerRecord> getAllManagers() {
        String selectSQL = "SELECT * FROM `Manager`;";
        List<ManagerRecord> managers = new ArrayList<>();

        try (Connection connection = dba.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            // Parcourir les résultats
            while (resultSet.next()) {
                // Créer un objet ManagerRecord pour chaque ligne
                ManagerRecord manager = new ManagerRecord(
                        resultSet.getInt("idmanager"),
                        resultSet.getString("nomprenommanager"),
                        resultSet.getString("emailm"),
                        resultSet.getString("passwordm"),
                        resultSet.getInt("salarym"),
                        resultSet.getInt("contractmonthsm")
                );

                // Ajouter le manager à la liste
                managers.add(manager);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Une erreur s'est produite lors de la récupération des managers.");
        }

        return managers;
    }


}
