import java.util.Scanner;

public class NPC {

    public String[] general(){

        String[] generalInfo = new String[]{""};
        return null;
    }


        public static String harveyDio(int goodPoints){   // good points is how well you're doing
                                                            // in the mini-game.
                                                            // 100 is a stand-in and can be
                                                            // replaced with anything else

            int index = 1; // stand-in number
        //string of dialogue for Steve harvey to choose from
           String DIO;
            if(goodPoints >= 100){

                //dialogue to encourage the player and congratulate them on being good at the game
                String[] goodDio = new String[]{" ya did good kid ", " hey! look at that! good work"};
                DIO = goodDio[index];
            }
            else{
                //dialogue to make fun of the player because they arent good at simple tasks
                String[] badDio = new String[]{" wow... i can not 'believe' that was your answer ",
                        " alright, now you know why i said not to do that hmmm? "};
                DIO = badDio[index];
            }
                return DIO;
        }


    public static String[] hints(){ // all of sodi's hints will be stored here. hints share an index with riddles
        //insert array containing the hints for ALL of the riddles
        // cant really finish till we have a set amount of riddles
        String[] riddleHint;
        riddleHint = new String[]{"hello, i exist", "please don't use this in final version"};

        return riddleHint;
    }

    public static String phoningFriend(int helpPoint, int phoneAFriend, int index){ // this is sodi's diolouge

        String responce = new String("sodi: dude... i cant give you any more hints, stop bothering me.");
        if(helpPoint >= 1) {
            String[] hint = hints();
            if(phoneAFriend == 0){
                // first time phoningFriend is called
                responce = ("sodi: so, you actually need help huh? great give me a sec... \n");

            }
            else{
                //every other time "phoningFriend" is called
                responce = ("sodi: need me again? fine, i have time\n");

            }
            //this will be what calls and types the hint in the console
            responce = responce + ("alright, pay attention, you're only getting this once; ") + hint[index];

            helpPoint = helpPoint - 1;
            return responce;
        }
        return responce;
}
}
