package model.statistiques;
public class StatistiqueGardien extends StatistiqueMatch {
    private int cleanSheet;
    private int parades;

    public StatistiqueGardien(int note, int minutes, int sprintDistance,int id, int cleanSheet, int parades) {
        super(note, minutes, sprintDistance,id);
        this.cleanSheet = cleanSheet;
        this.parades = parades;
    }

    public int getCleanSheet() {
        return cleanSheet;
    }

    public void setCleanSheet(int cleanSheet) {
        this.cleanSheet = cleanSheet;
    }

    public int getParades() {
        return parades;
    }

    public void setParades(int parades) {
        this.parades = parades;
    } public StatistiqueGardien() {
        super(0, 0, 0,0); // Appelle le constructeur de la classe parente
        this.cleanSheet = 0;
        this.parades = 0;
    }
}

