import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Character {
    /**
     * Character class defines the player character stats and methods for adjusting stats and inventory
     */
    protected String playerName;
    protected int hp;
    protected int mana;
    protected int maxHP;
    protected int maxMana;
    protected Item[] inventory = new Item[4]; //Character can carry max four items

    public void dmgChar(int dmg){
        //TODO make method to reduce HP until character death
    }
    public void healChar(int heals, @NotNull Character player){
        if (player.hp + heals <= player.maxHP ){
            player.hp += heals;
        }
        else {
            player.hp = player.maxHP;
        }
    }
    public void accessInventory(Scanner userInput){
        //TODO - make method to access inventory and use item or return
    }
    public void alterInventory(Scanner userInput){
        //TODO - make method to add items to inventory and allow player to drop/replace items
    }

    private Character(String playerName, int maxHP, int maxMana) {
        this.maxHP = maxHP;
        hp = maxHP;
        this.maxMana = maxMana;
        mana = maxMana;
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

