import java.util.concurrent.TimeUnit;

public class MiniGame {
    public static boolean triviaGame() throws InterruptedException {

        int q = Game.diceRoll(1, 5);
        String[] gamePiece = NPC.triviaGameQuestionsAndAnswers(q);
        String question = gamePiece[0];
        String answers = gamePiece[1];
        System.out.println(question);
        System.out.println(answers);
        System.out.print("Enter your answer here; ");

        while (true) {
            switch (Game.userInput.nextLine()) {
                case "1": {
                    if (q == 1) {
                        System.out.println("Correct!");
                        return true;
                    }
                    if (q == 2) {
                        System.out.println("Bruh... Columbus... come on now!");
                        break;
                    }
                    if (q == 3) {
                        System.out.println("I can't with you right now...");
                        break;
                    }
                    if (q == 4) {
                        System.out.println("really.... REALLY?!?!");
                        break;
                    }
                    if (q == 5) {
                        System.out.println("~shakes bald head~");
                        break;
                    }
                }
                case "2": {
                    if (q == 1) {
                        System.out.println("Wait... you actually thought an integer had decimals? It's a whole number!");
                        break;
                    }
                    if (q == 2) {
                        System.out.println("Haha, you stupid...");
                        break;
                    }
                    if (q == 3) {
                        System.out.println("Yes! Finally! A half-decently smart person.");
                        return true;
                    }
                    if (q == 4) {
                        System.out.println("Come on now! You can do better than THAT");
                        break;
                    }
                    if (q == 5) {
                        System.out.println("Nice try");
                        break;
                    }
                }
                case "3": {
                    if (q == 1) {
                        System.out.println("Haha, nice try...");
                        break;
                    }
                    if (q == 2) {
                        System.out.println("Oh my gawd, well look atchu, aren't you just the smartest person in the room");
                        return true;
                    }
                    if (q == 3) {
                        System.out.println("'Steve looks on in horror'");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("I'm done....");
                        break;
                    }
                    if (q == 4) {
                        System.out.println("DING DING DING, we have a winner!");
                        return true;
                    }
                    if (q == 5) {
                        System.out.println("I can't believe they even allowed you to play");
                        break;
                    }
                }
                case "4": {
                    if (q == 1) {
                        System.out.println("Haha, you're funny...");
                        break;
                    }
                    if (q == 2) {
                        System.out.println("Haha, nice try...");
                        break;
                    }
                    if (q == 3) {
                        System.out.println("WHY ARE YOU EVEN HERE RIGHT NOW");
                        break;
                    }
                    if (q == 4) {
                        System.out.println("Just leave bruh");
                        break;
                    }
                    if (q == 5) {
                        System.out.println("Yes... yEs... YES!!!");
                        return true;
                    }
                }
                default: {
                    System.out.println("That ain't even an answer. Try again.");
                    continue;
                }
            }
            break;
        }
        return false;
    }

