package automata.jares;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanny = new Scanner(System.in);
        int rules = scanny.nextInt();

        ContextFreeGrammar g = new ContextFreeGrammar();
        for (int i = 0; i < rules; i++){
            String input = scanny.nextLine();
            g.Productions.add(new ProductionRule(input.charAt(0), input.substring(3)));
        }

        // Convert CFG

        // Test PDA

        // Output yes/no
    }
}