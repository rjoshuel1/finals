import java.util.Random;
import java.util.Scanner;
public class BattleArena {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int score = 0;
        int difficulty = 1;

        System.out.println("=== WELCOME TO THE BATTLE ARENA ===");
        System.out.print("Enter your name: ");
        String playerName = sc.nextLine();

        System.out.print("Choose your class (Warrior / Mage): ");
        String choice = sc.nextLine().toLowerCase();

        Character player;
        switch (choice) {
            case "mage" -> player = new Mage(playerName);
            default -> player = new Warrior(playerName);
        }

        System.out.println("\nWelcome, " + player.name + "! Prepare for battle!");

        // Game loop
        while (player.isAlive()) {
            Enemy enemy = Enemy.randomEnemy(difficulty);
            System.out.println("\n⚔️ A wild " + enemy.name + " appears! (HP: " + enemy.hp + ")\n");

            while (enemy.isAlive() && player.isAlive()) {
                System.out.println("Your HP: " + player.hp + " | MP: " + player.mp + " | SP: " + player.sp);
                System.out.println("Potions: Healing=" + player.healingPotions + " Mana=" + player.manaPotions);
                System.out.print("\nChoose action (Attack / Defend / Special / Potion): ");
                String action = sc.nextLine().toLowerCase();

                switch (action) {
                    case "attack" -> player.attack(enemy);
                    case "defend" -> player.defend();
                    case "special" -> player.specialMove(enemy);
                    case "potion" -> {
                        System.out.print("Use which potion? (Healing / Mana): ");
                        String type = sc.nextLine();
                        player.usePotion(type);
                    }
                    default -> System.out.println("Invalid action!");
                }

                if (enemy.isAlive()) {
                    System.out.println("\nEnemy's turn!");
                    enemy.takeTurn(player);
                }
            }

            if (player.isAlive()) {
                score++;
                difficulty++;
                System.out.println("\n✅ You defeated the enemy! Score: " + score);

                // Random potion drop
                if (rand.nextBoolean()) {
                    player.healingPotions++;
                    System.out.println("You found a Healing Potion!");
                } else {
                    player.manaPotions++;
                    System.out.println("You found a Mana Potion!");
                }
            }
        }

        System.out.println("\n💀 You were defeated! Final score: " + score);
        sc.close();
    }
}