package automata.jares;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanny = new Scanner(System.in);
        int rules = scanny.nextInt();

        String variables = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String terminals = "abcdefghijklmnopqrstuvwxyz_";
        // input may contain terminals union "!" (the empty string)

        ContextFreeGrammar g = new ContextFreeGrammar(variables, terminals);
        for (int i = 0; i < rules; i++) {
            String input = scanny.nextLine();
            g.productions.add(new ProductionRule(input.charAt(0), input.substring(3)));
        }

        // Test
        while (scanny.hasNext()){
            String line = scanny.nextLine();
            String output = g.doesAccept(line) ? "yes" : "no";
            System.out.println(output);
        }
    }
}