    public static boolean priceIsRightGame() {

        String[] priceIsRightQuestions = new String[]{"How much is the cheapest Ferrari on the market right now?",
                "How much does the most expensive house in Beverly Hills cost?",
                "How much does a bag of rice cost?",
                "How much does the cheapest Louis Vuitton bag cost?",
                "How much does a Gucci bag cost?"};
        String[] priceIsRightAnswers = new String[]{"215000", "165000000", "15", "1100", "630"};
        int j = Game.diceRoll(1, 5);
        String printOut = priceIsRightQuestions[j - 1];
        System.out.println(printOut);
        String priceGamePrompt = "Please enter a price (no decimals, commas, or $ sign): ";
        String rareEqualsCase = "Your answer and the mob's answer were equally close to the real price, so we're just gonna give you the win. Congrats.";
        String winningPhrase = "Way to go bud, you finally did something right in your life";
        String losingPhrase = "Sometimes ya win, and sometimes ya lose. This time, ya lost big time.";
        String freePhrase = "Nothin' in life is free bruh.";
        String negativePhrase = "What? You think they're gonna pay YOU to buy their product???";
        String invalidInput = "That was not a valid answer. Please try again.";

        // initializing variables
        int userInput;
        int mobAnswer;
        // loop to validate user's input
        while (true) {
            System.out.print(priceGamePrompt);
            String inputHolder = Game.userInput.nextLine();
            // seeing if string is an int and if string contains just one int
            try {
                userInput = Integer.parseInt(inputHolder);
                // telling user that their input was invalid because their input was out of bounds
                if (userInput == 0) {
                    System.out.println(freePhrase);
                    continue;
                }
                if (userInput < 0) {
                    System.out.println(negativePhrase);
                    continue;
                }
                break;
            }
            // telling user that their input was invalid because their input didn't meet 1 of the 2 requirements mentioned above
            catch (NumberFormatException e) {
                System.out.println(invalidInput);
            }
        }

        while (true) {
            if (j == 1) {
                mobAnswer = Game.diceRoll(1, 215000);
                if (userInput <= 215000) {
                    if (215000 - userInput < 215000 - mobAnswer) {
                        System.out.println(winningPhrase);
                        System.out.println("The answer was " + priceIsRightAnswers[0] + ".");
                        return true;
                    }
                    if (215000 - userInput == 215000 - mobAnswer) {
                        System.out.println(rareEqualsCase);
                        System.out.println("The answer was " + priceIsRightAnswers[0] + ".");
                        return true;
                    }
                    if (215000 - userInput > 215000 - mobAnswer) {
                        System.out.println(losingPhrase);
                        System.out.println("The answer was " + priceIsRightAnswers[0] + ".");
                        break;
                    }
                } else {
                    System.out.println(losingPhrase);
                    System.out.println("The answer was " + priceIsRightAnswers[0] + ".");
                    break;
                }
            }
            break;
        }

        while (true) {
            if (j == 2) {
                mobAnswer = Game.diceRoll(1, 165000000);
                if (userInput <= 165000000) {
                    if (165000000 - userInput < 165000000 - mobAnswer) {
                        System.out.println(winningPhrase);
                        System.out.println("The answer was " + priceIsRightAnswers[1] + ".");
                        return true;
                    }
                    if (165000000 - userInput == 165000000 - mobAnswer) {
                        System.out.println(rareEqualsCase);
                        System.out.println("The answer was " + priceIsRightAnswers[1] + ".");
                        return true;
                    }
                    if (165000000 - userInput > 165000000 - mobAnswer) {
                        System.out.println(losingPhrase);
                        System.out.println("The answer was " + priceIsRightAnswers[1] + ".");
                        break;
                    }
                } else {
                    System.out.println(losingPhrase);
                    System.out.println("The answer was " + priceIsRightAnswers[1] + ".");
                    break;
                }
            }
            break;
        }

        while (true) {
            if (j == 3) {
                mobAnswer = Game.diceRoll(1, 15);
                if (userInput <= 15) {
                    if (15 - userInput < 15 - mobAnswer) {
                        System.out.println(winningPhrase);
                        System.out.println("The answer was " + priceIsRightAnswers[2] + ".");
                        return true;
                    }
                    if (15 - userInput == 15 - mobAnswer) {
                        System.out.println(rareEqualsCase);
                        System.out.println("The answer was " + priceIsRightAnswers[2] + ".");
                        return true;
                    }
                    if (15 - userInput > 15 - mobAnswer) {
                        System.out.println(losingPhrase);
                        System.out.println("The answer was " + priceIsRightAnswers[2] + ".");
                        break;
                    }
                } else {
                    System.out.println(losingPhrase);
                    System.out.println("The answer was " + priceIsRightAnswers[2] + ".");
                    break;
                }
            }
            break;
        }

        while (true) {
            if (j == 4) {
                mobAnswer = Game.diceRoll(1, 1100);
                if (userInput <= 1100) {
                    if (1100 - userInput < 1100 - mobAnswer) {
                        System.out.println(winningPhrase);
                        System.out.println("The answer was " + priceIsRightAnswers[3] + ".");
                        return true;
                    }
                    if (1100 - userInput == 1100 - mobAnswer) {
                        System.out.println(rareEqualsCase);
                        System.out.println("The answer was " + priceIsRightAnswers[3] + ".");
                        return true;
                    }
                    if (1100 - userInput > 1100 - mobAnswer) {
                        System.out.println(losingPhrase);
                        System.out.println("The answer was " + priceIsRightAnswers[3] + ".");
                        break;
                    }
                } else {
                    System.out.println(losingPhrase);
                    System.out.println("The answer was " + priceIsRightAnswers[3] + ".");
                    break;
                }
            }
            break;
        }

        while (true) {
            if (j == 5) {
                mobAnswer = Game.diceRoll(1, 630);
                if (userInput <= 630) {
                    if (630 - userInput < 630 - mobAnswer) {
                        System.out.println(winningPhrase);
                        System.out.println("The answer was " + priceIsRightAnswers[4] + ".");
                        return true;
                    }
                    if (630 - userInput == 630 - mobAnswer) {
                        System.out.println(rareEqualsCase);
                        System.out.println("The answer was " + priceIsRightAnswers[4] + ".");
                        return false;
                    }
                    if (630 - userInput > 630 - mobAnswer) {
                        System.out.println(losingPhrase);
                        System.out.println("The answer was " + priceIsRightAnswers[4] + ".");
                        break;
                    }
                } else {
                    System.out.println(losingPhrase);
                    System.out.println("The answer was " + priceIsRightAnswers[4] + ".");
                    break;
                }
            }
            break;
        }
        return false;
    }

