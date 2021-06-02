import java.util.Scanner;

public class Entity {
    //players and mobs are entities. Call entity methods when you need to do Stuff.
    protected String classType;
    protected int hp;
    protected int mana;
    protected final int maxHP;
    protected final int maxMana;
    protected int atkStr;
    protected int atkSize;
    protected int initiative;
    protected int initBuff;

    public Entity(int maxHP, int maxMana, int atkStr, int atkSize, String classType, int initBuff) {
        this.classType = classType;
        hp = this.maxHP = maxHP;
        mana = this.maxMana = maxMana;
        this.atkStr = atkStr;
        this.atkSize = atkSize;
        initiative = this.initBuff = initBuff; //default initiative is always zero, gets rolled at top of encounter
    }

    //Player Character factory methods === === === === === === === === === === === === === === === === === === === ===
    public static PlayerCharacter buildRogue(String playerName){
        String classType = "rogue";
        int maxHP = 20;
        int maxMana = 15;
        int passiveResist = 0;
        int atkStr = 3;
        int atkSize = 2;
        int initBuff = 2;
        return new PlayerCharacter(playerName, maxHP, maxMana, passiveResist, classType, atkStr, atkSize, initBuff);
    }

    public static PlayerCharacter buildWarrior(String playerName){
        String classType = "warrior";
        int maxHP = 25;
        int maxMana = 10;
        int passiveResist = 1;
        int atkStr = 4;
        int atkSize = 2;
        int initBuff = 0;
        return new PlayerCharacter(playerName, maxHP, maxMana, passiveResist, classType, atkStr, atkSize, initBuff);
    }

    public static PlayerCharacter buildMage(String playerName){
        String classType = "mage";
        int maxHP = 15;
        int maxMana = 20;
        int passiveResist = 0;
        int atkStr = 3;
        int atkSize = 2;
        int initBuff = 0;
        return new PlayerCharacter(playerName, maxHP, maxMana, passiveResist, classType, atkStr, atkSize, initBuff);
    }

//Mob Factory Methods === === === === === === === === === === === === === === === === === === === ===
    public static Mob buildGrunt(){
        String classType = "grunt";
        int maxHP = 10;
        int maxMana = 10;
        int atkDice = 1;
        int atkSize = 4;
        int initBuff = 0;
        return new Mob(classType, maxHP, maxMana, atkDice, atkSize, initBuff);
    }

    public static Mob buildBrute(){
        String classType = "brute";
        int maxHP = 20;
        int maxMana = 10;
        int atkDice = 2;
        int atkSize = 4;
        int initBuff = 0;
        return new Mob(classType, maxHP, maxMana, atkDice, atkSize, initBuff);
    }

    public static Mob buildShaman(){
        String classType = "shaman";
        int maxHP = 10;
        int maxMana = 15;
        int atkDice = 1;
        int atkSize = 4;
        int initBuff = 0;
        return new Mob(classType, maxHP, maxMana, atkDice, atkSize, initBuff);
    }

