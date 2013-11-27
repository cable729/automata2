package automata.jares;

public class State extends ProductionRule {
    public int origin = 0;
    public int dot_position = 0;

    public State(ProductionRule rule) {
        super(rule.variable, rule.rule);
    }

    public boolean isIncomplete() {
        return dot_position < rule.length();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        State state = (State) o;

        if (dot_position != state.dot_position) return false;
        if (origin != state.origin) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + origin;
        result = 31 * result + dot_position;
        return result;
    }

    public boolean isNextSymbolVariable(String variables) {
        return !rule.isEmpty() && variables.indexOf(nextSymbol()) != -1;
    }

    public char nextSymbol() {
        return rule.charAt(dot_position);
    }

    public State newStateWithDotIncremented() {
        State s = new State(this);
        s.dot_position = this.dot_position + 1;
        s.origin = this.origin;
        return s;
    }

}
