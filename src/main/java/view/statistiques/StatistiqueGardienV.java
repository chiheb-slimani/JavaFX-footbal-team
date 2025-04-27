package view.statistiques;


import model.statistiques.StatistiqueGardien;

public class StatistiqueGardienV {


    public void afficherStatistiques(StatistiqueGardien gardien) {
        System.out.println("Statistiques du gardien :");
        System.out.println("  Note : " + gardien.getNote());
        System.out.println("  Minutes jouées : " + gardien.getMinutes());
        System.out.println("  Distance en sprint : " + gardien.getSprintDistance());
        System.out.println("  Clean Sheets : " + gardien.getCleanSheet());
        System.out.println("  Parades : " + gardien.getParades());
    }


    public void afficherMessage(String message) {
        System.out.println(message);
    }
}