
import java.awt.*;
import java.util.*;

public class Dungeon {

    private String description;
    protected HashMap<Point, Room> map;
    private Room currentRoom;
    private Point lastRoomCoord;
    public static Point[] roomCoords;
    protected static final Point startCoord = new Point(0, 0);

    public Dungeon() {
        roomCoords = new Point[16];
        for (int i = 0; i < 16; i++) {
            for (int x = 0; x < 4; x++) {
                for (int y = 0; y < 4; y++) {
                    roomCoords[i] = new Point(x, y);
                }
            }
        }

        map = new HashMap<>();
        for (int i = 0; i < 16; i++) {
            map.put(roomCoords[i], Room.whichRoom[i]);
        }

        currentRoom = map.get(startCoord);
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Point newCoord) {
        currentRoom = map.get(newCoord);
    }

    public HashMap<Point, Room> getMap() {
        return map;
    }

    public void movePlayer(){
        boolean playerMoved = false;

        System.out.println("Where would you like to go? There are doors to the:");
        if (currentRoom.isCanMoveNorth()){
            System.out.print("1. North ");
        }
        if (currentRoom.isCanMoveEast()){
            System.out.print("2. East ");
        }
        if (currentRoom.isCanMoveSouth()){
            System.out.print("3. South ");
        }
        if (currentRoom.isCanMoveWest()){
            System.out.print("4. West ");
        }
        System.out.println("Pick a direction 1-4 or choose 5 to stay here.");
        int newX;
        int newY;
        String noDoor = "There's no door there, pick another way.";
        int currentX = newX = currentRoom.getRoomCoordinate().x, currentY = newY = currentRoom.getRoomCoordinate().y;
        while(true){
            switch(Game.userInput.nextLine()){
                case "1":{
                    if (currentRoom.isCanMoveNorth()){
                        newY = currentY - 1;
                        playerMoved = true;
                    }
                    else{
                        System.out.println(noDoor);
                    }
                    break;
                }
                case "2":{
                    if (currentRoom.isCanMoveEast()){
                        newX = currentX + 1;
                        playerMoved = true;
                    }
                    else{
                        System.out.println(noDoor);
                    }
                    break;
                }
                case "3":{
                    if (currentRoom.isCanMoveSouth()){
                        newY = currentY + 1;
                        playerMoved = true;
                    }
                    else{
                        System.out.println(noDoor);
                    }
                    break;
                }
                case "4":{
                    if (currentRoom.isCanMoveWest()){
                        newX = currentX - 1;
                        playerMoved = true;
                    }
                    else{
                        System.out.println(noDoor);
                    }
                    break;
                }
                case "5":{
                    System.out.println("You will stay here for now.");
                    playerMoved = false;
                    break;
                }
                default:{
                    continue;
                }
            }
            break;
        }//End input validation loop for movement switch
        if (playerMoved){
            lastRoomCoord = currentRoom.getRoomCoordinate();
            Point newRoomCoord = new Point(currentX, currentY);
            currentRoom = map.get(newRoomCoord);
        }
    }
}




