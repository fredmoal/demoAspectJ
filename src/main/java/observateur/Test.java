package observateur;

/**
 * Created by Fred on 07/03/2017.
 */
public class Test {
    public static void main(String... args){
        Point p = new Point(1.0, 2.0);

        Observateur observ = new ObservateurPoint(p);
        p.ajouteObservateur(observ);

        p.setY(3.0);
        p.getX();
        p.setX(-2.5);

        p.retireObservateur(observ);
        p.setY(-7);
    }
}
