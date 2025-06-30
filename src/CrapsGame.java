import java.util.Scanner;

public class CrapsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            // FORCE Case iii: first roll is 6
            int die1 = 3;
            int die2 = 3;
            int sum = die1 + die2;

            System.out.println("First Roll: " + die1 + " + " + die2 + " = " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lose.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win.");
            } else {
                int point = sum;
                System.out.println("Point is set to: " + point);

                boolean rolling = true;
                while (rolling) {
                    // FORCE second roll to 5 (not 6 or 7)
                    die1 = 2;
                    die2 = 3;
                    sum = die1 + die2;

                    System.out.println("Rolling for point: " + die1 + " + " + die2 + " = " + sum);

                    if (sum == point) {
                        System.out.println("Made the point! You win.");
                        rolling = false;
                    } else if (sum == 7) {
                        System.out.println("Got a seven! You lose.");
                        rolling = false;
                    } else {
                        System.out.println("Trying for point...");
                        rolling = false; // stop here to just show 1 "Trying for point"
                    }
                }
            }

            System.out.print("Do you want to play again? (y/n): ");
            String input = scanner.next();
            playAgain = input.equalsIgnoreCase("y");
        }

        System.out.println("Game Over. Thanks for playing.");
    }
}