public class MiniGame {
    public static boolean triviaGame() {

        String[] triviaGameQuestions = new String[]{"Do doubles or ints have decimals?",
                "What year did America gain its independence?",
                "What do you have to put at the top of your code when utilizing a Scanner?",
                "What's the difference between while loops and for loops?",
                "Do you have to create a constructor when coding an object class?"};
        int i = Game.diceRoll(1, 5);
        String question = triviaGameQuestions[i];
        System.out.println(question);

        if (i == 1) {
            System.out.println("""
                    Choose your answer:\s
                    1) Doubles\s
                    2) Ints\s
                    3) Both
                    4) Neither""");
            System.out.print("Enter your answer here; ");
            while (true) {
                switch (Game.userInput.nextLine()) {
                    case "1" -> {
                        System.out.println("Correct!");
                        return true;
                    }
                    case "2" -> System.out.println("Wait... you actually thought an integer had decimals? It's a whole number!");
                    case "3" -> System.out.println("Haha, nice try...");
                    case "4" -> System.out.println("Haha, you're funny...");
                    default -> System.out.println("Enter 1, 2, 3 or 4 to choose.");
                }

            }
        }
        if (i == 2) {
            System.out.println("""
                    Choose your answer:\s
                    1) 1492\s
                    2) 1861\s
                    3) 1776
                    4) 2021""");
            System.out.print("Enter your answer here; ");
            while (true) {
                switch (Game.userInput.nextLine()) {
                    case "1" -> System.out.println("Bruh... Columbus... come on now!");
                    case "2" -> System.out.println("Haha, you stupid...");
                    case "3" -> {
                        System.out.println("Oh my gawd, well look atchu, aren't you just the smartest person in the room");
                        return true;
                    }
                    case "4" -> System.out.println("Haha, nice try...");
                    default -> System.out.println("Enter 1, 2, 3 or 4 to choose.");
                }

            }
        }
        if (i == 3) {
            System.out.println("""
                    Choose your answer:\s
                    1) Your name\s
                    2) An import statement\s
                    3) Class name
                    4) Main method""");
            System.out.print("Enter your answer here; ");
            while (true) {
                switch (Game.userInput.nextLine()) {
                    case "1" -> System.out.println("I can't with you right now...");
                    case "2" -> {
                        System.out.println("Yes! Finally! A half-decently smart person.");
                        return true;
                    }
                    case "3" -> System.out.println("I'm done....");
                    case "4" -> System.out.println("WHY ARE YOU EVEN HERE RIGHT NOW");
                    default -> System.out.println("Enter 1, 2, 3 or 4 to choose.");
                }
            }
        }
        if (i == 4) {
            System.out.println("""
                    Choose your answer:\s
                    1) One compares things and one performs loops\s
                    2) Nothing, they're the same\s
                    3) Really just looks since you can rewrite a while loop to resemble a for loop and vice versa
                    4) One's a type and one's a method call""");
            System.out.print("Enter your answer here; ");
            while (true) {
                switch (Game.userInput.nextLine()) {
                    case "1" -> System.out.println("really.... REALLY?!?!");
                    case "2" -> System.out.println("Come on now! You can do better than THAT");
                    case "3" -> {
                        System.out.println("DING DING DING, we have a winner!");
                        return true;
                    }
                    case "4" -> System.out.println("Just leave bruh");
                    default -> System.out.println("Enter 1, 2, 3 or 4 to choose.");
                }
            }
        }
        if (i == 5) {
            System.out.println("""
                    Choose your answer:\s
                    1) Well duh\s
                    2) Yes, you need several\s
                    3) Yes, but just 1
                    4) Well not necessarily because there's a default constructor""");
            System.out.print("Enter your answer here; ");
            while (true) {
                switch (Game.userInput.nextLine()) {
                    case "1" -> System.out.println("a;sdlfkjie");
                    case "2" -> System.out.println("Nice try");
                    case "3" -> System.out.println("I can't believe they even allowed you to play");
                    case "4" -> {
                        System.out.println("Yes... yEs... YES!!!");
                        return true;
                    }
                    default -> System.out.println("Enter 1, 2, 3 or 4 to choose.");
                }
            }
        }
        return false;
    }

