package model.staff;
import model.statistiques.*;

public class DataIng extends Personne {

    private StatistiqueJoueur statistiqueJoueur;

    public DataIng() {
        this.statistiqueJoueur = new StatistiqueJoueur();
    }

    public StatistiqueJoueur getStatistiqueJoueur() {
        return statistiqueJoueur;
    }

    public void ajouterStatistique(StatistiqueDefenseur stat) {
        this.statistiqueJoueur.ajouterStatistique(stat);
    }

    public boolean supprimerStatistique(int matchId) {
        return this.statistiqueJoueur.supprimerStatistique(matchId);
    }

    public boolean modifierStatistique(int matchId, StatistiqueDefenseur newStat) {
        return this.statistiqueJoueur.modifierStatistique(matchId, newStat);
    }
}
