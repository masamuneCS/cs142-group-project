import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Character {
    /**
     * Character class defines the player character stats and methods for adjusting stats and inventory
     */
    protected String playerName;
    protected String classType;
    protected int hp;
    protected int mana;
    protected int resist;
    private final int maxHP;
    private final int maxMana;
    private final int passiveResist;
    private static final int maxResist = 4;
    protected Item[] inventory = new Item[4]; //Character can carry max four items

    private Character(String playerName, int maxHP, int maxMana, int passiveResist, String classType) {
        this.playerName = playerName;
        hp = this.maxHP = maxHP;
        mana = this.maxMana = maxMana;
        resist = this.passiveResist = passiveResist;
        this.classType = classType;
    }

        public static Character buildRogue(String playerName){
            String classType = "rogue";
            int maxHP = 20;
            int maxMana = 15;
            int passiveResist = 0;
            return new Character(playerName, maxHP, maxMana, passiveResist, classType);
        }

        public static Character buildWarrior(String playerName){
            String classType = "warrior";
            int maxHP = 25;
            int maxMana = 10;
            int passiveResist = 1;
            return new Character(playerName, maxHP, maxMana, passiveResist, classType);
        }

        public static Character buildMage(String playerName){
            String classType = "mage";
            int maxHP = 15;
            int maxMana = 20;
            int passiveResist = 0;
            return new Character(playerName, maxHP, maxMana, passiveResist, classType);
        }

    // Stat effecting methods === === === === === === === === === === === === === === === === === === === ===

    /**
     * method to reduce players hp and kill the player.
     * @param dmg how much to lower player hp
     * @param player player character
     * @param userInput
     * @throws GameOverException ends the game
     */
    public void dmg(int dmg, Character player, Scanner userInput) throws GameOverException{
        if (player.hp - (dmg - player.resist) > 0){
            player.hp -= (dmg - player.resist);
        }
        else{
            Game.gameOver(player, userInput);
        }
    }

    /**
     * method to increase player HP
     * @param heals how much to increase HP
     * @param player player character
     */
    public void heal(int heals, @NotNull Character player){
        if (player.hp + heals <= player.maxHP ){
            player.hp += heals;
        }
        else {
            player.hp = player.maxHP;
        }
    }

    /**
     * method to increase or decrease players mana pool
     * @param manas positive increases mana, negative decreases mana
     * @param player player character
     */
    public void changeMana(int manas, @NotNull Character player){
        if (player.mana + manas <= player.maxMana && player.mana + manas > 0){
            player.mana += manas;
        }
        else if(player.mana + manas > player.maxMana){
            player.mana = player.maxMana;
        }
        else{
            player.mana = 0;
        }
    }

    public void changeResist(int resists, @NotNull Character player){
        if (player.resist + resists > player.passiveResist && player.resist + resists < maxResist){
            player.resist += resists;
        }
        else if (player.resist + resists < player.passiveResist){
            player.resist = player.passiveResist;
        }
        else if (player.resist + resists > maxResist){
            player.resist = maxResist;
        }
    }
    public void accessInventory(Scanner userInput, Character player){
        //TODO - make method to access inventory and use item or return
    }
    public void alterInventory(Scanner userInput, Character player){
        //TODO - make method to add items to inventory and allow player to drop/replace items
    }

  //Ability Methods

    public void basicAttack(Mob enemy){

    }

}



