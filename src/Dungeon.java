// potentially re-include these so the game can be seen and played in a standalone window akin to StarsAndStripes
// otherwise the game currently will be played in the console itself

/*
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.sql.Array;
import java.lang.reflect.Array;*/

public class Dungeon {

    public static Room currentRoom;
    public static int currentX = 0;
    public static int currentY = 0;
    public static int[] pastXValues = new int[16];
    public static int[] pastYValues = new int[16];
    public static int i = 0;
//    public boolean roomWasVisited;

    public static boolean roomDescription() {
        if (currentX == 0 && currentY == 0) {
            System.out.print("A hermit outside the dungeon greets you with a proposition.\n\"These dungeons are littered with treasure!\" he exclaims.\n");
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("But, there is a caveat... the stability of its walls have deteriorated for far too long and the risk of it falling upon whomever enters is high...");
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("You enter the dark dungeon from the west, with torch in hand. Your adventure begins...");
            return true;
        }
        if (currentX == 1 && currentY == 0) {
            System.out.print("You step into the first room, noticing three doorways - one in each direction to the North, East and South, or you can return West to the start.");
            return true;
        }
        if (currentX == 1 && currentY == -1) {
            System.out.print("Mysterious yells can be heard from another part of the dungeon...");
            return true;
        }
        if (currentX == 1 && currentY == 1) {
            System.out.print("As you enter the room, several bats shriek as they fly past you...");
            return true;
        }
        if (currentX == 1 && currentY == 2) {
            System.out.println("A strange regality adorns this room with limestone walls...");
            return true;
        }
        if (currentX == 2 && currentY == 2) {
            System.out.println("The tiles in this room show signs of wear...");
            return true;
        }
        if (currentX == 2 && currentY == 1) {
            System.out.println("There's an ominous shrine standing at the far end of the room.");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("An unknown force beckons you towards it...");
            return true;
        }
        if (currentX == 2 && currentY == 0) {
            System.out.println("A seemingly endless abyss lies underneath the rope bridge adjoining the room before you to the one ahead...");
            return true;
        }
        if (currentX == 2 && currentY == -1) {
            System.out.println("A mysterious hum emanates from the southern doorway.");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("There's a crackling sound akin to that of a portal...");
            return true;
        }
        if (currentX == 3 && currentY == 2) {
            System.out.println("The northern doorway hums eerily.");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("There's a crackling sound akin to that of a portal...");
            return true;
        }
        if (currentX == 3 && currentY == 1) {
            System.out.println("Candles have been set up around some sort of magic circle on the ground.");
            return true;
        }
        if (currentX == 3 && currentY == 0) {
            System.out.println("");
            return true;
        }
        return false;
    }

