// potentially re-include these so the game can be seen and played in a standalone window akin to StarsAndStripes
// otherwise the game currently will be played in the console itself

/*
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.sql.Array;
import java.lang.reflect.Array;*/

import java.util.HashMap;
import java.util.Map;

public class Dungeon {

    private String description;
    private final Map<Integer, Map<Integer, Room>> map = new HashMap<Integer, Map<Integer, Room>>();
    //protected Map<Pair, Room> map2 = new HashMap<Pair, Room>(); <== Just an FYI, you could use a Pair for XY instead of two ints.
    public Room currentRoom;
    private int currentX = 0;
    private int currentY = 0;

    private Room getRoom(int x, int y) {
        return map.get(x).get(y);
    }

    public void putRoom(int x, int y) {
        if (!map.containsKey(x)) {
            map.put(x, new HashMap<Integer, Room>());
        }
        map.get(x).put(y, currentRoom);
    }

    private boolean roomExists(int x, int y) {
        if (!map.containsKey(x)) {
            return false;
        }
        return map.get(x).containsKey(y);
    }

    /*public boolean interactable(int x, int y) {
        if (currentRoom(2,1) || currentRoom(3,-1) || currentRoom(4,-1)) {
            return true;
        }
        return false;
    }*/

    public Room currentRoom(int x, int y) {
        Room currentRoom = (getRoom(currentX, currentY));
        return currentRoom;
    }

    public String roomDescription() {
        if (currentX == 0 && currentY == 0) {
            System.out.print("You step into the dark dungeon from the west, with torch in hand. Your adventure begins.");
        }
        if (currentX == 1 && currentY == 0) {
            System.out.print("You step into the first room, noticing three doorways - one in each direction to the North, East and South, or you can return West to the start.");
            //System.out.println("A slight chill grips the air.");
        }
        if (currentX == 1 && currentY == -1) {
            System.out.print("Mysterious yells can be heard from another part of the dungeon...");
        }
        if (currentX == 1 && currentY == 1) {
            System.out.print("As you enter the room, several bats shriek as they fly past you...");
            //System.out.println("There are doorways to the north, east, and south.");
        }
        if (currentX == 1 && currentY == 2) {
            System.out.println("A strange regality adorns this room with limestone walls...");
            //System.out.println("There are doorways to the east, and south.");
        }
        if (currentX == 2 && currentY == 2) {
            System.out.println("The tiles in this room show signs of wear...");
            //System.out.println("There are doorways to the east, north, and west.");
        }
        if (currentX == 2 && currentY == -1) {
            System.out.println("There's an ominous shrine standing at the far end of the room.");
            System.out.println("An unknown force beckons you towards it...");
        }
        if (currentX == 2 && currentY == 0) {
            System.out.println("A seemingly endless abyss lies underneath the rope bridge adjoining the room before you to the one ahead...");
        }
        if (currentX == 2 && currentY == -1) {
            System.out.println("A mysterious hum emanates from the southern doorway. There's a crackling sound akin to that of a portal...");
        }
        if (currentX == 3 && currentY == 2) {
            System.out.println("The northern doorway hums eerily. There's a crackling sound akin to that of a portal...");
        }
        if (currentX == 3 && currentY == 1) {
            System.out.println("Candles have been set up around some sort of magic circle on the ground.");
        }
        if (currentX == 3 && currentY == 0) {
            System.out.println("");
        }
        return roomDescription();
    }

    /*public Room currentRoom(int x, int y) {
        //return currentRoom = getRoom(currentX, currentY);
        return currentRoom;
    }*/

