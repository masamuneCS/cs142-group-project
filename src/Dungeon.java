import com.sun.istack.internal.Nullable;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.PrintStream;
import java.sql.Array;


public class Dungeon {
    // Don't touch, this is for testing - might use a different method to design levels
    // Comment everything below this out with /* */ if you want to set up your own process please
    // Seth
    /*public void graphics
    {
        public void drawString(String text, String artChar, Settings settings) {
        BufferedImage image = getImageIntegerMode(settings.width, settings.height);

        Graphics2D graphics2D = getGraphics(image.getGraphics(), settings);
        graphics2D.drawString(text, 6, ((int) (settings.height * 0.67)));

        for (int y = 0; y < settings.height; y++) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int x = 0; x < settings.width; x++) {
                stringBuilder.append(image.getRGB(x, y) == -16777216 ? " " : artChar);
            }

            if (stringBuilder.toString()
                    .trim()
                    .isEmpty()) {
                continue;
            }

            System.out.println(stringBuilder);
        }

    }

        private BufferedImage getImageIntegerMode(int width, int height) {
        return new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

        private Graphics2D getGraphics2D(Graphics graphics, Settings settings) {
        graphics.setFont(settings.font);

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        return graphics2D;
    }

        public class Settings {
            public Font font;
            public int width;
            public int height;

            public Settings(Font font, int width, int height) {
                this.font = font;
                this.width = width;
                this.height = height;
            }
        }
    }*/
    static String nextLine = System.getProperty("line.separator");

    static String maps[] = new String[8];

    public static void initializeMapDesigns() {
        String design1 = "*****";
        String design1Vert = "*" + nextLine + "*" + nextLine + "*" + nextLine + "*" + nextLine + "*";
        String design1Door = "**" + "O" + "**";
        String design1DoorVert = "*" + nextLine + "*" + nextLine + "O" + nextLine + "*" + nextLine + "*";
        String design1Character = "**" + "C" + "**";

        String design2 = ".....";
        String design2Vert = "." + nextLine + "." + nextLine + "." + nextLine + "." + nextLine + ".";
        String design2Door = ".." + "O" + "..";
        String design2DoorVert = "." + nextLine + "." + nextLine + "O" + nextLine + "." + nextLine + ".";
        String design2Character = ".." + "C" + "..";

        String design3 = "=====";
        String design3Vert = "||" + nextLine + "||" + nextLine + "||";
        String design3Door = "==" + "O" + "==";
        String design3DoorVert = "||" + nextLine + "O" + nextLine + "||";
        String design3Character = "==" + "C" + "==";

        for (int i = 0; i < maps.length; i++) {
            maps[0] = design1
                    + nextLine
                    + design2
                    + nextLine
                    + design3;

            maps[1] = design1
                    + nextLine
                    + design1
                    + nextLine
                    + design1;

            maps[2] = design2
                    + nextLine
                    + design2
                    + nextLine
                    + design2;

            maps[3] = design3
                    + nextLine
                    + design3
                    + nextLine
                    + design3;

            maps[4] = design1Character;

            maps[5] = design1Door;

            maps[6] = design2Character;

            maps[7] = design3Door;

        }
    }
    public static void printArray() {
        for (int i = 0; i < 8; i++) {
            System.out.println(maps[i]);
        }
    }

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

    public static boolean move(int[] map, int position) {
        return true;
    }


    public static void main(String[] args) {
        initializeMapDesigns();
        printArray();
    }
}
