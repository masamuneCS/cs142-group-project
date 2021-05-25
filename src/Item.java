public class Item {
    // choice 1-3 represents which potion the player is drinking
    public static int healingPotions (int choice, int currentPlayerHP, int maxHP) {
        // healing potion that adds 3 HP back
        if (choice == 1) {
            if (currentPlayerHP + 3 <= maxHP) {
                currentPlayerHP = currentPlayerHP + 3;
            }
            else {
                System.out.println("You may not drink this potion right now because your HP is too high.");
            }
        }

        // healing potion that restores half of what's been lost (rounded down)
        if (choice == 2) {
            if (currentPlayerHP + ((maxHP - currentPlayerHP) / 2) <= maxHP) {
                currentPlayerHP = currentPlayerHP + ((maxHP - currentPlayerHP) / 2);
            }
            else {
                System.out.println("You may not drink this potion right now because your HP is too high.");
            }
        }

        // frickin super ninja ultra max healing potion that resets you back to 10
        if (choice == 3) {
            currentPlayerHP = maxHP;
        }
        return currentPlayerHP;
    }

    // spell that reduces mob-inflicted damage by half for 2 turns (rounded up)
    public static double mobDamageReducerSpell(double mobDamage) {
        int turn = 1;
        while (turn <= 2) {
            mobDamage = mobDamage / 2.0;
            turn++;
        }
        return mobDamage;
    }

    // armor item that reduces mob-inflicted damage by 20% forever
    public static double armorItem(double mobDamage) {
        return mobDamage * 0.8;
    }

    // I wanted this to be like "if you take this, you can move 2 spaces instead of just one for a turn"
    // but it may be a little too involved cuz we'd prbly have to rewrite canMove, move, and moveVisual
    public static int[] bunnyPotion(int position) {
        int[] filler = {1, 2, 3};
        return filler;
    }
}