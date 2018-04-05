package visiteur;

public class Binaire implements Expression {
    private Expression gauche;
    private Expression droite;

    public Binaire(Expression gauche, Expression droite) {
        this.gauche = gauche;
        this.droite = droite;
    }

    public Expression getGauche() {
        return gauche;
    }
    public Expression getDroite() {
        return droite;
    }
}
