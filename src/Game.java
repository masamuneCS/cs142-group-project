import javax.naming.NoInitialContextException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        MiniGame.blackJack();
        int gameStage = 1;
        while(true) { //game loop. All game processes should be inside this loop.
            try { //KEEP ALL GAME CODE INSIDE THE TRY BLOCK PLEASE AND THANK YOU
                PlayerCharacter player;
                System.out.println("What kind of hero are you? Type a number and press enter.\n" +
                        "1: Warrior. Can take a lot of hits.\n" +
                        "2: Rogue. Everything balanced, as it should be.\n" +
                        "3: Mage. Hits very hard, is made of glass.");
                while(true) {
                    switch (userInput.nextLine()) {
                        case "1" : {
                            System.out.println("What should I call you, warrior? Type a name and press enter.");
                            String name = userInput.nextLine();
                            player = PlayerCharacter.buildWarrior(name);
                            break;
                        }
                        case "2" : {
                            System.out.println("What should I call you, rogue?");
                            String name = userInput.nextLine();
                            player = PlayerCharacter.buildRogue(name);
                            break;
                        }
                        case "3" : {
                            System.out.println("What should I call you, mage?");
                            String name = userInput.nextLine();
                            player = PlayerCharacter.buildMage(name);
                            break;
                        }
                        default : {
                            System.out.println("Enter 1,2, or 3 to choose.");
                            continue;
                        }
                    }
                    break; //breaks loop
                }

                encounter(player, gameStage);

                Item newItem = Item.smallHealingPotion();
                player.alterInventory(newItem);
                player.accessInventory();
                //TODO - Ya know, the rest of the game.
                gameOver(player);
            }
            catch (GameOverException exception) { //either closes program or restarts game based on player choice in GameOverException.
                if (exception.playAgain){
                    continue;
                }
                break;
            }
        }//game loop end
    }

    /**
     * the player lost, the end of the game.
     * @param player the player character
     * @throws GameOverException end the game
     */
    public static void gameOver (PlayerCharacter player) throws GameOverException {
        System.out.println(player.playerName + " died. How sad.\nG A M E  O V E R");
        System.out.println("Do you want to play again Y/n?");
        boolean playAgain = !userInput.next().equalsIgnoreCase("n");
        throw new GameOverException(playAgain);

    }

    private static final Random rand = new Random(); //for getting nice random numbers without the weird math.random formula
    /**
     * rolls dice!
     * @param numDice how many dice to roll
     * @param dSize how big of a die are you rolling
     * @return what did you roll
     */
    public static int diceRoll (int numDice, int dSize){
        int roll = 0;
        for (int i = 0; i < numDice; i++){
            roll += 1 + rand.nextInt(dSize);
        }
        return roll;
    }

    /**
     * Does what it says on the tin
     * @param ceiling maximum allowable int input
     * @return int input
     */
    public static int inputValidation (int ceiling){
        while (true){
            if (userInput.hasNextInt()){
                int input = userInput.nextInt();
                if (input <= ceiling && input > 0){
                    return input;
                }
                else{
                    userInput.nextLine();
                    System.out.println("Enter a number between 1 and " + ceiling + " to choose.");
                }
            }
            else{
                System.out.println("Enter a number between 1 and " + ceiling + " to choose.");
            }
        }
    }

    public static boolean encounter(PlayerCharacter player, int gameStage) throws GameOverException {
        Mob[] encounterMobs = new Mob[] {Entity.buildDead(), Entity.buildDead(), Entity.buildDead(), Entity.buildDead()};
        int mobCount = diceRoll(1, 3);

        for (int i = 0; i < mobCount; i++){
            switch(diceRoll(1, 3)){ //picking mobType based on int 1-3
                case 1:
                    encounterMobs[i] = Entity.buildGrunt();
                    break;
                case 2:
                    encounterMobs[i] = Entity.buildBrute();
                    break;
                case 3:
                    encounterMobs[i] = Entity.buildShaman();
                    break;
                default :
                    throw new IllegalArgumentException("Encounter mob builder received invalid mob type roll");
            }
        }
        Entity[] encounterAll = new Entity[5]; //placing player in entity array w/ mobs
        encounterAll[0] = player;
        System.arraycopy(encounterMobs, 0, encounterAll, 1, encounterMobs.length);
        //establish initiative for player and mobs.
        player.initiative = diceRoll(1, 20);
        for (Mob mob : encounterMobs){
            mob.initiative = diceRoll(1, 20);
        }
        //Ordering entities in array by initiative to establish turn order.
        for (int i = 1; i < encounterAll.length; i++){
            Entity key = encounterAll[i];
            int j = i - 1;
            while (j >= 0 && encounterAll[j].initiative > key.initiative){
                encounterAll[j+1] = encounterAll[j];
                j--;
            }
            encounterAll[j+1] = key;

        }
        int turn = 0;
        while(true){
            int movePoint = 1;
            if (encounterAll[turn] instanceof PlayerCharacter){
                while(movePoint > 0){
                    if (mobCount > 1){
                        System.out.println("There are " + mobCount + " enemies before you!");
                    }
                    else{
                        System.out.println("There is " + mobCount + " enemy before you!");
                    }
                    System.out.println("HP: " + player.hp + " Mana: " + player.mana);
                    System.out.println("What would you like to do?\n1: Attack\n2: Special Attack\n3: Use an item from your inventory");
                    switch(userInput.nextLine()){
                        case "1": {
                            System.out.println("Your basic attack deals " + player.atkSize + "d" + player.atkStr + "damage, which enemy would you like to target?");
                            int i = 1;
                            for (Mob mob : encounterMobs) {
                                if (!mob.classType.equals("dead"))
                                    System.out.println(i + ": A " + mob.classType + " with " + mob.hp + "HP");
                                i++;
                            }
                            System.out.println("or choose " + encounterMobs.length + " to go back.");
                            System.out.print("Choose: ");
                            int input = inputValidation(encounterMobs.length);
                            if (input < mobCount) {
                                player.basicAttack(encounterMobs[input - 1]);
                                movePoint -= 1;
                            } else {
                                continue;
                            }
                            break;
                        }
                        case "2": {
                            if (player.classType.equals("warrior")) {
                                System.out.println(player.playerName + " your special warrior ability is SMASH. SMASH deals 4d" + player.atkStr + " damage and costs 5 mana");
                            }
                            if (player.mana < 5){
                                System.out.println("You don't have enough mana, maybe try using a potion?");
                                System.out.println();
                                continue;
                            }
                            System.out.println("Which enemy would you like to attack?\n or press " + encounterMobs.length + " to go back.");
                            int i = 1;
                            for (Mob mob : encounterMobs) {
                                if (!mob.classType.equals("dead"))
                                    System.out.println(i + ": A " + mob.classType + " with " + mob.hp + "HP");
                                i++;
                            }
                            System.out.println(encounterMobs.length + ": Go back");
                            int input = inputValidation(encounterMobs.length);
                            if (input <= mobCount){
                                if (player.classType.equals("warrior")){
                                    player.smash(encounterMobs[input]);
                                    movePoint -= 1;
                                }
                            }
                            else{
                                continue;
                            }
                        }
                    }
                }
            }
            if (turn >= encounterAll.length){
                turn = 0;
            }
            turn += 1;
        }
    }

}

/**
 * GameOverException either restarts or ends the game.
 */
class GameOverException extends Exception{
    boolean playAgain;

    GameOverException(boolean playAgain){
        this.playAgain = playAgain;
    }
}