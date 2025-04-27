package view.statistiques;

import model.statistiques.StatistiqueTeamMatch;

import java.util.Scanner;

public class StatistiqueTeamSeasonV {

    private Scanner scanner;
    public StatistiqueTeamSeasonV() {
        this.scanner = new Scanner(System.in);
    }
   // Display team statistics
    public void displayTeamSeasonStats(int nbMatch, StatistiqueTeamMatch somme) {
        System.out.println("Number of Matches: " + nbMatch);
        System.out.println("Cumulative Statistics:");
        System.out.println("Score: " + somme.getScore());
        System.out.println("Possession: " + somme.getPossession());
        System.out.println("Expected Goals In: " + somme.getExpectedGoalsIn());
        System.out.println("Expected Goals Out: " + somme.getExpectedGoalsOut());
    }

    // Input for adding a match
    public StatistiqueTeamMatch getMatchInput() {
        System.out.println("Enter match statistics:");

        System.out.print("Score: ");
        int score = scanner.nextInt();

        System.out.print("Possession (%): ");
      int  possession = scanner.nextInt();

        System.out.print("Expected Goals In: ");
        double xGIn = scanner.nextDouble();

        System.out.print("Expected Goals Out: ");
        double xGOut = scanner.nextDouble();

        scanner.nextLine(); // Consume newline
        System.out.print("Match Notes: ");
        String notes = scanner.nextLine();

        return new StatistiqueTeamMatch(score, possession, xGIn, xGOut, notes);
    }

    // Display success message
    public void displaySuccess(String message) {
        System.out.println(message);
    }
}
