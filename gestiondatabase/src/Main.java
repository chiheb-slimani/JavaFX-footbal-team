import database.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        ComptableDba comptable = new ComptableDba();
        comptable.createComptable();
        DataIngDba ing = new DataIngDba();
        ManagerDba m = new ManagerDba();
        m.createManager();
        StatistiqueMatchDba joueurs = new StatistiqueMatchDba();
        joueurs.createStatistiqueMatch();
        ing.createDataIng();
        EquipeDba equipe = new EquipeDba();
        equipe.createEquipe();

        JoueurDba j1 = new JoueurDba();
        j1.createJoueur();
    }
}