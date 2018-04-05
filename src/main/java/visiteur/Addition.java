package visiteur;

public class Addition extends Expression {
	private Expression gauche;
	private Expression droite;

	public Addition(Expression gauche, Expression droite) {
		super();
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
		return gauche.eval() + droite.eval();
	}
}