    public static String movePlayer() throws GameOverException {
        boolean interactPossible = true;
//        int[] pastXValues = new int[16];
//        int[] pastYValues = new int[16];
//        pastXValues[0] = 0;
//        pastYValues[0] = 0;
//        int i = 1;

        Dungeon.roomDescription();

        System.out.println("\nWhere would you like to go from here? :");
        if ((currentX == 1 && currentY == 0) || (currentX == 1 && currentY == -1) || (currentX == 1 && currentY == 1)
                || (currentX == 3 && currentY == 2) || (currentX == 3 && currentY == 1) || (currentX == 3 && currentY == -1) || (currentX == 4 && currentY == 0)) {
            System.out.print(" North (n)");
        }

        if ((currentX == 0 && currentY == 0) || (currentX == 1 && currentY == 2) || (currentX == 1 && currentY == 1) || (currentX == 1 && currentY == 0) || (currentX == 1 && currentY == -1) || (currentX == 2 && currentY == 2) || (currentX == 2 && currentY == 0) || (currentX == 3 && currentY == 2) || (currentX == 3 && currentY == 1)) {
            System.out.print(" East (e)");
        }
        if ((currentX == 1 && currentY == 2) || (currentX == 1 && currentY == 1) || (currentX == 1 && currentY == 0) || (currentX == 2 && currentY == -1) || (currentX == 3 && currentY == 2) || (currentX == 3 && currentY == 0) || (currentX == 4 && currentY == 1) || (currentX == 4 && currentY == 0)) {
            System.out.print(" South (s)");

        }
        if ((currentX == 0 && currentY == 0) || (currentX == 1 && currentY == 0) || (currentX == 2 && currentY == 2) || (currentX == 2 && currentY == 1) ||
                (currentX == 2 && currentY == 0) || (currentX == 2 && currentY == -1) || (currentX == 3 && currentY == 2) || (currentX == 3 && currentY == 0) ||
                (currentX == 4 && currentY == 2)) {
            System.out.print(" West (w)");
        }

            if ((currentX == 1 && currentY == -1) || (currentX == 1 && currentY == -1) || (currentX == 1 && currentY == -1)) {
                System.out.print(" Use (u)");
            }

            System.out.print(" ? ");


            String error = "Invalid input.";

            while (true) {
                switch (Game.userInput.nextLine()) {
                    case "n": {
                        pastXValues[i] = currentX;
                        pastYValues[i] = currentY;
                        currentY++;
//                        pastXValues[i] = currentX;
//                        pastYValues[i] = currentY;
//                        i++;
                        if (roomWasVisited(pastXValues, pastYValues, currentX, currentY) == false) {
                            int chancer = Game.diceRoll(1,2);
                            if (chancer == 1) {
                                break;
                            }
                            if (chancer == 2) {
                                Game.encounter(Game.player, Game.gameStage);
//                                System.out.println("You would be playing the game."); (for debugging purposes)
                            }
                        }
                        // preventing user from going off the map
                        if (currentY == 3 && (currentX == 1 || currentX == 4)) {
                            currentY = 2;
                            System.out.println(error);
                            break;
                        }
                        // letting user pass through a portal
                        if (currentX == 3 && currentY == 3) {
                            currentX = 2;
                            currentY = -1;
                            System.out.print("\nThe portal spits you out in another part of the dungeon!");
                        }
                        break;
                    }

                    case "s": {
                        pastXValues[i] = currentX;
                        pastYValues[i] = currentY;
                        currentY--;
//                        pastXValues[i] = currentX;
//                        pastYValues[i] = currentY;
//                        i++;
                        if (roomWasVisited(pastXValues, pastYValues, currentX, currentY) == false) {
                            int chancer = Game.diceRoll(1,2);
                            if (chancer == 1) {
                                break;
                            }
                            if (chancer == 2) {
                                Game.encounter(Game.player, Game.gameStage);
//                                System.out.println("You would be playing the game.");
                            }
                        }
                        // preventing user from going off the map
                        if (currentY == -2 && (currentX == 3 || currentX == 4)) {
                            currentY = -1;
                            System.out.println(error);
                            break;
                        }
                        // letting user pass through a portal
                        if (currentX == 2 && currentY == -2) {
                            currentX = 3;
                            currentY = 2;
                            System.out.print("\nThe portal spits you out in another part of the dungeon!");
                        }
                        break;
                    }

                    case "e": {
                        pastXValues[i] = currentX;
                        pastYValues[i] = currentY;
                        currentX++;
//                        pastXValues[i] = currentX;
//                        pastYValues[i] = currentY;
//                        i++;
                        if (roomWasVisited(pastXValues, pastYValues, currentX, currentY) == false) {
                            int chancer = Game.diceRoll(1,2);
                            if (chancer == 1) {
                                break;
                            }
                            if (chancer == 2) {
                                Game.encounter(Game.player, Game.gameStage);
//                                System.out.println("You would be playing the game."); (for debugging purposes)
                            }
                        }
                        // preventing user from going off the map
                        if (currentX == 5 && (currentY == 1 || currentY == 0 || currentY == -1)) {
                            currentX = 4;
                            System.out.println(error);
                            break;
                        }
                        break;
                    }
                    case "w": {
                        pastXValues[i] = currentX;
                        pastYValues[i] = currentY;
                        currentX--;
//                        pastXValues[i] = currentX;
//                        pastYValues[i] = currentY;
//                        i++;
                        if (roomWasVisited(pastXValues, pastYValues, currentX, currentY) == false) {
                            int chancer = Game.diceRoll(1,2);
                            if (chancer == 1) {
                                break;
                            }
                            if (chancer == 2) {
                                Game.encounter(Game.player, Game.gameStage);
//                                System.out.println("You would be playing the game."); (for debugging purposes)
                            }
                        }
                        // preventing user from going off the map
                        if (currentX == 0 && (currentY == 2 || currentY == 1 || currentY == -1)) {
                            currentX = 1;
                            System.out.println(error);
                            break;
                        }
                        break;
                    }

                    case "u": {
                        if (currentX == 2 && currentY == 1) {
                            //shrine interaction
                        } else {
                            //chest interaction
                        }
                    }
                    default: {
                        System.out.println(error);
                    }

                }
                i++;
                movePlayer();

            }

    }