    public String movePlayer() {
        boolean northPossible = roomExists(currentX, currentY + 1);
        boolean southPossible = roomExists(currentX, currentY - 1);
        boolean eastPossible = roomExists(currentX + 1, currentY);
        boolean westPossible = roomExists(currentX - 1, currentY);
        boolean interactPossible = true;

        System.out.print("Where would you like to go from here? :");
        if (northPossible) {
            if ((currentX == 1 && currentY == 0) || (currentX == 1 && currentY == -1) || (currentX == 1 && currentY == 1) || (currentX == 2 && currentY == 2)
                    || (currentX == 3 && currentY == 2) || (currentX == 3 && currentY == 1) || (currentX == 3 && currentY == -1) || (currentX == 4 && currentY == 0)) {
                System.out.print(" North (n)");
            }
        }
        if (eastPossible) {
            if ((currentX == 0 && currentY == 0) || (currentX == 1 && currentY == 2) || (currentX == 1 && currentY == 1) || (currentX == 1 && currentY == 0) || (currentX == 1 && currentY == -1) || (currentX == 2 && currentY == 2) || (currentX == 2 && currentY == 0) || (currentX == 3 && currentY == 2) || (currentX == 3 && currentY == 1) || (currentX == 4 && currentY == 2)) {
                System.out.print(" East (e)");
            }
        }
        if (southPossible) {
            if ((currentX == 1 && currentY == 2) || (currentX == 1 && currentY == 1) || (currentX == 1 && currentY == 0) || (currentX == 1 && currentY == -1) || (currentX == 2 && currentY == -1) || (currentX == 3 && currentY == 2) || (currentX == 3 && currentY == 0) || (currentX == 4 && currentY == 1) || (currentX == 4 && currentY == 0)) {
                System.out.print(" South (s)");
            }
        }
        if (westPossible) {
            if ((currentX == 0 && currentY == 0) || (currentX == 1 && currentY == 0) || (currentX == 2 && currentY == 2) || (currentX == 2 && currentY == 1) ||
                    (currentX == 2 && currentY == 0) || (currentX == 2 && currentY == -1) || (currentX == 3 && currentY == 2) || (currentX == 3 && currentY == 0) ||
                    (currentX == 4 && currentY == 2)) {
                System.out.print(" West (w)");
            }
        }

        if (interactPossible) {
            if ((currentX == 1 && currentY == -1) || (currentX == 1 && currentY == -1) || (currentX == 1 && currentY == -1)) {
                System.out.print(" Use (u)");
            }
        }
            System.out.print(" ? ");


            String error = "Invalid input.";

            while (true) {
                switch (Game.userInput.nextLine()) {
                    case "n": {
                        if (northPossible) {
                            currentY++;
                            currentRoom = getRoom(currentX, currentY);
                            System.out.println(currentRoom.roomDescriptions());
                            break;
                        } else {
                            return error;
                        }
                    }
                    case "s": {
                        if (southPossible) {
                            currentY--;
                            currentRoom = getRoom(currentX, currentY);
                            System.out.println(currentRoom.roomDescriptions());
                            break;
                        } else {
                            return error;
                        }
                    }
                    case "e": {
                        if (eastPossible) {
                            currentX--;
                            currentRoom = getRoom(currentX, currentY);
                            System.out.println(currentRoom.roomDescriptions());
                            break;
                        } else {
                            return error;
                        }
                    }
                    case "w": {
                        if (westPossible) {
                            currentX++;
                            currentRoom = getRoom(currentX, currentY);
                            System.out.println(currentRoom.roomDescriptions());
                            break;
                        } else if ((westPossible) && (currentX == 0 && currentY == 0)) {
                            System.out.println("As you try to exit the dungeon, rocks very conveniently collapse upon the entrance.");
                            System.out.println("You must press onward and complete what you came here for.");
                        } else {
                            return error;
                        }
                    }
                    case "u": {
                        if (interactPossible) {
                            if (currentX == 2 && currentY == 1) {
                                //shrine interaction
                            } else {
                                //chest interaction
                            }
                        }
                    }
                }
            }
    }


    public Dungeon newInstance() {
        Dungeon dungeon = new Dungeon();
        dungeon.putRoom(0, 0);
        dungeon.putRoom(1, 0);
        dungeon.putRoom(1, -1);
        dungeon.putRoom(1, 1);
        dungeon.putRoom(1, 2);
        dungeon.putRoom(2, 2);
        dungeon.putRoom(2, 1);
        dungeon.putRoom(2, 0);
        dungeon.putRoom(2, -1);
        dungeon.putRoom(3, -1);
        dungeon.putRoom(3, 0);
        dungeon.putRoom(3, 1);
        dungeon.putRoom(3, 2);
        dungeon.putRoom(4, 2);
        dungeon.putRoom(4, 1);
        dungeon.putRoom(4, 0);
        dungeon.currentRoom = dungeon.getRoom(0, 0);
        return dungeon;

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
