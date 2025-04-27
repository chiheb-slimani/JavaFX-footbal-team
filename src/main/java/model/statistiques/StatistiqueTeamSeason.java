package model.statistiques;
import java.util.ArrayList;

public class StatistiqueTeamSeason {

    private ArrayList<StatistiqueTeamMatch> stats;
    private int nbMatch;
    private StatistiqueTeamMatch somme;

    public StatistiqueTeamSeason() {
        this.stats = new ArrayList<>();
        this.nbMatch = 0;
        this.somme = new StatistiqueTeamMatch(0, 0, 0.0, 0.0, "");  // Initialize with default values
    }
    // Getters et setters
    public int getNbMatch() {
        return nbMatch;
    }

    public void setNbMatch(int nbMatch) {
        this.nbMatch = nbMatch;
    }

    public ArrayList<StatistiqueTeamMatch> getStats() {
        return stats;
    }

    public void setStats(ArrayList<StatistiqueTeamMatch> stats) {
        this.stats = stats;
    }

    public StatistiqueTeamMatch getSomme() {
        return somme;
    }

    public void setSomme(StatistiqueTeamMatch somme) {
        this.somme = somme;
    }

    // Méthode pour ajouter un match et mettre à jour les statistiques
    public void ajouterMatch(StatistiqueTeamMatch match) {
        stats.add(match);
        nbMatch++;
        // Mettre à jour les statistiques cumulées
        somme.setScore(somme.getScore() + match.getScore());
        somme.setPossession((somme.getPossession() + match.getPossession()) / nbMatch); // Moyenne
        somme.setExpectedGoalsIn(somme.getExpectedGoalsIn() + match.getExpectedGoalsIn());
        somme.setExpectedGoalsOut(somme.getExpectedGoalsOut() + match.getExpectedGoalsOut());
    }
}


