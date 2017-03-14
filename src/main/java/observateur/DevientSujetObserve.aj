package observateur;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fred on 07/03/2017.
 */
public aspect DevientSujetObserve {
    private List<Observateur> Point.observateurs =
            new ArrayList<>();
    private void Point.notifieObservateurs() {
        for(Observateur o:observateurs) {
            o.actualiser();
        }
    }
    public void Point.ajouteObservateur(Observateur o) {
        observateurs.add(o);
    }
    public void Point.retireObservateur(Observateur o) {
        observateurs.add(o);
    }
    pointcut setting(Point p) :
        execution( void Point.set*(*) ) && this ( p );

    after (Point p) returning : setting(p) {
        p.notifieObservateurs();
    }
}
