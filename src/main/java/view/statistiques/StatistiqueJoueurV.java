package view.statistiques;
import model.statistiques.StatistiqueJoueur;
import model.statistiques.StatistiqueMatch;


public class StatistiqueJoueurV {

    // Méthode pour afficher les statistiques d'un joueur
    public void afficherStatistiques(StatistiqueJoueur joueur) {
        System.out.println("Statistiques du joueur :");
        System.out.println("Nombre de matchs : " + joueur.getNbMatch());
        System.out.println("Somme des statistiques :");
        StatistiqueMatch somme = joueur.getSomme();
        System.out.println("  Note totale : " + somme.getNote());
        System.out.println("  Minutes totales : " + somme.getMinutes());
        System.out.println("  Distance en sprint totale : " + somme.getSprintDistance());
    }

    // Méthode pour afficher une statistique spécifique
    public void afficherStatistiqueMatch(StatistiqueMatch stat) {
        System.out.println("Statistique d'un match :");
        System.out.println("  Note : " + stat.getNote());
        System.out.println("  Minutes jouées : " + stat.getMinutes());
        System.out.println("  Distance en sprint : " + stat.getSprintDistance());
    }

    // Méthode pour afficher un message personnalisé
    public void afficherMessage(String message) {
        System.out.println(message);
    }
}