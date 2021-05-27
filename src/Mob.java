import org.jetbrains.annotations.NotNull;

public class Mob {
    protected String mobType;
    protected int hp;
    protected int mana;
    protected int atkStr;
    protected int atkSize;
    private final int maxHP;
    private final int maxMana;

    private Mob(String mobType, int maxHP, int maxMana, int atkDice, int atkSize){
        this.mobType = mobType;
        hp = this.maxHP = maxHP;
        mana = this.maxMana = maxMana;
        this.atkStr = atkDice;
        this.atkSize = atkSize;
    }

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
     * method to reduce players hp and kill the player.
     * @param dmg how much to lower player hp
     * @param enemy enemy mob
     */
    public void dmg(int dmg, Mob enemy){
        if (enemy.hp - dmg > 0){
            enemy.hp -= dmg;
        }
        else{
            enemy.mobType = "dead";
        }
    }

    /**
     * method to increase enemy HP
     * @param heals how much to increase HP
     * @param enemy enemy mob
     */
    public void heal(int heals, @NotNull Mob enemy){
        if (enemy.hp + heals <= enemy.maxHP ){
            enemy.hp += heals;
        }
        else {
            enemy.hp = enemy.maxHP;
        }
    }

    /**
     * method to increase or decrease enemy mana pool
     * @param manas positive increases mana, negative decreases mana
     * @param enemy enemy mob
     */
    public void changeMana(int manas, @NotNull Mob enemy){
        if (enemy.mana + manas <= enemy.maxMana && enemy.mana + manas > 0){
            enemy.mana += manas;
        }
        else if(enemy.mana + manas > enemy.maxMana){
            enemy.mana = enemy.maxMana;
        }
        else{
            enemy.mana = 0;
        }
    }
}
