package observateur;

/**
 * Created by Fred on 07/03/2017.
 */
public class Test {
    public static void main(String... args){
        Point p = new Point(1.0, 2.0);
        p.ajouteObservateur( new ObservateurPoint(p) );

        p.setY(3.0);

        p.getX();

        p.setX(-2.5);
    }
}
