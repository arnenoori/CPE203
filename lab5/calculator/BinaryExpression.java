abstract class BinaryExpression implements Expression {
    private final Expression lft;
    private final Expression rht;
    private final String opr;
    // access it frm the classes from its subclasses
    protected abstract double _applyOperator(double lft, double rht);

    public BinaryExpression(Expression lft, Expression rht, String opr) {
        this.lft = lft;
        this.rht = rht;
        this.opr = opr;
    }

    public String toString() {
        return "(" + lft + " " + opr + " " + rht + ")";
    }

    public double evaluate(Bindings bindings) {
        return _applyOperator(lft.evaluate(bindings), rht.evaluate(bindings));
    }
}
