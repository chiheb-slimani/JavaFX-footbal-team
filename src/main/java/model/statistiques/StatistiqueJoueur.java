package model.statistiques;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StatistiqueJoueur {

    private ObservableList<StatistiqueDefenseur> stats;
    private int nbMatch;
    private StatistiqueMatch somme;

    public StatistiqueJoueur() {
        this.stats = FXCollections.observableArrayList();
        this.nbMatch = 0;
        this.somme = new StatistiqueMatch(0, 0, 0, 0);
    }

    public int getNbMatch() {
        return this.nbMatch;
    }

    public StatistiqueMatch getSomme() {
        return somme;
    }

    public ObservableList<StatistiqueDefenseur> getStats() {
        return stats;
    }

    public void ajouterStatistique(StatistiqueDefenseur stat) {
        this.stats.add(stat);
        this.nbMatch++;
        this.somme = new StatistiqueMatch(
                somme.getNote() + stat.getNote(),
                somme.getMinutes() + stat.getMinutes(),
                somme.getSprintDistance() + stat.getSprintDistance(),
                somme.getMatchid()
        );
    }

    public boolean supprimerStatistique(int matchId) {
        StatistiqueMatch toRemove = null;
        for (StatistiqueMatch stat : stats) {
            if (stat.getMatchid() == matchId) {
                toRemove = stat;
                break;
            }
        }
        if (toRemove != null) {
            this.stats.remove(toRemove);
            this.nbMatch--;
            this.somme = new StatistiqueMatch(
                    somme.getNote() - toRemove.getNote(),
                    somme.getMinutes() - toRemove.getMinutes(),
                    somme.getSprintDistance() - toRemove.getSprintDistance(),
                    somme.getMatchid()
            );
            return true;
        }
        return false;
    }

    public boolean modifierStatistique(int matchId, StatistiqueDefenseur newStat) {
        for (int i = 0; i < stats.size(); i++) {
            if (stats.get(i).getMatchid() == matchId) {
                StatistiqueMatch oldStat = stats.get(i);
                this.somme = new StatistiqueMatch(
                        somme.getNote() - oldStat.getNote() + newStat.getNote(),
                        somme.getMinutes() - oldStat.getMinutes() + newStat.getMinutes(),
                        somme.getSprintDistance() - oldStat.getSprintDistance() + newStat.getSprintDistance(),
                        somme.getMatchid()
                );
                stats.set(i, newStat);
                return true;
            }
        }
        return false;
    }
}
