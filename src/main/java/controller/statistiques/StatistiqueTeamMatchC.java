package controller.statistiques;
import model.statistiques.StatistiqueTeamMatch;
import view.statistiques.StatistiqueTeamMatchV;
public class StatistiqueTeamMatchC {
    private StatistiqueTeamMatch model;
    private StatistiqueTeamMatchV view;
    public StatistiqueTeamMatchC(StatistiqueTeamMatch model, StatistiqueTeamMatchV view) {
        this.model = model;
        this.view = view;
    }
    public void setStatistiques(int score, int possession, double expectedGoalsIn, double expectedGoalsOut, String status) {
        model.setScore(score);
        model.setPossession(possession);
        model.setExpectedGoalsIn(expectedGoalsIn);
        model.setExpectedGoalsOut(expectedGoalsOut);
        model.setStatus(status);
        view.afficherMessage("Statistiques mises à jour avec succès !");
    }
   public void afficherStatistiques() {
        view.afficherStatistiques(model);
    }
}