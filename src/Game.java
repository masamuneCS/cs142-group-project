import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        //TODO - Create game loop that runs player interactions and calls other class methods to create gameplay.
        //prompt
        Character player = Character.buildMage("Bob");
        System.out.println(player.hp);
    }

}
