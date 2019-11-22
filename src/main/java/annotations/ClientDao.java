package annotations;

/**
 * Created by Fred on 17/02/2015.
 */
public interface ClientDao {
    void addClient();
    String addClientReturnValue();
    void addClientThrowException() throws Exception;
    void addClientAround(String name);
}
