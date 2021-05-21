public class NPC {
    int phoneAFriend = 0;

    public static void NPCinteraction(){
        //needs to call "phoningFriend" with current "hintPoint" and "phoneAFriend" values when
        // "phoningFriend" or "phone a friend" is typed into console

    }
    public static void steveHarvyDiolouge(boolean miniGame, int miniGameTriggered){ // steeveHary needs to
                                                                            // activate whenever the minigame
                                                                                // is triggered
        if(miniGame = true){
            //the following is text that comes up when the mini-game starts
           if(miniGameTriggered > 0){
               //text plays if this isn't your first time on the show
           }
           else{
               //this text plays if it IS your first time on the show
           }
        }

    }
    public static String hints(){
        //insert array containing the hints for ALL of the riddles
        String[] riddelHint;
        riddelHint = new String[]{"hello", "please don't use this in final version"};

        return riddelHint[1];
    }
    public static void phoningFriend(int i, int helpPoint, int phoneAFriend){
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
            System.out.println(hints());
        }
        helpPoint = helpPoint - 1;
    }
}
