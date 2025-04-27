package model.staff;



import model.statistiques.StatistiqueJoueur;

public class Comptable extends Personne {

    public Comptable(String nom, String prenom, String mail, String password) {
        super(nom, prenom, mail, password);
    }

    public Comptable() {
        super();
    }

    public void modifierContrat(Joueur joueur, int newContractMonths) {
        joueur.setContractMonths(newContractMonths);
    }

    public void modifierSalaire(Joueur joueur, int newSalary) {
        joueur.setSalary(newSalary);
    }

    public void modifierBonus(JoueurAvecBonus joueur, double newFactorA, double newFactorB) {
        joueur.setBonusFactorA(newFactorA);
        joueur.setBonusFactorB(newFactorB);
    }

    public double calculerSommeOwed(Joueur joueur) {
        double total = joueur.getContractMonths() * joueur.getSalary();

        if (joueur instanceof JoueurAvecBonus) {
            JoueurAvecBonus bonusPlayer = (JoueurAvecBonus) joueur;
            StatistiqueJoueur stats = bonusPlayer.getStatistiqueJoueur();

            total += stats.getSomme().getNote() * bonusPlayer.getBonusFactorA();
            total += stats.getSomme().getMinutes() * bonusPlayer.getBonusFactorB();
        }

        return total;
    }
}
