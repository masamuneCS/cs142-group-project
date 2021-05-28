public class Item {
    public int heals;
    public int damage;
    public int resist;
    public String name;

    public Item(int heals, int damage, int resist, String name){
        this.heals = heals;
        this.damage = damage;
        this.resist = resist;
        this.name = name;
    }

    // healing potion that adds 3 HP back
    public static Item healing3Potion () {
        int heals = 3;
        int damage = 0;
        int resist = 0;
        String name = "Plus 3 HP Healing potion";
        return new Item(heals, damage, resist, name);
    }

    // healing potion that restores half of what's been lost (rounded down)
    public static Item healingHalfPotion (PlayerCharacter target) {
        int heals = (target.maxHP - target.hp) / 2;
        int damage = 0;
        int resist = 0;
        String name = "Plus half of what was lost Healing potion";
        return new Item(heals, damage, resist, name);
    }

    // frickin super ninja ultra max healing potion that resets you back to 10
    public static Item healingMaxPotion (PlayerCharacter target) {
        int heals = target.maxHP;
        int damage = 0;
        int resist = 0;
        String name = "Frickin super ninja ultra max healing potion that resets you back to full HP";
        return new Item(heals, damage, resist, name);
    }

    // spell that reduces mob-inflicted damage by 1
    public static Item mobDamageReducerSpell(PlayerCharacter target) {
        int heals = 0;
        int damage = 0;
        int resist = 1;
        String name = "Mob damage reducer spell";
        return new Item(heals, damage, resist, name);
    }

    // armor item that reduces mob-inflicted damage by.....
    public static Item armorItem(PlayerCharacter target) {
        int heals = 0;
        int damage = 0;
        int resist = 0; // figure out later
        String name = "Armor";
        return new Item(heals, damage, resist, name);
    }
}