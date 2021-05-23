import java.util.Scanner;

public class NPC {
    int phoneAFriend = 0;

    public static String NPCinteraction(Scanner userInput, int helpPoint, int phoneAFriend){

        String output;
        //needs to call "phoningFriend" with current "hintPoint" and "phoneAFriend" values when
        // "phoningFriend" or "phone a friend" is typed into console
        String input = userInput.toString();

        String[] validInput; // this will be a series of valid inputs the player can put into the system
                            // that is accepted and will prompt an NPC interaction depending on
                            // what is typed and if the player is talking to anyone.

        validInput = new String[]{"call Sodi","phone a friend","need help please"};
                                    // what would some valid inputs be? should we add some EasterEggs?


        for(int j = 0; j < validInput.length; j++) {
            if (input == validInput[j]) { //what is your plan to implement this?

                //output will be different depending on the input,
                // will take time to program, but will probably be worth.
                output = (" ");
                return output;
            }
        }
        output =("remember to capitalize names and don't end with a period" +
                "always use the name of the NPC you want to talk to unless its the 'phone a friend command" +
                " try again: ");
        return output;
    }
    public static void steveHarvyDiolouge(boolean miniGame, int miniGameTriggered){ // steeveHary needs to
                                                                            // activate whenever the minigame
                                                                                // is triggered
        if(miniGame){
            //the following is text that comes up when the mini-game starts
           if(miniGameTriggered > 0){
               //text plays if this isn't your first time on the show
           }
           else{
               //this text plays if it IS your first time on the show
           }
        }

    }
    public static String hints(int indexForRiddle){
        //insert array containing the hints for ALL of the riddles
        // cant really finish till we have a set amount of riddles
        String[] riddleHint;
        riddleHint = new String[]{"hello", "please don't use this in final version"};

        return riddleHint[indexForRiddle];
    }
    public static void phoningFriend(int helpPoint, int phoneAFriend, int index){
        //the following controls everything that happens when you type "phone a friend" in the console
        if(helpPoint == 1) {
            if(phoneAFriend == 0){
                // first time phoningFriend is called
                System.out.println("sodi: so, you actually need help huh? great give me a sec.");
            }
            else{
                //every other time "phoningFriend" is called
                System.out.println("sodi: need me again? fine i have time");
            }
            //this will be what calls and types the hint in the console
            System.out.println("alright, heres the hint; and pay attention, im not saying this twice!");
            System.out.println(hints(index));

            helpPoint = helpPoint - 1;
        }

    }
}
