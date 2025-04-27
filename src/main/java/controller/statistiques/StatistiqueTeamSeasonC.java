package controller.statistiques;
import model.statistiques.StatistiqueTeamMatch;
import view.statistiques.StatistiqueTeamSeasonV;
import model.statistiques.StatistiqueTeamSeason;
public class StatistiqueTeamSeasonC {

    private StatistiqueTeamSeason model;
    private StatistiqueTeamSeasonV view;

    public StatistiqueTeamSeasonC(StatistiqueTeamSeason model, StatistiqueTeamSeasonV view) {
        this.model = model;
        this.view = view;
    }

    // Add a new match
    public void addMatch() {
        StatistiqueTeamMatch match = view.getMatchInput();
        model.ajouterMatch(match);
        view.displaySuccess("Match added successfully!");
    }

    // Display all team statistics
    public void displayTeamStats() {
        view.displayTeamSeasonStats(model.getNbMatch(), model.getSomme());
    }
}
