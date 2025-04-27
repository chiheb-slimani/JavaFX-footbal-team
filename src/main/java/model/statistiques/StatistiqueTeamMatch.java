package model.statistiques;

public class StatistiqueTeamMatch {
    private int score;
    private int possession;
    private double expectedGoalsIn;
    private double expectedGoalsOut;
    private String status;

    public StatistiqueTeamMatch(int score, int possession, double expectedGoalsIn, double expectedGoalsOut, String status) {
        this.score = score;
        this.possession = possession;
        this.expectedGoalsIn = expectedGoalsIn;
        this.expectedGoalsOut = expectedGoalsOut;
        this.status = status;
    }
    public StatistiqueTeamMatch() {
        this.score = 0;
        this.possession = 0;
        this.expectedGoalsIn = 0.0;
        this.expectedGoalsOut = 0.0;
        this.status = "Non défini";
    }
    // Getters et setters
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPossession() {
        return possession;
    }

    public void setPossession(int possession) {
        this.possession = possession;
    }

    public double getExpectedGoalsIn() {
        return expectedGoalsIn;
    }

    public void setExpectedGoalsIn(double expectedGoalsIn) {
        this.expectedGoalsIn = expectedGoalsIn;
    }

    public double getExpectedGoalsOut() {
        return expectedGoalsOut;
    }

    public void setExpectedGoalsOut(double expectedGoalsOut) {
        this.expectedGoalsOut = expectedGoalsOut;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
