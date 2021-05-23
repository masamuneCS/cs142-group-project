// potentially re-include these so the game can be seen and played in a standalone window akin to StarsAndStripes
// otherwise the game currently will be played in the console itself

/*import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.sql.Array;
import java.lang.reflect.Array;*/

import java.util.Scanner;

public class Dungeon {

    static String nextLine = System.getProperty("line.separator");

    static Scanner userEntry = new Scanner(System.in);

    //array number arbitrary until we finalize number of floors + size of floors relative to time
    static String[] maps = new String[32];

    static int[] playerPosition = new int[32];

    public static void initializeMapDesigns() {
        //separation is intentional for visual clarity

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

        for (int i = 0; i < maps.length; i++) {
            maps[0] = design1Single + design1 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design2Character + "O"
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design1 + design1Single;

            maps[1] = design1Single + design1HorizontalDoor + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    +"O" + design2Character +"O"
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design3Single + design3HorizontalDoor + design3Single;

            maps[2] = design1Single + design1HorizontalDoor + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design2Character + "O"
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design1HorizontalDoor + design1Single;

            maps[3] = design1Single + design1 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design2Character + "O"
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design1HorizontalDoor + design1Single;

            maps[4] = design1Single + design1HorizontalDoor + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + "O" + design2Character + "O"
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design1 + design1Single;

            maps[5] = design1Single + design1 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design3Single + design3 + design3Single;

            maps[6] = design1Single + design1 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design3Single + design3 + design3Single;

            maps[7] = design1Single + design1 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design3Single + design3 + design3Single;

            maps[8] = design1Single + design1 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design3Single + design3 + design3Single;

            maps[9] = design1Single + design1 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design3Single + design3 + design3Single;

            maps[10] = design1Single + design1 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design3Single + design3 + design3Single;

            maps[11] = design1Single + design1 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design3Single + design3 + design3Single;

            maps[12]= design1Single + design1 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design3Single + design3 + design3Single;

            maps[13]= design1Single + design1 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design3Single + design3 + design3Single;

            maps[14]= design1Single + design1 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design3Single + design3 + design3Single;

            maps[15]= design1Single + design1 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design3Single + design3 + design3Single;

            maps[16]= design1Single + design1 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design1Single + design2 + design1Single
                    + nextLine
                    + design3Single + design3 + design3Single;

        }
    }

    // temporary method to print map designs into console to see them, replace i<6 with a higher number
    // every time a new map is designed
    public static void printArray() {
        for (int i = 0; i < 6; i++) {
            System.out.println(maps[i]);
        }
    }
    // figuring out user entry + how to integrate it alongside maps
    // or should this be done in Game.java?
    public static boolean canMove(int[] maps) {
        boolean moveOkay = false;
        String e = userEntry.next();
        //int x = (int) Array.get(maps, Integer.parseInt(i));

            if (e.equals("right")) {
                for (int i = 0; i < maps.length; i++) {
                    if (i < maps.length - 1 && maps[i] == 1 || maps[i] == 3) {
                        if (maps[i] == 0) {
                            moveOkay = true;
                            break;
                        }
                    }
                }
            }
            if (e.equals("down")) {
                for (int i = 0; i < maps.length; i++) {
                    if (i < maps.length - 1 && maps[i] == 1 || maps[i] == 3) {
                        if (maps[i + 1] == 0) {
                            moveOkay = true;
                            break;
                        }
                    }
                }
            }
            if (e.equals("left")) {
                for (int i = 0; i < maps.length; i++) {
                    if (i < maps.length - 1 && maps[i] == 1 || maps[i] == 3) {
                        if (maps[i + 1] == 0) {
                            moveOkay = true;
                            break;
                        }
                    }
                }
            }
            if (e.equals("up")) {
                for (int i = 0; i < maps.length; i++) {
                    if (i < maps.length - 1 && maps[i] == 1 || maps[i] == 3) {
                        if (maps[i + 1] == 0) {
                            moveOkay = true;
                            break;
                        }
                    }
                }
            }
            if (e.equals("use")) {
                for (int i = 0; i < maps.length; i++) {
                    if (i < maps.length - 1 && maps[i] == 1 || maps[i] == 3) {
                        if (maps[i + 1] == 0) {
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

    // stub for moving the character through the dungeon
    // move character visually towards destination? e.g.  C..   .C.   ..C
    public static boolean moveVisual(int position) {
        //position 0 will be "centered"
        playerPosition[0] = 0;

        //1 + 2 will be "walking Up"
        playerPosition[1] = 1;
        playerPosition[2] = 2;

        //3 + 4 will be "walking Right"
        playerPosition[3] = 3;
        playerPosition[4] = 4;

        //5 + 6 will be "walking Down"
        playerPosition[5] = 5;
        playerPosition[6] = 6;

        //7 + 8 will be "walking Left"
        playerPosition[7] = 7;
        playerPosition[8] = 8;

        return true;
    }

    // stub for moving character from one map to the next
    public static boolean move(int[] map, int position) {
        return true;
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
        return input;
    }

    // currently only for printing map designs to the console
    public static void main(String[] args) {
        initializeMapDesigns();
        printArray();

        Scanner s = new Scanner(System.in);
        String prompt = "Please enter your next move.\nAcceptable inputs are: \"up\", \"down\", \"left\", \"right\", \"use\"";
        String entry = s.nextLine();




    }
}
