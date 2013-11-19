package automata.jares;

public class ProductionRule {
    public final char variable;
    public final String rule;

    public ProductionRule(char variable, String rule){
        this.variable = variable;
        this.rule = rule;
    }
}
