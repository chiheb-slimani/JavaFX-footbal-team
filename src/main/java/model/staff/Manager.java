package model.staff;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager extends Personne {
    private ObservableList<Joueur> joueurs; // Changed to ObservableList

    // Constructor
    public Manager(String nom, String prenom, String mail, String password) {
        super(nom, prenom, mail, password);
        this.joueurs = FXCollections.observableArrayList();  // Initialize as ObservableList
    }

    public Manager() {
        super();
        this.joueurs = FXCollections.observableArrayList();  // Initialize as ObservableList
    }

    // Add a player to the list
    public void addJoueur(Joueur joueur) {
        if (joueur != null && !joueurs.contains(joueur)) {
            joueurs.add(joueur);
            System.out.println(joueur.getNom() + " added to the team.");
        } else {
            System.out.println("Player already exists or invalid.");
        }
    }

    // Remove a player from the list
    public void deleteJoueur(Joueur joueur) {
        if (joueurs.remove(joueur)) {
            System.out.println(joueur.getNom() + " removed from the team.");
        } else {
            System.out.println("Player not found in the team.");
        }
    }


    // Getter for ObservableList
    public ObservableList<Joueur> getJoueurs() {
        return joueurs;
    }
}
