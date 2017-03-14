package base;

/**
 * Created by Fred on 17/02/2015.
 */
public class Main {
    public static void main(String[] args) {
        ClientDao clientDao = new ClientDaoImpl();

        clientDao.addClient();

        System.out.println();

        String s = clientDao.addClientReturnValue();
        System.out.println();

        clientDao.addClientAround("fred");

        System.out.println();
        try {
            clientDao.addClientThrowException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
