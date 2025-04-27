package model.staff;

import model.statistiques.StatistiqueJoueur;

public class JoueurAvecBonus extends Joueur {
    private double bonusFactorA = 0.0;
    private double bonusFactorB = 0.0;
    public JoueurAvecBonus(String nom, String prenom, String mail, String password, int num, int salaire, int moisDeContrat,String position, StatistiqueJoueur statistiqueJoueur ,int fcA , int fcB)
    {

        super(nom, prenom, mail, password,num,salaire,moisDeContrat,position,statistiqueJoueur); this.bonusFactorA=fcA;this.bonusFactorB=fcB;  }

    public double getBonusFactorA() {
        return 0;
    }
    public double getBonusFactorB() {
        return bonusFactorB;
    }

    public void setBonusFactorA(double newFactorA) {
    }
public JoueurAvecBonus() {super();this.bonusFactorA=0.0;
    this.bonusFactorB=0.0;}
    public void setBonusFactorB(double newFactorB) {
    }
}