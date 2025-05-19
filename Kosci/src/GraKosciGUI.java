/**
 * Klasa GraKosci
 * @author Jakub Czepinski 5pp
 */


import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

class GraKosci {
    Random random = new Random();

    public int calculatePoints(ArrayList<Integer> diceResults) {
        int score = 0;
        int[] occurrences = new int[7];

        for (int result : diceResults) {
            occurrences[result]++;
        }

        for (int i = 1; i <= 6; i++) {
            if (occurrences[i] > 1) {
                score += i * occurrences[i];
            }
        }
        return score;
    }

    public ArrayList<Integer> rollDice(int numberOfDice) {
        ArrayList<Integer> diceResults = new ArrayList<>();
        for (int i = 0; i < numberOfDice; i++) {
            int diceValue = random.nextInt(1, 7);
            diceResults.add(diceValue);
            System.out.println("Kostka " + (i + 1) + ": " + diceValue);
        }
        return diceResults;
    }

    public static void main(String[] args) {
        GraKosci diceGame = new GraKosci();
        Scanner scanner = new Scanner(System.in);
        String playAgain;
        int numberOfDice;

        System.out.println("Ile kostek chcesz rzucić?(3 - 10)");
        numberOfDice = scanner.nextInt();
        while (numberOfDice < 3 || numberOfDice > 10) {
            System.out.println("Ile kostek chcesz rzucić?(3 - 10)");
            numberOfDice = scanner.nextInt();
        }

        do {
            ArrayList<Integer> diceResults = diceGame.rollDice(numberOfDice);
            System.out.println("Liczba uzyskanych punktów: " + diceGame.calculatePoints(diceResults));
            System.out.println("Jeszcze raz? (t/n)");
            playAgain = scanner.next();
        } while (Objects.equals(playAgain, "t"));
    }
}