    public static boolean priceIsRightGame() {

        String[] priceIsRightQuestions = new String[]{"How much is the cheapest Ferrari on the market right now?",
                "How much does the most expensive house in Beverly Hills cost?",
                "How much does a bag of rice cost?",
                "How much does the cheapest Louis Vuitton bag cost?",
                "How much does a Gucci bag cost?"};
        int j = Game.diceRoll(1, 5);
        String printOut = priceIsRightQuestions[j];
        System.out.println(printOut);
        String priceGamePrompt = "Please enter a price (no decimals, commas, or $ sign): ";
        String rareEqualsCase = "Your answer and the mob's answer were equally close to the real price. Please enter another answer.";
        String losingPhrase = "Sometimes ya win, and sometimes ya lose. This time, ya lost big time.";
        String freePhrase = "Nothin' in life is free bruh.";
        String negativePhrase = "What? You think they're gonna pay YOU to buy their product???";
        String invalidInput = "That was not a valid answer. Please try again.";

        if (j == 1) {
           int mobAnswer = Game.diceRoll(1, 215000);
            // initializing variables
           int userInput;
           // loop to validate user's input
            while (true) {
                System.out.print(priceGamePrompt);
                String inputHolder = Game.userInput.nextLine();
                // seeing if string is an int and if string contains just one int
                try {
                    userInput = Integer.parseInt(inputHolder);
                    if ((userInput >= 1 && userInput <= 215000)) {
                        if (215000 - userInput < 215000 - mobAnswer) {
                            return true;
                        }
                        if (215000 - userInput == 215000 - mobAnswer) {
                            System.out.println(rareEqualsCase);
                            mobAnswer = Game.diceRoll(1, 215000);
                            continue;
                        }
                        if (215000 - userInput > 215000 - mobAnswer) {
                            System.out.println(losingPhrase);
                            break;
                        }
                    }
                    // telling user that their input was invalid because their input was out of bounds
                    if (userInput == 0) {
                        System.out.println(freePhrase);
                        continue;
                    }
                    if (userInput < 0) {
                        System.out.println(negativePhrase);
                        continue;
                    }
                    if (userInput > 215000) {
                        System.out.println(losingPhrase);
                        break;
                    }
                }
                // telling user that their input was invalid because their input didn't meet 1 of the 2 requirements mentioned above
                catch (NumberFormatException e) {
                    System.out.println(invalidInput);
                }
            }
        }
        if (j == 2) {
            int mobAnswer = Game.diceRoll(1, 165000000);
            // initializing variables
            int userInput;
            // loop to validate user's input
            while (true) {
                System.out.print(priceGamePrompt);
                String inputChecker = Game.userInput.nextLine();
                // seeing if string is an int and if string contains just one int
                try {
                    userInput = Integer.parseInt(inputChecker);
                    if ((userInput >= 1 && userInput <= 165000000)) {
                        if (165000000 - userInput < 165000000 - mobAnswer) {
                            return true;
                        }
                        if (165000000 - userInput == 165000000 - mobAnswer) {
                            System.out.println(rareEqualsCase);
                            continue;
                        }
                        if (165000000 - userInput > 165000000 - mobAnswer){
                            System.out.println(losingPhrase);
                            break;
                        }
                    }
                    // telling user that their input was invalid because their input was out of bounds
                    if (userInput == 0) {
                        System.out.println(freePhrase);
                        continue;
                    }
                    if (userInput < 0) {
                        System.out.println(negativePhrase);
                        continue;
                    }
                    if (userInput > 165000000) {
                        System.out.println(losingPhrase);
                        break;
                    }
                }
                // telling user that their input was invalid because their input didn't meet 1 of the 2 requirements mentioned above
                catch (NumberFormatException e) {
                    System.out.println(invalidInput);
                }
            }
        }
        if (j == 3) {
            int mobAnswer = Game.diceRoll(1, 15);
            // initializing variables
            int userInput;
            // loop to validate user's input
            while (true) {
                System.out.print(priceGamePrompt);
                String inputChecker = Game.userInput.nextLine();
                // seeing if string is an int and if string contains just one int
                try {
                    userInput = Integer.parseInt(inputChecker);
                    if ((userInput >= 1 && userInput <= 15)) {
                        if (15 - userInput < 15 - mobAnswer) {
                            return true;
                        }
                        if (15 - userInput == 15 - mobAnswer) {
                            System.out.println(rareEqualsCase);
                            continue;
                        }
                        if (15 - userInput > 15 - mobAnswer) {
                            System.out.println(losingPhrase);
                            break;
                        }
                    }
                    // telling user that their input was invalid because their input was out of bounds
                    if (userInput == 0) {
                        System.out.println(freePhrase);
                        continue;
                    }
                    if (userInput < 0) {
                        System.out.println(negativePhrase);
                        continue;
                    }
                    if (userInput > 15) {
                        System.out.println(losingPhrase);
                        break;
                    }
                }
                // telling user that their input was invalid because their input didn't meet 1 of the 2 requirements mentioned above
                catch (NumberFormatException e) {
                    System.out.println(invalidInput);
                }
            }
        }
        if (j == 4) {
            int mobAnswer = Game.diceRoll(1, 1100);
            // initializing variables
            int userInput;
            // loop to validate user's input
            while (true) {
                System.out.print(priceGamePrompt);
                String inputChecker = Game.userInput.nextLine();
                // seeing if string is an int and if string contains just one int
                try {
                    userInput = Integer.parseInt(inputChecker);
                    if ((userInput >= 1 && userInput <= 1100)) {
                        if (1100 - userInput < 1100 - mobAnswer) {
                            return true;
                        }
                        if (1100 - userInput == 1100 - mobAnswer) {
                            System.out.println(rareEqualsCase);
                            continue;
                        }
                        if (1100 - userInput > 1100 - mobAnswer) {
                            System.out.println(losingPhrase);
                            break;
                        }
                    }
                    // telling user that their input was invalid because their input was out of bounds
                    if (userInput == 0) {
                        System.out.println(freePhrase);
                        continue;
                    }
                    if (userInput < 0) {
                        System.out.println(negativePhrase);
                        continue;
                    }
                    if (userInput > 1100) {
                        System.out.println(losingPhrase);
                        break;
                    }
                }
                // telling user that their input was invalid because their input didn't meet 1 of the 2 requirements mentioned above
                catch (NumberFormatException e) {
                    System.out.println(invalidInput);
                }
            }
        }
        if (j == 5) {
            int mobAnswer = Game.diceRoll(1, 630);
            int userInput;
            // validating player's input
            while (true) {
                System.out.print(priceGamePrompt);
                String inputChecker = Game.userInput.nextLine();
                // seeing if input is an int and if input is more than just one int
                try {
                    userInput = Integer.parseInt(inputChecker);
                    if ((userInput >= 1 && userInput <= 630)) {
                        if (630 - userInput < 630 - mobAnswer) {
                            return true;
                        }
                        if (630 - userInput == 630 - mobAnswer) {
                            System.out.println(rareEqualsCase);
                            continue;
                        }
                        if (630 - userInput > 630 - mobAnswer) {
                            System.out.println(losingPhrase);
                            break;
                        }
                    }
                    // telling user that their input was invalid because their input was out of bounds
                    if (userInput == 0) {
                        System.out.println(freePhrase);
                        continue;
                    }
                    if (userInput < 0) {
                        System.out.println(negativePhrase);
                        continue;
                    }
                    if (userInput > 630) {
                        System.out.println(losingPhrase);
                        break;
                    }
                }
                // telling user that their input was invalid because their input didn't meet 1 of the 2 requirements mentioned above
                catch (NumberFormatException e) {
                    System.out.println(invalidInput);
                }
            }
        }
        return false;
    }

    // will start when we have our group coding sesh
    public static boolean blackJack () {
        return false;
    }
}