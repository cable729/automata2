package automata.jares;

import java.util.ArrayList;

public class ContextFreeGrammar {
    public final ArrayList<ProductionRule> productions;
    public final String variables;
    public final String terminals;

    public ContextFreeGrammar(String variables, String terminals) {
        this.variables = variables;
        this.terminals = terminals;
        productions = new ArrayList<ProductionRule>();
    }

    // Using algorithm http://en.wikipedia.org/wiki/Earley_parser
    public boolean doesAccept(String string) {
        Chart chart = new Chart();
        chart.add(new StateSet());
        chart.get(0).add(new State(productions.get(0)));

        for (int i = 0; i < string.length(); i++) {
            for (State s : chart.get(i)) {

            }
        }

        return false;
    }

    // 1. Find states in S(k) where the next symbol to be matched is a variable
    // 2. Add the state defined by that variable with the dot position at 0 to S(k)
    private void predict() {

    }

    // 1. Find states in S(k) where the next symbol to be matched is the same as the next in the string
    // 2. Add the state with dot position incremented to S(k+1)
    private void scan() {

    }

    // 1. Find states in S(k) where the dot position is at the end of the string
    // 2. For each found state (with origin j and rule defined for variable v):
    //      a. Find states in S(j) whose symbol after the dot position is v
    //      b. Add each found state to S(k) with their dot position incremented
    private void complete() {

    }
}
