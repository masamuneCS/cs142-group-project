import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class NPC {
    public String[] general(){

        String[] generalInfo = new String[]{""};
        return null;
    }

    public static String[] narrator( String target, String itemReceved){

        String[] speakingPart = new String[]{"congradulations on your victory against " + target + " !",
                                            "game over, would you like to start again?",
                                            "you found " + itemReceved + "from the chest! what luck",
                                                "you got " + itemReceved + " from completing the minigame!",
                                            "if you need help with trivia, try asking sodi for help! she *is* being payed after all!"};
        return speakingPart;
    }


        public static String harveyDio(int goodPoints) throws InterruptedException{   // good points is how well you're doing
                                                            // in the mini-game.
                                                            // 100 is a stand-in and can be
                                                            // replaced with anything else

            int index = 1; // stand-in number
        //string of dialogue for Steve harvey to choose from
           String DIO;
            if(goodPoints >= 100){

                //dialogue to encourage the player and congratulate them on being good at the game
                String[] goodDio = new String[]{" ", " hey! look at that! good work"};
                DIO = goodDio[index];
            }
            else{
                //dialogue to make fun of the player because they arent good at simple tasks
                String[] badDio = new String[]{"wow... i can not 'believe' that was your answer",
                        "let me ask ya a little something, aright? how in THE hell did you get that?",
                "'steeve looks on in horror'\n ...what the hell man?"};
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

public static String[] triviaGameQuestionsAndAnswers(int q) {
        String[] triviaGameQuestions = new String[]{"Do doubles or ints have decimals?",
            "What year did America gain its independence?",
            "What do you have to put at the top of your code when utilizing a Scanner?",
            "What's the difference between while loops and for loops?",
            "Do you have to create a constructor when coding an object class?"};
        String[] triviaGameAnswers = new String[]{"Choose your answer: \n" + "1) Doubles \n" + "2) Ints \n" + "3) Both\n" + "4) Neither",
            "Choose your answer: \n" + "1) 1492 \n" + "2) 1861 \n" + "3) 1776\n" + "4) 2021",
            "Choose your answer: \n" + "1) Your name \n" + "2) An import statement \n" + "3) Class name\n" + "4) Main method",
            "Choose your answer: \n" + "1) One compares things and one performs loops \n" + "2) Nothing, they're the same \n" +
                    "3) Really just looks since you can rewrite a while loop to resemble a for loop and vice versa\n" +
                    "4) One's a type and one's a method call",
            "Choose your answer: \n" + "1) Well duh \n" + "2) Yes, you need several \n" + "3) Yes, but just 1\n" +
                    "4) Well not necessarily because there's a default constructor"};
        String question = triviaGameQuestions[q - 1];
        String answer = triviaGameAnswers[q - 1];
        String[] questionAndAnswer = new String[]{question,answer};
        return questionAndAnswer;
}

public static String[] trivia(int index){
        String[] trivia = new String[]{"", "", ""};
        String[] answer = new String[]{"", "", ""};
        String[] both = new String[]{trivia[index], answer[index]};
        return both;
}

public static String help(int index){
        String[] hints = new String[]{"", "", ""};
        String given = hints[index];
        return given;
}

    public static String phoningFriend(int helpPoint, int phoneAFriend, String hint){ // this is sodi's diolouge

        String responce = new String("sodi: dude... i cant give you any more hints, stop bothering me.");
        if(helpPoint >= 1) {
            if(phoneAFriend == 0){
                // first time phoningFriend is called
                responce = ("sodi: so, you actually need help huh? great give me a sec... \n");

            }
            else{
                //every other time "phoningFriend" is called
                responce = ("sodi: need me again? fine, i have time\n");

            }
            //this will be what calls and types the hint in the console
            responce = responce + ("alright, pay attention, you're only getting this once; ") + hint;

            helpPoint = helpPoint - 1;
            return responce;
        }
        return responce;
}
}
