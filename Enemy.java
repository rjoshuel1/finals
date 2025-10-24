import java.util.Random;
class Enemy extends Character {
    Enemy(String name, int hp, int mp, int sp) {
        super(name, hp, mp, sp);
    }

    static Enemy randomEnemy(int difficulty) {
        String[] names = {"Bandit", "Goblin", "Dark Mage", "Skeleton Warrior"};
        Random r = new Random();
        String name = names[r.nextInt(names.length)];
        int hp = 70 + difficulty * 20;
        int mp = 40 + difficulty * 10;
        int sp = 20 + difficulty * 5;
        return new Enemy(name, hp, mp, sp);
    }

    void takeTurn(Character player) {
        Random rand = new Random();
        int action = rand.nextInt(3);

        switch (action) {
            case 0 -> attack(player);
            case 1 -> defend();
            case 2 -> System.out.println(name + " hesitates...");
        }
    }

    @Override
    void specialMove(Character enemy) {
        // Enemies don't have special moves in this simple version
    }
}