import com.sun.tools.javac.util.Pair;

import java.awt.*;
import java.io.IOException;
import java.util.*;

public final class Room {

    private final String description;
    private boolean roomSeen;
    private boolean canMoveNorth;
    private boolean canMoveSouth;
    private boolean canMoveEast;
    private boolean canMoveWest;
    private boolean containsShrine;
    private boolean containsChest;
    private Point roomCoordinate;

    protected static Room[] whichRoom = new Room[16];

    private Room(String description, boolean roomSeen, boolean canMoveNorth, boolean canMoveSouth, boolean canMoveEast, boolean canMoveWest, boolean containsShrine, boolean containsChest, Point roomCoordinate) {
        this.description = description;
        this.roomSeen = roomSeen;
        this.canMoveNorth = canMoveNorth;
        this.canMoveSouth = canMoveSouth;
        this.canMoveEast = canMoveEast;
        this.canMoveWest = canMoveWest;
        this.containsShrine = containsShrine;
        this.containsChest = containsChest;
        this.roomCoordinate = roomCoordinate;
    }



    public static void dungeon0Builder(Point[] roomCoord){
        for (int i = 0; i < whichRoom.length; i++){
            switch(i){
                case 0:{
                    Point roomCoordinate = roomCoord[i];//(0,0)
                    boolean doorWest = false;
                    boolean doorNorth = false;
                    boolean doorEast = true;
                    boolean doorSouth = true;
                    boolean hasShrine = false;
                    boolean hasChest = false;
                    break;
                }
                case 1:{
                    Point roomCoordinate = roomCoord[i];//(0,1)
                    boolean doorWest = false;
                    boolean doorNorth = true;
                    boolean doorEast = true;
                    boolean doorSouth = true;
                    boolean hasShrine = false;
                    boolean hasChest = false;
                    break;
                }
                case 2:{
                    Point roomCoordinate = roomCoord[i];//(0,2)
                    boolean doorWest = false;
                    boolean doorNorth = true;
                    boolean doorEast = false;
                    boolean doorSouth = true;
                    boolean hasShrine = false;
                    boolean hasChest = false;
                    break;
                }
                case 3:{
                    Point roomCoordinate = roomCoord[i];//(0,3)
                    boolean doorWest = false;
                    boolean doorNorth = true;
                    boolean doorEast = true;
                    boolean doorSouth = false;
                    boolean hasShrine = false;
                    boolean hasChest = true;
                    break;
                }
                case 4:{
                    Point roomCoordinate = roomCoord[i];//(1,0)
                    boolean doorWest = true;
                    boolean doorNorth = false;
                    boolean doorEast = true;
                    boolean doorSouth = false;
                    boolean hasShrine = false;
                    boolean hasChest = true;
                    break;
                }
                case 5:{
                    Point roomCoordinate = roomCoord[i];//(1,1)
                    boolean doorWest = true;
                    boolean doorNorth = false;
                    boolean doorEast = false;
                    boolean doorSouth = true;
                    boolean hasShrine = true;
                    boolean hasChest = false;
                    break;
                }
                case 6:{
                    Point roomCoordinate = roomCoord[i];//(1,2)
                    boolean doorWest = false;
                    boolean doorNorth = true;
                    boolean doorEast = true;
                    boolean doorSouth = true;
                    boolean hasShrine = false;
                    boolean hasChest = false;
                    break;
                }
                case 7:{
                    Point roomCoordinate = roomCoord[i];//(1,3)
                    boolean doorWest = true;
                    boolean doorNorth = true;
                    boolean doorEast = false;
                    boolean doorSouth = false;
                    boolean hasShrine = false;
                    boolean hasChest = false;
                    break;
                }
                case 8:{
                    Point roomCoordinate = roomCoord[i];//(2,0)
                    boolean doorWest = true;
                    boolean doorNorth = false;
                    boolean doorEast = true;
                    boolean doorSouth = true;
                    boolean hasShrine = false;
                    boolean hasChest = false;
                    break;
                }
                case 9:{
                    Point roomCoordinate = roomCoord[i];//(2,1)
                    boolean doorWest = false;
                    boolean doorNorth = true;
                    boolean doorEast = true;
                    boolean doorSouth = false;
                    boolean hasShrine = false;
                    boolean hasChest = false;
                    break;
                }
                case 10:{
                    Point roomCoordinate = roomCoord[i];//(2,2)
                    boolean doorWest = true;
                    boolean doorNorth = false;
                    boolean doorEast = true;
                    boolean doorSouth = true;
                    boolean hasShrine = false;
                    boolean hasChest = false;
                    break;
                }
                case 11:{
                    Point roomCoordinate = roomCoord[i];//(2,3)
                    boolean doorWest = false;
                    boolean doorNorth = true;
                    boolean doorEast = false;
                    boolean doorSouth = false;
                    boolean hasShrine = false;
                    boolean hasChest = true;
                    break;
                }
                case 12:{
                    Point roomCoordinate = roomCoord[i];//(3,0)
                    boolean doorWest = true;
                    boolean doorNorth = false;
                    boolean doorEast = false;
                    boolean doorSouth = false;
                    boolean hasShrine = false;
                    boolean hasChest = true;
                    break;
                }
                case 13:{
                    Point roomCoordinate = roomCoord[i];//(3,1)
                    boolean doorWest = true;
                    boolean doorNorth = false;
                    boolean doorEast = false;
                    boolean doorSouth = true;
                    boolean hasShrine = false;
                    boolean hasChest = true;
                    break;
                }
                case 14:{
                    Point roomCoordinate = roomCoord[i];//(3,2)
                    boolean doorWest = true;
                    boolean doorNorth = true;
                    boolean doorEast = false;
                    boolean doorSouth = true;
                    boolean hasShrine = false;
                    boolean hasChest = false
                    break;
                }
                case 15:{
                    Point roomCoordinate = roomCoord[i];//(3,3)
                    boolean doorWest = false;
                    boolean doorNorth = true;
                    boolean doorEast = false;
                    boolean doorSouth = false;
                    boolean hasShrine = false;
                    boolean hasChest = false;
                    break;
                }
            }
        }



    }

    /*public static Room newRegularInstance() {
        if (roomsSeen.size() == NUM_ROOMS) {
            roomsSeen.clear();
        }
        int i;
        do {
            i = random.nextInt(NUM_ROOMS);
        } while (roomsSeen.contains(i));
        roomsSeen.add(i);

        String roomDescription = null;
        if (i == 0) {
            roomDescription = "a fetid, dank room teeming with foul beasts";
        } else if (i == 1) {
            roomDescription = "an endless mountain range where eagles soar looking for prey";
        } else if (i == 2) {
            roomDescription = "a murky swamp with a foul smelling odour";
        } else if (i == 3) {
            roomDescription = "a volcano with rivers of lava at all sides";
        } else if (i == 4) {
            roomDescription =
                    "a thick forest where strange voices call out from the trees high above";
        } else if (i == 5) {
            roomDescription =
                    "an old abandoned sailing ship, littered with the remains of some unlucky sailors";
        } else if (i == 6) {
            roomDescription = "a cafe filled with hipster baristas who refuse to use encapsulation";
        } else {
        }
        return new Room(roomDescription);
    }*/

}
