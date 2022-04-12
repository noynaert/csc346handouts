package edu.missouriwestern.csc346.monsters;

public class Cook extends Human{
    public Cook() {
        super("Cook", 0.50, "\uD83D\uDC68\u200D\uD83C\uDF73", "\uD83D\uDC69\uD83C\uDFFB\u200D\uD83C\uDF73");
        setAggressiveness(0.75);
        setDefenseMessage("Blocks with a large pot lid.");
    }

    @Override
    public void attack() {
        enum Weapon {
            cleaver,
            skillet,
            whisk
        }
        Weapon weapon = null;
        int choice = (int) (Math.random() * 6.0);
        switch (choice) {
            case 0:
            case 1:
            case 2:
            case 3:
                weapon = Weapon.cleaver;
                break;
            case 4:
                weapon = Weapon.skillet;
                break;
            case 5:
                weapon = Weapon.whisk;
        }
        switch (weapon) {
            case cleaver:
                setAttackMessage("swings a wickedly sharp meat cleaver");
                setAttackEffectiveness(1.0 * Math.random());
                break;
            case whisk:
                setAttackMessage("pokes awkwardly with an egg whisk");
                setAttackEffectiveness(0.01 * Math.random());
                break;
            case skillet:
                setAttackEffectiveness(.50 * Math.random());
                setAttackMessage("swings a red-hot cast iron frying pan");
                break;
        }
    }

    @Override
    public void defend() {
        setDefenseEffectiveness(0.3 + Math.random());
    }

    @Override
    public String getNoAttackMessage() {

        String[] messages = {
                "stirs the hollandaise sauce.",
                "ponders the fact that \"sweetbreads\" are neither sweet, nor breads",
                "yells at the sous chef."
        };
        int pick = (int) (Math.random() * messages.length);
        return messages[pick];
    }
}

