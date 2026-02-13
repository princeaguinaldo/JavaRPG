import java.util.Random;
import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    static class Player {
        String name;
        int health;
        int maxHealth;
        int gold;
        int potions;
        int level;
        int experience;
        int experienceToLevel;
        int weaponPower;
        int armorDefense;
        String weapon;
        String armor;

        Player(String name) {
            this.name = name;
            this.health = 100;
            this.maxHealth = 100;
            this.gold = 50;
            this.potions = 3;
            this.level = 1;
            this.experience = 0;
            this.experienceToLevel = 100;
            this.weaponPower = 5;
            this.armorDefense = 2;
            this.weapon = "Wooden Sword";
            this.armor = "Leather Armor";
        }

        void displayStatus() {
            System.out.println("\n=== CHARACTER STATUS ===");
            System.out.println("Name: " + name);
            System.out.println("Level: " + level);
            System.out.println("Health: " + health + "/" + maxHealth);
            System.out.println("Experience: " + experience + "/" + experienceToLevel);
            System.out.println("Gold: " + gold);
            System.out.println("Potions: " + potions);
            System.out.println("Weapon: " + weapon + " (+" + weaponPower + " damage)");
            System.out.println("Armor: " + armor + " (+" + armorDefense + " defense)");
            System.out.println("======================\n");
        }

        void gainExperience(int xp) {
            experience += xp;
            System.out.println("Gained " + xp + " experience!");
            if (experience >= experienceToLevel) {
                levelUp();
            }
        }

        void levelUp() {
            level++;
            maxHealth += 20;
            health = maxHealth;
            experience = 0;
            experienceToLevel += 50;
            weaponPower += 3;
            armorDefense += 1;
            System.out.println("\n*** LEVEL UP! You are now level " + level + "! ***");
            System.out.println("Max health increased to " + maxHealth + "!");
            System.out.println("Your weapon and armor feel stronger!\n");
        }

        void usePotion() {
            if (potions > 0) {
                int healed = 40;
                health = Math.min(health + healed, maxHealth);
                potions--;
                System.out.println("You used a potion! +" + healed + " HP. You have " + potions + " potions left.");
            } else {
                System.out.println("No potions left!");
            }
        }
    }

    static class Enemy {
        String name;
        int health;
        int maxHealth;
        int damage;
        int xpReward;
        int goldReward;

        Enemy(String type) {
            if (type.equals("Goblin")) {
                this.name = "Goblin";
                this.maxHealth = 20;
                this.damage = 8;
                this.xpReward = 30;
                this.goldReward = 15;
            } else if (type.equals("Orc")) {
                this.name = "Orc";
                this.maxHealth = 40;
                this.damage = 15;
                this.xpReward = 60;
                this.goldReward = 30;
            } else if (type.equals("Troll")) {
                this.name = "Troll";
                this.maxHealth = 60;
                this.damage = 20;
                this.xpReward = 100;
                this.goldReward = 50;
            } else {
                this.name = "Dragon";
                this.maxHealth = 100;
                this.damage = 30;
                this.xpReward = 200;
                this.goldReward = 100;
            }
            this.health = maxHealth;
        }

        void takeDamage(int damage) {
            health -= damage;
        }

        boolean isAlive() {
            return health > 0;
        }
    }

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("  WELCOME TO THE JAVA ADVENTURE  ");
        System.out.println("=================================");

        System.out.print("Enter your name, hero: ");
        String playerName = scanner.nextLine();

        System.out.println("Welcome, " + playerName + "! Your journey begins...\n");

        Player player = new Player(playerName);
        gameLoop(player);
    }

    public static void gameLoop(Player player) {

        while (player.health > 0) {

            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Explore");
            System.out.println("2. View Status");
            System.out.println("3. Use Potion");
            System.out.println("4. Visit Shop");
            System.out.println("5. Rest (Restore Health)");
            System.out.println("6. Exit Game");
            System.out.println("==============================");

            System.out.print("Choose an action: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    explore(player);
                    break;
                case 2:
                    player.displayStatus();
                    break;
                case 3:
                    player.usePotion();
                    break;
                case 4:
                    visitShop(player);
                    break;
                case 5:
                    rest(player);
                    break;
                case 6:
                    System.out.println("\nThanks for playing, " + player.name + "! Final Stats:");
                    player.displayStatus();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        System.out.println("\n*** GAME OVER! ***");
        System.out.println("You fell after reaching level " + player.level + ".");
    }

    public static void explore(Player player) {
        String[] locations = {"Dark Forest", "Mountain Pass", "Ancient Ruins", "Dragon's Lair"};
        String chosenLocation = locations[random.nextInt(locations.length)];

        System.out.println("\nYou venture into the " + chosenLocation + "...");

        String[] enemyTypes = {"Goblin", "Orc", "Troll"};
        if (player.level >= 5 && random.nextDouble() < 0.3) {
            battle(player, new Enemy("Dragon"));
        } else {
            battle(player, new Enemy(enemyTypes[random.nextInt(enemyTypes.length)]));
        }
    }

    public static void battle(Player player, Enemy enemy) {
        System.out.println("\n*** BATTLE START ***");
        System.out.println("A " + enemy.name + " appears!");
        System.out.println(enemy.name + " health: " + enemy.maxHealth + "\n");

        while (player.health > 0 && enemy.isAlive()) {
            System.out.println("--- Your Turn ---");
            System.out.println("1. Attack");
            System.out.println("2. Defend");
            System.out.println("3. Use Potion");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();

            int playerDamage = 0;
            int defenseBonus = 0;

            switch (choice) {
                case 1:
                    playerDamage = player.weaponPower + random.nextInt(10);
                    System.out.println("You attack for " + playerDamage + " damage!");
                    break;
                case 2:
                    defenseBonus = 10;
                    System.out.println("You take a defensive stance!");
                    break;
                case 3:
                    player.usePotion();
                    break;
            }

            if (playerDamage > 0) {
                enemy.takeDamage(playerDamage);
                if (enemy.health <= 0) {
                    System.out.println("You defeated the " + enemy.name + "!");
                    player.gold += enemy.goldReward;
                    player.gainExperience(enemy.xpReward);
                    System.out.println("Gained " + enemy.goldReward + " gold!");
                    return;
                }
            }

            System.out.println(enemy.name + " health: " + enemy.health + "\n");

            // Enemy turn
            int enemyDamage = Math.max(1, enemy.damage - player.armorDefense - defenseBonus + random.nextInt(5));
            System.out.println("--- " + enemy.name + "'s Turn ---");
            System.out.println("The " + enemy.name + " attacks for " + enemyDamage + " damage!");
            player.health -= enemyDamage;

            if (player.health <= 0) {
                System.out.println("\nYou were defeated!");
                return;
            }

            System.out.println("Your health: " + player.health + "\n");
        }
    }

    public static void visitShop(Player player) {
        System.out.println("\n========== SHOP ==========");
        System.out.println("1. Sword (50 gold) - +5 weapon power");
        System.out.println("2. Battle Axe (100 gold) - +10 weapon power");
        System.out.println("3. Leather Armor (30 gold) - +2 armor defense");
        System.out.println("4. Steel Armor (75 gold) - +5 armor defense");
        System.out.println("5. Potion (20 gold) - Restores 40 HP");
        System.out.println("6. Leave Shop");
        System.out.println("========================");
        System.out.println("Your gold: " + player.gold);
        System.out.print("What would you like? ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                if (player.gold >= 50) {
                    player.gold -= 50;
                    player.weaponPower = Math.max(player.weaponPower, 10);
                    player.weapon = "Iron Sword";
                    System.out.println("You bought a Sword!");
                } else {
                    System.out.println("Not enough gold!");
                }
                break;
            case 2:
                if (player.gold >= 100) {
                    player.gold -= 100;
                    player.weaponPower = Math.max(player.weaponPower, 15);
                    player.weapon = "Battle Axe";
                    System.out.println("You bought a Battle Axe!");
                } else {
                    System.out.println("Not enough gold!");
                }
                break;
            case 3:
                if (player.gold >= 30) {
                    player.gold -= 30;
                    player.armorDefense = Math.max(player.armorDefense, 4);
                    player.armor = "Leather Armor";
                    System.out.println("You bought Leather Armor!");
                } else {
                    System.out.println("Not enough gold!");
                }
                break;
            case 4:
                if (player.gold >= 75) {
                    player.gold -= 75;
                    player.armorDefense = Math.max(player.armorDefense, 7);
                    player.armor = "Steel Armor";
                    System.out.println("You bought Steel Armor!");
                } else {
                    System.out.println("Not enough gold!");
                }
                break;
            case 5:
                if (player.gold >= 20) {
                    player.gold -= 20;
                    player.potions++;
                    System.out.println("You bought a Potion!");
                } else {
                    System.out.println("Not enough gold!");
                }
                break;
            case 6:
                System.out.println("You left the shop.");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void rest(Player player) {
        if (player.gold >= 10) {
            player.gold -= 10;
            player.health = player.maxHealth;
            System.out.println("You rested at the inn. Health fully restored! (Cost: 10 gold)");
        } else {
            System.out.println("You don't have enough gold to rest at the inn (costs 10 gold).");
        }
    }
}
