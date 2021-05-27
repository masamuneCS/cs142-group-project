import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Character extends Entity {
    /**
     * Character class defines the player character stats and methods for adjusting stats and inventory
     */
    protected String playerName;
    protected String classType;
    protected int resist;

    private final int passiveResist;
    private static final int maxResist = 4;
    protected Item[] inventory = new Item[4]; //Character can carry max four items

    private Character(String playerName, int maxHP, int maxMana, int passiveResist, String classType, int atkStr, int atkSize) {
        super(maxHP, maxMana, atkStr, atkSize);
        this.playerName = playerName;
        resist = this.passiveResist = passiveResist;
        this.classType = classType;
    }

        public static Character buildRogue(String playerName){
            String classType = "rogue";
            int maxHP = 20;
            int maxMana = 15;
            int passiveResist = 0;
            int atkStr = 6;
            int atkSize = 2;
            return new Character(playerName, maxHP, maxMana, passiveResist, classType, atkStr, atkSize);
        }

        public static Character buildWarrior(String playerName){
            String classType = "warrior";
            int maxHP = 25;
            int maxMana = 10;
            int passiveResist = 1;
            int atkStr = 6;
            int atkSize = 2;
            return new Character(playerName, maxHP, maxMana, passiveResist, classType, atkStr, atkSize);
        }

        public static Character buildMage(String playerName){
            String classType = "mage";
            int maxHP = 15;
            int maxMana = 20;
            int passiveResist = 0;
            int atkStr = 6;
            int atkSize = 2;
            return new Character(playerName, maxHP, maxMana, passiveResist, classType, atkStr, atkSize);
        }

    // Stat effecting methods === === === === === === === === === === === === === === === === === === === ===



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

}



