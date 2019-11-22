package annotations;

/**
 * Created by Fred on 17/02/2015.
 */
public class ClientDaoImpl implements ClientDao {
    public void addClient() {
        System.out.println("execution de addClient()");
    }

    public String addClientReturnValue() {
        System.out.println("execution de addClientReturnValue()");
        return "1234";
    }

    public void addClientThrowException() throws Exception {
        System.out.println("execution de addClientThrowException()");
        throw new Exception("Erreur !");
    }

    public void addClientAround(String name) {
        System.out.println("exe de addClientAround(String) avec : " + name);
    }
}
