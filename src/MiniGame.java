import java.util.concurrent.TimeUnit;

public class MiniGame {
    public static boolean triviaGame(){

        // selecting the question and answer used to play
        int q = Game.diceRoll(1, 8);
        String[] gamePiece = NPC.triviaGameQuestionsAndAnswers(q);
        System.out.println("Annnnnd here's your host, Steve Harvey! 'Alright, welcome to trivia! This is a very simple game, I ask you a question, and you answer with one of the provided by each question\n"+
                "That's right, this is multiple choice. Here we go now.'");

        // printing out the question and answer
        String question = gamePiece[0];
        String answers = gamePiece[1];
        System.out.println(question);
        System.out.println(answers);
        System.out.print("You have your question, you have your options, now we need your answer, whatcha got for me; ");

        // loop for gameplay
        while (true) {
            // taking in user input
            switch (Game.userInput.nextLine()) {
                // if input is 1
                case "1": {
                    // if question and answer is the 1st pair
                    if (q == 1) {
                        System.out.println("We-hel look at you, all smart'n stuff. getting answers right.");
                        return true;
                    }
                    // if question and answer is the 2nd pair
                    if (q == 2) {
                        System.out.println("Are you familiar with the story of Christopher Columbus? No? I didn't think so.");
                        break;
                    }
                    // if question and answer is the 3rd pair
                    if (q == 3) {
                        System.out.println("I can't with you right now...");
                        break;
                    }
                    // if question and answer is the 4th pair
                    if (q == 4) {
                        System.out.println("Alright, look. That ain't right and we both know that. what I want, no, need to know is this\n"
                        + "How long have you been crazy?");
                        break;
                    }
                    // if question and answer is the 5th pair
                    if (q == 5) {
                        System.out.println("~shakes bald head~\n" + "no");
                        break;
                    }
                    // if question and answer is the 6th pair
                    if (q == 6) {
                        System.out.println("You're joking...\n" + "no");
                        break;
                    }
                    // if question and answer is the 7th pair
                    if (q == 7) {
                        System.out.println("You're funny...\n" + "no");
                        break;
                    }
                    // if question and answer is the 8th pair
                    if (q == 8) {
                        System.out.println("not even close...");
                        break;
                    }
                }
                // if input is 2
                case "2": {
                    // if question and answer is the 1st pair
                    if (q == 1) {
                        System.out.println("ha! even i know that ain't right.");
                        break;
                    }
                    // if question and answer is the 2nd pair
                    if (q == 2) {
                        System.out.println("Haha, you stupid...");
                        break;
                    }
                    // if question and answer is the 3rd pair
                    if (q == 3) {
                        System.out.println("Not bad, but then again, I know nothing of this subject so that could-a-been an easy one for all I know.");
                        return true;
                    }
                    // if question and answer is the 4th pair
                    if (q == 4) {
                        System.out.println("That's incorrect. I don't know why it is either, I don't know anything about this");
                        break;
                    }
                    // if question and answer is the 5th pair
                    if (q == 5) {
                        System.out.println("Nice try");
                        break;
                    }
                    // if question and answer is the 6th pair
                    if (q == 6) {
                        System.out.println("Omg...");
                        break;
                    }
                    // if question and answer is the 7th pair
                    if (q == 7) {
                        System.out.println("Heck yeah baby!");
                        return true;
                    }
                    // if question and answer is the 8th pair
                    if (q == 8) {
                        System.out.println("just... why?");
                        break;
                    }
                }
                // if input is 3
                case "3": {
                    // if question and answer is the 1st pair
                    if (q == 1) {
                        System.out.println("Haha, nice try...");
                        break;
                    }
                    // if question and answer is the 2nd pair
                    if (q == 2) {
                        System.out.println("Well the people in charge of the show tell me you're right. So good job");
                        return true;
                    }
                    // if question and answer is the 3rd pair
                    if (q == 3) {
                        System.out.println("~Steve looks on in horror~");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            System.err.println(e);
                        }
                        System.out.println("I'm done....");
                        break;
                    }
                    // if question and answer is the 4th pair
                    if (q == 4) {
                        System.out.println("DING DING DING, we have a winner!");
                        return true;
                    }
                    // if question and answer is the 5th pair
                    if (q == 5) {
                        System.out.println("I can't believe they even allowed you to play");
                        break;
                    }
                    // if question and answer is the 6th pair
                    if (q == 6) {
                        System.out.println("Why haven't you come to this show before?!?!");
                        return true;
                    }
                    // if question and answer is the 7th pair
                    if (q == 7) {
                        System.out.println("Ugh, I simply just can't");
                        break;
                    }
                    // if question and answer is the 8th pair
                    if (q == 8) {
                        System.out.println("Nice try");
                        break;
                    }
                }
                // if input is 4
                case "4": {
                    // if question and answer is the 1st pair
                    if (q == 1) {
                        System.out.println("Haha, you're funny...");
                        break;
                    }
                    // if question and answer is the 2nd pair
                    if (q == 2) {
                        System.out.println("Haha, nice try...");
                        break;
                    }
                    // if question and answer is the 3rd pair
                    if (q == 3) {
                        System.out.println("WHY ARE YOU EVEN HERE RIGHT NOW");
                        break;
                    }
                    // if question and answer is the 4th pair
                    if (q == 4) {
                        System.out.println("Just leave bruh");
                        break;
                    }
                    // if question and answer is the 5th pair
                    if (q == 5) {
                        System.out.println("Yes... yEs... YES!!!");
                        return true;
                    }
                    // if question and answer is the 6th pair
                    if (q == 6) {
                        System.out.println("~walks away~");
                        break;
                    }
                    // if question and answer is the 7th pair
                    if (q == 7) {
                        System.out.println("~opens mouth in disbelief~");
                        break;
                    }
                    // if question and answer is the 8th pair
                    if (q == 8) {
                        System.out.println("OMG YESSS");
                        return true;
                    }
                }
                default: {
                    System.out.println("That's not an answer, but you know, that's okay, lets give it another go");
                    continue;
                }
            }
            break;
        }
        return false;
    }

    public static boolean priceIsRightGame() {

        // setting the questions up for the game
        String[] priceIsRightQuestions = new String[]{"How much is the cheapest Ferrari on the market right now?",
                "How much does the most expensive house in Beverly Hills cost?",
                "How much does a 10 lb bag of rice cost?",
                "How much does the cheapest Louis Vuitton bag cost?",
                "How much does the cheapest Gucci bag cost?"};
        // setting up the answers for the game
        String[] priceIsRightAnswers = new String[]{"215000", "165000000", "15", "1100", "630"};

        // randomly choosing a question/answer pair and printing
        int j = Game.diceRoll(1, 5);
        String printOut = priceIsRightQuestions[j - 1];

        // announcing the rules
        System.out.println("And here's your host.... Steve Harvey!");
        System.out.println("You are now playing the price is right.");
        System.out.println("The goal is to guess a price as close to the actual price as possible without going over.");
        System.out.println("Use your brain, and good luck.");
        System.out.println(printOut);

        // setting phrases to string variables
        String priceGamePrompt = "Steve: Please enter a price (no decimals, commas, or $ sign): ";
        String rareEqualsCase = "Steve: Your answer and the mob's answer were equally close to the real price, so we're just gonna give you the win. Congrats.";
        String winningPhrase = "Steve: Way to go bud, you won over that... i don't even know what that is some kinda goblin? anyway, congratulations";
        String losingPhrase = "Steve: Sometimes ya win, and uh, sorry man but this ain't one of those times.";
        String freePhrase = "Steve: What the hell man, you know full well that 'Free' isn't the right answer. since when have you *ever* gotten a free anything!";
        String negativePhrase = "Steve: What? You think they're gonna pay YOU to buy their product???";
        String invalidInput = "Steve: That was not a valid answer. Please try again.";
        String goodByeStatement = "Well anyway, ive been your host, and i will see you later.";

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
                // checking to see if input is negative
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
        // loop for 1st question and answer
        while (true) {
            if (j == 1) {
                mobAnswer = Game.diceRoll(1, 215000);
                if (userInput <= 215000) {
                    if (215000 - userInput < 215000 - mobAnswer) {
                        System.out.println(winningPhrase);
                        System.out.println("The answer was " + priceIsRightAnswers[0] + ".");
                        System.out.println("The mob's guess was " + mobAnswer + ".");
                        return true;
                    }
                    if (215000 - userInput == 215000 - mobAnswer) {
                        System.out.println(rareEqualsCase);
                        System.out.println("The answer was " + priceIsRightAnswers[0] + ".");
                        System.out.println("The mob's guess was " + mobAnswer + ".");
                        return true;
                    }
                    if (215000 - userInput > 215000 - mobAnswer) {
                        System.out.println(losingPhrase);
                        System.out.println("The answer was " + priceIsRightAnswers[0] + ".");
                        System.out.println("The mob's guess was " + mobAnswer + ".");
                        break;
                    }
                }
                else {
                    System.out.println(losingPhrase);
                    System.out.println("The answer was " + priceIsRightAnswers[0] + ".");
                    System.out.println("The mob's guess was " + mobAnswer + ".");
                    break;
                }
            }
            break;
        }
        // loop for 2nd question and answer
        while (true) {
            if (j == 2) {
                mobAnswer = Game.diceRoll(1, 165000000);
                if (userInput <= 165000000) {
                    if (165000000 - userInput < 165000000 - mobAnswer) {
                        System.out.println(winningPhrase);
                        System.out.println("The answer was " + priceIsRightAnswers[1] + ".");
                        System.out.println("The mob's guess was " + mobAnswer + ".");
                        return true;
                    }
                    if (165000000 - userInput == 165000000 - mobAnswer) {
                        System.out.println(rareEqualsCase);
                        System.out.println("The answer was " + priceIsRightAnswers[1] + ".");
                        System.out.println("The mob's guess was " + mobAnswer + ".");
                        return true;
                    }
                    if (165000000 - userInput > 165000000 - mobAnswer) {
                        System.out.println(losingPhrase);
                        System.out.println("The answer was " + priceIsRightAnswers[1] + ".");
                        System.out.println("The mob's guess was " + mobAnswer + ".");
                        break;
                    }
                }
                else {
                    System.out.println(losingPhrase);
                    System.out.println("The answer was " + priceIsRightAnswers[1] + ".");
                    System.out.println("The mob's guess was " + mobAnswer + ".");
                    break;
                }
            }
            break;
        }
        // loop for 3rd question and answer
        while (true) {
            if (j == 3) {
                mobAnswer = Game.diceRoll(1, 15);
                if (userInput <= 15) {
                    if (15 - userInput < 15 - mobAnswer) {
                        System.out.println(winningPhrase);
                        System.out.println("The answer was " + priceIsRightAnswers[2] + ".");
                        System.out.println("The mob's guess was " + mobAnswer + ".");
                        return true;
                    }
                    if (15 - userInput == 15 - mobAnswer) {
                        System.out.println(rareEqualsCase);
                        System.out.println("The answer was " + priceIsRightAnswers[2] + ".");
                        System.out.println("The mob's guess was " + mobAnswer + ".");
                        return true;
                    }
                    if (15 - userInput > 15 - mobAnswer) {
                        System.out.println(losingPhrase);
                        System.out.println("The answer was " + priceIsRightAnswers[2] + ".");
                        System.out.println("The mob's guess was " + mobAnswer + ".");
                        break;
                    }
                }
                else {
                    System.out.println(losingPhrase);
                    System.out.println("The answer was " + priceIsRightAnswers[2] + ".");
                    System.out.println("The mob's guess was " + mobAnswer + ".");
                    break;
                }
            }
            break;
        }
        // loop for the 4th question and answer
        while (true) {
            if (j == 4) {
                mobAnswer = Game.diceRoll(1, 1100);
                if (userInput <= 1100) {
                    if (1100 - userInput < 1100 - mobAnswer) {
                        System.out.println(winningPhrase);
                        System.out.println("The answer was " + priceIsRightAnswers[3] + ".");
                        System.out.println("The mob's guess was " + mobAnswer + ".");
                        return true;
                    }
                    if (1100 - userInput == 1100 - mobAnswer) {
                        System.out.println(rareEqualsCase);
                        System.out.println("The answer was " + priceIsRightAnswers[3] + ".");
                        System.out.println("The mob's guess was " + mobAnswer + ".");
                        return true;
                    }
                    if (1100 - userInput > 1100 - mobAnswer) {
                        System.out.println(losingPhrase);
                        System.out.println("The answer was " + priceIsRightAnswers[3] + ".");
                        System.out.println("The mob's guess was " + mobAnswer + ".");
                        break;
                    }
                } else {
                    System.out.println(losingPhrase);
                    System.out.println("The answer was " + priceIsRightAnswers[3] + ".");
                    System.out.println("The mob's guess was " + mobAnswer + ".");
                    break;
                }
            }
            break;
        }
        // loop for the 5th question and answer
        while (true) {
            if (j == 5) {
                mobAnswer = Game.diceRoll(1, 630);
                if (userInput <= 630) {
                    if (630 - userInput < 630 - mobAnswer) {
                        System.out.println(winningPhrase);
                        System.out.println("The answer was " + priceIsRightAnswers[4] + ".");
                        System.out.println("The mob's guess was " + mobAnswer + ".");
                        return true;
                    }
                    if (630 - userInput == 630 - mobAnswer) {
                        System.out.println(rareEqualsCase);
                        System.out.println("The answer was " + priceIsRightAnswers[4] + ".");
                        System.out.println("The mob's guess was " + mobAnswer + ".");
                        return false;
                    }
                    if (630 - userInput > 630 - mobAnswer) {
                        System.out.println(losingPhrase);
                        System.out.println("The answer was " + priceIsRightAnswers[4] + ".");
                        System.out.println("The mob's guess was " + mobAnswer + ".");
                        break;
                    }
                }
                else {
                    System.out.println(losingPhrase);
                    System.out.println("The answer was " + priceIsRightAnswers[4] + ".");
                    System.out.println("The mob's guess was " + mobAnswer + ".");
                    break;
                }
            }
            break;
        }
        return false;
    }

    // will start when we have our group coding sesh
    public static boolean blackJack() {

        // initializing variables for gameplay
        int characterSwitcher = 1;
        int playerHandValue = Game.diceRoll(1, 12);
        int hiddenCard;
        int dealerHandValue = hiddenCard = Game.diceRoll(1, 12);
        int drawnCard = 0;
        int[] drawnHand = new int[53];
        int i = 0;
        int cardOccurrences = 0;

        // announcing the rules
        System.out.println("And here's your host.... Steve Harvey!");
        System.out.println("Steve: You are now playing BlackJack. The goal is to get as close to 21 as possible without going over.");
        System.out.println("You may choose to hit (draw another card) or stay (stop drawing cards for the rest of the game).");
        System.out.println("The dealer (i.e. me) will always choose to hit unless the value of their hand is 17 or over.");
        System.out.println("By the way, I have 1 card whose value will not be revealed until the end.");
        System.out.println("There is some strategy involved. Use your brain, and good luck.");

        // loop for gameplay
        while (true) {
            if (characterSwitcher == 1) {
                System.out.println("Your current hand's value is: " + playerHandValue + ".");
                System.out.print("Would you like to hit or stand? (1 - hit, 2 - stand): ");
                // if player hits
                if (Game.inputValidation(2) == 1) {
                    while (true) {
                        drawnCard = Game.diceRoll(1, 10);
                        // checking drawnCard against an array of already drawn cards
                        for (int key : drawnHand) {
                            if (drawnCard == key) {
                                cardOccurrences++;
                            }
                        }
                        // checking to see if drawnCard occurs 4 times or more
                        if (cardOccurrences > 4) {
                            continue;
                        }
                        // only passing drawnCard into array if possible
                        drawnHand[i] = drawnCard;
                        i++;
                        characterSwitcher = 2;
                        playerHandValue += drawnCard;
                        break;
                    }
                    if (playerHandValue > 21) {
                        break;
                    }
                }
                else { //Player chose to stay
                    System.out.println("Dealer's current hand's value is: " + (dealerHandValue - hiddenCard) + ".");
                    while (true) {
                        drawnCard = Game.diceRoll(1, 10);
                        // checking drawnCard against array
                        for (int key : drawnHand) {
                            if (drawnCard == key) {
                                cardOccurrences++;
                            }
                        }
                        // checking if drawnCard has been pulled more than 4 times
                        if (cardOccurrences > 4) {
                            continue;
                        }
                        drawnHand[i] = drawnCard;
                        i++;
                        if (dealerHandValue < 17) {
                            dealerHandValue += drawnCard;
                        }
                        break;
                    }
                    break;
                }
                if (characterSwitcher == 2) {
                    // always hitting if dealerHandValue is less than 17
                    if (dealerHandValue < 17) {
                        while (true) {
                            drawnCard = Game.diceRoll(1, 10);
                            // checking drawnCard against an array of previously drawn cards
                            for (int key : drawnHand) {
                                if (drawnCard == key) {
                                    cardOccurrences++;
                                }
                            }
                            // checking if drawnCard occurs more than 4 times
                            if (cardOccurrences > 4) {
                                continue;
                            }
                            // passing drawnCard into array only if possible
                            drawnHand[i] = drawnCard;
                            i++;
                            characterSwitcher = 1;
                            dealerHandValue += drawnCard;
                            System.out.println("Dealer's current hand's value is: " + (dealerHandValue - hiddenCard) + ".");
                            break;
                        }
                        if (dealerHandValue > 21) {
                            break;
                        }
                    }
                    else if (dealerHandValue >= 17) {
                        System.out.println("The dealer must stand because the value of their hand is/over 17");
                        System.out.println("Your current hand's value is: " + playerHandValue + ".");
                        System.out.print("Would you like to hit or stand? (1 - hit, 2 - stand): ");
                        // asking if player would like to hit one more time cuz dealer can't
                        if (Game.inputValidation(2) == 1) {
                            while (true) {
                                drawnCard = Game.diceRoll(1, 10);
                                // checking drawnCard against an array of previoiusly drawn cards
                                for (int key : drawnHand) {
                                    if (drawnCard == key) {
                                        cardOccurrences++;
                                    }
                                }
                                // checking if drawnCard occurs more than 4 times
                                if (cardOccurrences > 4) {
                                    continue;
                                }
                                // passing drawnCard into array only if possible
                                drawnHand[i] = drawnCard;
                                i++;
                                playerHandValue += drawnCard;
                                break;
                            }
                            break;
                        }
                        else {
                            break;
                        }
                    }
                }
            }
        }
        if (dealerHandValue > 21) {
            System.out.println("Your hand value was " + playerHandValue + ".");
            System.out.println("The dealer's hand value was " + dealerHandValue + ". ");
            System.out.println("Steve: well, looks like I went over, and you won. I've been Steeve Harvey and I will see you later.");
            return true;
        }
        else if (playerHandValue > 21) {
            System.out.println("Your hand value was " + playerHandValue + ".");
            System.out.println("The dealer's hand value was " + dealerHandValue + ". ");
            System.out.println("Steve: dang man, I almost feel bad. No one wants to lose like that... \n" +
                    "Glad it ain't me though! See you next time!");
            return false;
        }
        else if (playerHandValue > dealerHandValue) {
            System.out.println("Your hand value was " + playerHandValue + ".");
            System.out.println("The dealer's hand value was " + dealerHandValue + ". ");
            System.out.println("Well, well. Looks like you beat me fair and square. Congratulations, and I will see you later.");
            return true;
        }
        else if (playerHandValue < dealerHandValue) {
            System.out.println("Your hand value was " + playerHandValue + ".");
            System.out.println("The dealer's hand value was " + dealerHandValue + ". ");
            System.out.println("Steeve: YES! Sorry, that was very rude of me. I'm just not use to winning in these games\n" +
                    "Until next time.");
            return false;
        }
        else {
            System.out.println("Your hand value was " + playerHandValue + ".");
            System.out.println("The dealer's hand value was " + dealerHandValue + ". ");
            System.out.println("Huh, looks like you won. I'm not sure how but you did it!\n" +
                    "I'm Steve Harvey and I will see you next time");
            return true;
        }
    }
}