package visiteur;

public class Demo {
    public static void main(String[] args) {
        Expression plus = new Addition(new Entier(10),new Entier(4));
        Expression top = new Multiplication(
                                new Entier(2),
                                new Addition(plus, new Entier(7)));

        Visiteur<Expression,String> visiteur = new Visiteur<>();
        visiteur.when(Entier.class, num -> ""+num.getValue())
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

        Visiteur<Expression,Integer> eval = new Visiteur<>();
        eval.when(Entier.class, num -> num.getValue())
            .when(Addition.class, addition -> eval.call(addition.getGauche())+eval.call(addition.getDroite()))
            .when(Multiplication.class, mult -> eval.call(mult.getGauche())*eval.call(mult.getDroite()));
        Integer valeur = eval.call(top);
        System.out.println("eval : "+valeur);
    }
}
