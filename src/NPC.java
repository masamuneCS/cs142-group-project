import java.util.Scanner;

public class NPC {
    int phoneAFriend = 0;

    public static String NPCinteraction(Scanner userInput, int helpPoint, int phoneAFriend,
                                        String numberKeyOptions, boolean Steeve, boolean miniGameTriggered){

        String output = new String("please use the number keys!(if that's what we're using)");
        //needs to call "phoningFriend" with current "hintPoint" and "phoneAFriend" values when
        // "phoningFriend" or "phone a friend" is typed into console
        String input = userInput.toString();

        String[] validInput; // this will be a series of valid inputs the player can put into the system
                            // that is accepted and will prompt an NPC interaction depending on
                            // what is typed and if the player is talking to anyone.

        validInput = numberKeyOptions.split(",");
        if(Steeve == true){
            steveHarvyDiolouge(miniGameTriggered, validInput);

        }
        for(int i = 0; i < validInput.length; i++) {
            if (input.equals(validInput[i])) {
                phoningFriend(helpPoint, phoneAFriend, validInput.length);
            } //what is your plan to implement this?
        }
        return output;
    }
    public static void steveHarvyDiolouge(boolean miniGameTriggered, String[] userCouldInput){ // steeveHary needs to
                                                                            // activate whenever the minigame
                                                                                // is triggered
           if(miniGameTriggered == true){
               //text plays if this isn't your first time on the show
           }
           else{
               //this text plays if it IS your first time on the show

               miniGameTriggered = true;
           }
        }

    public static String hints(int indexForRiddle){
        //insert array containing the hints for ALL of the riddles
        // cant really finish till we have a set amount of riddles
        String[] riddleHint;
        riddleHint = new String[]{"hello", "please don't use this in final version"};

        return riddleHint[indexForRiddle];
    }
    public static String phoningFriend(int helpPoint, int phoneAFriend, int index){
        //the following controls everything that happens when you type "phone a friend" in the console
        String responce = new String("sodi: dude... i cant give you any more hints, stop bothering me.");
        if(helpPoint >= 1) {
            if(phoneAFriend == 0){
                // first time phoningFriend is called
                responce = ("sodi: so, you actually need help huh? great give me a sec...");

            }
            else{
                //every other time "phoningFriend" is called
                responce = ("sodi: need me again? fine i have time");

            }
            //this will be what calls and types the hint in the console
            responce = responce + ("alreight, pay attention, you're only getting this once; ") + hints(index);

            helpPoint = helpPoint - 1;
            return responce;
        }
        return responce;
}
}
