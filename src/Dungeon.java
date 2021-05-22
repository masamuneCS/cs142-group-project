// potentially re-include these so the game can be seen and played in a standalone window akin to StarsAndStripes
// otherwise the game currently will be played in the console itself

/*import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.sql.Array;*/


public class Dungeon {

    static String nextLine = System.getProperty("line.separator");

    //array number arbitrary until we finalize number of floors + size of floors relative to time
    static String maps[] = new String[32];

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

    // Preparing for potential "if I'm on X map, these are my options"
    public static boolean canMove(int[] map) {
        boolean flag = false;
        int testVar = 0;

        if (testVar == 1) {
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
    public static boolean move(int[] map, int position) {
        return true;
    }

    // currently only for printing map designs to the console
    public static void main(String[] args) {
        initializeMapDesigns();
        printArray();
    }
}
