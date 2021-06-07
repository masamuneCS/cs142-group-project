import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.*;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class Game {

    protected static Logger logger = Logger.getLogger(Game.class.getName());

    public static Scanner userInput = new Scanner(System.in);
    protected static boolean encounterActive = false;
    protected static Mob[] encounterMobs = new Mob[] {Entity.buildDead(), Entity.buildDead(), Entity.buildDead(), Entity.buildDead(), Entity.buildDead()};

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 21; i++) {
            MiniGame.blackJack();
        }

        System.out.println("Dungeon Crawler production v0_2*");
        logger.setLevel(Level.INFO);
        //logger.setUseParentHandlers(false);
        FileHandler handler = new FileHandler("game.log", true);
        //ConsoleHandler consoleHandler = new ConsoleHandler();
        SimpleFormatter logFormatter = new SimpleFormatter();
        //consoleHandler.setLevel(Level.SEVERE);
        logger.addHandler(handler);
        //logger.addHandler(consoleHandler);
        handler.setFormatter(logFormatter);

        int gameStage = 0;
        while(true) { //Main game loop
            try { //KEEP ALL GAME CODE INSIDE THE TRY BLOCK PLEASE AND THANK YOU
                Dungeon dungeon0 = new Dungeon();
                Item.genLootTable();
                Player player;
                System.out.println("What kind of hero are you? Type a number and press enter.\n" +
                        "1: Warrior. Can take a lot of hits.\n" +
                        "2: Rogue. Everything balanced, as it should be.\n" +
                        "3: Mage. Hits very hard, is made of glass.");
                while(true) { //input validation loop
                    switch (inputValidation(3)) {
                        case 1 : {
                            System.out.println("What should I call you, warrior? Type a name and press enter.");
                            String name = userInput.nextLine();
                            player = Player.buildWarrior(name);
                            logger.info(player + " created with classType " + player.classType);
                            break;
                        }
                        case 2 : {
                            System.out.println("What should I call you, rogue?");
                            String name = userInput.nextLine();
                            player = Player.buildRogue(name);
                            logger.info(player + " created with classType " + player.classType);
                            break;
                        }
                        case 3 : {
                            System.out.println("What should I call you, mage?");
                            String name = userInput.nextLine();
                            player = Player.buildMage(name);
                            logger.info(player + " created with classType " + player.classType);
                            break;
                        }
                        default : {
                            System.out.println("Enter 1,2, or 3 to choose.");
                            continue;
                        }
                    }
                    break; //breaks loop
                }//End input validation loop for character creation switch
                while(true){ //Dungeon exploration loop
                    Room currentRoom = dungeon0.getCurrentRoom();
                    logger.info("Player entered " + currentRoom + " at coordinate " + currentRoom.getRoomCoordinate().toString());
                    if (currentRoom.getRoomCoordinate().equals(Dungeon.victoryCoord)){
                        System.out.println("There are monsters here, but you feel a breeze. You may be close to escape!");
                        encounter(player, gameStage);
                        System.out.println("There is sunlight streaming in from the far door, you've made it!");
                        victory(player);
                    }
                    if (currentRoom.getRoomCoordinate().equals(Dungeon.startCoord) && !currentRoom.isRoomSeen()){
                        currentRoom.setRoomSeen(true);
                        System.out.println("You step into the dark dungeon from the west, with torch in hand. Your adventure begins.");
                        System.out.println("A tumbling crash roars behind you, the entrance to the dungeon has caved in. You must find a new way out.");
                    }
                    //shrine case
                    if (currentRoom.isContainsShrine()){
                        System.out.println("There's an ominous shrine standing at the far end of the room.\nAn unknown force beckons you towards it...");
                        if (!currentRoom.isRoomSeen()){
                            boolean wonMiniGame = MiniGame.triviaGame();
                            if (wonMiniGame){
                                System.out.println("The shrine restores you.");
                                player.heal(player.maxHP);
                                player.changeMana(player.maxMana);
                                System.out.println("You have " + player.getHp() + " HP and " + player.getMana() + " mana.");
                            }
                        }
                        else{
                            System.out.println("Do you approach the shrine?\n1: Yes  2:No");
                            int input = inputValidation(2);
                            if (input == 1){
                                boolean wonMiniGame = MiniGame.triviaGame();
                                if (wonMiniGame){
                                    System.out.println("The shrine restores you.");
                                    player.heal(player.maxHP);
                                    player.changeMana(player.maxMana);
                                    System.out.println("You have " + player.getHp() + " HP and " + player.getMana() + " mana.");
                                }
                            }
                            else{
                                System.out.println("You back away from the shrine.");
                            }
                        }
                    }//End Shrine case
                    System.out.println(currentRoom.getDescription());
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //encounter case
                    if (!currentRoom.isRoomSeen()){
                        int encounterChanceRoll = diceRoll(1,20);
                        if (encounterChanceRoll < 11){
                            logger.info("Encounter rolled combat");
                            System.out.println("Monsters crawl forth from the shadows to attack!");
                            if (encounter(player, gameStage)){
                                System.out.println("You've defeated the monsters! Perhaps they carried something valuable?");
                                player.alterInventory(Item.getLootDrop());
                            }
                        }//End encounter combat case
                        else if (encounterChanceRoll >= 11 && encounterChanceRoll < 16){
                            boolean wonMiniGame;
                            System.out.println("A strange sound is quickly growing closer! Is that... the theme of a game show?");
                            if (encounterChanceRoll == 11 || encounterChanceRoll == 12){
                                logger.info("Encounter rolled blackjack");
                                wonMiniGame = MiniGame.blackJack();

                            }
                            else if(encounterChanceRoll == 13 || encounterChanceRoll == 14){
                                logger.info("Encounter rolled priceIsRight");
                                wonMiniGame = MiniGame.priceIsRightGame();
                            }
                            else{
                                logger.info("Encounter rolled trivia");
                                wonMiniGame = MiniGame.triviaGame();
                            }
                            if (wonMiniGame){
                                System.out.println("Steve Harvey has left you a gift!");
                                player.alterInventory(Item.getLootDrop());
                            }
                            else{
                                System.out.println("You have disappointed Steve Harvey. Perhaps if you'd done better he may have left you a boon.");
                            }
                        }//End MiniGame case
                    }//End encounter chance case
                    //chest case
                    if (currentRoom.isContainsChest()){
                        System.out.println("There is a strange chest in the center of the room, do you open it?\n1: Yes\n2: No");
                        if (inputValidation(2) == 1){
                            openChest(player);
                            currentRoom.setContainsChest(false);
                        }
                    }
                    currentRoom.setRoomSeen(true);
                    while(true){
                        int choiceCeiling = 2;
                        System.out.println("It seems safe enough here, what would you like to do?\n1. Move on\n2. Open inventory");
                        if (currentRoom.isContainsChest()){
                            System.out.println("3. Open the chest");
                            choiceCeiling = 3;
                        }
                        switch(inputValidation(choiceCeiling)){
                            case 1:{
                                dungeon0.movePlayer();
                                break;
                            }
                            case 2:{
                                player.accessInventory();
                                continue;
                            }
                            case 3:{
                                if (currentRoom.isContainsChest()){
                                    openChest(player);
                                    currentRoom.setContainsChest(false);
                                    continue;
                                }
                            }
                            default:
                                continue;
                        }
                        break;
                    }

                }//End exploration loop

            }
            catch (GameOverException exception) { //either closes program or restarts game based on player choice in GameOverException.
                if (exception.playAgain){
                    continue;
                }
                System.out.println("Thanks for playing!");
                break;
            }
        }//game loop end
    }

    /**
     * the player lost, the end of the game.
     * @param player the player character
     * @throws GameOverException end the game
     */
    public static void gameOver (Player player) throws GameOverException {
        System.out.println(player.playerName + " died. How sad.\nG A M E  O V E R");
        System.out.println("Do you want to play again Y/n?");
        boolean playAgain;
        if ("Y".equals(userInput.nextLine().toUpperCase(Locale.ROOT))) {
            playAgain = true;
        }
        else{
            playAgain = false;
        }
        throw new GameOverException(playAgain);

    }

    public static void victory (Player player) throws GameOverException {
        System.out.println(player.playerName + " escaped the dungeon and only got injured a little bit, good job!\nWould you like to play again? [y/N]");
        boolean playAgain;
        if ("Y".equals(userInput.nextLine().toUpperCase(Locale.ROOT))) {
            playAgain = true;
        }
        else{
            playAgain = false;
        }
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
                userInput.nextLine();
                System.out.println("Enter a number between 1 and " + ceiling + " to choose.");
            }
        }
    }

    private static void openChest(Player player) {
        int chestRoll = diceRoll(1,10);
        boolean wonMiniGame = false;
        if (chestRoll < 8){
            player.alterInventory(Item.getLootDrop());
            return;
        }
        else if (chestRoll == 8){
            wonMiniGame = MiniGame.blackJack();
        }
        else if (chestRoll >= 9){
            wonMiniGame = MiniGame.triviaGame();
        }
        if (wonMiniGame){
            System.out.println("Steve Harvey has left you a gift!");
            player.alterInventory(Item.getLootDrop());
        }
        else{
            System.out.println("You have disappointed Steve Harvey. Perhaps if you'd done better he may have left you a boon.");
        }
    }

    public static boolean encounter(Player player, int gameStage) throws GameOverException, IllegalArgumentException {
        int mobCount = diceRoll(1, 3);
        encounterActive = true;

        for (int i = 0; i < mobCount; i++){
            int roll = diceRoll(1, 10); //picking mobType based on int 1-10
            if (roll >= 1 && roll < 6) {
                encounterMobs[i] = Entity.buildGrunt();
                logger.info("Created " + encounterMobs[i] + " with class " + encounterMobs[i].classType);
            }
            else if (roll >= 6 && roll < 9) {
                encounterMobs[i] = Entity.buildBrute();
                logger.info("Created " + encounterMobs[i] + " with class " + encounterMobs[i].classType);
            }
            else if (roll >= 9 && roll < 11) {
                encounterMobs[i] = Entity.buildShaman();
                logger.info("Created " + encounterMobs[i] + " with class " + encounterMobs[i].classType);
            }
            else {
                throw new IllegalArgumentException("Encounter mob builder received invalid mob type roll");
            }
        }
        Entity[] encounterAll = new Entity[6]; //placing player in entity array w/ mobs
        encounterAll[0] = player;
        System.arraycopy(encounterMobs, 0, encounterAll, 1, encounterMobs.length);
        //establish initiative for player and mobs.
        player.setInitiative(diceRoll(1, 20) + player.initBuff);
        System.out.println("You rolled " + player.getInitiative() + " for initiative!");
        for (Mob mob : encounterMobs){
            mob.setInitiative(diceRoll(1, 20) + mob.initBuff);
            logger.info(mob + " initiative roll: " + mob.getInitiative());
        }

        //Ordering entities in array by initiative to establish turn order.
        logger.info("encounterAll before sort: " + Arrays.toString(encounterAll));
        for (int i = 1; i < encounterAll.length; i++){
            Entity key = encounterAll[i];
            int j = i - 1;
            while (j >= 0 && encounterAll[j].getInitiative() < key.getInitiative()){
                encounterAll[j+1] = encounterAll[j];
                j--;
            }
            encounterAll[j+1] = key;

        }
        logger.info("encounterAll after sort: " + Arrays.toString(encounterAll));

        int turn = -2;
        while(true){ // encounter combat turns loop
            turn++;
            logger.info("Turn: " + turn);
            if (isAllMobsDead()){
                logger.info("All mobs show dead");
                System.out.println("You are victorious over your slain enemies!");
                encounterActive = false;
                player.resetResist();
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
                logger.info("Turn reset to 0" );
            }
            if (encounterAll[turn] instanceof Player){
                logger.info(turn + " is player");
                while(true){
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        System.err.println("Slept thread was interrupted");
                    }
                    if (mobCount > 1){
                        System.out.println("There are " + mobCount + " enemies before you!");
                    }
                    else{
                        System.out.println("There is " + mobCount + " enemy before you!");
                    }
                    System.out.println("HP: " + player.getHp() + " Mana: " + player.getMana());
                    System.out.println("What would you like to do?\n1: Attack\n2: Special Attack\n3: Use an item from your inventory");
                    switch(inputValidation(3)){
                        case 1: {
                            System.out.println("Your basic attack deals " + player.atkSize + "d" + player.atkStr + "damage, which enemy would you like to target?");
                            int i = 1;
                            for (Mob mob : encounterMobs) {
                                if (!mob.classType.equals("dead"))
                                    System.out.println(i + ": A " + mob.classType + " with " + mob.getHp() + "HP");
                                i++;
                            }
                            System.out.println("or choose 5 to go back.");
                            System.out.print("Choose: ");
                            int input = inputValidation(encounterMobs.length) - 1;
                            if (input == 4){
                                continue;
                            }
                            if (encounterMobs[input].classType.equals("dead")){
                                System.out.println("There's nothing there for you to attack!");
                                continue;
                            }
                            else {
                                player.basicAttack(encounterMobs[input]);
                            }
                            break;
                        }
                        case 2: {
                            switch (player.classType) {
                                case "warrior":
                                    System.out.println(player.playerName + " your special warrior ability is SMASH. SMASH deals 4d" + player.atkStr + " damage and costs 5 mana");
                                    try {
                                        sleep(500);
                                    } catch (InterruptedException e) {
                                        System.err.println("Slept thread was interrupted");
                                    }
                                    break;
                                case "rogue":
                                    System.out.println(player.playerName + " your special rogue ability is SNEAK ATTACK. SNEAK ATTACK does damage based on your initiative and costs 5 mana. \nThis encounter it does 2d" + (player.getInitiative() / 2) + " damage.");
                                    try {
                                        sleep(500);
                                    } catch (InterruptedException e) {
                                        System.err.println("Slept thread was interrupted");
                                    }
                                    break;
                                case "mage":
                                    System.out.println(player.playerName + " your special mage ability is FIREBALL. FIREBALL does 2d8 damage and costs 5 mana.");
                                    try {
                                        sleep(500);
                                    } catch (InterruptedException e) {
                                        System.err.println("Slept thread was interrupted");
                                    }
                                    break;
                            }
                            if (player.getMana() < 5){
                                System.out.println("You don't have enough mana, maybe try using a potion?");
                                System.out.println();
                                try {
                                    sleep(500);
                                } catch (InterruptedException e) {
                                    System.err.println("Slept thread was interrupted");
                                }
                                continue;
                            }
                            System.out.println("Which enemy would you like to attack?\n or press " + encounterMobs.length + " to go back.");
                            int i = 1;
                            for (Mob mob : encounterMobs) {
                                if (!mob.classType.equals("dead"))
                                    System.out.println(i + ": A " + mob.classType + " with " + mob.getHp() + "HP");
                                i++;
                            }
                            System.out.println(encounterMobs.length + ": Go back");
                            int input = inputValidation(5) - 1;
                            if (input == 4){
                                continue;
                            }
                            if (input < 5){
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
                        case 3: {
                            System.out.println("Using an inventory item does NOT end your turn.");
                            player.accessInventory();
                            if (isAllMobsDead()){
                                System.out.println("You are victorious over your slain enemies!");
                                encounterActive = false;
                                return true; //all mobs are dead, player has won the encounter
                            }
                            continue;
                        }
                        default:{
                            continue;
                        }
                    }//End switch case
                    break;
                }//End player interaction loop
            }//End player turn options
            //Mob combat logic
            else if (encounterAll[turn] instanceof Mob){
                logger.info(turn + " is " + encounterAll[turn].getClass() + " " + encounterAll[turn]);
                /*
                Mobs will attack player until death.
                Shaman will check to see if any allies are below half health and attempt to heal them or else attack player.
                 */
                switch(encounterAll[turn].classType){
                    case "dead": {
                        logger.info(encounterAll[turn] + " is dead" );
                        continue;
                    }
                    case "grunt":
                    case "brute": {
                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            System.err.println("Slept thread was interrupted");
                        }
                        encounterAll[turn].basicAttack(player);
                        continue;
                    }
                    case "shaman": {
                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            System.err.println("Slept thread was interrupted");
                        }
                        for (Mob mob : encounterMobs) {
                            if (mob != encounterAll[turn]) { //this logic is very stupid and it might behoove me to sort for which ally has the LOWEST HP if time allows.
                                if (mob.getHp() < mob.maxHP / 2 && encounterAll[turn].getMana() >= 5 && !mob.classType.equals("dead")) {
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

    private static boolean isAllMobsDead() {
        boolean allMobsDead = true;
        for (Mob mob : encounterMobs){
            if (!mob.classType.equals("dead")){
                allMobsDead = false;
                break;
            }
        }
        return allMobsDead;
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