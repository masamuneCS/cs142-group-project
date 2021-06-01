import java.io.IOException;
import java.util.*;

public final class Room {

    private final String description;
    private final static Set<Integer> roomsSeen = new HashSet<Integer>();
    private final static Random random = new Random();
    private final static int NUM_ROOMS = 16;

    private Room(String description) {
        this.description = description;
    }

    public void enter() {
        System.out.println("You are in " + description);
    }

    public String roomDescriptions()  {
        return null;
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