    // will start when we have our group coding sesh
    public static boolean blackJack() {
        int characterSwitcher = 1;
        int playerHandValue = Game.diceRoll(1, 12);
        int hiddenCard;
        int dealerHandValue = hiddenCard = Game.diceRoll(1, 12);
        int drawnCard = 0;
        int[] drawnHand = new int[53];
        int i = 0;
        int cardOccurrences = 0;

        while (true) {
            if (characterSwitcher == 1) {
                System.out.println("Your current hand's value is: " + playerHandValue + ".");
                System.out.print("Would you like to hit or stand? (1 - hit, 2 - stand): ");
                if (Game.inputValidation(2) == 1) {
                    while (true) {
                        drawnCard = Game.diceRoll(1, 12);
                        for (int key : drawnHand) {
                            if (drawnCard == key) {
                                cardOccurrences++;
                            }
                        }
                        if (cardOccurrences > 3) {
                            continue;
                        }
                        drawnHand[i] = drawnCard;
                        i++;
                        characterSwitcher = 2;
                        playerHandValue += drawnCard;
                        if (playerHandValue > 21) {
                            System.out.println("Too bad, so sad.");
                            return false;
                        }
                        break;
                    }
                } else {
                    System.out.println("Dealer's current hand's value is: " + dealerHandValue + ".");
                    while (true) {
                        drawnCard = Game.diceRoll(1, 12);
                        for (int key : drawnHand) {
                            if (drawnCard == key) {
                                cardOccurrences++;
                            }
                        }
                        if (cardOccurrences > 3) {
                            continue;
                        }
                        drawnHand[i] = drawnCard;
                        i++;
                        dealerHandValue += drawnCard;
                        if (playerHandValue > dealerHandValue) {
                            System.out.println("Wow, you really frickin' did it. Who knew you had it in you.");
                            return true;
                        }
                        if (playerHandValue < dealerHandValue) {
                            System.out.println("Too bad, so sad.");
                            return false;
                        }
                        if (21 - playerHandValue == 21 - dealerHandValue) {
                            System.out.println("You lucky son of a gun");
                            return true;
                        }
                        break;
                    }
                }
            }
            if (characterSwitcher == 2) {
                System.out.println("Dealer's current hand's value is: " + dealerHandValue + ".");
                if (dealerHandValue < 17) {
                    while (true) {
                        drawnCard = Game.diceRoll(1, 12);
                        for (int key : drawnHand) {
                            if (drawnCard == key) {
                                cardOccurrences++;
                            }
                        }
                        if (cardOccurrences > 3) {
                            continue;
                        }
                        drawnHand[i] = drawnCard;
                        i++;
                        characterSwitcher = 1;
                        dealerHandValue += drawnCard;
                        if (dealerHandValue > 21) {
                            System.out.println("Wow, you really frickin' did it. Who knew you had it in you.");
                            return true;
                        }
                        break;
                    }
                }
                else if (dealerHandValue >= 17) {
                    System.out.println("Your current hand's value is: " + playerHandValue + ".");
                    while (true) {
                        drawnCard = Game.diceRoll(1, 12);
                        for (int key : drawnHand) {
                            if (drawnCard == key) {
                                cardOccurrences++;
                            }
                        }
                        if (cardOccurrences > 3) {
                            continue;
                        }
                        drawnHand[i] = drawnCard;
                        i++;
                        playerHandValue += drawnCard;
                        if (playerHandValue > dealerHandValue) {
                            System.out.println("Wow, you really frickin' did it. Who knew you had it in you.");
                            return true;
                        }
                        if (playerHandValue < dealerHandValue) {
                            System.out.println("Too bad, so sad.");
                            return false;
                        }
                        if (21 - playerHandValue == 21 - dealerHandValue) {
                            System.out.println("You lucky son of a gun");
                            return true;
                        }
                        break;
                    }
                }
            }
        }
    }
}

//        while (characterSwitcher == 2) {
//            dealerHandValue = Game.diceRoll(1,12);
//            System.out.println("Dealer's current hand value is: " + dealerHandValue + ".");
//            if (dealerHandValue < 17){
//                dealerHandValue += Game.diceRoll(1,12);
//                while(i < drawnHand.length) {
//                    drawnHand[i] = Game.diceRoll
//                    i++;
//                }
//                continue;
//            }
//            else if (dealerHandValue >= 17) {
//                // code here
//                characterSwitcher = 1;
//                break;
//            }
//        }

//    public static void standIn(int input){
//
//        boolean userContin = true;
//        int userHand = 0;
//        int DealerHand;
//        int drawnCard = 0;
//
//        while(true){
//            if(userContin == true){
//
//
//            drawnCard = Game.diceRoll(1,12);
//                if(input == 1){
//
//                }
//                else{
//                    userContin = false;
//            }
//            if(DealerHand < 17){
//
//            roll
//                DealerHand++;
//            }
//            if(userContin == false && DealerHand >= 17){
//
//
//                break;
//            }
//
//        }
//
//
//    }