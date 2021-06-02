public class Item {
    protected String itemType;
    public int size;
    public int strength;
    public String name;

    public Item(String itemType, int size, int strength, String name){
        this.itemType = itemType;
        this.size = size;
        this.strength = strength;
        this.name = name;
    }

    //FACTORY METHODS
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
                target.heal(Game.diceRoll(this.size, this.strength));
                break;
            }
            case "plusMana":{
                target.changeMana(Game.diceRoll(this.size, this.strength));
                break;
            }
            case "plusResist": {
                if (target instanceof Player){
                    ((Player) target).changeResist(Game.diceRoll(this.size, this.strength));
                    break;
                }
                else{
                    throw new IllegalArgumentException("Item.use plusResist expected Entity subclass Player got " + target.getClass());
                }
            }
            case "bomb":{
                target.dmg(Game.diceRoll(this.size, this.strength));
                break;
            }
            default:
                throw new IllegalArgumentException("Item.use received unknown itemType from " + this);
        }

    }

}
