public class Item {

    // healing potion with different "potencies"
    public static int healingPotion (int playerHP, int choice) {
        int startingPlayerHP = 10;

        // basic healing potion that adds 3 HP
        if (choice == 1) {
            if (playerHP + 3 <= startingPlayerHP) {
                playerHP = playerHP + 3;
            }
            else {
                System.out.println("You may not use this potion right now because your HP is too high.");
            }
        }

        // healing potion that adds back half of what the player's HP is currently at rounded up
        if (choice == 2) {
            if (playerHP + (playerHP / 2) <= startingPlayerHP) {
                playerHP = playerHP + (int) Math.ceil(playerHP / 2.0);
            }
            else {
                System.out.println("You may not use this potion right now because your HP is too high.");
            }
        }

        // frickin super ultra ninja max potion that resets you completely
        if (choice == 3) {
            playerHP = startingPlayerHP;
        }
        return playerHP;
    }
}
