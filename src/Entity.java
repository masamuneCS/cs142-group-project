import java.util.Scanner;

public class Entity {
    //players and mobs are entities. Call entity methods when you need to do Stuff.
    protected int hp;
    protected int mana;
    protected final int maxHP;
    protected final int maxMana;
    protected int atkStr;
    protected int atkSize;
    protected int initiative;

    public Entity(int maxHP, int maxMana, int atkStr, int atkSize) {
        hp = this.maxHP = maxHP;
        mana = this.maxMana = maxMana;
        this.atkStr = atkStr;
        this.atkSize = atkSize;
        this.initiative = 0; //default initiative is always zero, gets rolled at top of encounter
    }

    //Player Character factory methods === === === === === === === === === === === === === === === === === === === ===
    public static Character buildRogue(String playerName){
        String classType = "rogue";
        int maxHP = 20;
        int maxMana = 15;
        int passiveResist = 0;
        int atkStr = 3;
        int atkSize = 2;
        return new Character(playerName, maxHP, maxMana, passiveResist, classType, atkStr, atkSize);
    }

    public static Character buildWarrior(String playerName){
        String classType = "warrior";
        int maxHP = 25;
        int maxMana = 10;
        int passiveResist = 1;
        int atkStr = 4;
        int atkSize = 2;
        return new Character(playerName, maxHP, maxMana, passiveResist, classType, atkStr, atkSize);
    }

    public static Character buildMage(String playerName){
        String classType = "mage";
        int maxHP = 15;
        int maxMana = 20;
        int passiveResist = 0;
        int atkStr = 3;
        int atkSize = 2;
        return new Character(playerName, maxHP, maxMana, passiveResist, classType, atkStr, atkSize);
    }

//Mob Factory Methods === === === === === === === === === === === === === === === === === === === ===
    public static Mob grunt(){
        String mobType = "grunt";
        int maxHP = 10;
        int maxMana = 10;
        int atkDice = 1;
        int atkSize = 4;
        return new Mob(mobType, maxHP, maxMana, atkDice, atkSize);
    }

    public static Mob brute(){
        String mobType = "brute";
        int maxHP = 20;
        int maxMana = 10;
        int atkDice = 2;
        int atkSize = 4;
        return new Mob(mobType, maxHP, maxMana, atkDice, atkSize);
    }

    public static Mob shaman(){
        String mobType = "shaman";
        int maxHP = 10;
        int maxMana = 15;
        int atkDice = 1;
        int atkSize = 4;
        return new Mob(mobType, maxHP, maxMana, atkDice, atkSize);
    }

// Stat effecting methods === === === === === === === === === === === === === === === === === === === ===
    /**
     * method to reduce entity hp and kill entity.
     * @param dmg how much to lower hp
     * @throws GameOverException ends the game
     */
    public void dmg(int dmg) throws GameOverException{
        if (this instanceof Character){
            if (this.hp - (dmg - ((Character) this).resist) > 0){
                this.hp -= (dmg - ((Character) this).resist);
            }
            else{
                Game.gameOver((Character) this);
            }
        }
        else if (this.hp - dmg > 0){
            this.hp -= dmg;
        }
        else{
            ((Mob)this).mobType = "dead";
        }

    }

    /**
     * method to increase player HP
     * @param heals how much to increase HP
     */
    public void heal(int heals){
        if (this.hp + heals <= this.maxHP ){
            this.hp += heals;
        }
        else {
            this.hp = this.maxHP;
        }
    }

    /**
     * method to increase or decrease players mana pool
     * @param manas positive increases mana, negative decreases mana
     */
    public void changeMana(int manas){
        if (this.mana + manas <= this.maxMana && this.mana + manas > 0){
            this.mana += manas;
        }
        else if(this.mana + manas > this.maxMana){
            this.mana = this.maxMana;
        }
        else{
            this.mana = 0;
        }
    }

    //Ability methods === === === === === === === === === === === === === === === === === === === === === === === === ===

    public void basicAttack(Entity target, int atkStr, int atkSize) throws GameOverException{
        //damages an enemy target based on entity atk stats
        int dmg = Game.diceRoll(atkSize, atkStr);
        target.dmg(dmg);
    }

