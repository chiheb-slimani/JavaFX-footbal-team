package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipeDba {
    private String requette;
    private DbaConnector dba;
    public EquipeDba() {
        this.requette = "CREATE TABLE IF NOT EXISTS `Equipe` ("
                + "`idequipe` INT AUTO_INCREMENT PRIMARY KEY, "
                + "`nomequipe` VARCHAR(255) NOT NULL, "
                + "`idmanager` INT NOT NULL, "
                + "`idcomptable` INT NOT NULL, "
                + "`iddataing` INT NOT NULL, "
                + "FOREIGN KEY (`idmanager`) REFERENCES `Manager`(`idmanager`) ON DELETE CASCADE,"
                + "FOREIGN KEY (`idcomptable`) REFERENCES `Comptable`(`idcomptable`) ON DELETE CASCADE,"
                + "FOREIGN KEY (`iddataing`) REFERENCES `Dataing`(`iddataing`) ON DELETE CASCADE"
                + ");";
        this.dba = new DbaConnector();

    }
    public void createEquipe(){
        dba.createTable(requette);
    }
    //=============get joueurs=========================
    public List<JoueurRecord> getEquipeJoueurs(int idequipe) {
        String selectSQL = "SELECT * FROM `Joueur` WHERE idequipe = ?;";
        List<JoueurRecord> joueurs = new ArrayList<>();

        try (Connection connection = dba.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {

            // Assigner la valeur au paramètre de la requête
            preparedStatement.setInt(1, idequipe);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error occurred while retrieving players.");
        }

        return joueurs;
    }
    public List<EquipeRecord> getAllEquipes() {
        String selectSQL = "SELECT * FROM `Equipe`;";
        List<EquipeRecord> equipes = new ArrayList<>();

        try (Connection connection = dba.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            // Parcourir les résultats
            while (resultSet.next()) {
                // Créer un objet EquipeRecord pour chaque ligne
                EquipeRecord equipe = new EquipeRecord(
                        resultSet.getInt("idequipe"),
                        resultSet.getString("nomequipe"),
                        resultSet.getInt("idmanager"),
                        resultSet.getInt("idcomptable"),
                        resultSet.getInt("iddataing")
                );

                // Ajouter l'équipe à la liste
                equipes.add(equipe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error occurred while retrieving teams.");
        }

        return equipes;
    }
}
