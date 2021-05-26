import java.util.Scanner;

public class NPC {

        public static String[] harveyDio(int goodPoints){
        //string of diolouge for Steve harvey to choose from
           String[] DIO;
            if(goodPoints >= 100){
                //diolouge to encourage the player and congradulate them on being good at the game
                String[] goodDio = new String[]{" ", " "};
                DIO = goodDio;
            }
            else{
                //diolouge to make fun of the player because they arent good at simple tasks
                String[] badDio = new String[]{" ", " "};
                DIO = badDio;
            }
                return DIO;
        }


    public static String[] hints(int indexForRiddle){
        //insert array containing the hints for ALL of the riddles
        // cant really finish till we have a set amount of riddles
        String[] riddleHint;
        riddleHint = new String[]{"hello", "please don't use this in final version"};

        return riddleHint;
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
                responce = ("sodi: need me again? fine i have time\n");

            }
            //this will be what calls and types the hint in the console
            responce = responce + ("alright, pay attention, you're only getting this once; ") + hints(index);

            helpPoint = helpPoint - 1;
            return responce;
        }
        return responce;
}
}
