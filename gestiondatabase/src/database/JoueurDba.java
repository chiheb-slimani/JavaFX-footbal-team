package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JoueurDba {
    private final String requette;
    private final DbaConnector dba;

    // Constructor
    public JoueurDba() {
        this.requette = "CREATE TABLE IF NOT EXISTS `Joueur` ("
                + "`idjoueur` INT AUTO_INCREMENT PRIMARY KEY, "
                + "`nomprenomjoueur` VARCHAR(255) NOT NULL, "
                + "`position` VARCHAR(255) NOT NULL, "
                + "`emailj` VARCHAR(255) NOT NULL, "
                + "`passwordj` VARCHAR(255) NOT NULL, "
                + "`salaryj` INT NOT NULL, "
                + "`contractmonthsj` INT NOT NULL, "
                + "`num` INT NOT NULL, "
                + "`idequipe` INT NOT NULL, "
                + "`idmanager` INT NOT NULL, "
                + "FOREIGN KEY (`idequipe`) REFERENCES `Equipe`(`idequipe`) ON DELETE CASCADE, "
                + "FOREIGN KEY (`idmanager`) REFERENCES `Manager`(`idmanager`) ON DELETE CASCADE, "
                + ");";
        this.dba = new DbaConnector();
    }

    // Method to create the `Joueur` table
    public void createJoueur() {
        dba.createTable(requette);
    }

    // Method to add a `Joueur` to the table
    public void ajouterJoueur(JoueurRecord joueur) {
        String insertSQL = "INSERT INTO `Joueur` (nomprenomjoueur,position, emailj, passwordj, salaryj, contractmonthsj, num, "
                + "idequipe, idmanager) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try (Connection connection = dba.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            // Set parameters for the prepared statement using the JoueurRecord object
            preparedStatement.setString(1, joueur.nomprenomjoueur());
            preparedStatement.setString(3, joueur.position());
            preparedStatement.setString(3, joueur.emailj());
            preparedStatement.setString(4, joueur.passwordj());
            preparedStatement.setInt(5, joueur.salaryj());
            preparedStatement.setInt(6, joueur.contractmonthsj());
            preparedStatement.setInt(7, joueur.num());
            preparedStatement.setInt(8, joueur.idequipe());
            preparedStatement.setInt(9, joueur.idmanager());
            // Execute the query
            int rowsAffected = preparedStatement.executeUpdate();

            // Check result
            if (rowsAffected > 0) {
                System.out.println("Joueur added successfully!");
            } else {
                System.out.println("Failed to add Joueur.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error occurred while adding a Joueur.");
        }
    }
    public void modifierJoueur(JoueurRecord joueur) {
        String updateSQL = "UPDATE `Joueur` SET " +
                "nomprenomjoueur = ?, emailj = ?, passwordj = ?, salaryj = ?, " +
                "contractmonthsj = ?, num = ?, idequipe = ?, idmanager = ?, " +
                " position = ? " +
                "WHERE idjoueur = ?;";

        try (Connection connection = dba.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {

            // Set parameters for the prepared statement
            preparedStatement.setString(1, joueur.nomprenomjoueur());
            preparedStatement.setString(2, joueur.emailj());
            preparedStatement.setString(3, joueur.passwordj());
            preparedStatement.setInt(4, joueur.salaryj());
            preparedStatement.setInt(5, joueur.contractmonthsj());
            preparedStatement.setInt(6, joueur.num());
            preparedStatement.setInt(7, joueur.idequipe());
            preparedStatement.setInt(8, joueur.idmanager());
            preparedStatement.setString(9, joueur.position());
            preparedStatement.setInt(10, joueur.idjoueur());

            // Execute the update
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Joueur updated successfully!");
            } else {
                System.out.println("No Joueur found with the given ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error occurred while updating the Joueur.");
        }
    }
    public void supprimerJoueur(int idjoueur) {
        String deleteSQL = "DELETE FROM `Joueur` WHERE idjoueur = ?;";

        try (Connection connection = dba.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {

            // Set the parameter for the prepared statement
            preparedStatement.setInt(1, idjoueur);

            // Execute the delete
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Joueur deleted successfully!");
            } else {
                System.out.println("No Joueur found with the given ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error occurred while deleting the Joueur.");
        }
    }
    public List<JoueurRecord> getAllJoueurs() {
        String selectSQL = "SELECT * FROM `Joueur`;";
        List<JoueurRecord> joueurs = new ArrayList<>();

        try (Connection connection = dba.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            // Parcourir les résultats
            while (resultSet.next()) {
                // Créer un objet JoueurRecord pour chaque ligne
                JoueurRecord joueur = new JoueurRecord(
                        resultSet.getInt("idjoueur"),
                        resultSet.getString("nomprenomjoueur"),
                        resultSet.getString("position"),
                        resultSet.getString("emailj"),
                        resultSet.getString("passwordj"),
                        resultSet.getInt("salaryj"),
                        resultSet.getInt("contractmonthsj"),
                        resultSet.getInt("num"),
                        resultSet.getInt("idequipe"),
                        resultSet.getInt("idmanager")
                );

                // Ajouter le joueur à la liste
                joueurs.add(joueur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error occurred while retrieving players.");
        }

        return joueurs;
    }
    //=============== recherche de joueur====================
    public List<JoueurRecord> chercherJoueurParNom(String nom) {
        String selectSQL = "SELECT * FROM `Joueur` WHERE `nomprenomjoueur` LIKE ?;";
        List<JoueurRecord> joueursTrouves = new ArrayList<>();

        try (Connection connection = dba.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {

            // Ajouter des jokers pour une recherche partielle
            preparedStatement.setString(1, "%" + nom + "%");

            // Exécuter la requête
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    // Créer un objet JoueurRecord pour chaque ligne trouvée
                    JoueurRecord joueur = new JoueurRecord(
                            resultSet.getInt("idjoueur"),
                            resultSet.getString("nomprenomjoueur"),
                            resultSet.getString("position"),
                            resultSet.getString("emailj"),
                            resultSet.getString("passwordj"),
                            resultSet.getInt("salaryj"),
                            resultSet.getInt("contractmonthsj"),
                            resultSet.getInt("num"),
                            resultSet.getInt("idequipe"),
                            resultSet.getInt("idmanager")
                    );

                    // Ajouter le joueur à la liste
                    joueursTrouves.add(joueur);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error occurred while searching for players by name.");
        }

        return joueursTrouves;
    }
    /// return statistques
}
