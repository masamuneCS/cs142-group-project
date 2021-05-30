public class MiniGame {
    public static Item triviaGame() {

        String[] triviaGameQuestions = new String[]{"Do doubles or ints have decimals?",
                "What year did America gain its independence?",
                "What do you have to put at the top of your code when utilizing a Scanner?",
                "What's the difference between while loops and for loops?",
                "Do you have to create a constructor when coding an object class?"};
        int i = Game.diceRoll(triviaGameQuestions.length, 5);
        String question = triviaGameQuestions[i];
        System.out.println(question);

        if (i == 1) {
            System.out.println("Choose your answer: \n" + "1) Doubles \n" + "2) Ints \n" + "3) Both\n" + "4) Neither");
            System.out.print("Enter your answer here; ");
            while (true) {
                switch (Game.userInput.nextLine()) {
                    case "1": {
                        System.out.println("Correct!");
                        break;
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
                        break;
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
                        break;
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
                        break;
                    }
                    default: {
                        System.out.println("Enter 1, 2, 3 or 4 to choose.");
                    }
                }
            }
        }
            return Item.healing3Potion();
    }

    public static Item priceIsRightGame() {

        String[] priceIsRightQuestions = new String[]{"How much is the cheapest Ferrari on the market right now?",
                "How much does the most expensive house in Beverly Hills cost?",
                "How much does a bag of rice cost?",
                "How much does the cheapest Louis Vuitton bag cost?",
                "How much does a Gucci bag cost?"};
        int j = Game.diceRoll(priceIsRightQuestions.length, 5);
        String printOut = priceIsRightQuestions[j];
        System.out.println(printOut);

        if (j == 1) {
            System.out.println("Choose your answer: \n" + "1) $215,000 \n" + "2) $300,500 \n" + "3) $150,000\n"
                    + "4) $350,850");
            System.out.print("Enter your answer here; ");
            while (true) {
                switch (Game.userInput.nextLine()) {
                    case "1": {
                        System.out.println("Ok, ok, I see you ballin' out here with that supercar knowledge");
                        break;
                    }
                    case "2": {
                        System.out.println("Looks like someone ain't in the market for a 'rari...");
                        break;
                    }
                    case "3": {
                        System.out.println("Haha you're funny");
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
        if (j == 2) {
            System.out.println("Choose your answer: \n" + "1) $75 million \n" + "2) $165 million \n" + "3) $200 million\n"
                    + "4) $120 million");
            System.out.print("Enter your answer here; ");
            while (true) {
                switch (Game.userInput.nextLine()) {
                    case "1": {
                        System.out.println("Have you ever seen Bling Empire? Actually wait, I know the answer to that...");
                    }
                    case "2": {
                        System.out.println("Heck yeah! Let's go baby!");
                        break;
                    }
                    case "3": {
                        System.out.println("Oh my gawd, why are you even here");
                        break;
                    }
                    case "4": {
                        System.out.println("~shake my head~");
                        break;
                    }
                    default: {
                        System.out.println("Enter 1, 2, 3 or 4 to choose.");
                    }
                }

            }
        }
        if (j == 3) {
            System.out.println("Choose your answer: \n" + "1) $5.99 \n" + "2) $12.99 \n" +
                    "3) $9.99\n" + "4) $14.99");
            System.out.print("Enter your answer here; ");
            while (true) {
                switch (Game.userInput.nextLine()) {
                    case "1": {
                        System.out.println("Uncultured swine");
                        break;
                    }
                    case "2": {
                        System.out.println("I'm personally offended for all my Asian borthers and sisters out there");
                        break;
                    }
                    case "3": {
                        System.out.println("I'm done....");
                        break;
                    }
                    case "4": {
                        System.out.println("Well aren't you just a worldly human being");
                        break;
                    }
                    default: {
                        System.out.println("Enter 1, 2, 3 or 4 to choose.");
                    }
                }
            }
        }
        if (j == 4) {
            System.out.println("Choose your answer: \n" + "1) $2,000 \n" + "2) $1,500 \n" + "3) $1,100\n" +
                    "4) $2,500");
            System.out.print("Enter your answer here; ");
            while (true) {
                switch (Game.userInput.nextLine()) {
                    case "1": {
                        System.out.println("~drops cards and walks out~");
                        break;
                    }
                    case "2": {
                        System.out.println("Why did I say yes to this job");
                        break;
                    }
                    case "3": {
                        System.out.println("You just got lucky");
                        break;
                    }
                    case "4": {
                        System.out.println("~curses under breath~");
                        break;
                    }
                    default: {
                        System.out.println("Enter 1, 2, 3 or 4 to choose.");
                    }
                }
            }
        }
        if (j == 5) {
            System.out.println("Choose your answer: \n" + "1) $500 \n" + "2) $630 \n" + "3) $1,000\n" +
                    "4) $750");
            System.out.print("Enter your answer here; ");
            while (true) {
                switch (Game.userInput.nextLine()) {
                    case "1": {
                        System.out.println("five hunnid dollas....  FIVE HUNNID DOLLAS??? ARE YOU KIDDING ME");
                        break;
                    }
                    case "2": {
                        System.out.println("Now this is why you're my favorite contestant");
                        break;
                    }
                    case "3": {
                        System.out.println("Good guess... but NOPE");
                        break;
                    }
                    case "4": {
                        System.out.println("~drops dead on floor~ OMG!! Your stupidity killed Steve!!");
                        break;
                    }
                    default: {
                        System.out.println("Enter 1, 2, 3 or 4 to choose.");
                    }
                }
            }
        }
        return Item.mobDamageReducerSpell();
    }

    // will start when we have our group coding sesh
    public static Item blackJack () {
        return Item.healing3Potion();
    }
}