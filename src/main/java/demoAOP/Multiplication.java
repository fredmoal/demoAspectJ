package demoAOP;

/**
 * Created by Fred on 14/03/2017.
 */
public class Multiplication extends Expression {
    private Expression leftExpression;
    private Expression rightExpression;

    public Multiplication(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int eval() {
        System.out.println("Evaluation d'un noeud +");
        return leftExpression.eval() * rightExpression.eval();
    }
}
