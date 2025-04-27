package controller.statistiques;

import model.statistiques.StatistiqueAttaquant;
import view.statistiques.StatistiqueAttaquantV;

public class StatistiqueAttaquantC {
    private StatistiqueAttaquant model;
    private StatistiqueAttaquantV view;


    public StatistiqueAttaquantC(StatistiqueAttaquant model, StatistiqueAttaquantV view) {
        this.model = model;
        this.view = view;
    }


    public void setStatistiques(int note, int minutes, int sprintDistance, int buts, int assists) {
        model.setNote(note);
        model.setMinutes(minutes);
        model.setSprintDistance(sprintDistance);
        model.setButs(buts);
        model.setAssists(assists);
    }


    public void setButs(int buts) {
        model.setButs(buts);
    }


    public void setAssists(int assists) {
        model.setAssists(assists);
    }


    public void afficherStatistiques() {
        view.afficherStatistiques(model);
    }
}

