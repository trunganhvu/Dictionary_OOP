/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author vutrunganh
 */
public class UserThread extends Thread{
    private Socket socket;
    private ServerChat server;
    private ObjectInputStream input; 
    private ObjectOutputStream output;
    private String username;
    private static boolean client;
    
    public UserThread(Socket socket, ServerChat server){
        this.socket = socket;
        this.server = server;
    }
    
    @Override
    public void run() {
        try {
            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());
            String username = (String)input.readObject();
            this.username = username;
            server.addUser(username);
            server.addUserThread(username, this);
            server.sendAllListUseronline();
            String notify = this.username + "joined.";
            server.SendMessageToAll(notify, this);
            String message = "";
            while(true){
                Object mess = input.readObject();
                if (mess instanceof HashMap){
                    HashMap<String, String> client = (HashMap) mess;
                    for (String key : client.keySet()){
                        String value = client.get(key);
                        UserThread userThread = server.getMapUserThread().get(key);
                        server.sendToUser(userThread, this.username + ": " + value);
                        System.out.println(this.username + ": " + value);
                    }
                }
                else if(mess instanceof String){
                    message = (String) mess;
                    server.SendMessageToAll(message, this);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    public void sendMessage(String message) throws IOException {
        output.writeObject(message);
        output.flush();

    }

    public void sendMessageToUser(String message) throws IOException {
        HashMap<String, String> messageToUser = new HashMap<>();
        messageToUser.put(this.username, message);
        output.writeObject(messageToUser);
        output.flush();
    }

    public void sendListUser(ArrayList<String> listUser) throws IOException {
        output.writeObject(listUser);
        output.flush();
    }

    public String getUsername() {
        return this.username;
    }
}
