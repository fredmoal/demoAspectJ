package observateur;

@FunctionalInterface
public interface Observateur<T> {
    public void actualiser(T source);
}
