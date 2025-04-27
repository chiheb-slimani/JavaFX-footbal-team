package model.Equipe;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.staff.DataIng;
import model.staff.*;
import model.staff.Manager;

public class Equipe {
    // Singleton instance
    private static Equipe equipe;
     private Comptable comptable;
     private JoueurAvecBonus joueur;
    // Properties
    private Manager manager;
    private final ObservableList<Joueur> joueurs;
    private DataIng dataIng;
    private Joueur joueurAvecBonus;

    public JoueurAvecBonus getJoueur() {if (this.joueur== null) {
       JoueurAvecBonus joueur = new JoueurAvecBonus();

    } return joueur;}

    public void setJoueur(JoueurAvecBonus joueur) {
        this.joueur = joueur;
    }

    // Private constructor to prevent instantiation
    private Equipe() {
        this.joueurs = FXCollections.observableArrayList();
        this.manager = null;
        this.dataIng = null;
    }
   public Comptable getComptable() { if (this.comptable == null) {
      Comptable comptable = new Comptable();

   }
       return this.comptable; }
public void setComptable(Comptable comptable) { this.comptable = comptable; }


    public static void setEquipe(Equipe equipe) {
        Equipe.equipe = equipe;
    }

    // Thread-safe Singleton getter
    public static synchronized Equipe getEquipe() {
        if (equipe == null) {
            equipe = new Equipe();
        }
        return equipe;
    }
    public Joueur getJoueurAvecBonus() {
        if (this.joueurAvecBonus == null) {
            Joueur joueurAvecBonus = new Joueur();

        }
        return this.joueurAvecBonus;
    }

    // Getters
    public Manager getManager() {
        return manager;
    }
    public  void setJoueurAvecBonus(Joueur joueurAvecBonus) {

        this.joueurAvecBonus = joueurAvecBonus;
    }

    public ObservableList<Joueur> getJoueurs() {
        return joueurs;
    }

    // Setters
    public void setManager(Manager manager) {
        this.manager = manager;
    }
public void setDataIng(DataIng dataIng) {this.dataIng = dataIng;}
public DataIng getDataIng() {return dataIng;}
}