    public static Mob buildDead(){//build a dead mob to replaced later with an alive mob.
        String classType = "dead";
        int maxHP = 0;
        int maxMana = 0;
        int atkDice = 0;
        int atkSize = 0;
        int initBuff = 0;
        return new Mob(classType, maxHP, maxMana, atkDice, atkSize, initBuff);
    }

// Stat effecting methods === === === === === === === === === === === === === === === === === === === ===
    /**
     * dmg method to reduce entity hp and kill entity.
     * @param dmg how much to lower hp
     * @throws GameOverException ends the game
     */
    public void dmg(int dmg) throws GameOverException{
        if (this instanceof PlayerCharacter){
            if (this.hp - (dmg - ((PlayerCharacter) this).resist) > 0){
                this.hp -= (dmg - ((PlayerCharacter) this).resist);
            }
            else{
                Game.gameOver((PlayerCharacter) this);
            }
        }
        else if (this.hp - dmg > 0){
            this.hp -= dmg;
        }
        else{
            (this).classType = "dead";
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

    public void basicAttack(Entity target) throws GameOverException{
        //damages an enemy target based on entity atk stats
        int dmg = Game.diceRoll(this.atkSize, this.atkStr);
        target.dmg(dmg);
        if (this instanceof PlayerCharacter){
            if (target.hp > 0){
                System.out.println(((PlayerCharacter) this).playerName + " attacked " + target.classType + " for " + dmg + " damage!");
            }
            else{
                System.out.println(((PlayerCharacter) this).playerName + " attacked " + target.classType + " for " + dmg + " damage and killed it!");
            }
        }
        else{
            System.out.println(this.classType + " attacked " + ((PlayerCharacter)target).playerName + " for " + dmg + " damage!");
        }
    }
//Shaman special ability
    public void healAlly(Entity target) throws IllegalArgumentException{
        //shaman only, heals an ally target for 2 d3 heals for 5 mana
        int manaCost = 5;
        if (this instanceof Mob){
            if (this.classType.equals("shaman") && this.mana > manaCost){
                int heals = Game.diceRoll(2, 3);
                target.heal(heals);
                this.changeMana(-manaCost);
                System.out.println(this.classType + " healed " + target.classType + " for " + heals + " HP!");
            }
        }
        else{
            throw new IllegalArgumentException();
        }

    }
//Mage special ability
    public void fireball(Entity target) throws GameOverException, IllegalArgumentException {
        //mage only, deals 2 d8 damage
        int manaCost = 5;
        if (this instanceof PlayerCharacter){
            if (this.classType.equals("mage")){
                int dmg = Game.diceRoll(2, 8);
                target.dmg(dmg);
                this.changeMana(-manaCost);
                if (target.hp > 0){
                    System.out.println(((PlayerCharacter) this).playerName + " cast FIREBALL on " + target.classType + " for " + dmg + " damage!");
                }
                else{
                    System.out.println(((PlayerCharacter) this).playerName + " cast FIREBALL on " + target.classType + " for " + dmg + " damage and killed it!");
                }
            }
        }
        else{
            throw new IllegalArgumentException();
        }
    }
//Rogue special ability
    public void sneakAttack(Entity target) throws GameOverException, IllegalArgumentException {
        //rogue only, does 2 dInitiative damage
        int manaCost = 5;
        if (this instanceof PlayerCharacter){
            if (this.classType.equals("rogue")){
                int dmg = Game.diceRoll(2, this.initiative / 2);
                target.dmg(dmg);
                this.changeMana(-manaCost);
                if (target.hp > 0){
                    System.out.println(((PlayerCharacter) this).playerName + " used SNEAK ATTACK on " + target.classType + " for " + dmg + " damage!");
                }
                else{
                    System.out.println(((PlayerCharacter) this).playerName + " used SNEAK ATTACK on " + target.classType + " for " + dmg + " damage and killed it!");
                };
            }
        }
        else{
            throw new IllegalArgumentException();
        }
    }
//Warrior special ability
    public void smash(Entity target) throws GameOverException, IllegalArgumentException {
        //warrior only, does 4 dStrength damage
        int manaCost = 5;
        if (this instanceof PlayerCharacter){
            if (this.classType.equals("warrior")){
                int dmg = Game.diceRoll(4, this.atkStr);
                target.dmg(dmg);
                this.changeMana(-manaCost);
                if (target.hp > 0){
                    System.out.println(((PlayerCharacter) this).playerName + " used SMASH on " + target.classType + " for " + dmg + " damage!");
                }
                else{
                    System.out.println(((PlayerCharacter) this).playerName + " used SMASH on " + target.classType + " for " + dmg + " damage and killed it!");
                }
            }
        }
        else{
            throw new IllegalArgumentException();
        }
    }


}


class PlayerCharacter extends Entity {
    /**
     * Character class defines the player character stats and methods for adjusting stats and inventory
     */
    protected String playerName;
    protected int resist;
    private final int passiveResist;
    private static final int maxResist = 4;
    protected Item[] inventory = new Item[4]; //Character can carry max four items

    protected PlayerCharacter(String playerName, int maxHP, int maxMana, int passiveResist, String classType, int atkStr, int atkSize, int initBuff) {
        super(maxHP, maxMana, atkStr, atkSize, classType, initBuff);
        this.playerName = playerName;
        resist = this.passiveResist = passiveResist;
    }

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
    public void accessInventory(){
        System.out.println("Inventory:");
        for (int i = 0; i < this.inventory.length; i++){
            if (this.inventory[i] == null){
                System.out.println("Slot "+ (i + 1) + ": Empty ");
            }
            else{
                System.out.println("Slot " + (i + 1) + ": " + this.inventory[i].name);
            }
        }
        while (true){
            System.out.println("Which item would you like to use? Or choose 5 to go back:");
        }
    }
    public void alterInventory(Item newItem){
        for (int i = 0; i < this.inventory.length; i++){
            if (this.inventory[i] == null){
                System.out.println("Slot "+ (i + 1) + ": Empty ");
            }
            else{
                System.out.print("Slot " + (i + 1) + ": " + this.inventory[i].name);
            }

        }
        System.out.println("What slot would you like to add the item to? Or choose 5 to go back.");
        while(true) {
            switch (Game.userInput.nextLine()) {
                case "1": {
                    this.inventory[0] = newItem;
                    break;
                }
                case "2": {
                    this.inventory[1] = newItem;
                    break;
                }
                case "3": {
                    this.inventory[2] = newItem;
                    break;
                }
                case "4": {
                    this.inventory[3] = newItem;
                    break;
                }
                case "5": {

                }
                default: {
                    System.out.println("Enter 1,2, 3, or 4 to choose.");
                    continue;
                }
                //TODO - confirm if player wants to throw away item in occupied slot, allow them to just not pick up item
            }
            break;
        }
    }
}

class Mob extends Entity {

    protected Mob(String classType, int maxHP, int maxMana, int atkStr, int atkSize, int initBuff){
        super(maxHP, maxMana, atkStr, atkSize, classType, initBuff);
    }

}