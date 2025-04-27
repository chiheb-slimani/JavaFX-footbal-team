package view.statistiques;

import model.statistiques.StatistiqueDefenseur;

public class StatistiqueDefenseurV {

    // Méthode pour afficher les informations d'un défenseur
    public void afficherStatistiqueDefenseur(StatistiqueDefenseur defenseur) {
        System.out.println("Statistiques du défenseur :");
        System.out.println("  Note : " + defenseur.getNote());
        System.out.println("  Minutes : " + defenseur.getMinutes());
        System.out.println("  Distance sprintée : " + defenseur.getSprintDistance());
        System.out.println("  Récupérations de balles : " + defenseur.getRecuperationDeBalles());
        System.out.println("  Clean sheets : " + defenseur.getCleansheet());
    }

    // Méthode pour afficher un message personnalisé
    public void afficherMessage(String message) {
        System.out.println(message);
    }
}