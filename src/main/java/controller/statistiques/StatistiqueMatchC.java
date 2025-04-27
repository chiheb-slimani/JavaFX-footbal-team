package controller.statistiques;
import model.statistiques.StatistiqueMatch;
import view.statistiques.StatistiqueMatchV;

public class StatistiqueMatchC {
    private StatistiqueMatch model;
    private StatistiqueMatchV view;


    public StatistiqueMatchC(StatistiqueMatch model, StatistiqueMatchV view) {
        this.model = model;
        this.view = view;
    }


    public void setStatistiques(int note, int minutes, int sprintDistance) {
        model.setNote(note);
        model.setMinutes(minutes);
        model.setSprintDistance(sprintDistance);
        view.afficherMessage("Statistiques mises à jour avec succès !");
    }


    public void afficherStatistiques() {
        view.afficherStatistiques(model);
    }
}
