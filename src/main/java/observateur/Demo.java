package observateur;

public class Demo {
    public static void main(String... args){
        Point p = new Point(1.0, 2.0);
        Point p2 = new Point(4.0, 7.0);

        // good old Java 7
        Observateur<Point> observe = new Observateur<Point>() {
            @Override
            public void actualiser(Point source) {
                System.out.println("observateur 1 notif changement en "+source.toString());
            }
        };
        // Java 8+
        Observateur<Point> observe2 = point -> System.out.println("observateur 2 notif changement en "+point.toString());

        p.ajouteObservateurs(observe,observe2);
        p2.ajouteObservateurs(observe,observe2);

        System.out.println("p.set");
        p.setY(3.0);
        System.out.println("p.get");
        p.getX();
        System.out.println("p.set");
        p.setX(-2.5);

        System.out.println("p2.set");
        p2.setX(12.0);

        System.out.println("observateur 1 se désabonne de p");
        p.retireObservateurs(observe);
        System.out.println("p.set");
        p.setY(-7);
    }
}
