package de.effectivetrainings;

import java.util.Scanner;

public class CalculatorApp {

    public static void main(String[] args) {
        Calculator calc = initializeCalculator();

        System.out.println(splash());
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        while (scanner.hasNext()) {
            try {
                String input = scanner.next();
                InputMatcher inputMatcher = new InputMatcher(input);
                System.out.println(calc.calculate(inputMatcher.getOperation(),
                        inputMatcher.getOperandA(), inputMatcher.getOperandB()));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error - cannot calculate because : " + e.getMessage());
            }
        }

        scanner.close();
    }

    /**
     * initializes the calculator and registers operations necessary.
     */
    private static Calculator initializeCalculator() {
        Calculator calculator = new Calculator();
        //
        // register operations here
        //
        return calculator;
    }

    private static String splash() {
        return "__________  _____   _____                __   .__                         \n" +
                "\\_   _____/_/ ____\\_/ ____\\ ____   ____ _/  |_ |__|___  __  ____           \n" +
                " |    __)_ \\   __\\ \\   __\\_/ __ \\_/ ___\\\\   __\\|  |\\  \\/ /_/ __ \\   ______ \n" +
                " |        \\ |  |    |  |  \\  ___/\\  \\___ |  |  |  | \\   / \\  ___/  /_____/ \n" +
                "/_______  / |__|    |__|   \\___  >\\___  >|__|  |__|  \\_/   \\___  >         \n" +
                "        \\/                     \\/     \\/                       \\/          \n" +
                "___________                .__         .__                        \n" +
                "\\__    ___/_______ _____   |__|  ____  |__|  ____    ____   ______\n" +
                "  |    |   \\_  __ \\\\__  \\  |  | /    \\ |  | /    \\  / ___\\ /  ___/\n" +
                "  |    |    |  | \\/ / __ \\_|  ||   |  \\|  ||   |  \\/ /_/  >\\___ \\ \n" +
                "  |____|    |__|   (____  /|__||___|  /|__||___|  /\\___  //____  >\n" +
                "                        \\/          \\/          \\//_____/      \\/ \n";
    }

}
