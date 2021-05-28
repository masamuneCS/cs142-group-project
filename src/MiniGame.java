public class MiniGame {
    public static int triviaGame() {

        String[] name = new String[]{"Do doubles or ints have decimals?",
                "What year did America gain its independence?",
                "What do you have to put at the top of your code when utilizing a Scanner?", " ", " "};
        int i = Game.diceRoll(name.length, 5);
        String question = name[i];
        System.out.println(question);

        if (i == 1) {
            System.out.println("Choose your answer; \n" + "1) Doubles \n" + "2) Ints \n" + "3) Both\n" + "4) Neither");
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
                        continue;
                    }
                }

            }
        }
        if (i == 2) {
            System.out.println("Choose your answer; \n" + "1) 1492 \n" + "2) 1861 \n" + "3) 1776\n" + "4) 2021");
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
                        continue;
                    }
                }

            }
        }
        if (i == 3) {
            System.out.println("Choose your answer; \n" + "1) Your name \n" + "2) An import statement \n" +
                    "3) Class name\n" + "4) Main method1");
            System.out.print("Enter your answer here; ");
            while (true) {
                switch (Game.userInput.nextLine()) {
                    case "1": {
                        System.out.println("I can't with you right now...");
                        break;
                    }
                    case "2": {
                        System.out.println("Yes! Finally!  A half-decently smart person.");
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
                        continue;
                    }
                }

            }
        }
        return 1;
    }
}