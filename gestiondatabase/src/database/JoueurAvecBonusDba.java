package database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class JoueurAvecBonusDba {
    private String requette;
    private DbaConnector dba;
    public JoueurAvecBonusDba(String requette, DbaConnector dba) {
        this.requette = "CREATE TABLE IF NOT EXISTS `Joueuravecbonus` ("
                + "`idjabonus` INT AUTO_INCREMENT PRIMARY KEY, "
                + "`facteura` FLOAT NOT NULL, "
                + "`facteurb` FLOAT NOT NULL, "
                + "`idjoueur` INT NOT NULL, "
                + "FOREIGN KEY (`idjoueur`) REFERENCES `Joueur`(`idjoueur`) ON DELETE CASCADE"
                + ");";
        this.dba = new DbaConnector();

    }
    public void createJoueur(){
        dba.createTable(requette);
    }
    public List<JoueurAvecBonusRecord> getAllJoueurAvecBonus() {
        String selectSQL = "SELECT * FROM `Joueuravecbonus`;";
        List<JoueurAvecBonusRecord> joueursAvecBonus = new ArrayList<>();

        try (Connection connection = dba.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            // Parcourir les résultats
            while (resultSet.next()) {
                // Créer un objet JoueurAvecBonusRecord pour chaque ligne
                JoueurAvecBonusRecord joueur = new JoueurAvecBonusRecord(
                        resultSet.getInt("idjabonus"),
                        resultSet.getFloat("facteura"),
                        resultSet.getFloat("facteurb"),
                        resultSet.getInt("idjoueur")
                );

                // Ajouter le joueur avec bonus à la liste
                joueursAvecBonus.add(joueur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la récupération des joueurs avec bonus.");
        }

        return joueursAvecBonus;
    }

}
