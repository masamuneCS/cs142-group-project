import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Character {
    /**
     * Character class defines the player character stats and methods for adjusting stats and inventory
     */
    protected String playerName;
    protected int hp;
    protected int mana;
    private final int maxHP;
    private final int maxMana;
    protected Item[] inventory = new Item[4]; //Character can carry max four items

    /**
     * method to reduce players hp and kill the player.
     * @param dmg how much to lower player hp
     * @param player player character
     * @param userInput
     * @throws GameOverException ends the game
     */
    public void dmg(int dmg, Character player, Scanner userInput) throws GameOverException{
        if (player.hp - dmg > 0){
            player.hp -= dmg;
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
    public void accessInventory(Scanner userInput, Character player){
        //TODO - make method to access inventory and use item or return
    }
    public void alterInventory(Scanner userInput, Character player){
        //TODO - make method to add items to inventory and allow player to drop/replace items
    }

    private Character(String playerName, int maxHP, int maxMana) {
        this.playerName = playerName;
        hp = this.maxHP = maxHP;
        mana = this.maxMana = maxMana;
    }

    public static Character buildRogue(String playerName){
        int maxHP = 15;
        int maxMana = 15;
        return new Character(playerName, maxHP, maxMana);
    }

    public static Character buildWarrior(String playerName){
        int maxHP = 20;
        int maxMana = 10;
        return new Character(playerName, maxHP, maxMana);
    }

    public static Character buildMage(String playerName){
        int maxHP = 10;
        int maxMana = 20;
        return new Character(playerName, maxHP, maxMana);
    }
}

/*class Rogue extends Character{

    public Rogue(String playerName) {
        super(playerName);
        this.playerName = playerName;
        maxHP = 15;
        hp = maxHP;
        maxMana = 15;
        mana = maxMana;
    }
}

class Warrior extends Character{
    public Warrior(String playerName) {
        super(playerName);
        this.playerName = playerName;
        maxHP = 20;
        hp = maxHP;
        maxMana = 10;
        mana = maxMana;
    }
}

class Mage extends Character{
    public Mage(String playerName) {
        super(playerName);
        this.playerName = playerName;
        maxHP = 10;
        hp = maxHP;
        maxMana = 20;
        mana = maxMana;
    }
}*/

