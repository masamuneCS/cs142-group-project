import org.jetbrains.annotations.NotNull;

public class Mob extends Entity {
    protected String mobType;


    private Mob(String mobType, int maxHP, int maxMana, int atkStr, int atkSize){
        super(maxHP, maxMana, atkStr, atkSize );
        this.mobType = mobType;

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

//call entity methods to effect mob stats
}
