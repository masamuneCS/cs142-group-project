public class Item {
    public static int healingPotions (int choice, int playerHP) {
        int startingPlayerHP = 10;
        // healing potion that adds 3 HP back
        if (choice == 1) {
            if (playerHP + 3 <= startingPlayerHP) {
                playerHP = playerHP + 3;
            }
            else {
                System.out.println("You may not drink this potion right now because your HP is too high.");
            }
        }

        // healing potion that restores half of what's been lost (rounded down)
        if (choice == 2) {
            if (playerHP + ((startingPlayerHP - playerHP) / 2) <= startingPlayerHP) {
                playerHP = playerHP + ((startingPlayerHP - playerHP) / 2);
            }
            else {
                System.out.println("You may not drink this potion right now because your HP is too high.");
            }
        }

        // frickin super ninja ultra max healing potion that resets you back to 10
        if (choice == 3) {
            playerHP = startingPlayerHP;
        }
        return playerHP;
    }
}
