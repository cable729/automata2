package automata.jares;

public class State extends ProductionRule {
    public int origin = 0;
    public int dot_position = 0;

    public State(ProductionRule rule) {
        super(rule.variable, rule.rule);
    }

}
