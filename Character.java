import java.util.Random;

// Base class for all characters
abstract class Character {
    String name;
    int hp, mp, sp;
    int healingPotions = 2;
    int manaPotions = 2;

    Character(String name, int hp, int mp, int sp) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.sp = sp;
    }

    boolean isAlive() {
        return hp > 0;
    }

    void attack(Character enemy) {
        if (sp < 2) {
            System.out.println(name + " is too tired to attack!");
            return;
        }
        sp -= 2;
        int dmg = new Random().nextInt(10) + 10; // 10–20
        enemy.hp -= dmg;
        System.out.println(name + " attacks " + enemy.name + " for " + dmg + " damage!");
    }

    void defend() {
        if (sp < 3) {
            System.out.println(name + " is too tired to defend!");
            return;
        }
        sp -= 3;
        System.out.println(name + " braces for impact and takes reduced damage next hit!");
    }

    void usePotion(String type) {
        if (type.equalsIgnoreCase("healing") && healingPotions > 0) {
            hp += 30;
            healingPotions--;
            System.out.println(name + " drinks a Healing Potion and recovers 30 HP!");
        } else if (type.equalsIgnoreCase("mana") && manaPotions > 0) {
            mp += 20;
            manaPotions--;
            System.out.println(name + " drinks a Mana Potion and recovers 20 MP!");
        } else {
            System.out.println("No " + type + " potions left!");
        }
    }

    abstract void specialMove(Character enemy);
}