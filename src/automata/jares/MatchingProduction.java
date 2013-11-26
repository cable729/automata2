package automata.jares;

public class MatchingProduction extends ProductionRule {
    public int position = 0;

    public MatchingProduction(ProductionRule rule) {
        super(rule.variable, rule.rule);
    }

}
