
import java.awt.*;

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

    protected static Room[] whichRoom = new Room[16]; //whichRoom works with Dungeon.roomCoords to match rooms to coordinates in the Dungeon constructor
    protected static String[] roomDescription = {"Mysterious yells can be heard from another part of the dungeon...","As you enter the room, several bats shriek as they fly past you...",
            "A strange regality adorns this room with limestone walls...", "The tiles in this room show signs of wear...", "A seemingly endless abyss lies underneath the rope bridge adjoining the room before you to the one ahead...",
            "Candles have been set up around some sort of magic circle on the ground."};

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

    public String getDescription() {
        return description;
    }

    public boolean isRoomSeen() {
        return roomSeen;
    }

    public void setRoomSeen(boolean roomSeen) {
        this.roomSeen = roomSeen;
    }

    public boolean isCanMoveNorth() {
        return canMoveNorth;
    }

    public boolean isCanMoveSouth() {
        return canMoveSouth;
    }

    public boolean isCanMoveEast() {
        return canMoveEast;
    }

    public boolean isCanMoveWest() {
        return canMoveWest;
    }

    public boolean isContainsShrine() {
        return containsShrine;
    }

    public boolean isContainsChest() {
        return containsChest;
    }

    public Point getRoomCoordinate() {
        return roomCoordinate;
    }

    /**
     * dungeonBuilder methods create a set of rooms for a 4x4 dungeon grid on an XY coordinate plane
     * @param roomCoord XY coordinate to assign to each room
     */
    public static void dungeon0Builder(Point[] roomCoord){
        for (int i = 0; i < whichRoom.length; i++){
            Point roomCoordinate;
            boolean doorWest;
            boolean doorNorth;
            boolean doorEast;
            boolean doorSouth;
            boolean hasShrine;
            boolean hasChest;
            switch(i){
                case 0:{
                    roomCoordinate = roomCoord[i];//(0,0)
                    doorWest = false;
                    doorNorth = false;
                    doorEast = true;
                    doorSouth = true;
                    hasShrine = false;
                    hasChest = false;
                    break;
                }
                case 1:{
                    roomCoordinate = roomCoord[i];//(0,1)
                    doorWest = false;
                    doorNorth = true;
                    doorEast = true;
                    doorSouth = true;
                    hasShrine = false;
                    hasChest = false;
                    break;
                }
                case 2:{
                    roomCoordinate = roomCoord[i];//(0,2)
                    doorWest = false;
                    doorNorth = true;
                    doorEast = false;
                    doorSouth = true;
                    hasShrine = false;
                    hasChest = false;
                    break;
                }
                case 3:{
                    roomCoordinate = roomCoord[i];//(0,3)
                    doorWest = false;
                    doorNorth = true;
                    doorEast = true;
                    doorSouth = false;
                    hasShrine = false;
                    hasChest = true;
                    break;
                }
                case 4:{
                    roomCoordinate = roomCoord[i];//(1,0)
                    doorWest = true;
                    doorNorth = false;
                    doorEast = true;
                    doorSouth = false;
                    hasShrine = false;
                    hasChest = true;
                    break;
                }
                case 5:{
                    roomCoordinate = roomCoord[i];//(1,1)
                    doorWest = true;
                    doorNorth = false;
                    doorEast = false;
                    doorSouth = true;
                    hasShrine = true;
                    hasChest = false;
                    break;
                }
                case 6:{
                    roomCoordinate = roomCoord[i];//(1,2)
                    doorWest = false;
                    doorNorth = true;
                    doorEast = true;
                    doorSouth = true;
                    hasShrine = false;
                    hasChest = false;
                    break;
                }
                case 7:{
                    roomCoordinate = roomCoord[i];//(1,3)
                    doorWest = true;
                    doorNorth = true;
                    doorEast = false;
                    doorSouth = false;
                    hasShrine = false;
                    hasChest = false;
                    break;
                }
                case 8:{
                    roomCoordinate = roomCoord[i];//(2,0)
                    doorWest = true;
                    doorNorth = false;
                    doorEast = true;
                    doorSouth = true;
                    hasShrine = false;
                    hasChest = false;
                    break;
                }
                case 9:{
                    roomCoordinate = roomCoord[i];//(2,1)
                    doorWest = false;
                    doorNorth = true;
                    doorEast = true;
                    doorSouth = false;
                    hasShrine = false;
                    hasChest = false;
                    break;
                }
                case 10:{
                    roomCoordinate = roomCoord[i];//(2,2)
                    doorWest = true;
                    doorNorth = false;
                    doorEast = true;
                    doorSouth = true;
                    hasShrine = false;
                    hasChest = false;
                    break;
                }
                case 11:{
                    roomCoordinate = roomCoord[i];//(2,3)
                    doorWest = false;
                    doorNorth = true;
                    doorEast = false;
                    doorSouth = false;
                    hasShrine = false;
                    hasChest = true;
                    break;
                }
                case 12:{
                    roomCoordinate = roomCoord[i];//(3,0)
                    doorWest = true;
                    doorNorth = false;
                    doorEast = false;
                    doorSouth = false;
                    hasShrine = false;
                    hasChest = true;
                    break;
                }
                case 13:{
                    roomCoordinate = roomCoord[i];//(3,1)
                    doorWest = true;
                    doorNorth = false;
                    doorEast = false;
                    doorSouth = true;
                    hasShrine = false;
                    hasChest = true;
                    break;
                }
                case 14:{
                    roomCoordinate = roomCoord[i];//(3,2)
                    doorWest = true;
                    doorNorth = true;
                    doorEast = false;
                    doorSouth = true;
                    hasShrine = false;
                    hasChest = false;
                    break;
                }
                case 15:{
                    roomCoordinate = roomCoord[i];//(3,3)
                    doorWest = false;
                    doorNorth = true;
                    doorEast = false;
                    doorSouth = false;
                    hasShrine = false;
                    hasChest = false;
                    break;
                }
                default:{
                    roomCoordinate = new Point(-1, -1);//(3,3)
                    doorWest = false;
                    doorNorth = false;
                    doorEast = false;
                    doorSouth = false;
                    hasShrine = false;
                    hasChest = false;
                    throw new IllegalArgumentException("Room builder asked for more than 16 rooms");
                }
            }
            String description = roomDescription[Game.diceRoll(1,roomDescription.length - 1)];
            whichRoom[i] = new Room(description, false, doorNorth, doorSouth, doorEast, doorWest, hasShrine, hasChest, roomCoordinate);
        }
    }
}
