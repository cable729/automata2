package automata.jares;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

public class ContextFreeGrammar {
    public final ArrayList<ProductionRule> productions;
    public final String variables;
    public final String terminals;

    public ContextFreeGrammar(String variables, String terminals) {
        this.variables = variables;
        this.terminals = terminals;
        productions = new ArrayList<ProductionRule>();
    }

    public boolean doesAccept(String string) {
        Queue<MatchingProduction> q = new SynchronousQueue<MatchingProduction>();
        q.add(new MatchingProduction(productions.get(0)));
        return doesAccept(q, string);
    }

    private boolean doesAccept(Queue<MatchingProduction> currentProds, String currentString) {


        return false;
    }
}
