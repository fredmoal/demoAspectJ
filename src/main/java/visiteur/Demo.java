package visiteur;

public class Demo {
    public static void main(String[] args) {
        Expression dix = new Entier(10);
        Expression neuf = new Entier(9);
        Expression cinq = new Entier(5);
        Expression plus1 = new Addition(dix,neuf);
        Expression plus2 = new Addition(plus1,cinq);
        Expression deux = new Entier(2);
        Expression top = new Multiplication(deux, plus2);

        Visiteur<Expression,String> visiteur = new Visiteur<>();
        visiteur.when(Entier.class, num -> ""+num.eval())
                .when(Addition.class, addition -> "("
                                            +visiteur.call(addition.getGauche())
                                            +" + "
                                            +visiteur.call(addition.getDroite())
                                            +")"
                )
                .when(Multiplication.class, mult -> "("
                        +visiteur.call(mult.getGauche())
                        +" x "
                        +visiteur.call(mult.getDroite())
                        +")"
                );

        String texte = visiteur.call(top);
        System.out.println(texte);
    }
}
