package observateur;

import java.util.ArrayList;
import java.util.List;

public aspect DevientSujetObserve {
    // ajoute un champs avec la liste des abonnés
    private List<Observateur<Point>> Point.observateurs =
            new ArrayList<>();

    // ajoute les méthodes d'abonnement et de notification
    private void Point.notifieObservateurs() {
        for(Observateur o:observateurs) {
            o.actualiser(this);
        }
    }
    public void Point.ajouteObservateurs(Observateur... os) {
        for(Observateur o :os) observateurs.add(o);
    }
    public void Point.retireObservateurs(Observateur... os) {
        for(Observateur o :os) observateurs.remove(o);
    }

    // après un appel à un setter, on notifie les abonnés
    pointcut setting(Point p) :
        execution( void Point.set*(*) ) && this ( p );

    after (Point p) returning : setting(p) {
        p.notifieObservateurs();
    }
}
