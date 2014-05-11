package org.javaee7.rest.client;

/**
 *
 * @author Masudul Haque
 */
public class TestClient {

    public static void main(String[] args) {
        StudentIDEJersyClient client = new StudentIDEJersyClient();
        System.out.println(client.countREST());
//        Client client=ClientBuilder.newClient();
    }
}
