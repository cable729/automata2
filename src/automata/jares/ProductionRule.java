package automata.jares;

public class ProductionRule {
    public final char variable;
    public final String rule;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductionRule that = (ProductionRule) o;

        if (variable != that.variable) return false;
        if (!rule.equals(that.rule)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) variable;
        result = 31 * result + rule.hashCode();
        return result;
    }

    public ProductionRule(char variable, String rule) {
        this.variable = variable;
        this.rule = rule;
    }
}
