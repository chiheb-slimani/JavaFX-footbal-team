package model.statistiques;
public class StatistiqueMilieu extends StatistiqueMatch {
    private int passecles;
    private int recuperationDeBalles;

    public StatistiqueMilieu(int note, int minutes, int sprintDistance, int id, int passecles, int recuperationDeBalles) {
        super(note, minutes, sprintDistance,id);
        this.passecles = passecles;
        this.recuperationDeBalles = recuperationDeBalles;
    }
    public int getPassecles() {
        return passecles;
    }
    public StatistiqueMilieu() {
        super(0, 0, 0,0); // Appelle le constructeur de la classe parente
        this.passecles = 0;
        this.recuperationDeBalles = 0;
    }
    public void setPassecles(int passecles) {
        this.passecles = passecles;
    }
    public int getRecuperationDeBalles() {
        return recuperationDeBalles;
    }
    public void setRecuperationDeBalles(int recuperationDeBalles) {
        this.recuperationDeBalles = recuperationDeBalles;}}