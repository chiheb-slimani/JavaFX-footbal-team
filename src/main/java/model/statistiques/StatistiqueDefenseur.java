package model.statistiques;

public class StatistiqueDefenseur extends StatistiqueMatch {private int cleansheet;private int recuperationDeBalles;
    public StatistiqueDefenseur(int x,int y , int z,int n ,int l,int m  ){super(x,y,z,n); this.recuperationDeBalles = l;this.cleansheet = m;}
    public int getCleansheet(){return this.cleansheet;
    }public int getRecuperationDeBalles(){return this.recuperationDeBalles;}
    public void setRecuperationDeBalles(int recuperationDeBalles) {
        this.recuperationDeBalles = recuperationDeBalles;
    }public void setCleanSheet(int cleansheet) {this.cleansheet = cleansheet;}
}