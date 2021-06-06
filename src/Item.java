public class Item {
    protected String itemType;
    public int size;
    public int strength;
    public String name;
    public static Item[] lootTable0 = new Item[20];
    /*
    itemTypes:
    plusHealth = heals
    plusMana = restores mana
    plusResist = increases resistance
    bomb = deals damage
     */

    public Item(String itemType, int size, int strength, String name){
        this.itemType = itemType;
        this.size = size;
        this.strength = strength;
        this.name = name;
    }

    //FACTORY METHODS
    //Roll lootTable<gameStage>[diceRoll(1, 20)-1] to get a random appropriate loot drop
    public static Item[] genLootTable(){
        Item[] lootTable = new Item[20];
        for (int i = 0; i < lootTable0.length; i++){
            if (i < 4){
                lootTable0[i] = smallHealPotion();
            }
            else if (i >= 5 && i < 8){
                lootTable0[i] = mediumHealPotion();
            }
            else if (i >= 8 && i < 10){
                lootTable0[i] = largeHealPotion();
            }
            else if (i >= 10 && i < 13){
                lootTable0[i] = smallManaPot();
            }
            else if (i >= 13 && i < 15){
                lootTable0[i] = largeManaPot();
            }
            else if (i >= 15 && i < 18){
                lootTable0[i] = resistPot();
            }
            else{
                lootTable0[i] = bomb();
            }
        }
        return lootTable;
    }

    public static Item getLootDrop(){
        return lootTable0[Game.diceRoll(1, lootTable0.length - 1)];
    }

    // healing potion that adds 3 HP back
    public static Item smallHealPotion () {
        String itemType = "plusHealth";
        int size = 2;
        int strength = 4;
        String name = "Poultice heals " + size + "d" + strength + " HP.";
        return new Item(itemType, size, strength, name);
    }

    // medium healing potion
    public static Item mediumHealPotion () {
        String itemType = "plusHealth";
        int size = 3;
        int strength = 5;
        String name = "Potion of Health heals " + size + "d" + strength + " HP.";
        return new Item(itemType, size, strength, name);
    }

    // big-ass healing potion
    public static Item largeHealPotion () {
        String itemType = "plusHealth";
        int size = 4;
        int strength = 6;
        String name = "Draught of health heals " + size + "d" + strength + " HP.";
        return new Item(itemType, size, strength, name);
    }

    // spell that reduces mob-inflicted damage by 1
    public static Item resistPot() {
        String itemType = "plusResist";
        int size = 1;
        int strength = 3;
        String name = "Draught of Armor gives " + size + "d" + strength + " resistance.";
        return new Item(itemType, size, strength, name);
    }

    // mana potion - coffee
    public static Item smallManaPot() {
        String itemType = "plusMana";
        int size = 3;
        int strength = 4;
        String name = "Potion of Rest restores " + size + "d" + strength + " mana.";
        return new Item(itemType, size, strength, name);
    }

    // mana potion - cocaine
    public static Item largeManaPot() {
        String itemType = "plusMana";
        int size = 5;
        int strength = 4;
        String name = "Draught of Rest restores " + size + "d" + strength + " mana.";
        return new Item(itemType, size, strength, name);
    }

    public static Item bomb(){
        String itemType = "bomb";
        int size = 3;
        int strength = 4;
        String name = "Firebomb deals " + size + "d" + strength + " damage to all enemies.";
        return new Item(itemType, size, strength, name);
    }

    //USE METHODS
    public void use (Entity target) throws IllegalArgumentException, GameOverException {
        switch(this.itemType){
            case "plusHealth":{
                int heals = Game.diceRoll(this.size, this.strength);
                ((Player) target).heal(heals);
                System.out.println("Your potion healed you for " + heals + " HP.");
                break;
            }
            case "plusMana":{
                int manas = Game.diceRoll(this.size, this.strength);
                ((Player) target).changeMana(manas);
                System.out.println("Your potion restored " + manas + " mana.");
                break;
            }
            case "plusResist": {
                if (target instanceof Player){
                    int resists = Game.diceRoll(this.size, this.strength);
                    ((Player) target).changeResist(resists);
                    System.out.println("Your potion gave you " + resists + " more resistance til the end of this encounter!");
                    break;
                }
                else{
                    throw new IllegalArgumentException("Item.use plusResist expected Entity subclass Player got " + target.getClass());
                }
            }
            case "bomb":{
                int dmg = Game.diceRoll(this.size, this.strength);
                String targetClass = target.classType;
                target.dmg(dmg);
                System.out.println("Your bomb hit a " + targetClass + " for " + dmg + "damage!");
                break;
            }
            default:
                throw new IllegalArgumentException("Item.use received unknown itemType from " + this);
        }

    }

}
