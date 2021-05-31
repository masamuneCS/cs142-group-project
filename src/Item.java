public class Item {
    public int heals;
    public int damage;
    public int resist;
    public int manas;
    public String name;

    public Item(int heals, int damage, int resist, int manas, String name){
        this.heals = heals;
        this.damage = damage;
        this.resist = resist;
        this.manas = manas;
        this.name = name;
    }

    // healing potion that adds 3 HP back
    public static Item healingPotion (PlayerCharacter target) {
        int heals = Game.diceRoll(1, target.maxHP);
        int damage = 0;
        int resist = 0;
        int manas = 0;
        String name = "Randomized healing potion";
        return new Item(heals, damage, resist, manas, name);
    }

//    // healing potion that restores half of what's been lost (rounded down)
//    public static Item healingHalfPotion (PlayerCharacter target) {
//        int heals = (target.maxHP - target.hp) / 2;
//        int damage = 0;
//        int resist = 0;
//        int manas = 0;
//        String name = "Plus half of what was lost Healing potion";
//        return new Item(heals, damage, resist, manas, name);
//    }
//
//    // frickin super ninja ultra max healing potion that resets you back to 10
//    public static Item healingMaxPotion (PlayerCharacter target) {
//        int heals = target.maxHP;
//        int damage = 0;
//        int resist = 0;
//        int manas = 0;
//        String name = "Frickin super ninja ultra max healing potion that resets you back to full HP";
//        return new Item(heals, damage, resist, manas, name);
//    }

    // spell that reduces mob-inflicted damage by 1
    public static Item mobDamageReducerSpell() {
        int heals = 0;
        int damage = 0;
        int resist = Game.diceRoll(1, 5);
        int manas = 0;
        String name = "Mob damage reducer spell";
        return new Item(heals, damage, resist, manas, name);
    }

    // armor item that reduces mob-inflicted damage by.....
    public static Item armorItem() {
        int heals = 0;
        int damage = 0;
        int resist = Game.diceRoll(1, 5);
        int manas = 0;
        String name = "Armor";
        return new Item(heals, damage, resist, manas, name);
    }

    // mana potion
    public static Item manaPotion(PlayerCharacter target) {
        int heals = 0;
        int damage = 0;
        int resist = 0;
        int manas = Game.diceRoll(1, target.maxMana);
        String name = "Mana potion";
        return new Item(heals, damage, resist, manas, name);
    }
}