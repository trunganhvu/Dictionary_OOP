/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.sql.SQLException;

/**
 *
 * @author vutrunganh
 */
public class ClientMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ClientUI client = new ClientUI("127.0.0.1");
        client.startRunning();
    }

}
