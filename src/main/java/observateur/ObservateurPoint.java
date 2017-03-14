package observateur;

/**
 * Created by Fred on 07/03/2017.
 */
public class ObservateurPoint implements Observateur {
    private Point observe;

    public ObservateurPoint(Point observe) {
        this.observe = observe;
    }

    @Override
    public void actualiser() {
        System.out.println("notification de changement du point en "+observe.toString());
    }

}