    public void healAlly(Entity target, Entity caster) throws IllegalArgumentException{
        //shaman only, heals an ally target for 2 d3 heals for 5 mana
        int manaCost = 5;
        if (caster instanceof Mob){
            if (((Mob)caster).mobType.equals("shaman") && caster.mana > manaCost){
                int heals = Game.diceRoll(2, 3);
                target.heal(heals);
                caster.changeMana(-manaCost);
            }
        }
        else{
            throw new IllegalArgumentException();
        }

    }

    public void fireball(Entity target, Entity caster) throws GameOverException, IllegalArgumentException {
        //mage only, deals 2 d6 damage
        int manaCost = 5;
        if (caster instanceof Character){
            if (((Character) caster).classType.equals("mage")){
                int dmg = Game.diceRoll(2, 6);
                target.dmg(dmg);
                caster.changeMana(-manaCost);
            }
        }
        else{
            throw new IllegalArgumentException();
        }
    }


}


class Character extends Entity {
    /**
     * Character class defines the player character stats and methods for adjusting stats and inventory
     */
    protected String playerName;
    protected String classType;
    protected int resist;
    private final int passiveResist;
    private static final int maxResist = 4;
    protected Item[] inventory = new Item[4]; //Character can carry max four items

    protected Character(String playerName, int maxHP, int maxMana, int passiveResist, String classType, int atkStr, int atkSize) {
        super(maxHP, maxMana, atkStr, atkSize);
        this.playerName = playerName;
        resist = this.passiveResist = passiveResist;
        this.classType = classType;
    }

/*    public static Character buildRogue(String playerName){
        String classType = "rogue";
        int maxHP = 20;
        int maxMana = 15;
        int passiveResist = 0;
        int atkStr = 3;
        int atkSize = 2;
        return new Character(playerName, maxHP, maxMana, passiveResist, classType, atkStr, atkSize);
    }

    public static Character buildWarrior(String playerName){
        String classType = "warrior";
        int maxHP = 25;
        int maxMana = 10;
        int passiveResist = 1;
        int atkStr = 4;
        int atkSize = 2;
        return new Character(playerName, maxHP, maxMana, passiveResist, classType, atkStr, atkSize);
    }

    public static Character buildMage(String playerName){
        String classType = "mage";
        int maxHP = 15;
        int maxMana = 20;
        int passiveResist = 0;
        int atkStr = 3;
        int atkSize = 2;
        return new Character(playerName, maxHP, maxMana, passiveResist, classType, atkStr, atkSize);
    }*/

    // Stat effecting methods === === === === === === === === === === === === === === === === === === === ===

    public void changeResist(int resists){
        if (this.resist + resists > this.passiveResist && this.resist + resists < maxResist){
            this.resist += resists;
        }
        else if (this.resist + resists < this.passiveResist){
            this.resist = this.passiveResist;
        }
        else if (this.resist + resists > maxResist){
            this.resist = maxResist;
        }
    }
    public void accessInventory(Scanner userInput, Character player){
        //TODO - make method to access inventory and use item or return
    }
    public void alterInventory(Scanner userInput, Character player){
        //TODO - make method to add items to inventory and allow player to drop/replace items
    }

}

class Mob extends Entity {
    protected String mobType;


    protected Mob(String mobType, int maxHP, int maxMana, int atkStr, int atkSize){
        super(maxHP, maxMana, atkStr, atkSize );
        this.mobType = mobType;

    }

/*    public static Mob grunt(){
        String mobType = "grunt";
        int maxHP = 10;
        int maxMana = 10;
        int atkDice = 1;
        int atkSize = 4;
        return new Mob(mobType, maxHP, maxMana, atkDice, atkSize);
    }

    public static Mob brute(){
        String mobType = "brute";
        int maxHP = 20;
        int maxMana = 10;
        int atkDice = 2;
        int atkSize = 4;
        return new Mob(mobType, maxHP, maxMana, atkDice, atkSize);
    }

    public static Mob shaman(){
        String mobType = "shaman";
        int maxHP = 10;
        int maxMana = 15;
        int atkDice = 1;
        int atkSize = 4;
        return new Mob(mobType, maxHP, maxMana, atkDice, atkSize);
    }*/

//call entity methods to effect mob stats
}