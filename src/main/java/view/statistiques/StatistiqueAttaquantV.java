package view.statistiques;

import model.statistiques.StatistiqueAttaquant;

public class StatistiqueAttaquantV {


    public void afficherStatistiques(StatistiqueAttaquant stats) {
        System.out.println("Statistiques de l'attaquant :");
        System.out.println("Note : " + stats.getNote());
        System.out.println("Minutes jouées : " + stats.getMinutes());
        System.out.println("Distance en sprint : " + stats.getSprintDistance());
        System.out.println("Buts : " + stats.getButs());
        System.out.println("Assists : " + stats.getAssists());
    }


    public void afficherMessage(String message) {
        System.out.println(message);
    }
}