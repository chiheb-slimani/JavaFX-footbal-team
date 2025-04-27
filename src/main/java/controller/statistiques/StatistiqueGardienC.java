package controller.statistiques;

import model.statistiques.StatistiqueGardien;
import view.statistiques.StatistiqueGardienV;

public class StatistiqueGardienC {
    private StatistiqueGardien model;
    private StatistiqueGardienV view;

    // Constructeur
    public StatistiqueGardienC(StatistiqueGardien model, StatistiqueGardienV view) {
        this.model = model;
        this.view = view;
    }


    public void setStatistiques(int note, int minutes, int sprintDistance, int cleanSheet, int parades) {
        model.setNote(note);
        model.setMinutes(minutes);
        model.setSprintDistance(sprintDistance);
        model.setCleanSheet(cleanSheet);
        model.setParades(parades);
        view.afficherMessage("Statistiques mises à jour avec succès !");
    }


    public void afficherStatistiques() {
        view.afficherStatistiques(model);
    }
}
