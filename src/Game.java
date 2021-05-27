import java.util.Random;
import java.util.Scanner;

public class Game {
    public static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        int gameStage = 1;
        while(true) { //game loop. All game processes should be inside this loop.
            try { //KEEP ALL GAME CODE INSIDE THE TRY BLOCK PLEASE AND THANK YOU
                Character player;
                System.out.println("What kind of hero are you? Type a number and press enter.\n" +
                        "1: Warrior. Can take a lot of hits.\n" +
                        "2: Rogue. Everything balanced, as it should be.\n" +
                        "3: Mage. Hits very hard, is made of glass.");
                while(true) {
                    switch (userInput.nextLine()) {
                        case "1" : {
                            System.out.println("What should I call you, warrior? Type a name and press enter.");
                            String name = userInput.nextLine();
                            player = Character.buildWarrior(name);
                            break;
                        }
                        case "2" : {
                            System.out.println("What should I call you, rogue?");
                            String name = userInput.nextLine();
                            player = Character.buildRogue(name);
                            break;
                        }
                        case "3" : {
                            System.out.println("What should I call you, mage?");
                            String name = userInput.nextLine();
                            player = Character.buildMage(name);
                            break;
                        }
                        default : {
                            System.out.println("Enter 1,2, or 3 to choose.");
                            continue;
                        }
                    }
                    break; //breaks loop
                }
                //TODO - Ya know, the rest of the game.
                gameOver(player);
            }
            catch (GameOverException exception) { //either closes program or restarts game based on player choice in GameOverException.
                if (exception.playAgain){
                    continue;
                }
                break;
            }
        }
    }

    /**
     * the player lost, the end of the game.
     * @param player the player character
     * @throws GameOverException end the game
     */
    public static void gameOver (Character player) throws GameOverException {
        System.out.println(player.playerName + " died. How sad.\nG A M E  O V E R");
        System.out.println("Do you want to play again Y/n?");
        boolean playAgain = !userInput.next().equalsIgnoreCase("n");
        throw new GameOverException(playAgain);

    }

    private static Random rand = new Random(); //for getting nice random numbers without the weird math.random formula
    /**
     * rolls dice!
     * @param numDice how many dice to roll
     * @param dSize how big of a die are you rolling
     * @return what did you roll
     */
    public static int diceRoll (int numDice, int dSize){
        int roll = 0;
        for (int i = 0; i < numDice; i++){
            roll += rand.nextInt(dSize + 1);
        }
        return roll;
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