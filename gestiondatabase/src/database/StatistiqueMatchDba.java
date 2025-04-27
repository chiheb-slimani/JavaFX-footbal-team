package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StatistiqueMatchDba {
    private String requette;
    private DbaConnector dba;
    public StatistiqueMatchDba() {
        this.requette = "CREATE TABLE IF NOT EXISTS `Statistiquematch` ("
                + "`idstatistiquematch` INT AUTO_INCREMENT PRIMARY KEY, "
                + "`idjoueur` INT NOT NULL, "
                + "`idmatch` INT NOT NULL, "
                + "`note` INT NOT NULL, "
                + "`minutes` INT NOT NULL, "
                + "`sprintdistance` INT NOT NULL, "
                + "`buts` INT DEFAULT NULL, "
                + "`assists` INT DEFAULT NULL, "
                + "`recuperationballs` INT DEFAULT NULL, "
                + "`keypass` INT DEFAULT NULL, "
                + "`cleansheet` INT DEFAULT NULL, "
                + "FOREIGN KEY (`idjoueur`) REFERENCES `Joueur`(`idjoueur`) ON DELETE CASCADE `)"
                + ");";
        this.dba = new DbaConnector();

    }
    public void createStatistiqueMatch() {
        dba.createTable(requette);
    }

    //=============== return list des stats d'un joueur==================
    public List<StatistiqueMatchRecord> getStatistiqueMatch(int idjoueur) {
        String selectSQL = "SELECT * FROM `Statistiquematch` WHERE idjoueur = ?;";
        List<StatistiqueMatchRecord> statistiques = new ArrayList<>();

        try (Connection connection = dba.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {

            // Assigner la valeur au paramètre de la requête
            preparedStatement.setInt(1, idjoueur);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // Parcourir les résultats
                while (resultSet.next()) {
                    // Créer un objet StatistiqueMatchRecord pour chaque ligne
                    StatistiqueMatchRecord statistique = new StatistiqueMatchRecord(
                            resultSet.getInt("idstatistiquematch"),
                            resultSet.getInt("idjoueur"),
                            resultSet.getInt("idmatch"),
                            resultSet.getInt("note"),
                            resultSet.getInt("minutes"),
                            resultSet.getInt("sprintdistance"),
                            resultSet.getInt("buts"),
                            resultSet.getInt("assists"),
                            resultSet.getInt("recuperationballs"),
                            resultSet.getInt("keypass"),
                            resultSet.getInt("cleansheet")
                    );

                    // Ajouter la statistique à la liste
                    statistiques.add(statistique);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Une erreur s'est produite lors de la récupération des statistiques.");
        }

        return statistiques;
    }

}