    public static boolean roomWasVisited(int[] xValues, int[] yValues, int playersX, int playersY) {
        for (int i = 0; i < xValues.length; i++) {
            if (xValues[i] != playersX && yValues[i] != playersY) {
                continue;
            }
            else if (xValues[i] == playersX && yValues[i] == playersY){
//                while (Dungeon.i == 1) {
//                    if (xValues[1] == 1 && yValues[1] == 0) {
//                        return false;
//                    }
//                }
                return true;
            }
        }
        return false;
    }
}







    /* static String nextLine = System.getProperty("line.separator");

    public static void initializeMapDesigns() {
        //separation is intentional for visual clarity

        Font plainFont = new Font("Times New Roman", Font.PLAIN, 24);

        String design1 = "*******";
        String design1Single = "*";
        String design1HorizontalDoor = "***" + "O" + "***";
        String design1Character = "***" + "C" + "***";

        String design2 = ".......";
        String design2Single = ".";
        String design2HorizontalDoor = "..." + "O" + "...";
        String design2Character = "..." + "C" + "...";

        String design3 = "=======";
        String design3Single = "=";
        String design3HorizontalDoor = "===" + "O" + "===";
        String design3Character = "===" + "C" + "===";

        String designChest = "m";

        //map8 has a shrine
        String designShrine = "S";

        AttributedString aa = new AttributedString(designChest);
        aa.addAttribute(TextAttribute.FONT, plainFont);
        aa.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON, 1,
                15);
        AttributedString ab = new AttributedString(designShrine);
        ab.addAttribute(TextAttribute.FONT, plainFont);
        ab.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON, 1,
                15);

        String mapStart = new String();
        String map2 = new String();
        String map3 = new String();
        String map4 = new String();
        String map5 = new String();
        String map6 = new String();
        String map7 = new String();
        String map8 = new String();
        String map9 = new String();
        String map10 = new String();
        String map11 = new String();
        String map12 = new String();
        String map13 = new String();
        String map14 = new String();
        String map15 = new String();
        String map16 = new String();
        String map17 = new String();

            mapStart    = design1Single + design1 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design2Character + "O"
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design1 + design1Single;

            map2 = design1Single + design1HorizontalDoor + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    +"O" + design2Character +"O"
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design3Single + design3HorizontalDoor + design3Single;

            map3 = design1Single + design1HorizontalDoor + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design2Character + "O"
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design1HorizontalDoor + design1Single;

            map4 = design1Single + design1 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design2Character + "O"
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design1HorizontalDoor + design1Single;

            map5 = design1Single + design1HorizontalDoor + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + "O" + design2Character + "O"
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design1 + design1Single;

            map6 = design1Single + design1HorizontalDoor + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + "O" + design2Character + "O"
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design3Single + design3HorizontalDoor + design3Single;

            map7 = design1Single + design1 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + "O" + design2Character + "O"
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design3Single + design3 + design3Single;

            map8 = design1Single + design1 + design1Single
                    + nextLine
                    + design1Single + design2Single + design2Single + design2Single + designShrine + design2Single + design1Single
                    + nextLine
                    + "O" + design2Character + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design3Single + design3 + design3Single;

            map9 = design1Single + design1HorizontalDoor + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design2 + "O"
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design3Single + design3 + design3Single;

            map10 = design1Single + design1 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + "O" + design2Character + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design3Single + design3HorizontalDoor + design3Single;

            map11 = design1Single + design1 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + "O" + design2Character + "O"
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design3Single + design3 + design3Single;

            map12 = design1Single + design1 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + "O" + design2Character + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design3Single + design3HorizontalDoor + design3Single;

            map13 = design1Single + design1HorizontalDoor + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design2Character + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design3Single + design3HorizontalDoor + design3Single;

            map14 = design1Single + design1HorizontalDoor + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design2Character + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design3Single + design3HorizontalDoor + design3Single;

            map15 = design1Single + design1 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + "O" + design2Character + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design3Single + design3HorizontalDoor + design3Single;

            map16 = design1Single + design1HorizontalDoor + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design2Character + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design3Single + design3 + design3Single;

            map17 = design1Single + design1HorizontalDoor + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design2Character + "O"
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design3Single + design3 + design3Single;

        }
    }

    // figuring out user entry + how to integrate it alongside maps
    // or should this be done in Game.java?
    //Maybe create a method that can be called based on input from Game? - Zac
    public static boolean canMove(int[] maps) {
        boolean moveOkay = false;
        String input = Game.userInput.nextLine();
        //int x = (int) Array.get(maps, Integer.parseInt(i));

        switch (input) {
            case "right" : {
                System.out.println("arbitrary");
                for (int i = 0; i < maps.length; i++) {
                    if (i < maps.length - 1 && maps[i] == 1 || maps[i] == 3) {
                        moveOkay = true;
                        break;
                    }
                }
            }
            case "up" : {
                System.out.println("arbitrary");
                for (int i = 0; i < maps.length; i++) {
                    if (i < maps.length - 1 && maps[i] == 1 || maps[i] == 3) {
                        moveOkay = true;
                        break;
                    }
                }
            }
            case "left" : {
                System.out.println("arbitrary");
                for (int i = 0; i < maps.length; i++) {
                    if (i < maps.length - 1 && maps[i] == 1 || maps[i] == 3) {
                        moveOkay = true;
                        break;
                    }
                }
            }
            case "down" : {
                System.out.println("arbitrary");
                for (int i = 0; i < maps.length; i++) {
                    if (i < maps.length - 1 && maps[i] == 1 || maps[i] == 3) {
                        moveOkay = true;
                        break;
                    }
                }
            }

        }
        return moveOkay;

    }
    // Preparing for potential "if I'm on X map, these are my options"
    // nothing to see here x)
    public static boolean move(int[] characterPosition) {
        boolean flag = false;
        int testVar = 0;

        if (characterPosition[0] == 0) {
            flag = true;
        }
        else if (testVar == 2) {
            flag = true;
        }
        else if (testVar == 3) {
            flag = true;
        }
        else if (testVar == 4) {
            flag = true;
        }
        else if (testVar == 5) {
            flag = true;
        }
        else if (testVar == 6) {
            flag = true;
        }
        else if (testVar == 7) {
            flag = true;
        }
        else if (testVar == 8) {
            flag = true;
        }
        else {
            return false;
        }
        return false;
    }


    public static String promptUserEntry(Scanner s, String prompt, String max) {
        String input = "";
        int flag;

        String error = "That is not a valid input, please try again.";

        while (true) {
            System.out.print(prompt);
            String temp = s.nextLine();

            if ((temp.equals("right"))) {
                break;
            } else if ((temp.equals("up"))) {
                break;
            } else if ((temp.equals("left"))) {
                break;
            } else if ((temp.equals("down"))) {
                break;
            } else if ((temp.equals("use"))) {
                break;
            } else {
                System.out.print(error);
            }
        }
        return input;*/
