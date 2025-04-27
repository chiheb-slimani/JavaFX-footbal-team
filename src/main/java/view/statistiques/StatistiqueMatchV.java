package view.statistiques;

import model.statistiques.StatistiqueMatch;

public class StatistiqueMatchV {


    public void afficherStatistiques(StatistiqueMatch match) {
        System.out.println("Statistiques du match :");
        System.out.println("  Note : " + match.getNote());
        System.out.println("  Minutes jouées : " + match.getMinutes());
        System.out.println("  Distance en sprint : " + match.getSprintDistance() + " mètres");
    }


    public void afficherMessage(String message) {
        System.out.println(message);
    }}