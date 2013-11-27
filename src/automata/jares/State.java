package automata.jares;

public class State extends ProductionRule {
    public int origin = 0;
    public int dot_position = 0;

    public State(ProductionRule rule) {
        super(rule.variable, rule.rule);
    }

    public boolean isIncomplete() {
        return dot_position == rule.length();
    }

    public boolean isNextSymbolVariable(String variables) {
        return variables.indexOf(nextSymbol()) != -1;
    }

    public char nextSymbol() {
        return rule.charAt(dot_position);
    }

    public State newStateWithDotIncremented() {
        State s = new State(this);
        s.dot_position++;
        return s;
    }
}
