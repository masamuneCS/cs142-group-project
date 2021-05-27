import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Entity {
    //players and mobs are entities. Call entity methods when you need to do Stuff.
    protected int hp;
    protected int mana;
    protected final int maxHP;
    protected final int maxMana;
    protected int atkStr;
    protected int atkSize;

    public Entity(int maxHP, int maxMana, int atkStr, int atkSize) {
        hp = this.maxHP = maxHP;
        mana = this.maxMana = maxMana;
        this.atkStr = atkStr;
        this.atkSize = atkSize;
    }

// Stat effecting methods === === === === === === === === === === === === === === === === === === === ===
    /**
     * method to reduce entity hp and kill entity.
     * @param dmg how much to lower hp
     * @param target character or mob to damage
     * @throws GameOverException ends the game
     */
    public void dmg(int dmg, Entity target, Scanner userInput) throws GameOverException{
        if (target instanceof Character){
            if (target.hp - (dmg - ((Character) target).resist) > 0){
                target.hp -= (dmg - ((Character) target).resist);
            }
            else{
                Game.gameOver((Character) target, userInput);
            }
        }
        else if (target.hp - dmg > 0){
            target.hp -= dmg;
        }
        else{
            ((Mob)target).mobType = "dead";
        }

    }

    /**
     * method to increase player HP
     * @param heals how much to increase HP
     * @param target target entity
     */
    public void heal(int heals, @NotNull Entity target){
        if (target.hp + heals <= target.maxHP ){
            target.hp += heals;
        }
        else {
            target.hp = target.maxHP;
        }
    }

    /**
     * method to increase or decrease players mana pool
     * @param manas positive increases mana, negative decreases mana
     * @param target character or mob
     */
    public void changeMana(int manas, @NotNull Entity target){
        if (target.mana + manas <= target.maxMana && target.mana + manas > 0){
            target.mana += manas;
        }
        else if(target.mana + manas > target.maxMana){
            target.mana = target.maxMana;
        }
        else{
            target.mana = 0;
        }
    }
}
