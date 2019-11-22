package visiteur.lambdas;

import java.util.HashMap;
import java.util.function.Function;


public class Visiteur<U, R> {
    private final HashMap<Class<? extends U>, Function<U, ? extends R>> map = new HashMap<>();

    public <T extends U> Visiteur<U, R> when(Class<? extends T> type, Function<? super T, ? extends R> fun) {
        map.put(type, fun.compose(type::cast));
        return this;
    }
    public R call(U receiver) {
        return map.getOrDefault(receiver.getClass(),
                obj -> { throw new IllegalArgumentException("invalid " + obj); })
                .apply(receiver);
    }
}
