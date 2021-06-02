import javax.naming.NoInitialContextException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {
    public static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args){
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
                    userInput.nextLine();
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

    public static boolean encounter(PlayerCharacter player, int gameStage) throws GameOverException, IllegalArgumentException {
        boolean encounterActive = true;
        Mob[] encounterMobs = new Mob[] {Entity.buildDead(), Entity.buildDead(), Entity.buildDead(), Entity.buildDead(), Entity.buildDead()};
        int mobCount = diceRoll(1, 3);

        for (int i = 0; i < mobCount; i++){
            int roll = diceRoll(1, 10); //picking mobType based on int 1-10
            if (roll >= 1 && roll < 6) {
                encounterMobs[i] = Entity.buildGrunt();
            }
            else if (roll >= 6 && roll < 9) {
                encounterMobs[i] = Entity.buildBrute();
            }
            else if (roll >= 9 && roll < 11) {
                encounterMobs[i] = Entity.buildShaman();
            }
            else {
                throw new IllegalArgumentException("Encounter mob builder received invalid mob type roll");
            }
        }
        Entity[] encounterAll = new Entity[6]; //placing player in entity array w/ mobs
        encounterAll[0] = player;
        System.arraycopy(encounterMobs, 0, encounterAll, 1, encounterMobs.length);
        //establish initiative for player and mobs.
        player.initiative = diceRoll(1, 20) + player.initBuff;
        System.out.println("You rolled " + player.initiative + " for initiative!");
        for (Mob mob : encounterMobs){
            mob.initiative = diceRoll(1, 20);
        }
        //Ordering entities in array by initiative to establish turn order.
        for (int i = 1; i < encounterAll.length; i++){
            Entity key = encounterAll[i];
            int j = i - 1;
            while (j >= 0 && encounterAll[j].initiative < key.initiative){
                encounterAll[j+1] = encounterAll[j];
                j--;
            }
            encounterAll[j+1] = key;

        }
        int turn = -2;
        boolean allMobsDead = false;
        while(true){ // encounter combat turns loop
            turn++;
            for (Mob mob : encounterMobs){
                allMobsDead = true;
                if (!mob.classType.equals("dead")){
                    allMobsDead = false;
                    break;
                }
            }
            if (allMobsDead){
                System.out.println("You are victorious over your slain enemies!");
                return true; //all mobs are dead, player has won the encounter
            }
            mobCount = 0;
            for (Mob mob : encounterMobs){
                if (!mob.classType.equals("dead")){
                    mobCount ++;
                }
            }
            if (turn >= encounterAll.length - 1 || turn == -1){
                turn = 0;
            }
            if (encounterAll[turn] instanceof PlayerCharacter){
                while(true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.err.println("Slept thread was interrupted");
                    }
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
                            int input = inputValidation(encounterMobs.length) - 1;
                            if (encounterMobs[input].classType.equals("dead")){
                                System.out.println("There's nothing there for you to attack!");
                                continue;
                            }
                            else {
                                player.basicAttack(encounterMobs[input]);
                            }
                            break;
                        }
                        case "2": {
                            if (player.classType.equals("warrior")) {
                                System.out.println(player.playerName + " your special warrior ability is SMASH. SMASH deals 4d" + player.atkStr + " damage and costs 5 mana");
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    System.err.println("Slept thread was interrupted");
                                }
                            }
                            else if (player.classType.equals("rogue")){
                                System.out.println(player.playerName + " your special rogue ability is SNEAK ATTACK. SNEAK ATTACK does damage based on your initiative and costs 5 mana. \nThis encounter it does 2d" + (player.initiative / 2) + " damage.");
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    System.err.println("Slept thread was interrupted");
                                }
                            }
                            else if (player.classType.equals("mage")){
                                System.out.println(player.playerName + " your special mage ability is FIREBALL. FIREBALL does 2d8 damage and costs 5 mana.");
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    System.err.println("Slept thread was interrupted");
                                }
                            }
                            if (player.mana < 5){
                                System.out.println("You don't have enough mana, maybe try using a potion?");
                                System.out.println();
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    System.err.println("Slept thread was interrupted");
                                }
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
                            int input = inputValidation(5) - 1;
                            if (input < encounterMobs.length){
                                if (encounterMobs[input].classType.equals("dead")){
                                    System.out.println("There's nothing there for you to attack!");
                                    continue;
                                }
                                switch (player.classType) {
                                    case "warrior":
                                        player.smash(encounterMobs[input]);
                                        break;
                                    case "mage":
                                        player.fireball(encounterMobs[input]);
                                        break;
                                    case "rogue":
                                        player.sneakAttack(encounterMobs[input]);
                                        break;
                                    default:
                                        throw new IllegalArgumentException("Unexpected player.classType in encounter special attack line 214");
                                }
                            }
                            else{
                                continue;
                            }
                            break;
                        }
                        case "3": {
                            System.out.println("Using an inventory item does NOT end your turn.");
                            player.accessInventory();
                            continue;
                        }
                    }//End switch case
                    break;
                }//End player interaction loop
            }//End player turn options
            //Mob combat logic
            else if (encounterAll[turn] instanceof Mob){
                /*
                Mobs will attack player until death.
                Shaman will check to see if any allies are below half health and attempt to heal them or else attack player.
                 */
                switch(encounterAll[turn].classType){
                    case "dead": {
                        continue;
                    }
                    case "grunt":
                    case "brute": {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            System.err.println("Slept thread was interrupted");
                        }
                        encounterAll[turn].basicAttack(player);
                        continue;
                    }
                    case "shaman": {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            System.err.println("Slept thread was interrupted");
                        }
                        for (Mob mob : encounterMobs) {
                            if (mob != encounterAll[turn]) { //this logic is very stupid and it might behoove me to sort for which ally has the LOWEST HP if time allows.
                                if (mob.hp < mob.maxHP / 2 && encounterAll[turn].mana >= 5 && !mob.classType.equals("dead")) {
                                    encounterAll[turn].healAlly(mob);
                                    continue;
                                }
                            }
                        }
                        encounterAll[turn].basicAttack(player);
                        continue;
                    }
                    default:
                        throw new IllegalArgumentException("Unexpected mob.classType in encounter combat logic line 244");

                }
            }
        }//End encounter combat loop
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