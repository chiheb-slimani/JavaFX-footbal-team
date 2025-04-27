package view.statistiques;

import model.statistiques.StatistiqueTeamMatch;

public class StatistiqueTeamMatchV {


    public void afficherStatistiques(StatistiqueTeamMatch teamMatch) {
        System.out.println("Statistiques de l'équipe pour le match :");
        System.out.println("  Score : " + teamMatch.getScore());
        System.out.println("  Possession (%) : " + teamMatch.getPossession());
        System.out.println("  Expected Goals (In) : " + teamMatch.getExpectedGoalsIn());
        System.out.println("  Expected Goals (Out) : " + teamMatch.getExpectedGoalsOut());
        System.out.println("  Status : " + teamMatch.getStatus());
    }

    // Méthode pour afficher un message personnalisé
    public void afficherMessage(String message) {
        System.out.println(message);
    }
}