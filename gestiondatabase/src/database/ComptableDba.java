package database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComptableDba {
    private String requette;
    private DbaConnector dba;
    public ComptableDba() {
        this.requette = "CREATE TABLE IF NOT EXISTS `Comptable` ("
                + "`idcomptable` INT AUTO_INCREMENT PRIMARY KEY, "
                + "`nomprenomcomptable` VARCHAR(255) NOT NULL, "
                + "`emailc` VARCHAR(255) NOT NULL, "
                + "`passwordc` VARCHAR(255) NOT NULL, "
                + "`salaryc` INT NOT NULL"
                + ");";
        this.dba = new DbaConnector();

    }
    public void createComptable(){
        dba.createTable(requette);
    }
    public void ajouterComptable(ComptableRecord comptable) {
        String insertSQL = "INSERT INTO `Comptable` (`nomprenomcomptable`, `emailc`, `passwordc`, `salaryc`) VALUES (?, ?, ?, ?);";

        try (Connection connection = dba.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            // Ajouter les valeurs au statement
            preparedStatement.setString(1, comptable.nomprenomcomptable());
            preparedStatement.setString(2, comptable.emailc());
            preparedStatement.setString(3, comptable.passwordc());
            preparedStatement.setInt(4, comptable.salaryc());

            // Exécuter la requête
            int rowsInserted = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de l'ajout du comptable.");

        }
    }
    public void modifierComptable(ComptableRecord comptable) {
        String updateSQL = "UPDATE `Comptable` SET `nomprenomcomptable` = ?, `emailc` = ?, `passwordc` = ?, `salaryc` = ? WHERE `idcomptable` = ?;";

        try (Connection connection = dba.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {

            // Ajouter les valeurs au statement
            preparedStatement.setString(1, comptable.nomprenomcomptable());
            preparedStatement.setString(2, comptable.emailc());
            preparedStatement.setString(3, comptable.passwordc());
            preparedStatement.setInt(4, comptable.salaryc());
            preparedStatement.setInt(5, comptable.idcomptable());

            // Exécuter la requête
            int rowsUpdated = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la modification du comptable.");

        }
    }
    public void supprimerComptable(int idcomptable) {
        String deleteSQL = "DELETE FROM `Comptable` WHERE `idcomptable` = ?;";

        try (Connection connection = dba.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {

            // Ajouter la valeur de l'ID au statement
            preparedStatement.setInt(1, idcomptable);

            // Exécuter la requête
            int rowsDeleted = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la suppression du comptable.");

        }
    }
//========= ajouter jouer avec bonus===============
public void ajouterJoueurAvecBonus(int idjoueur, float facteura, float facteurb) {
    String insertSQL = "INSERT INTO `Joueuravecbonus` (`idjoueur`, `facteura`, `facteurb`) VALUES (?, ?, ?);";

    try (Connection connection = dba.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

        // Ajouter les valeurs au statement
        preparedStatement.setInt(1, idjoueur);
        preparedStatement.setFloat(2, facteura);
        preparedStatement.setFloat(3, facteurb);

        // Exécuter la requête
        int rowsInserted = preparedStatement.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Erreur lors de l'ajout du joueur avec bonus.");

    }}
    //================ modifier joueur avec bonus ================
    public void modifierJoueurAvecBonus(int idjabonus, float facteura, float facteurb) {
        String updateSQL = "UPDATE `Joueuravecbonus` SET `facteura` = ?, `facteurb` = ? WHERE `idjabonus` = ?;";

        try (Connection connection = dba.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {

            // Ajouter les valeurs au statement
            preparedStatement.setFloat(1, facteura);
            preparedStatement.setFloat(2, facteurb);
            preparedStatement.setInt(3, idjabonus);

            // Exécuter la requête
            int rowsUpdated = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la modification du joueur avec bonus.");

        }
    }
//=================== supprimer joueur avec bonus========================
    public void supprimerJoueurAvecBonus (int idjabonus) {
        String deleteSQL = "DELETE FROM `Joueuravecbonus` WHERE `idjabonus` = ?;";

        try (Connection connection = dba.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {

            // Ajouter la valeur de l'ID au statement
            preparedStatement.setInt(1, idjabonus);

            // Exécuter la requête
            int rowsDeleted = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la suppression du joueur avec bonus.");

        }
    }



}
