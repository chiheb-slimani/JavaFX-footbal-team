package controller.statistiques;

import model.statistiques.StatistiqueMilieu;
import view.statistiques.StatistiqueMilieuV;

public class StatistiqueMilieuC {
    private StatistiqueMilieu model;
    private StatistiqueMilieuV view;


    public StatistiqueMilieuC(StatistiqueMilieu model, StatistiqueMilieuV view) {
        this.model = model;
        this.view = view;
    }


    public void setStatistiques(int note, int minutes, int sprintDistance, int passecles, int recuperationDeBalles) {
        model.setNote(note);
        model.setMinutes(minutes);
        model.setSprintDistance(sprintDistance);
        model.setPassecles(passecles);
        model.setRecuperationDeBalles(recuperationDeBalles);
        view.afficherMessage("Statistiques mises à jour avec succès !");
    }


    public void afficherStatistiques() {
        view.afficherStatistiques(model);
    }
}
