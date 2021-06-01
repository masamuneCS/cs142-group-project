import java.util.Random;
import java.util.Scanner;

public class Game {
    public static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
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
     * @return
     */
    public static int inputValidation (int ceiling){
        while (true){
            if (userInput.hasNextInt()){
                int input = userInput.nextInt();
                if (input < ceiling && input > 0){
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

    public static boolean encounter(PlayerCharacter player, int gameStage){
        Mob[] encounterMobs = new Mob[] {Entity.buildDead(), Entity.buildDead(), Entity.buildDead(), Entity.buildDead()};
        int mobCount = diceRoll(1, 3);

        for (int i = 0; i < mobCount; i++){
            switch(diceRoll(1, 3)){ //picking mobtype based on int 1-3
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
        //TODO - implement turn based combat w/ logic for mobs and input choices for player
        return true;
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