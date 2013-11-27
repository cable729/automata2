package automata.jares;

import java.util.ArrayList;
import java.util.HashSet;

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
        for (int i = 0; i <= string.length(); i++) {
            chart.add(new StateSet());
        }
        chart.get(0).add(new State(productions.get(0)));

        for (int i = 0; i <= string.length();
             i++) {
            boolean addedStates;
            do {
                addedStates = false;
                HashSet<State> toAddSk = new HashSet<State>();
                HashSet<State> toAddSkplus1 = new HashSet<State>();
                for (State s : chart.get(i)) {
                    if (s.isIncomplete()) {
                        if (s.isNextSymbolVariable(variables)) {
                            toAddSk.addAll(predict(chart, i));
                        } else if (i < string.length()) {
                            toAddSkplus1.addAll(scan(chart, i, string.charAt(i)));
                        }
                    } else {
                        toAddSk.addAll(complete(chart, i));
                    }
                }
                addedStates = chart.get(i).addAll(toAddSk);
                if (i < string.length()) {
                    addedStates = addedStates || chart.get(i + 1).addAll(toAddSkplus1);
                }
            } while (addedStates);
        }

        for (State s : chart.get(string.length())) {
            if (s.variable == productions.get(0).variable && s.origin == 0) {
                return true;
            }
        }
        return false;
    }

    // 1. Find states in S(k) where the next symbol to be matched is a variable (v)
    // 2. Add every rule in the production defined by variable v to S(k)
    private StateSet predict(Chart chart, int k) {
        StateSet toAdd = new StateSet();
        for (State s : chart.get(k)) {
            if (s.isNextSymbolVariable(variables)) {
                for (ProductionRule prod : productions) {
                    if (prod.variable == s.nextSymbol()) {
                        toAdd.add(new State(prod));
                    }
                }
            }
        }

        return toAdd;
    }

    // 1. Find states in S(k) where the next symbol to be matched is the same as the next in the string
    // 2. Add the state with dot position incremented to S(k+1)
    private StateSet scan(Chart chart, int k, char next) {
        StateSet toAdd = new StateSet();
        for (State s : chart.get(k)) {
            if (s.isIncomplete() && s.nextSymbol() == next) {
                toAdd.add(s.newStateWithDotIncremented());
            }
        }

        return toAdd;
    }

    // 1. Find states in S(k) where the dot position is at the end of the string
    // 2. For each found state (with origin j and rule defined for variable v):
    //      a. Find states in S(j) whose symbol after the dot position is v
    //      b. Add each found state to S(k) with their dot position incremented
    private StateSet complete(Chart chart, int k) {
        StateSet toAdd = new StateSet();
        for (State s : chart.get(k)) {
            if (!s.isIncomplete()) {
                for (State s2 : chart.get(s.origin)) {
                    if (s2.nextSymbol() == s.variable) {
                        toAdd.add(s2.newStateWithDotIncremented());
                    }
                }
            }
        }

        return toAdd;
    }
}
