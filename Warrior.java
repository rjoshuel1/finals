import java.util.Random;
class Warrior extends Character {
    Warrior(String name) {
        super(name, 120, 40, 25);
    }

    @Override
    void specialMove(Character enemy) {
        if (sp < 8) {
            System.out.println(name + " doesn’t have enough SP for Power Slash!");
            return;
        }
        sp -= 8;
        int dmg = new Random().nextInt(15) + 20; // 20–35 damage
        enemy.hp -= dmg;
        System.out.println(name + " uses Power Slash on " + enemy.name + " for " + dmg + " damage!");
    }
}