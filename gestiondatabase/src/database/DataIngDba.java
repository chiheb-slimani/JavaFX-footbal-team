package database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataIngDba {
    private String requette;
    private DbaConnector dba;
    public DataIngDba() {
        this.requette = "CREATE TABLE IF NOT EXISTS `Dataing` ("
                + "`iddataing` INT AUTO_INCREMENT PRIMARY KEY, "
                + "`nomprenomdataing` VARCHAR(255) NOT NULL, "
                + "`emaild` VARCHAR(255) NOT NULL, "
                + "`passwordd` VARCHAR(255) NOT NULL, "
                + "`salaryd` INT NOT NULL"
                + ");";
        this.dba = new DbaConnector();

    }
    public void createDataIng(){
        dba.createTable(requette);
    }
    public void ajouterStatistique(StatistiqueMatchRecord statistique) {
        String insertSQL = "INSERT INTO `Statistiquematch` "
                + "(`idjoueur`, `idmatch`, `note`, `minutes`, `sprintdistance`, `buts`, `assists`, `recuperationballs`, `keypass`, `cleansheet`) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try (Connection connection = dba.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            // Ajouter les valeurs au statement
            preparedStatement.setInt(1, statistique.idjoueur());
            preparedStatement.setInt(2, statistique.idmatch());
            preparedStatement.setInt(3, statistique.note());
            preparedStatement.setInt(4, statistique.minutes());
            preparedStatement.setInt(5, statistique.sprintdistance());
            preparedStatement.setObject(6, statistique.buts());
            preparedStatement.setObject(7, statistique.assists());
            preparedStatement.setObject(8, statistique.recuperationballs());
            preparedStatement.setObject(9, statistique.keypass());
            preparedStatement.setObject(10, statistique.cleansheet());

            // Exécuter la requête
            int rowsInserted = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de l'ajout de la statistique.");

        }
    }
    public void modifierStatistique(StatistiqueMatchRecord statistique) {
        String updateSQL = "UPDATE `Statistiquematch` SET "
                + "`idjoueur` = ?, `idmatch` = ?, `note` = ?, `minutes` = ?, `sprintdistance` = ?, "
                + "`buts` = ?, `assists` = ?, `recuperationballs` = ?, `keypass` = ?, `cleansheet` = ? "
                + "WHERE `idstatistiquematch` = ?;";

        try (Connection connection = dba.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {

            // Ajouter les valeurs au statement
            preparedStatement.setInt(1, statistique.idjoueur());
            preparedStatement.setInt(2, statistique.idmatch());
            preparedStatement.setInt(3, statistique.note());
            preparedStatement.setInt(4, statistique.minutes());
            preparedStatement.setInt(5, statistique.sprintdistance());
            preparedStatement.setObject(6, statistique.buts());
            preparedStatement.setObject(7, statistique.assists());
            preparedStatement.setObject(8, statistique.recuperationballs());
            preparedStatement.setObject(9, statistique.keypass());
            preparedStatement.setObject(10, statistique.cleansheet());
            preparedStatement.setInt(11, statistique.idstatistiquematch());

            // Exécuter la requête
            int rowsUpdated = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la modification de la statistique.");

        }
    }
    public void supprimerStatistique(int idstatistiquematch) {
        String deleteSQL = "DELETE FROM `Statistiquematch` WHERE `idstatistiquematch` = ?;";

        try (Connection connection = dba.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {

            // Ajouter la valeur de l'ID au statement
            preparedStatement.setInt(1, idstatistiquematch);

            // Exécuter la requête
            int rowsDeleted = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la suppression de la statistique.");

        }
    }


}
