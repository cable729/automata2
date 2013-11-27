package automata.jares;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanny = new Scanner(System.in);
        int rules = scanny.nextInt();
        scanny.nextLine();

        String variables = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String terminals = "abcdefghijklmnopqrstuvwxyz_!";
        // ! is the empty string

        ContextFreeGrammar g = new ContextFreeGrammar(variables, terminals);
        for (int i = 0; i < rules; i++) {
            String input = scanny.nextLine();
            char var = input.charAt(0);
            String rule = input.substring(3);//.replaceAll("!", "");
            g.productions.add(new ProductionRule(var, rule));
        }
        g.removeEmptyStrings();

        // Test
        while (scanny.hasNext()) {
            String line = scanny.nextLine();
            if (line.equals("!")) line = "";
            String output = g.doesAccept(line) ? "yes" : "no";
            System.out.println(output);
        }
    }
}