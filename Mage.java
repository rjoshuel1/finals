import java.util.Random;
class Mage extends Character {
    Mage(String name) {
        super(name, 100, 80, 20);
    }

    @Override
    void specialMove(Character enemy) {
        if (mp < 25) {
            System.out.println(name + " doesn’t have enough MP for Fireball!");
            return;
        }
        mp -= 25;
        int dmg = new Random().nextInt(20) + 25; // 25–45
        enemy.hp -= dmg;
        System.out.println(name + " casts Fireball and burns " + enemy.name + " for " + dmg + " damage!");
    }
}