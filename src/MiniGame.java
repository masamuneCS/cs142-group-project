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
            System.out.println("Choose your answer: \n" + "1) Doubles \n" + "2) Ints \n" + "3) Both\n" + "4) Neither");
            System.out.print("Enter your answer here; ");
            while (true) {
                switch (Game.userInput.nextLine()) {
                    case "1": {
                        System.out.println("Correct!");
                        return true;
                    }
                    case "2": {
                        System.out.println("Wait... you actually thought an integer had decimals? It's a whole number!");
                        break;
                    }
                    case "3": {
                        System.out.println("Haha, nice try...");
                        break;
                    }
                    case "4": {
                        System.out.println("Haha, nice try...");
                        break;
                    }
                    default: {
                        System.out.println("Enter 1, 2, 3 or 4 to choose.");
                    }
                }

            }
        }
        if (i == 2) {
            System.out.println("Choose your answer: \n" + "1) 1492 \n" + "2) 1861 \n" + "3) 1776\n" + "4) 2021");
            System.out.print("Enter your answer here; ");
            while (true) {
                switch (Game.userInput.nextLine()) {
                    case "1": {
                        System.out.println("Bruh... Columbus... come on now!");
                        break;
                    }
                    case "2": {
                        System.out.println("Haha, you stupid...");
                        break;
                    }
                    case "3": {
                        System.out.println("Oh my gawd, well look atchu, aren't you just the smartest person in the room");
                        return true;
                    }
                    case "4": {
                        System.out.println("Haha, nice try...");
                        break;
                    }
                    default: {
                        System.out.println("Enter 1, 2, 3 or 4 to choose.");
                    }
                }

            }
        }
        if (i == 3) {
            System.out.println("Choose your answer: \n" + "1) Your name \n" + "2) An import statement \n" +
                    "3) Class name\n" + "4) Main method");
            System.out.print("Enter your answer here; ");
            while (true) {
                switch (Game.userInput.nextLine()) {
                    case "1": {
                        System.out.println("I can't with you right now...");
                        break;
                    }
                    case "2": {
                        System.out.println("Yes! Finally! A half-decently smart person.");
                        return true;
                    }
                    case "3": {
                        System.out.println("I'm done....");
                        break;
                    }
                    case "4": {
                        System.out.println("WHY ARE YOU EVEN HERE RIGHT NOW");
                        break;
                    }
                    default: {
                        System.out.println("Enter 1, 2, 3 or 4 to choose.");
                    }
                }
            }
        }
        if (i == 4) {
            System.out.println("Choose your answer: \n" + "1) One compares things and one performs loops \n" +
                    "2) Nothing, they're the same \n" +
                    "3) Really just looks since you can rewrite a while loop to resemble a for loop and vice versa\n" +
                    "4) One's a type and one's a method call");
            System.out.print("Enter your answer here; ");
            while (true) {
                switch (Game.userInput.nextLine()) {
                    case "1": {
                        System.out.println("really.... REALLY?!?!");
                        break;
                    }
                    case "2": {
                        System.out.println("Come on now! You can do better than THAT");
                        break;
                    }
                    case "3": {
                        System.out.println("DING DING DING, we have a winner!");
                        return true;
                    }
                    case "4": {
                        System.out.println("Just leave bruh");
                        break;
                    }
                    default: {
                        System.out.println("Enter 1, 2, 3 or 4 to choose.");
                    }
                }
            }
        }
        if (i == 5) {
            System.out.println("Choose your answer: \n" + "1) Well duh \n" +
                    "2) Yes, you need several \n" +
                    "3) Yes, but just 1\n" +
                    "4) Well not necessarily because there's a default constructor");
            System.out.print("Enter your answer here; ");
            while (true) {
                switch (Game.userInput.nextLine()) {
                    case "1": {
                        System.out.println("a;sdlfkjie");
                        break;
                    }
                    case "2": {
                        System.out.println("Nice try");
                        break;
                    }
                    case "3": {
                        System.out.println("I can't believe they even allowed you to play");
                        break;
                    }
                    case "4": {
                        System.out.println("Yes... yEs... YES!!!");
                        return true;
                    }
                    default: {
                        System.out.println("Enter 1, 2, 3 or 4 to choose.");
                    }
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

        if (j == 1) {
           int mobAnswer = Game.diceRoll(1, 215000);
            // initializing variables
           int userInput = 0;
           // loop to validate user's input
            while (true) {
                System.out.print("Please enter a price (no decimals and disregarding the $ sign): ");
                String inputChecker = Game.userInput.nextLine();
                // seeing if string is an int and if string contains just one int
                try {
                    userInput = Integer.parseInt(inputChecker);
                    if ((userInput >= 1 && userInput <= 215000)) {
                        if (215000 - userInput < 215000 - mobAnswer) {
                            return true;
                        }
                        if (215000 - userInput == 215000 - mobAnswer) {
                            System.out.println("Your answer and the mob's answer were equally close to the real price. Please enter another answer.");
                            mobAnswer = Game.diceRoll(1, 215000);
                            continue;
                        }
                        if (215000 - userInput > 215000 - mobAnswer) {
                            break;
                        }
                    }
                    // telling user that their input was invalid because their input was out of bounds
                    if (userInput < 1) {
                        System.out.println("Your answer is invalid. Please try again.");
                    }
                    if (userInput > 215000) {
                        System.out.println("Sometimes ya win, and sometimes ya lose. This time, ya lost big time.");
                        break;
                    }
                }
                // telling user that their input was invalid because their input didn't meet 1 of the 2 requirements mentioned above
                catch (NumberFormatException e) {
                    System.out.println("That was not a valid answer! Please try again.");
                    continue;
                }
            }
        }
        if (j == 2) {
            int mobAnswer = Game.diceRoll(1, 165000000);
            // initializing variables
            int userInput = 0;
            // loop to validate user's input
            while (true) {
                System.out.print("Please enter a price (no decimals and disregarding the $ sign): ");
                String inputChecker = Game.userInput.nextLine();
                // seeing if string is an int and if string contains just one int
                try {
                    userInput = Integer.parseInt(inputChecker);
                    if ((userInput >= 1 && userInput <= 165000000)) {
                        if (165000000 - userInput < 165000000 - mobAnswer) {
                            return true;
                        }
                        if (165000000 - userInput == 165000000 - mobAnswer) {
                            System.out.println("Your answer and the mob's answer were equally close to the real price. Please enter another answer.");
                            continue;
                        }
                        if (165000000 - userInput > 165000000 - mobAnswer){
                            break;
                        }
                    }
                    // telling user that their input was invalid because their input was out of bounds
                    if (userInput < 1) {
                        System.out.println("Your answer is invalid. Please try again.");
                    }
                    if (userInput > 165000000) {
                        System.out.println("Sometimes ya win, and sometimes ya lose. This time, ya lost big time.");
                        break;
                    }
                }
                // telling user that their input was invalid because their input didn't meet 1 of the 2 requirements mentioned above
                catch (NumberFormatException e) {
                    System.out.println("That was not a valid answer. Please try again.");
                    continue;
                }
            }
        }
        if (j == 3) {
            int mobAnswer = Game.diceRoll(1, 15);
            // initializing variables
            int userInput = 0;
            // loop to validate user's input
            while (true) {
                System.out.print("Please enter a price (no decimals and disregarding the $ sign): ");
                String inputChecker = Game.userInput.nextLine();
                // seeing if string is an int and if string contains just one int
                try {
                    userInput = Integer.parseInt(inputChecker);
                    if ((userInput >= 1 && userInput <= 15)) {
                        if (15 - userInput < 15 - mobAnswer) {
                            return true;
                        }
                        if (15 - userInput == 15 - mobAnswer) {
                            System.out.println("Your answer and the mob's answer were equal. Please enter another answer.");
                            continue;
                        }
                        if (15 - userInput > 15 - mobAnswer) {
                            break;
                        }
                    }
                    // telling user that their input was invalid because their input was out of bounds
                    if (userInput < 1) {
                        System.out.println("Your answer is invalid. Please try again.");
                    }
                    if (userInput > 15) {
                        System.out.println("Sometimes ya win, and sometimes ya lose. This time, ya lost big time.");
                        break;
                    }
                }
                // telling user that their input was invalid because their input didn't meet 1 of the 2 requirements mentioned above
                catch (NumberFormatException e) {
                    System.out.println("That was not a valid answer. Please try again.");
                    continue;
                }
            }
        }
        if (j == 4) {
            int mobAnswer = Game.diceRoll(1, 1100);
            // initializing variables
            int userInput = 0;
            // loop to validate user's input
            while (true) {
                System.out.print("Please enter a price (no decimals and disregarding the $ sign): ");
                String inputChecker = Game.userInput.nextLine();
                // seeing if string is an int and if string contains just one int
                try {
                    userInput = Integer.parseInt(inputChecker);
                    if ((userInput >= 1 && userInput <= 1100)) {
                        if (1100 - userInput < 1100 - mobAnswer) {
                            return true;
                        }
                        if (1100 - userInput == 1100 - mobAnswer) {
                            System.out.println("Your answer and the mob's answer were equal. Please enter another answer.");
                            continue;
                        }
                        if (1100 - userInput > 1100 - mobAnswer) {
                            break;
                        }
                    }
                    // telling user that their input was invalid because their input was out of bounds
                    if (userInput < 1) {
                        System.out.println("Your answer is invalid. Please try again.");
                    }
                    if (userInput > 1100) {
                        System.out.println("Sometimes ya win, and sometimes ya lose. This time, ya lost big time.");
                        break;
                    }
                }
                // telling user that their input was invalid because their input didn't meet 1 of the 2 requirements mentioned above
                catch (NumberFormatException e) {
                    System.out.println("That was not a valid answer. Please try again.");
                    continue;
                }
            }
        }
        if (j == 5) {
            int mobAnswer = Game.diceRoll(1, 630);
            int userInput = 0;
            // validating player's input
            while (true) {
                System.out.print("Please enter a price (no decimals and disregarding the $ sign): ");
                String inputChecker = Game.userInput.nextLine();
                // seeing if input is an int and if input is more than just one int
                try {
                    userInput = Integer.parseInt(inputChecker);
                    if ((userInput >= 1 && userInput <= 630)) {
                        if (630 - userInput < 630 - mobAnswer) {
                            return true;
                        }
                        if (630 - userInput == 630 - mobAnswer) {
                            System.out.println("Your answer and the mob's answer were equal. Please enter another answer.");
                            continue;
                        }
                        if (630 - userInput > 630 - mobAnswer) {
                            break;
                        }
                    }
                    // telling user that their input was invalid because their input was out of bounds
                    if (userInput < 1) {
                        System.out.println("Your answer is invalid. Please try again.");
                    }
                    if (userInput > 630) {
                        System.out.println("Sometimes ya win, and sometimes ya lose. This time, ya lost big time.");
                        break;
                    }
                }
                // telling user that their input was invalid because their input didn't meet 1 of the 2 requirements mentioned above
                catch (NumberFormatException e) {
                    System.out.println("That was not a valid answer. Please try again.");
                    continue;
                }
            }
        }
        return false;
    }

    // will start when we have our group coding sesh
    public static Item blackJack () {
        return Item.healing3Potion();
    }
}