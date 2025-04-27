package model.statistiques;


public class StatistiqueAttaquant extends StatistiqueMatch   {private int buts ; private int assists;
    public StatistiqueAttaquant(int note, int minutes, int sprintDistance,int id, int buts, int assists) {
        super(note, minutes, sprintDistance,id);
        this.buts = buts;
        this.assists = assists;
    }
    public StatistiqueAttaquant() {
        super(-1, -1, -1,-1); // Appelle le constructeur de StatistiqueMatch avec des valeurs par défaut
        this.buts = -1;
        this.assists = -1;
    }
        public int getButs() {
        return buts;
    }
    public void setButs(int buts) {this.buts = buts; }
    public void setAssists(int assists) {this.assists = assists; }
            public int getAssists() {
        return assists;
    }
}

