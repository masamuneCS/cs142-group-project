
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
