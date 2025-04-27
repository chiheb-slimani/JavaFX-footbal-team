package model.staff;

import model.statistiques.StatistiqueDefenseur;
import model.statistiques.StatistiqueJoueur;

public class Joueur extends Personne {
    private int salary;
    private int contractMonths;
    private int numero;
    private String position;
    private StatistiqueJoueur statistiqueJoueur;

    public Joueur(String nom, String prenom, String mail, String password, int num, int salary, int contractMonths, String position, StatistiqueJoueur statistiqueJoueur) {
        super(nom, prenom, mail, password);
        this.salary = salary;
        this.numero = num;
        this.contractMonths = contractMonths;
        this.setPosition(position);
        this.statistiqueJoueur = statistiqueJoueur;
    }

    public Joueur(String nom, String prenom, int numero, String position) {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setNumero(numero);
        this.setPosition(position);
        this.statistiqueJoueur = new StatistiqueJoueur();
        this.setSalary(0);
        this.setContractMonths(0);
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        if (position.equals("a") || position.equals("m") || position.equals("d") || position.equals("g")) {
            this.position = position;
        } else {
            throw new IllegalArgumentException("Invalid position. Must be one of: 'a' (attacker), 'm' (midfielder), 'd' (defender), 'g' (goalkeeper).");
        }
    }

    public StatistiqueJoueur getStatistiqueJoueur() {
        return statistiqueJoueur;
    }

    public void setStatistiqueJoueur(StatistiqueJoueur statistiqueJoueur) {
        this.statistiqueJoueur = statistiqueJoueur;
    }
public Joueur(){super();
        this.statistiqueJoueur = new StatistiqueJoueur();



}
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Salary must be non-negative.");
        }
    }

    public int getContractMonths() {
        return contractMonths;
    }

    public void setContractMonths(int contractMonths) {
        if (contractMonths >= 0) {
            this.contractMonths = contractMonths;
        } else {
            throw new IllegalArgumentException("Contract months must be non-negative.");
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int num) {
        this.numero = num;
    }
}