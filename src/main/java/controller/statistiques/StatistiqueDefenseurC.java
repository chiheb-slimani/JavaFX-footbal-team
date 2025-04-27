package controller.statistiques;
import model.statistiques.StatistiqueDefenseur;
import view.statistiques.StatistiqueDefenseurV;

public class StatistiqueDefenseurC {
    private StatistiqueDefenseur model;
    private StatistiqueDefenseurV view;

    // Constructeur
    public StatistiqueDefenseurC(StatistiqueDefenseur model, StatistiqueDefenseurV view) {
        this.model = model;
        this.view = view;
    }

    // Méthode pour mettre à jour les clean sheets
    public void setCleanSheet(int cleanSheet) {
        model.setCleanSheet(cleanSheet);
        view.afficherMessage("Nombre de clean sheets mis à jour avec succès.");
    }

    // Méthode pour mettre à jour les récupérations de balles
    public void setRecuperationDeBalles(int recuperationDeBalles) {
        model.setRecuperationDeBalles(recuperationDeBalles);
        view.afficherMessage("Nombre de récupérations de balles mis à jour avec succès.");
    }

    // Méthode pour afficher les statistiques du défenseur
    public void afficherStatistiqueDefenseur() {
        view.afficherStatistiqueDefenseur(model);
    }
}
