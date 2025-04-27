package view.statistiques;

import model.statistiques.StatistiqueMilieu;

public class StatistiqueMilieuV {


    public void afficherStatistiques(StatistiqueMilieu milieu) {
        System.out.println("Statistiques du milieu de terrain :");
        System.out.println("  Note : " + milieu.getNote());
        System.out.println("  Minutes jouées : " + milieu.getMinutes());
        System.out.println("  Distance en sprint : " + milieu.getSprintDistance());
        System.out.println("  Passes clés : " + milieu.getPassecles());
        System.out.println("  Récupérations de balles : " + milieu.getRecuperationDeBalles());
    }

    // Méthode pour afficher un message personnalisé
    public void afficherMessage(String message) {
        System.out.println(message);
    }
}