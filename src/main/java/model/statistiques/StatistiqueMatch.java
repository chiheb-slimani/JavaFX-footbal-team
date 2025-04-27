package model.statistiques;
public class StatistiqueMatch {
    private int matchid;
    private int note ;
    private int minutes ;
    private int Sprintdistance;
    public StatistiqueMatch (int note,int minutes,int sprintdistance,int matchid)
    {this.note=note;this.minutes=minutes;this.Sprintdistance=Sprintdistance;this.matchid=matchid;}
    public StatistiqueMatch(){this.note=0;this.minutes=0;this.Sprintdistance=0;this.matchid=0;}
    public int getNote() {
        return note;
    }
    public void setNote(int note) {
        this.note = note;
    }
    public int getMinutes() {
        return minutes;
    }
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
    public int getSprintDistance() {
        return Sprintdistance;
    }
    public void setSprintDistance(int sprintDistance) {
        this.Sprintdistance = sprintDistance;
    }
    public int getMatchid() {return this.matchid;}
    public void setMatchid(int matchid) {this.matchid = matchid;}

}
