package visiteur;

/**
 * Created by Fred on 14/03/2017.
 */
public class Multiplication extends Expression {
    private Expression gauche;
    private Expression droite;

    public Multiplication(Expression gauche, Expression droite) {
        this.gauche = gauche;
        this.droite = droite;
    }

    public Expression getGauche() {
        return gauche;
    }

    public Expression getDroite() {
        return droite;
    }

    @Override
    public int eval() {
        return gauche.eval() * droite.eval();
    }
}
